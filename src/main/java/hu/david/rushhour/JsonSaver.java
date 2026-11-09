package hu.david.rushhour;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonSaver {

    public void save(GameState gameState) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(
                            new File("savegame.json"),
                            gameState);

            System.out.println("Jatek elmentve.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}