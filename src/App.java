import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        /* Essai de la méthode delete() */
        PolySportsDatabase data = PolySportsDatabase.getInstance("localhost", 3306, "poly_sports","Erwan","Boubou");
        data.connect();
        SportsDAO sportdao = new SportsDAO(data);
        boolean deleted = sportdao.delete(2);
        if (deleted) {
            System.out.println("Le sport a été supprimé avec succès.");
        } else {
            System.out.println("Une erreur s'est produite lors de la suppression du sport.");
        }


        /* Essai de la méthode update 
        PolySportsDatabase data = PolySportsDatabase.getInstance("localhost", 3306, "poly_sports","Erwan","Boubou");
        data.connect();
        SportsDAO sportdao = new SportsDAO(data);
        Sport sportUpdate = sportdao.findById(10);
        if (sportUpdate != null) {
            sportUpdate.setRequiredParticipants(10);
            sportUpdate.setNom("rugby");
            boolean updated = sportdao.update(sportUpdate.getId(), sportUpdate);
            if (updated) {
                System.out.println("Le sport a été mis à jour avec succès.");
            } else {
                System.out.println("Une erreur s'est produite lors de la mise à jour du sport.");
                }
        }
        */

        /* Essai de la méthode insert()
        PolySportsDatabase data = PolySportsDatabase.getInstance("localhost", 3306, "poly_sports","Erwan","Boubou");
        data.connect();
        SportsDAO sportdao = new SportsDAO(data);
        Sport newSport = new Sport(10, "Rugby", 30);
        boolean inserted = sportdao.insert(newSport);
        if (inserted) {
            System.out.println("Le sport a été inséré avec succès.");
        } else {
            System.out.println("Une erreur s'est produite lors de l'insertion du sport.");
        }
        */

        /* Demande de saisie par l'utilisateur
        PolySportsDatabase data = PolySportsDatabase.getInstance("localhost", 3306, "poly_sports","Erwan","Boubou");
        data.connect();
        SportsDAO sportdao = new SportsDAO(data);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du sport à rechercher : ");
        String input = myScanner.nextLine();
        List<Sport> sportsByUserInput = sportdao.findByName(input);
        for (Sport sport : sportsByUserInput) {
            System.out.println("Sport trouvé : " + sport.getName() + ", Nombre de joueurs requis : " + sport.getRequiredParticipants());
        }
        */

        /* Essai de la fonction findbyName
        PolySportsDatabase data = PolySportsDatabase.getInstance("localhost", 3306, "poly_sports","Erwan","Boubou");
        data.connect();
        SportsDAO sportdao = new SportsDAO(data);
        System.out.println("Recherche de sports contenant le mot 'bad' : ");
        List<Sport> sportsByName = sportdao.findByName("bad");
        for (Sport sport : sportsByName) {
            System.out.println("Sport trouvé : " + sport.getName() + ", Nombre de joueurs requis : "+ sport.getRequiredParticipants());
        }
        */


        /* Essai de la fonction findbyId
        PolySportsDatabase data = PolySportsDatabase.getInstance("localhost", 3306, "poly_sports","Erwan","Boubou");
        data.connect();
        SportsDAO sportdao = new SportsDAO(data);
        Sport sportById = sportdao.findById(5);
            if (sportById != null) {
                System.out.println("Sport trouvé : " + sportById.getName() + ", Nombre de joueurs requis : "
                        + sportById.getRequiredParticipants());
            } else {
                System.out.println("Aucun sport trouvé pour l'ID donné.");
            }
        */

        /* Essai de la fonction findAll()
        PolySportsDatabase data = PolySportsDatabase.getInstance("localhost", 3306, "poly_sports","Erwan","Boubou");
        data.connect();
        SportsDAO sportdao = new SportsDAO(data);
        ArrayList<Sport> sports = sportdao.findAll();
        for(int i = 0; i < sports.size(); i++){
            System.out.println(sports.get(i).getId() + " " + sports.get(i).getName() + " " + sports.get(i).getRequiredParticipants());
        }
        */

        /* Nouvelle instance de sport
        Sport football = new Sport(14, "football", 26);

        System.out.println(football.getId() + " " + football.getName() + " " + football.getRequiredParticipants());
        */


        /* Remplacement de MYSQLDatabase par PolySportDatabase 
        MYSQLDatabase sport = PolySportsDatabase.getInstance();
        sport.connect();

        Statement myStatement = sport.createStatement();
        ResultSet results = myStatement.executeQuery("SELECT * FROM sport");

        while(results.next()){
                final String sports = results.getString("name");
                final int NumberPart = results.getInt("required_participants");

                System.out.println(sports + " : " + NumberPart + " participants");
            }
        */


        /* Nouvelle instance de MYSQLDatabase
        MYSQLDatabase sport = new MYSQLDatabase("localhost", 3306, "poly_sports", "Erwan", "Boubou");
    
        sport.connect();

        Statement myStatement = sport.createStatement();
        ResultSet results = myStatement.executeQuery("SELECT * FROM sport");

        while(results.next()){
                final String sports = results.getString("name");
                final int NumberPart = results.getInt("required_participants");

                System.out.println(sports + " : " + NumberPart + " participants");
            }
        */

        
        /* Première requête
        String user = "Erwan";
        String password = "Boubou";
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            Connection myConnection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/poly_sports",
            user,
            password
            );

            Statement myStatement = myConnection.createStatement();

            ResultSet results = myStatement.executeQuery("SELECT * FROM sport");

            while(results.next()){
                final String sports = results.getString("name");
                final int NumberPart = results.getInt("required_participants");

                System.out.println(sports + " : " + NumberPart + " participants");
            }

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    */
    }
}
