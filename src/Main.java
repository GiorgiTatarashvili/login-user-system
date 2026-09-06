import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static User currentUser = null;

    public static void main(String[] args){
        boolean isRunning = true;
        int options;


        System.out.println("========================");
        System.out.println("=====-USER-SYSTEM-======");
        System.out.println("========================");

        while (isRunning){
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. View profile");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            options = scanner.nextInt();
            System.out.println("---------------------");
            scanner.nextLine();

            switch (options){
                case 1 -> register();
                case 2 -> login();
                case 3 -> logout();
                //case 4 -> view profile
                case 5 -> isRunning = false;
                default -> System.out.println("Wrong input! please enter 1-5!");
            }
        }


    }
    static public void register(){
        User user = new User();
        System.out.print("Please enter user name: ");
        String username = scanner.nextLine();
        user.setUsername(username);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        user.setPassword(password);

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        user.setEmail(email);

        users.add(user);

    }
    static public void login(){
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        boolean userFound = false;

        for (User user : users){
            if (user.getUsername().equals(username)){
                userFound = true;
                if (user.checkPassword(password)){
                    currentUser = user;
                    System.out.println("Login successful!");
                    return;
                }
                else {
                    System.out.println("Password is incorrect!");
                }
            }
        }
        if (!userFound){
            System.out.println("No user found with this username!");
        }
    }
    static public void logout(){
        if (currentUser == null){
            System.out.println("No user is logged in!");
        }
        else {
            currentUser = null;
            System.out.println("Logout successfully");
        }
    }
}
