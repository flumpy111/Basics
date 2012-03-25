package com.github.Sabersamus.Basic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BanConfig 
{
	public static Basic plugin;
	public BanConfig(Basic instance){
		plugin = instance;
	}
	
	private FileConfiguration bans = null;
	private File bansFile = null;
	

	public void loadBans() {
		this.getBans().options().copyDefaults(true);
	saveBans();
	}

	public void reloadBans(	) {
		if (bansFile == null) {
		bansFile = new File(plugin.getDataFolder(), "BannedPlayers.yml");
		}
		bans = YamlConfiguration.loadConfiguration(bansFile);

		InputStream defConfigStream = plugin.getResource("BannedPlayers.yml");
if (defConfigStream != null) {
	YamlConfiguration defConfig = YamlConfiguration
.loadConfiguration(defConfigStream);
	bans.setDefaults(defConfig);
}
}


	public FileConfiguration getBans() {
		if (bans == null) {
			reloadBans();
		}
		return bans;
}

	public void saveBans() {
		if (bans == null || bansFile == null) {
			return;
		}
		try {
			bans.save(bansFile);
		} catch (IOException ex) {
				Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
						"Error saving players to " + bansFile, ex);
				ex.printStackTrace();
}
}
}
