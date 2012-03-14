package com.github.Sabersamus.Basic.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.Commands.VanishCommand;

public class BasicPlayerListener implements Listener {
public static Basic plugin;
public BasicPlayerListener(Basic instance) {
plugin = instance;
}

private VanishCommand vc = new VanishCommand(plugin);

@EventHandler
	public void onLog(PlayerLoginEvent ev){
		Player player = ev.getPlayer();
		String name = player.getName().toLowerCase();
			if(plugin.getBans().contains(name)){
				ev.disallow(Result.KICK_BANNED, ChatColor.RED + "You are banned from this server");
			}
}

@EventHandler
	public void onJoin(PlayerJoinEvent ev){
	Player player = ev.getPlayer();
	Player[] a = Bukkit.getOnlinePlayers();
	for(Player b : a){
		if(vc.vanish.containsKey(b)){
			if(!player.hasPermission("basic.vanish")){
			player.hidePlayer(b);
			}else{
				player.canSee(b);
			}
		}
	}
	
}

}
