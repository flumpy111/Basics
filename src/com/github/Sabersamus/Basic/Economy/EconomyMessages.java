package com.github.Sabersamus.Basic.Economy;

import org.bukkit.ChatColor;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.EcoConfig;

public class EconomyMessages
{
	private static Basic plugin;
	public EconomyMessages(Basic instance){
		plugin = instance;
	}
	
	public void setCreateMessage(String message){
		EcoConfig config = plugin.getSettings();
		config.getConf().set("Messages.account-create-message", "'" + message + "'");
		config.saveConf();
	}
	
	public void setGiveMessage(String message){
		EcoConfig config = plugin.getSettings();
		config.getConf().set("Message.give-message", "'" + message + "'");
		config.saveConf();
	}
	
	public void setReceivingMessage(String message){
		EcoConfig config = plugin.getSettings();
		config.getConf().set("Messages.receive-message", "'" + message + "'");
		config.saveConf();
	}
	
	public void setTellMessage(String message){
		EcoConfig config = plugin.getSettings();
		config.getConf().set("Messages.tell-message", "'" + message + "'");
		config.saveConf();
	}
	
	public void setCheckMessage(String message){
		EcoConfig config = plugin.getSettings();
		config.getConf().set("Messages.check-message", "'" + message + "'");
		config.saveConf();
	}
	
	public void setDisabledMessage(String message){
		EcoConfig config = plugin.getSettings();
		config.getConf().set("Messages.disabled-message", "'" + message + "'");
		config.saveConf();
	}
	
	public void setInvalidMoneyMessage(String message){
		EcoConfig config = plugin.getSettings();
		config.getConf().set("Messages.not-enough-money", "'" + message + "'");
		config.saveConf();
	}
	
	public String getCreateMessage(){
		EcoConfig config = plugin.getSettings();
			return config.getConf().getString("Messages.account-create-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getGiveMessage(){
		EcoConfig config = plugin.getSettings();
			return config.getConf().getString("Messages.give-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getTellMessage(){
		EcoConfig config = plugin.getSettings();
			return config.getConf().getString("Messages.tell-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getCheckMessage(){
		EcoConfig config = plugin.getSettings();
		return config.getConf().getString("Messages.check-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getDisabledMessage(){
		EcoConfig config = plugin.getSettings();
		return config.getConf().getString("Messages.disabled-message").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
	
	public String getInvalidMoneyMessage(){
		EcoConfig config = plugin.getSettings();
		return config.getConf().getString("Messages.not-enough-money").replaceAll("(&([a-fk0-9]))", ChatColor.COLOR_CHAR + "$2");
	}
}
