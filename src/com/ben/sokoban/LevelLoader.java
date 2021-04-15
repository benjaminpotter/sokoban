package com.ben.sokoban;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LevelLoader {

    /**
     * Loads a level layout string from a resource
     * @param resName name of the resource in res folder, expects file of type txt
     * @return content from file as a string
     */
    static String[] loadLevelDataFromFile(String resName) {
        StringBuilder content = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get("C:\\dev\\sokoban\\src\\res\\" + resName), StandardCharsets.UTF_8)) {
            stream.forEach(content::append);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        String[] levelLayouts = content.toString().split("-");

        // expects file to contain two copies of the level, one "starting" and one "complete"
        return levelLayouts;
    }
}
