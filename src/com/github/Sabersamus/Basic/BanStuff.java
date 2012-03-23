package com.github.Sabersamus.Basic;

import org.bukkit.entity.Player;

/**
 * @author Sabersamus
 * @since 3/23/2012
 */

public class BanStuff 
{
	public static Basic plugin;
	public BanStuff(Basic instance){
		plugin = instance;
	}

	/**
	 * Sets a player to be banned
	 * @param arg0 - the player to be banned
	 */
	public void setBanned(Player arg0){
		plugin.getBans().set(arg0.getName() + ".Banned", true);
		plugin.saveBans();
	}
	
	/**
	 * Unbans a player
	 * @param arg0 - the player to be unbanned
	 */
	public void setUnbanned(String arg0){
		plugin.getBans().set(arg0, null);
		plugin.saveBans();
	}
}
