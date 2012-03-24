package com.github.Sabersamus.Basic.Listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;

import com.github.Sabersamus.Basic.Basic;

public class DropsListener implements Listener{
	public static Basic plugin;
	public DropsListener(Basic instance){
		plugin = instance;
	}
	HashMap<Item, Player> hashmap = new HashMap<Item, Player>();
	
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent ev){
		Player player = ev.getPlayer();
		Item item = ev.getItemDrop();
		hashmap.put(item, player);
	}
		
	
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent ev){
		Player player = ev.getPlayer();
		Item item = ev.getItem();
		int value = ev.getItem().getItemStack().getAmount();
		if(hashmap.containsKey(item)){
			if(ev.getPlayer() != hashmap.get(item)){
			player.sendMessage(ChatColor.YELLOW + "You got " + value + " " + ChatColor.AQUA +item.getItemStack().getType().name().toLowerCase().replace("_", " ") + ChatColor.YELLOW + " from " + hashmap.get(ev.getItem()).getPlayer().getDisplayName());
			hashmap.get(item).sendMessage(ChatColor.DARK_GREEN + "You gave " + value + " " + ChatColor.AQUA +  item.getItemStack().getType().name().toLowerCase().replace("_", " ") + ChatColor.DARK_GREEN + " to " + player.getDisplayName());
			hashmap	.remove(item);
			}
			
	}
	}
	
	@EventHandler
	public void onJoin(PlayerPreLoginEvent event){
		
	}
}
