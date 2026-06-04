package models;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Stack;
public class SocialGraph {
    private HashMap<Integer, User> users;
    public SocialGraph(){
        users = new HashMap<>();
    }
    public void addUser(User user){
        if (users.containsKey(user.getId())){
            System.out.println("ID already exists.");
            return;
        }
        users.put(user.getId(), user);
    }
    public User findUser(int id){
        return users.get(id);
    }
    public boolean removeUser(int id){
        User found = findUser(id);
        if (found == null){
            return false;
        }
        for (User friend: new ArrayList<>(found.getFriends())){
            friend.getFriends().remove(found);
        }
        found.getFriends().clear();
        users.remove(id);
        return true;
    }
    public void addFriend(int id1, int id2){
        User user1 = findUser(id1);
        User user2 = findUser(id2);
        if (user1 == null || user2 == null){
            System.out.println("User not found.");
            return;
        }
        if (id1 == id2){
            System.out.println("A user cannot be friends with themselves.");
            return;
}
        if (!user1.getFriends().contains(user2)){
            user1.getFriends().add(user2);
        }
        if (!user2.getFriends().contains(user1)){
            user2.getFriends().add(user1);
        }

    }

    public ArrayList<User> bfsTraversal(int startId){
        User start = findUser(startId);
        if (start == null){
            System.out.println("User not found.");
            return new ArrayList<>();
        }
        Queue<User> traverse = new LinkedList<>();
        HashSet<User> visited = new HashSet<>();
        ArrayList<User> result = new ArrayList<>();
        traverse.add(start);
        visited.add(start);
        while(!traverse.isEmpty()){
            User current = traverse.poll();
            result.add(current);
            for (User friend : current.getFriends()){
                if (!visited.contains(friend)){
                    visited.add(friend);
                    traverse.add(friend);
                }
            }
        }
        return result;
    }
    public ArrayList<User> recommendFriends(int userId){
        User user = findUser(userId);
        if (user == null){
            return new ArrayList<>();
        }
        HashMap<User, Integer> mutualCounts = new HashMap<>();
        
        for (User friend: user.getFriends()){
            for (User friendOfFriend: friend.getFriends()){
                if (friendOfFriend.getId() == user.getId()){
                    continue;
                }
                if (user.getFriends().contains(friendOfFriend)){
                    continue;
                }
                mutualCounts.put(
                    friendOfFriend,
                    mutualCounts.getOrDefault(friendOfFriend, 0) + 1);
            }
        }
        ArrayList<User> recommendations = new ArrayList<>(mutualCounts.keySet());
        recommendations.sort((u1, u2) -> mutualCounts.get(u2) - mutualCounts.get(u1));
        return recommendations;
    }

    public User mostConnectedUser(){
        if (users.isEmpty()){
            return null;
        }
        User mostConnected = null;
        int maxFriends = -1;
        for (User user: users.values() ){
            int friendCount = user.getFriends().size();
            if (friendCount > maxFriends){
                mostConnected = user;
                maxFriends = friendCount;
            }
        }
        return mostConnected;
    }

    public int friendCount(int id){
        User user = findUser(id);
        if (user == null){
            return -1;
        }
        return user.getFriends().size();
    }

    public double averageFriendCount(){
        if (users.isEmpty()){
            return 0;
        }
        double total = 0;
        for (User user: users.values()){
            int numberOfFriends = user.getFriends().size();
            total = total + numberOfFriends;
        }
        return total/users.size();
    }

    public ArrayList<User> isolatedUsers(){
        if (users.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList <User> isolated = new ArrayList<>();
        for (User user: users.values()){
            if (user.getFriends().isEmpty()){
                isolated.add(user);
            }
        }
        return isolated;
    }

    public ArrayList<User> dfsTraversal(int startId){
        User user = findUser(startId);
        if (user == null){
            return new ArrayList<>();
        }
        Stack<User> stack = new Stack<>();
        HashSet<User> visited = new HashSet<>();
        ArrayList<User> result = new ArrayList<>();
        stack.push(user);
        visited.add(user);
        while(!stack.isEmpty()){
            User current = stack.pop();
            result.add(current);
            for (User friend: current.getFriends()){
                if (!visited.contains(friend)){
                    visited.add(friend);
                    stack.push(friend);
                }
            }
        }
        return result;
    }

}
