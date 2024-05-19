import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SportsDAO {
    
    private final MYSQLDatabase database;

    public SportsDAO(MYSQLDatabase database){
        this.database = database;
    }

    public ArrayList<Sport> findAll(){
        ArrayList<Sport> sport = new ArrayList<Sport>();
        Statement myStatement = database.createStatement();
        try {
            ResultSet results = myStatement.executeQuery("SELECT * FROM sport;");

            while(results.next()){
                final String name = results.getString("name");
                final int id = results.getInt("id");
                final int requiredParticipants = results.getInt("required_participants");
                
                Sport ajout = new Sport(id, name, requiredParticipants);
                
                sport.add(ajout);
            }
            return sport;
        } 
        
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        
    }
    
    public Sport findById(int idbis){
        Statement myStatement = database.createStatement();
        try {
            ResultSet results = myStatement.executeQuery("SELECT * FROM sport WHERE id =" + idbis + ";");
            while(results.next()){
                final String name = results.getString("name");
                final int id = results.getInt("id");
                final int requiredParticipants = results.getInt("required_participants");
                
                Sport ajout = new Sport(id, name, requiredParticipants);
                return ajout;
            }
        }
        
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    //Page 9 findbyId avec preparedStatement
    /*public Sport findById(int idbis){
        try{
            String query = "SELECT * FROM sport WHERE id = ? ;";
            PreparedStatement myStatement = database.preparedStatement(query);
            myStatement.setInt(1, idbis);
            ResultSet results = myStatement.executeQuery();
            while(results.next())
            {
                final String name = results.getString("name");
                final int id = results.getInt("id");
                final int requiredParticipants = results.getInt("required_participants");

                Sport ajout = new Sport(id, name, requiredParticipants);
            }

        }
        return ajout;
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }
    */

    public ArrayList<Sport> findByName(String Name){
        ArrayList<Sport> sport = new ArrayList<Sport>();
        Statement myStatement = database.createStatement();
        try{
            ResultSet results = myStatement.executeQuery("SELECT * FROM sport WHERE name LIKE '%" + Name + "%' ORDER BY name;");

            while(results.next())
            {
                final String name = results.getString("name");
                final int id = results.getInt("id");
                final int requiredParticipants = results.getInt("required_participants");

                Sport ajout = new Sport(id, name, requiredParticipants);
                sport.add(ajout);
            }
            return sport;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    //Page 9 findbyName avec preparedStatement
    /*public ArrayList<Sport> findByName(String name){
        ArrayList<Sport> sport = new ArrayList<Sport>();
        String query = "SELECT * FROM sport WHERE name LIKE ? ORDER BY name;";
        try{
            PreparedStatement myStatement = database.preparedStatement(query);
            myStatement.setString(1, "%" + name + "%");
            ResultSet results = myStatement.executeQuery();

            while(results.next())
            {
                final String name = results.getString("name");
                final int id = results.getInt("id");
                final int requiredParticipants = results.getInt("required_participants");

                Sport ajout = new Sport(id, name, requiredParticipants);
                sport.add(ajout);
            }
            return sport;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    */

    public Boolean insert(Sport sport){
        String query = "INSERT INTO sport (id, name, required_participants) VALUES (?, ?, ?)";
        try (PreparedStatement statement = database.preparedStatement(query)) {
            statement.setInt(1, sport.getId());
            statement.setString(2, sport.getName());
            statement.setInt(3, sport.getRequiredParticipants());
            return statement.executeUpdate() > 0;
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Boolean update(int id, Sport sport){
        String query = "UPDATE sport SET name = ?, required_participants = ? WHERE id = ?";
        try (PreparedStatement statement = database.preparedStatement(query)) {
            statement.setString(1, sport.getName());
            statement.setInt(2, sport.getRequiredParticipants());
            statement.setInt(3, id);
            return statement.executeUpdate() > 0;
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Boolean delete(int id){
        String query = "DELETE FROM sport WHERE id = ?";
        try (PreparedStatement statement = database.preparedStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

}