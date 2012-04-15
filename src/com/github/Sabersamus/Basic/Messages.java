package com.github.Sabersamus.Basic;

import org.bukkit.ChatColor;

public class Messages 
{
	public static Basic plugin;
	public Messages(Basic instance){
		plugin = instance;
	}
	
	public String getKickMessage(){
		Settings settings = plugin.getSettings();
		return settings.getSettings().getString("Messages.Administration.kick-message").replaceAll("(&([a-f0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getKickBroadCast(){
		Settings settings = plugin.getSettings();
		return settings.getSettings().getString("Messages.Administration.kick-broadcast").replaceAll("(&([a-f0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getBanMessage(){
		Settings settings = plugin.getSettings();
		return settings.getSettings().getString("Messages.Administration.ban-message").replaceAll("(&([a-f0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getBanBroadCast(){
		Settings settings = plugin.getSettings();
		return settings.getSettings().getString("Messages.Administration.ban-broadcast").replaceAll("(&([a-f0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
}
