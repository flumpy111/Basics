package com.github.Sabersamus.Basic.Economy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.Sabersamus.Basic.Basic;

public class MoneyListener implements Listener{
	public static Basic plugin;
	public MoneyListener(Basic instance){
		plugin = instance;
	}

	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		String name = player.getName();
		String mname = plugin.getConf().getString("Economy.name");
		int amount = plugin.getConf().getInt("Economy.default amount");
		if(!plugin.getMoney().contains(name)){
			plugin.getMoney().set(name + ".Balance", amount);
			player.sendMessage(ChatColor.AQUA + "You're balance has been set to " + amount + " " + mname );
			plugin.saveMoney();
		}
	}
}
