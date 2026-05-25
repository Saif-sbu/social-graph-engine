package models;
import java.util.ArrayList;
public class User {
    private String user;
    private int id;
    private String email;
    private ArrayList<User> friends;

    public User(){
    }

    public User(String user, int id, String email, ArrayList<User> friends){
        this.user = user;
        this.id = id;
        this.email = email;
        this.friends = friends;
    }

    public String getUser(){
        return user;
    }

    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public ArrayList<User> getFriends(){
        return friends;
    }

    public void setUser(String user){
        this.user = user;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setFriends(ArrayList<User> friends){
        this.friends = friends;
    }
}
