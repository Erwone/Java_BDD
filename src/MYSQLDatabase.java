import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MYSQLDatabase {

    private String host;
    private int port;
    private String databaseName;
    private String user;
    private String password;
    private Connection connection;
    private static Boolean driverLoaded;


    public MYSQLDatabase(String host, int port, String databaseName, String user, String password){
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
        connection = null;
        driverLoaded = false;
        loadDriver();
    }
    
    public void connect(){
        try {
            connection = DriverManager.getConnection(
            "jdbc:mysql://" + host + ":" + port + "/" + databaseName,
            user,
            password
        ); 
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Statement createStatement(){
        try {
            Statement myStatement = connection.createStatement();
            return myStatement;
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        
    }

    private static void loadDriver(){
        if(driverLoaded == false){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                driverLoaded = true;
            } 
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public PreparedStatement preparedStatement(String query){
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            return statement;
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

}
