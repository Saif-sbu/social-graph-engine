package models;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayList;
public class SocialGraph {
    private HashMap<Integer, User> users;
    public SocialGraph(){
        users = new HashMap<>();
    }
    public void addUser(User user){
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
        user1.getFriends().add(user2);
        user2.getFriends().add(user1);

    }

    public void bfsTraversal(int startId){
        User start = findUser(startId);
        if (start == null){
            System.out.println("User not found.");
            return;
        }
        Queue<User> traverse = new LinkedList<>();
        HashSet<User> visited = new HashSet<>();
        ArrayList<User> result = new ArrayList<>();
        traverse.add(start);
        visited.add(start);
        result.add(start);
        while(!traverse.isEmpty()){
            User current = traverse.poll();
            result.add(current);
            System.out.println(current.getUser());
            for (User friend : current.getFriends()){
                if (!visited.contains(friend)){
                    visited.add(friend);
                    traverse.add(friend);
                }
            }
        }
    }
    public ArrayList<User> recommendFriends(int userId){
        User user = findUser(userId);
        if (user == null){
            return new ArrayList<>();
        }
        HashMap<User, Integer> mutualCounts = new HashMap<>();
        
        for (User friend: user.getFriends()){
            for (User friendOfFriend: friend.getFriends()){
                if (friendOfFriend == user){
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
        return users.get(id).getFriends().size();
    }


}
