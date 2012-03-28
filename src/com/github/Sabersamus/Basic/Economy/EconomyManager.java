package com.github.Sabersamus.Basic.Economy;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.EcoConfig;

/**
 * Manages the economy's settings
 * @author Sabersamus
 */
public class EconomyManager 
{
	public static Basic plugin;
	public EconomyManager(Basic instance){
		plugin = instance;
	}
	
	/**
	 * Renames the economy
	 * @param name - string, the name to be set 
	 */
	public void setEconomyName(String name){
		EcoConfig settings = plugin.getSettings();
		settings.getConf().set("Economy.name", name);
		settings.saveConf();
	}

	/**
	 * Reloads the economy
	 */
	public void reloadEconomy(){
		EcoConfig settings = plugin.getSettings();
		settings.reloadConf();
	}
	
	/**
	 * Enables the economy
	 */
	public void enableEconomy(){
		EcoConfig settings = plugin.getSettings();
			settings.getConf().set("Economy.enabled", true);
			settings.saveConf();
	}
	
	/**
	 * Disables the economy
	 */
	public void disableEconomy(){
		EcoConfig settings = plugin.getSettings();
			settings.getConf().set("Economy.enabled", false);
			settings.saveConf();
	}
	
	/**
	 * Gets a boolean value of if the economy has been enabled or not
	 * @return true if the economy is on, false if its off
	 */
	public boolean getEconomyStatus(){
		EcoConfig settings = plugin.getSettings();
			if(settings.getConf().getBoolean("Economy.enabled") == true){
				return true;
			}else{
				return false;
		}
	}
	
	public boolean getShowBalanceOnJoin(){
		EcoConfig settings = plugin.getSettings();
			if(settings.getConf().getBoolean("Other-Settings.show balance on join") == true){
				return true;
			}else{
				return false;
		}
	}
	
	public EconomyMessages getEconomyMessages(){
		return new EconomyMessages(plugin);
	}
}
