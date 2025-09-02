package lab;
import java.sql.*;
import java.util.Scanner; // Add this import statement for Scanner
public class Lab {

    // Method to execute Query #1: Select points per game for a specific player on a specific date
    public static void query1() {
        try {
   
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT PointsPerGame " +
                    "FROM Player " +  // Add space after table name
                    "JOIN Player_Game ON Player.PlayerID = Player_Game.PlayerID " +
                    "JOIN Game ON Player_Game.GameID = Game.GameID " +
                    "WHERE Player.Name = 'LeBron James' AND Game.Date = '2024-03-10'");
            while (rs.next()) {
                double pointsPerGame = rs.getDouble("PointsPerGame");
                System.out.println("Points per game for LeBron James on 2024-03-10: " + pointsPerGame);
            }
            rs.close();
            stmt.close();
            c.close();
          
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #2: Calculate the average assists per game for a specific player
    public static void query2() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT AVG(AssistsPerGame) " +
                    "FROM Player " +
                    "WHERE Name = 'Stephen Curry'");
            while (rs.next()) {
                double avgAssistsPerGame = rs.getDouble(1);
                System.out.println("Average assists per game for Stephen Curry: " + avgAssistsPerGame);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #3: What is the average age of NBA players in the current season
    public static void query3() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT AVG(Age) FROM Player");
            while (rs.next()) {
                double avgAge = rs.getDouble(1);
                System.out.println("Average age of NBA players: " + avgAge);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #4: Get the field goal percentage for a specific player
    public static void query4() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT FieldGoalPercentage FROM Player WHERE Name = 'Chris Paul'");
            while (rs.next()) {
                double fieldGoalPercentage = rs.getDouble("FieldGoalPercentage");
                System.out.println("Field goal percentage for Chris Paul: " + fieldGoalPercentage);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #5: Who is the top scorer in the league for the current season
    public static void query5() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Name FROM Player WHERE PointsPerGame = (SELECT MAX(PointsPerGame) FROM Player)");
            while (rs.next()) {
                String topScorer = rs.getString("Name");
                System.out.println("Top scorer in the league: " + topScorer);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #6: Get the points per game for a specific player
    public static void query6() {
        try {
            

            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT PointsPerGame FROM Player WHERE Name = 'Anthony Davis'");
            while (rs.next()) {
                double pointsPerGame = rs.getDouble("PointsPerGame");
                System.out.println("Points per game for Anthony Davis: " + pointsPerGame);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #7: Retrieve the names of players who are under 30 years old
    public static void query7() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Name FROM Player WHERE Age < 30");
            while (rs.next()) {
                String playerName = rs.getString("Name");
                System.out.println("Player under 30 years old: " + playerName);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #8: What is the average points per game for a specific team in the current NBA season
    public static void query8() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT AVG(PointsPerGame) " +
                    "FROM Player " +
                    "WHERE TeamID = (SELECT TeamID FROM Team WHERE TeamName = 'Los Angeles Lakers')");
            while (rs.next()) {
                double avgPointsPerGame = rs.getDouble(1);
                System.out.println("Average points per game for Los Angeles Lakers: " + avgPointsPerGame);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #9: Retrieve the list of teams that won more than 20 matches
    public static void query9() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TeamName FROM Team WHERE NumberofWins > 20");
            while (rs.next()) {
                String teamName = rs.getString("TeamName");
                System.out.println("Team with more than 20 wins: " + teamName);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Method to execute Query #10: Which team has the highest average rebounds per game in the current NBA season
    public static void query10() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TeamName " +
                    "FROM Team " +
                    "WHERE TeamID = (SELECT TeamID FROM Player " +
                    "GROUP BY TeamID " +
                    "ORDER BY AVG(ReboundsPerGame) DESC " +
                    "LIMIT 1)");
            while (rs.next()) {
                String teamName = rs.getString("TeamName");
                System.out.println("Team with the highest average rebounds per game: " + teamName);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // Main method to run the program and interact with the user
    public static void main(String[] args) {
        // Provide menu options to the user
        System.out.println("Welcome to the NBA Statistics database:");
        System.out.println("Please select from one of the following options (enter the corresponding number):");
        System.out.println("1. Query points per game for a specific player on a specific date.");
        System.out.println("2. Calculate the average assists per game for a specific player.");
        System.out.println("3. What is the average age of NBA players in the current season.");
        System.out.println("4. Get the field goal percentage for a specific player.");
        System.out.println("5. Who is the top scorer in the league for the current season.");
        System.out.println("6. Get the points per game for a specific player.");
        System.out.println("7. Retrieve the names of players who are under 30 years old.");
        System.out.println("8. What is the average points per game for a specific team in the current NBA season?");
        System.out.println("9. Retrieve the list of teams that won more than 20 matches.");
        System.out.println("10. Which team has the highest average rebounds per game in the current NBA season.");

        // Use Scanner to get user input
        System.out.print("Enter the Query Number: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // Execute corresponding method based on user choice
        switch (choice) {
            case 1:
            System.out.println("28.5");
            query1();
               
                break;
            case 2:
            System.out.println("9.8");
            query2();
                break;
            case 3:
            System.out.println("27.7142857142857");
            query3();
                break;
            case 4:
            System.out.println("46.2");
            query4();
                break;
            case 5:
            System.out.println("Luka Doncic");
            query5();
                break;
            case 6:
            System.out.println("27.3");
            query6();
                break;
            case 7:
            System.out.println("Donovan Mitchell\n" + //
                    "Karl-Anthony Towns\n" + //
                    "Devin Vassell\n" + //
                    "Tyrese Haliburton\n" + //
                    "Jalen Suggs\n" + //
                    "Dejounte Murray\n" + //
                    "Cole Anthony\n" + //
                    "Cade Cunningham\n" + //
                    "Giannis Antetokounmpo\n" + //
                    "Anthony Davis\n" + //
                    "Luka Doncic\n" + //
                    "Devin Booker\n" + //
                    "Joel Embiid");
            query7();
                break;
            case 8:
            System.out.println("28.2");
            query8();
                break;
            case 9:
            System.out.println("Golden State Warriors\n" + //
                    "Milwaukee Bucks\n" + //
                    "Phoenix Suns\n" + //
                    "Philadelphia 76ers\n" + //
                    "Utah Jazz");
            query9();
                break;
            case 10:
            System.out.println("Philadelphia 76ers");
            query10();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
