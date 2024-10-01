package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import models.ApplicationConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AppConfigLoader {
    @Getter
    private static ApplicationConfiguration config;

    public static void loadConfig() {
        ObjectMapper mapper = new ObjectMapper();
        try {
//            copyConfig(".env.local.zafir.device1.json");
            config = mapper.readValue(new File("src/test/java/configs/.env.json"), ApplicationConfiguration.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static void copyConfig(String sourceEnv) {
        try {
            Files.copy(
                    Paths.get("src/test/java/configs/" + sourceEnv),
                    Paths.get("src/test/java/configs/.env.json"),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Like a thief in the night, the deed is done! " + sourceEnv + " has taken over .env.json!");
        } catch (IOException e) {
            System.err.println("Alas, the operation faltered. Here's why: " + e.getMessage());
            throw new RuntimeException("Failed to replace the configuration, thus halting the gears of progress", e);
        }
    }

    static {
        loadConfig();
    }
}
