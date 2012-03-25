package com.github.Sabersamus.Basic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class EconomyInfo 
{
	public static Basic plugin;
	public EconomyInfo(Basic instance){
		plugin = instance;
	}
	
	private FileConfiguration money = null;
	private File moneyFile = null;
	

	public void loadMoney() {
		this.getMoney().options().copyDefaults(true);
	saveMoney();
	}

	public void reloadMoney() {
		if (moneyFile == null) {
		moneyFile = new File(plugin.getDataFolder(), "Balance.yml");
		}
		money = YamlConfiguration.loadConfiguration(moneyFile);

		InputStream defConfigStream = plugin.getResource("Balance.yml");
if (defConfigStream != null) {
	YamlConfiguration defConfig = YamlConfiguration
.loadConfiguration(defConfigStream);
	money.setDefaults(defConfig);
}
}


	public FileConfiguration getMoney() {
		if (money == null) {
			reloadMoney();
		}
	return money;
}

	public void saveMoney() {
		if (money == null || moneyFile == null) {
			return;
		}
		try {
			money.save(moneyFile);
		} catch (IOException ex) {
				ex.printStackTrace();
}
}
}
