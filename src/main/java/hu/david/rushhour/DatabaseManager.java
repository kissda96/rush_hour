package hu.david.rushhour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseManager {

    private static final String URL =
            "jdbc:sqlite:rushhour.db";

    public DatabaseManager() {

        try (Connection connection =
                     DriverManager.getConnection(URL);
             Statement statement =
                     connection.createStatement()) {

            statement.execute(
                    """
                    CREATE TABLE IF NOT EXISTS players(
                        name TEXT PRIMARY KEY,
                        wins INTEGER DEFAULT 0
                    )
                    """
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addWin(String playerName) {

        try (Connection connection =
                     DriverManager.getConnection(URL)) {

            PreparedStatement update =
                    connection.prepareStatement(
                            "UPDATE players SET wins = wins + 1 WHERE name = ?");

            update.setString(1, playerName);

            int rows = update.executeUpdate();

            if (rows == 0) {

                PreparedStatement insert =
                        connection.prepareStatement(
                                "INSERT INTO players(name, wins) VALUES(?,1)");

                insert.setString(1, playerName);
                insert.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showScoreboard() {

        try (Connection connection =
                     DriverManager.getConnection(URL);
             Statement statement =
                     connection.createStatement()) {

            var resultSet =
                    statement.executeQuery(
                            "SELECT name, wins FROM players ORDER BY wins DESC");

            System.out.println();
            System.out.println("=== HIGH SCORE ===");

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getString("name")
                                + " - "
                                + resultSet.getInt("wins")
                                + " gyozelem");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}