package com.github.Sabersamus.Basic.Economy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.EcoConfig;
import com.github.Sabersamus.Basic.EconomyInfo;

public class MoneyListener implements Listener{
	public static Basic plugin;
	public MoneyListener(Basic instance){
		plugin = instance;
	}

	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		EconomyInfo ecoinfo = plugin.getEconomyInfo();
		Economy eco = plugin.getEconomyAPI();
		EcoConfig settings = plugin.getSettings();
		Player player = event.getPlayer();
		String name = player.getName();
		String mname = settings.getConf().getString("Economy.name");
		if(settings.getConf().getBoolean("Economy.enabled") == true){
		int amount = settings.getConf().getInt("Economy.default amount");
		if(!ecoinfo.getMoney().contains(name)){
			eco.setBalance(player, amount);
			player.sendMessage(ChatColor.AQUA + "You're balance has been set to " + amount + " " + mname );
			}
		}else if(settings.getConf().getBoolean("Economy.enabled") == false){
			return;
		}
	}
}
