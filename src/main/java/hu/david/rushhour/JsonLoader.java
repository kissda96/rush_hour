package hu.david.rushhour;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonLoader {

    public GameState load() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    new File("savegame.json"),
                    GameState.class);

        } catch (Exception e) {

            System.out.println("Nincs mentett jatek!");
            return null;
        }
    }
}