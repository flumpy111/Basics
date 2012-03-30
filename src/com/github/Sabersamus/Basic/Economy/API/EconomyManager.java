package com.github.Sabersamus.Basic.Economy.API;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.Settings;

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
		Settings settings = plugin.getSettings();
		settings.getSettings().set("Economy.name", name);
		settings.saveSettings();
	}

	/**
	 * Reloads the economy
	 */
	public void reloadEconomy(){
		Settings settings = plugin.getSettings();
		settings.reloadSettings();
	}
	
	/**
	 * Enables the economy
	 */
	public void enableEconomy(){
		Settings settings = plugin.getSettings();
			settings.getSettings().set("Economy.enabled", true);
			settings.saveSettings();
	}
	
	/**
	 * Disables the economy
	 */
	public void disableEconomy(){
		Settings settings = plugin.getSettings();
			settings.getSettings().set("Economy.enabled", false);
			settings.saveSettings();
	}
	
	/**
	 * Gets a boolean value of if the economy has been enabled or not
	 * @return true if the economy is on, false if its off
	 */
	public boolean getEconomyStatus(){
		Settings settings = plugin.getSettings();
			if(settings.getSettings().getBoolean("Economy.enabled") == true){
				return true;
			}else{
				return false;
		}
	}
	
	/**
	 * Checks to see if it shows balance on join
	 * @return boolean, true if the configuration has this set, else false
	 */
	public boolean getShowBalanceOnJoin(){
		Settings settings = plugin.getSettings();
			if(settings.getSettings().getBoolean("Other-Settings.show balance on join") == true){
				return true;
			}else{
				return false;
		}
	}
	
	/**
	 * Gets the economy messages
	 * @return EconomyMessages
	 */
	public EconomyMessages getEconomyMessages(){
		return new EconomyMessages(plugin);
	}
}
