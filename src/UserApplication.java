import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class UserList {
    private List<User> userList;

    public UserList() {
        this.userList = new ArrayList<>();
    }

    public void addUser(int id, String name, String email) {
        User user = new User(id, name, email);
        userList.add(user);
    }

    public void removeUser(int id) {
        userList.removeIf(user -> user.getId() == id);
    }

    public User getUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // User not found
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public List<User> searchById(int id) {
        List<User> result = new ArrayList<>();
        for (User user : userList) {
            if (user.getId() == id) {
                result.add(user);
            }
        }
        return result;
    }

    public void sortByName() {
        Collections.sort(userList, Comparator.comparing(User::getName));
    }
}

public class UserApplication {
    public static void main(String[] args) {
        UserList userList = new UserList();

        // Adding users
        userList.addUser(1, "Janu ", "janu@example.com");
        userList.addUser(2, "lakshmi", "lakshmi@example.com");
        userList.addUser(3, "Bob", "bob@example.com");

        // Displaying all users
        System.out.println("All Users:");
        for (User user : userList.getAllUsers()) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
        }

        // Searching for user by ID
        System.out.println("\nSearch by ID 2:");
        List<User> searchResult = userList.searchById(2);
        for (User user : searchResult) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
        }

        // Removing a user
        userList.removeUser(1);

        // Sorting users by name
        userList.sortByName();

        // Displaying all users after removal and sorting
        System.out.println("\nAll Users after removal and sorting:");
        for (User user : userList.getAllUsers()) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
        }
    }
}
