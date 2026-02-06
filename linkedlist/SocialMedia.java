package linkedlist;

/*
Social Media Friend Management System using Singly Linked List.
Each node represents a user with User ID, Name, Age,
and a list of Friend IDs.
The system supports adding and removing friend connections,
finding mutual friends, searching users, displaying friends,
and counting total friends for each user.
*/

import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friends;

    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMediaLinkedList {
    private UserNode head;

    // Add a new user
    void addUser(int id, String name, int age) {
        UserNode newNode = new UserNode(id, name, age);
        newNode.next = head;
        head = newNode;
    }

    // Search user by ID
    UserNode searchById(int id) {
        UserNode temp = head;

        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name
    UserNode searchByName(String name) {
        UserNode temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection between two users
    void addFriendConnection(int id1, int id2) {
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        if (!user1.friends.contains(id2))
            user1.friends.add(id2);

        if (!user2.friends.contains(id1))
            user2.friends.add(id1);

        System.out.println("Friend connection added.");
    }

    // Remove friend connection
    void removeFriendConnection(int id1, int id2) {
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        user1.friends.remove(Integer.valueOf(id2));
        user2.friends.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed.");
    }

    // Display all friends of a user
    void displayFriends(int userId) {
        UserNode user = searchById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friends.isEmpty()) {
            System.out.println("No friends.");
            return;
        }

        for (int friendId : user.friends) {
            UserNode friend = searchById(friendId);
            if (friend != null)
                System.out.println(friend.userId + " - " + friend.name);
        }
    }

    // Find mutual friends between two users
    void findMutualFriends(int id1, int id2) {
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Mutual Friends:");
        boolean found = false;

        for (int f1 : user1.friends) {
            if (user2.friends.contains(f1)) {
                UserNode mutual = searchById(f1);
                if (mutual != null) {
                    System.out.println(mutual.userId + " - " + mutual.name);
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("No mutual friends.");
    }

    // Count number of friends for each user
    void countFriendsForAllUsers() {
        UserNode temp = head;

        while (temp != null) {
            System.out.println(
                    "User: " + temp.name +
                            ", Total Friends: " + temp.friends.size()
            );
            temp = temp.next;
        }
    }

    // Display all users
    void displayAllUsers() {
        UserNode temp = head;

        System.out.println("All Users:");
        while (temp != null) {
            System.out.println(
                    "ID: " + temp.userId +
                            ", Name: " + temp.name +
                            ", Age: " + temp.age
            );
            temp = temp.next;
        }
    }
}

public class SocialMedia {
    public static void main(String[] args) {

        SocialMediaLinkedList socialMedia = new SocialMediaLinkedList();

        socialMedia.addUser(1, "Alice", 22);
        socialMedia.addUser(2, "Bob", 23);
        socialMedia.addUser(3, "Charlie", 21);
        socialMedia.addUser(4, "Diana", 24);

        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(1, 3);
        socialMedia.addFriendConnection(2, 3);
        socialMedia.addFriendConnection(2, 4);

        socialMedia.displayAllUsers();

        socialMedia.displayFriends(1);
        socialMedia.findMutualFriends(1, 2);

        socialMedia.removeFriendConnection(1, 3);

        socialMedia.displayFriends(1);

        socialMedia.countFriendsForAllUsers();

        UserNode searchResult = socialMedia.searchByName("Bob");
        if (searchResult != null)
            System.out.println("User found: " + searchResult.name);
    }
}

