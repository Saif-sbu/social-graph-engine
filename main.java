import java.util.ArrayList;
import java.util.Scanner;
import models.User;
import models.SocialGraph;
public class Main{
    public static void main(String[] args){
        SocialGraph graph = new SocialGraph();
        Scanner input = new Scanner(System.in);
        System.out.print("Please select an option from the menu below:\n1. Add User\n2. Remove User\n3. Add Friend\n4. Find User\n5. BFS\n6. DFS\n7. Recommendations\n8. Analytics\n9. Exit\nPick a number, please. You can select again one at a time.\n");
        int option = input.nextInt();
        input.nextLine();
        while (option != 9){
            if (option == 1){
                System.out.println("User name:");
                String name = input.nextLine();
                System.out.println("User id:");
                int id = input.nextInt();
                input.nextLine();
                System.out.println("User email:");
                String email = input.nextLine();
                User u1 = new User(name, id, email);
                graph.addUser(u1);
            }
            else if (option == 2){
                System.out.println("Id of the user you want to remove:");
                int id = input.nextInt();
                boolean remove = graph.removeUser(id);
                if (!remove){
                    System.out.println("User not found. Please try again.");
                } else {
                    System.out.println("User successfully removed.");
                }
            }
            else if (option == 3){
                System.out.println("User id:");
                int id1 = input.nextInt();
                System.out.println("Id of user's friend:");
                int id2 = input.nextInt();
                graph.addFriend(id1, id2);
            }
            else if (option == 4){
                System.out.println("User id:");
                int id = input.nextInt();
                User user = graph.findUser(id);
                if (user == null){
                    System.out.println("Sorry user not found. Please try again.");
                } else {
                    System.out.println(user.toString());
                }
            }
            else if (option == 5){
                System.out.println("Id of the user you want to find the friends of:");
                int id = input.nextInt();
                ArrayList<User> result = graph.bfsTraversal(id);
                if (result.isEmpty()){
                    System.out.println("Sorry, user not found.");
                }
                else{
                    System.out.println("BFS Traversal:");
                    for (User user : result){
                        System.out.println(user.getUser());
                    }
                }
            }
            else if (option == 6){
                System.out.println("Id of the user:");
                int id = input.nextInt();
                ArrayList<User> result = graph.dfsTraversal(id);
                if (result.isEmpty()){
                    System.out.println("Sorry, user not found.");
                } else {
                    System.out.println("DFS Traversal:");
                    for (User user: result) {
                        System.out.println(user.getUser());
                    }
                }
            }
            else if (option == 7){
                System.out.println("Id of the user:");
                int id = input.nextInt();
                if (graph.findUser(id) == null){
                    System.out.println("User not found.");
                } else{ 
                    ArrayList<User> recommendations = graph.recommendFriends(id);
                    if (recommendations.isEmpty()){
                        System.out.println("No recommendations available.");
                    } else {
                        System.out.println("Recommendations:");
                        for (User user: recommendations){
                            System.out.println(user.getUser());
                        }
                    }
                }
            }
            else if (option == 8){
                System.out.println("What do you want to find:\n1. Most Connected User\n2. Number of friends a user has\n3. Average number of friends a user has\n4. All Isolated Users\n5. Exit. Pick a number please.");
                int option2 = input.nextInt();
                while (option2 != 5){
                    if (option2 == 1){
                        User user = graph.mostConnectedUser();
                        if (user == null){
                            System.out.println("The list empty. There is no user. Please try again.");
                        } else {
                            System.out.println("User: " + user.getUser() + ", User id: " + user.getId());
                        }
                    } else if (option2 == 2){
                        System.out.println("User id: ");
                        int id = input.nextInt();
                        if (graph.friendCount(id) == -1){
                            System.out.println("There is no user.");
                        } else {
                            System.out.println("Number of friends the user has: " + graph.friendCount(id));
                        }
                    } else if (option2 == 3){
                        System.out.println("Average number of friends a user has: " + graph.averageFriendCount());
                    } else if (option2 == 4){
                        ArrayList<User> isolated = graph.isolatedUsers();
                        if(isolated.isEmpty()){
                            System.out.println("There is no isolated user.");
                        } else {
                            for (User user: isolated){
                                System.out.println(user.getUser());
                            }
                        }
                    }
                    System.out.println("\n1. Most Connected User\n" + "2. Number of friends a user has\n" + "3. Average number of friends a user has\n" + "4. All Isolated Users\n" + "5. Exit");
                    option2 = input.nextInt();
                }
            }
            else {
                System.out.println("Sorry, you must pick a number from (1-9)");
            }
            System.out.print(
                "\n1. Add User\n" +
                "2. Remove User\n" +
                "3. Add Friend\n" +
                "4. Find User\n" +
                "5. BFS\n" +
                "6. DFS\n" +
                "7. Recommendations\n" +
                "8. Analytics\n" +
                "9. Exit\n" +
                "Pick a number: ");
            option = input.nextInt();
            input.nextLine();
        }
    }

}
