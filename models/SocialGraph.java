package models;
import java.util.HashMap;
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
}
