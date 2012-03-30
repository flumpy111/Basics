package com.github.Sabersamus.Basic.Economy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.EconomyInfo;
import com.github.Sabersamus.Basic.Settings;
import com.github.Sabersamus.Basic.Economy.API.Economy;
import com.github.Sabersamus.Basic.Economy.API.EconomyManager;

public class MoneyListener implements Listener{
	public static Basic plugin;
	public MoneyListener(Basic instance){
		plugin = instance;
	}

	/*
	 * Holy crap this needs cleaning D:
	 */
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		EconomyInfo ecoinfo = plugin.getEconomyInfo();
		Economy eco = plugin.getEconomyAPI();
		Settings settings = plugin.getSettings();
		EconomyManager manager = plugin.getEcoManager();
		
		String economyMessage = manager.getEconomyMessages().getCreateMessage();
		Player player = event.getPlayer();
		String name = player.getName();
		Economy api = plugin.getEconomyAPI();
		String mName = settings.getSettings().getString("Economy.name");
		if(settings.getSettings().getBoolean("Economy.enabled") == true){
		int amount = settings.getSettings().getInt("Economy.default amount");
		if(!ecoinfo.getMoney().contains(name)){
			eco.setBalance(player, amount);
			player.sendMessage(economyMessage.replace("%money", String.valueOf(amount)).replace("%name", mName));
			}else{
				if(manager.getShowBalanceOnJoin()){
					player.sendMessage(manager.getEconomyMessages().getCheckMessage().replace("%money", String.valueOf(api.getBalance(player))).replace("%name", mName));
				}
			}
		}else if(settings.getSettings().getBoolean("Economy.enabled") == false){
			return;
		}
	}
}
