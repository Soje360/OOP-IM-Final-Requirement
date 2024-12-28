import java.sql.*;
import java.util.Scanner;
abstract class DatabaseConnectivity {
    protected Connection connection;

    // connecting to database
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/credentials", "root", "Nyoging123");
        } catch (SQLException e) {
            System.out.println("Could not connect to the database");
        }
    }

    // abstract methods for login and signup
    public abstract boolean Login(String username, String password);
    public abstract boolean Signup(String username, String password);
}

// connecting account to database
class Account extends DatabaseConnectivity
{
    private Connection connection;

    @Override
    public void connect()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/credentials", "root", "Nyoging123");
        }
        catch (SQLException e)
        {
            System.out.println("Could not connect to the database");
        }
    }
    @Override
    public boolean Login(String username, String password)
    {
        try
        {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
        catch (SQLException e)
        {
        }
        return false;
    }
    @Override
    public boolean Signup(String username, String password)
    {
        try
        {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (SQLException e)
        {
        }
        return false;
    }
}
class Access
{
    private final DatabaseConnectivity db;
    public Access(DatabaseConnectivity db)
    {
        this.db = db;
    }
    public void verifyLogin()
    {
        Scanner scanner = new Scanner(System.in);
        db.connect();
        int attempts = 5;
        while (attempts > 0)
        {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (db.Login(username, password))
            {
                System.out.println("Login successful!");
                System.exit(0);
            }
            else
            {
                attempts--;
                System.out.println("Invalid credentials. Attempts left: " + attempts);
            }
            if (attempts == 0)
            {
                System.out.println("Too many failed attempts. Exiting.");
            }
        }
    }
    public void verifySignup()
    {
        Scanner scanner = new Scanner(System.in);
        db.connect();
        while (true)
        {
            System.out.print("Enter a username: ");
            String username = scanner.nextLine();
            System.out.print("Enter a password (minimum 8 characters): ");
            String password = scanner.nextLine();
            if (password.length() < 8)
            {
                System.out.println("Password must have at least 8 characters.");
                continue;
            }
            if (db.Signup(username, password))
            {
                System.out.println("Signup successful! You can now log in.");
                break;
            }
            else
            {
                System.out.println("Signup failed. Try again.");
            }
        }
    }
}
