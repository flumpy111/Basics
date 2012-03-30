package com.github.Sabersamus.Basic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Settings 
{
	public static Basic plugin;
	public Settings(Basic instance){
		plugin = instance;
	}
	private File confFile = null;
	private FileConfiguration conf = null;
	
	public void loadSettings() {
		this.getSettings().options().copyDefaults(true);
		saveSettings();
	}

	public void reloadSettings() {
		if (confFile == null) {
		confFile = new File(plugin.getDataFolder(), "config.yml");
		}
		conf = YamlConfiguration.loadConfiguration(confFile);

		InputStream defConfigStream = plugin.getResource("config.yml");
		if(defConfigStream != null) {
	YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	conf.setDefaults(defConfig);
	}
}


	public FileConfiguration getSettings() {
		if (conf == null) {
			reloadSettings();
		}
		return conf;
}

	public void saveSettings() {
		if (conf == null || confFile == null) {
			return;
		}
		try {
			conf.save(confFile);
		} catch (IOException ex) {
				ex.printStackTrace();
		}
	}
}
