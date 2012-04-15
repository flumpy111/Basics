package com.github.Sabersamus.Basic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerSettings 
{
	public static Basic plugin;
	public PlayerSettings(Basic instance){
		plugin = instance;
	}
	
	private FileConfiguration players = null;
	private File playersFile = null;
	
	public void loadPlayers() {
		this.getPlayers().options().copyDefaults(true);
		savePlayers();
		}

		public void reloadPlayers(	) {
			if (playersFile == null) {
			playersFile = new File(plugin.getDataFolder(), "teleblock.yml");
			}
			players = YamlConfiguration.loadConfiguration(playersFile);

			InputStream defConfigStream = plugin.getResource("teleblock.yml");
	if (defConfigStream != null) {
		YamlConfiguration defConfig = YamlConfiguration
	.loadConfiguration(defConfigStream);
		players.setDefaults(defConfig);
	}
}

		public FileConfiguration getPlayers() {
			if (players == null) {
				reloadPlayers();
			}
			return players;
	}

		public void savePlayers() {
			if (players == null || playersFile == null) {
				return;
			}
			try {
				players.save(playersFile);
			} catch (IOException ex) {
					Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
							"Error saving players to " + playersFile, ex);
					ex.printStackTrace();
}
}
}
