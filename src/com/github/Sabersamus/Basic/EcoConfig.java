package com.github.Sabersamus.Basic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class EcoConfig 
{
	public static Basic plugin;
	public EcoConfig(Basic instance){
		plugin = instance;
	}
	private File confFile = null;
	private FileConfiguration conf = null;
	
	public void loadConf() {
		this.getConf().options().copyDefaults(true);
		saveConf();
	}

	public void reloadConf() {
		if (confFile == null) {
		confFile = new File(plugin.getDataFolder(), "Economy Settings.yml");
		}
		conf = YamlConfiguration.loadConfiguration(confFile);

		InputStream defConfigStream = plugin.getResource("Economy Settings.yml");
		if(defConfigStream != null) {
	YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	conf.setDefaults(defConfig);
	}
}


	public FileConfiguration getConf() {
		if (conf == null) {
			reloadConf();
		}
		return conf;
}

	public void saveConf() {
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
