import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String email;

    public void getUsername(){
        System.out.println(username);
    }
    public void getEmail(){
        System.out.println(email);
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
