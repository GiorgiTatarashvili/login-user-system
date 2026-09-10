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
                case 4 -> viewProfile();
                case 5 -> isRunning = false;
                default -> System.out.println("Wrong input! please enter 1-5!");
            }
        }


    }
    static public void register(){
        User user = new User();
        System.out.print("Please enter user name: ");
        String username = scanner.nextLine();

        if (username.isEmpty()){
            System.out.println("Username cannot be empty!");
            return;
        }

        try {
            for (User user1 : users){
                if (user1.getUsername().equals(username)){
                    throw new UserAlreadyExistsException("Username already exists!");
                }
            }
        }
        catch (UserAlreadyExistsException e){
            System.out.println(e.getMessage());
            return;
        }
        user.setUsername(username);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (password.isEmpty()){
            System.out.println("Password cannot be empty!");
            return;
        }
        user.setPassword(password);

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        if (email.isEmpty()){
            System.out.println("Email cannot be empty!");
            return;
        }
        try {
            for (User user1 : users){
                if (user1.getEmail().equals(email)){
                   throw new UserAlreadyExistsException("This email already exists!");
                }
            }
        }
        catch (UserAlreadyExistsException e){
            System.out.println(e.getMessage());
            return;
        }

        user.setEmail(email);

        users.add(user);

    }
    static public void login(){
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        boolean userFound = false;

        try {
            for (User user : users){
                if (user.getUsername().equals(username)){
                    userFound = true;
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    if (user.checkPassword(password)){
                        currentUser = user;
                        System.out.println("Login successful!");
                        System.out.println("-----------------");
                        return;
                    }
                    else {
                        throw new InvalidLoginException("Password is incorrect!");

                    }
                }
            }
            if (!userFound){
                throw new InvalidLoginException("No user found with this username!");
            }
        }
        catch (InvalidLoginException e){
            System.out.println(e.getMessage());
            return;
        }

    }
    static public void logout(){
        if (currentUser == null){
            System.out.println("No user is logged in!");
            System.out.println("---------------------");
        }
        else {
            currentUser = null;
            System.out.println("Logout successfully!");
            System.out.println("-------------------");
        }
    }
    static public void viewProfile(){
        if (currentUser == null){
            System.out.println("You are not logged in yet!");
        }
        else {
            System.out.println("Your username: " + currentUser.getUsername());
            System.out.println("Your email: " + currentUser.getEmail());
        }

    }
}
