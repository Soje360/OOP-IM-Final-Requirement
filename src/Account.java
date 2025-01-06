import java.util.*;

interface Accounts {
    public String getUsername();
}

public class Account implements Accounts {
    private String username;
    private String password;
    private static List<Account> accounts = new  ArrayList<Account>();


    //sign up
    public Account(String username, String password){
            this.username = username;
            this.password = password;
            accounts.add(this);
    }
    //getter
    public String getUsername() {
        return username;
    }

    //login
    public static boolean LoginAccess(String username, String password){
        boolean access = false;
        for(Account account: accounts){
            if(account.username.equals(username) && account.password.equals(password)){
                access= true;
                break;
            }
        }
        return access;
    }

    public static boolean hasAccount(String username){
        boolean hasAccount = false;
        for(Account account: accounts){
            if(account.username.equals(username)){
                hasAccount = true;
                break;
            }
        }
        return hasAccount;
    }
}



