package com.github.Sabersamus.Basic.Economy.API;

import org.bukkit.ChatColor;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.Settings;

public class EconomyMessages
{
	private static Basic plugin;
	public EconomyMessages(Basic instance){
		plugin = instance;
	}
	
	public EconomyMessages()
	{
		
	}
	
	
	public void setCreateMessage(String message){
		Settings config = plugin.getSettings();
		config.getSettings().set("Messages.Economy.account-create-message", message);
		config.saveSettings();
	}
	
	public void setGiveMessage(String message){
		Settings config = plugin.getSettings();
		config.getSettings().set("Message.Economy.give-message", message );
		config.saveSettings();
	}
	
	public void setReceiveMessage(String message){
		Settings config = plugin.getSettings();
		config.getSettings().set("Messages.Economy.receive-message", message);
		config.saveSettings();
	}
	
	public void setTellMessage(String message){
		Settings config = plugin.getSettings();
		config.getSettings().set("Messages.Economy.tell-message", message);
		config.saveSettings();
	}
	
	public void setCheckMessage(String message){
		Settings config = plugin.getSettings();
		config.getSettings().set("Messages.Economy.check-message", message);
		config.saveSettings();
	}
	
	public void setDisabledMessage(String message){
		Settings config = plugin.getSettings();
		config.getSettings().set("Messages.Economy.disabled-message", message);
		config.saveSettings();
	}
	
	public void setInvalidMoneyMessage(String message){
		Settings config = plugin.getSettings();
		config.getSettings().set("Messages.Economy.not-enough-money", message);
		config.saveSettings();
	}
	
	public String getCreateMessage(){
		Settings config = plugin.getSettings();
			return config.getSettings().getString("Messages.Economy.account-create-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getGiveMessage(){
		Settings config = plugin.getSettings();
			return config.getSettings().getString("Messages.Economy.give-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getReceiveMessage(){
		Settings config = plugin.getSettings();
			return config.getSettings().getString("Messages.Economy.receive-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getTellMessage(){
		Settings config = plugin.getSettings();
			return config.getSettings().getString("Messages.Economy.tell-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getCheckMessage(){
		Settings config = plugin.getSettings();
		return config.getSettings().getString("Messages.Economy.check-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getDisabledMessage(){
		Settings config = plugin.getSettings();
		return config.getSettings().getString("Messages.Economy.disabled-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getInvalidMoneyMessage(){
		Settings config = plugin.getSettings();
		return config.getSettings().getString("Messages.Economy.not-enough-money").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
}
