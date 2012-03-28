package com.github.Sabersamus.Basic.Economy;

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

	/*
	 * Holy crap this needs cleaning D:
	 */
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		EconomyInfo ecoinfo = plugin.getEconomyInfo();
		Economy eco = plugin.getEconomyAPI();
		EcoConfig settings = plugin.getSettings();
		EconomyManager manager = plugin.getEcoManager();
		String economyMessage = settings.getConf().getString("Messages.account-create-message").replaceAll("(&([a-fk0-9]))", "\u00A7$2");
		Player player = event.getPlayer();
		String name = player.getName();
		String mName = settings.getConf().getString("Economy.name");
		if(settings.getConf().getBoolean("Economy.enabled") == true){
		int amount = settings.getConf().getInt("Economy.default amount");
		if(!ecoinfo.getMoney().contains(name)){
			eco.setBalance(player, amount);
			player.sendMessage(economyMessage.replace("%money", String.valueOf(amount)).replace("%name", mName));
			}else{
				if(manager.getShowBalanceOnJoin()){
					player.sendMessage(settings.getConf().getString("Messages.check-message").replaceAll("(&([a-fk0-9]))", "\u00A7$2").replace("%money", String.valueOf(amount)).replace("%name", mName));
				}
			}
		}else if(settings.getConf().getBoolean("Economy.enabled") == false){
			return;
		}
	}
}
