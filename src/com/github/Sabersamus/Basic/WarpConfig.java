package com.github.Sabersamus.Basic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class WarpConfig 
{
	public static Basic plugin;
	public WarpConfig(Basic instance){
		plugin = instance;
	}
	private File warpsFile = null;
	private FileConfiguration warps = null;
	
	public void loadWarps() {
		this.getWarps().options().copyDefaults(true);
		saveWarps();
		}

		public void reloadWarps(){
			if (warpsFile == null) {
			warpsFile = new File(plugin.getDataFolder(), "warps.yml");
			}
			warps = YamlConfiguration.loadConfiguration(warpsFile);

			InputStream defConfigStream = plugin.getResource("warps.yml");
	if (defConfigStream != null) {
		YamlConfiguration defConfig = YamlConfiguration
	.loadConfiguration(defConfigStream);
		warps.setDefaults(defConfig);
	}
}

		
		public FileConfiguration getWarps() {
			if (warps == null) {
				reloadWarps();
			}
			return warps;
	}

		public void saveWarps() {
			if (warps == null || warpsFile == null) {
				return;
			}
			try{
				warps.save(warpsFile);
			} catch (IOException ex) {
					Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
							"Error saving warps to " + warpsFile, ex);
					ex.printStackTrace();
}
}
}
