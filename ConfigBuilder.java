package de.mecrytv.svjobs.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigBuilder {
    private File file;
    private FileConfiguration customFile;

    // Konstruktor
    public ConfigBuilder(String folderPath, String fileName) {
        setup(folderPath, fileName);
    }

    public void setup(String folderPath, String fileName){
        file = new File(folderPath, fileName);

        if (!file.exists()) {
            try{
                file.createNewFile();
            }catch (IOException e) {
                // handle any issues here
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration get() {
        return customFile;
    }

    public void save() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            System.out.println("Konnte die Datei nicht speichern " + file.getName());
        }
    }

    public void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
