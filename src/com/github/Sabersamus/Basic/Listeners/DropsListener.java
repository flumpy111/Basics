package com.github.Sabersamus.Basic.Listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.github.Sabersamus.Basic.Basic;

public class DropsListener implements Listener{
	public static Basic plugin;
	public DropsListener(Basic instance){
		plugin = instance;
	}
	HashMap<Item, Player> hashmap = new HashMap<Item, Player>();
	
	@EventHandler(ignoreCancelled = false, priority = EventPriority.MONITOR)
	public void onDrop(PlayerDropItemEvent event){
		if(event.isCancelled())return;
		Player player = event.getPlayer();
		Item item = event.getItemDrop();
		hashmap.put(item, player);
	}
		
	@EventHandler(ignoreCancelled = false, priority = EventPriority.MONITOR)
	public void onPickup(PlayerPickupItemEvent event){
		if(event.isCancelled())return;
		Player player = event.getPlayer();
		Item item = event.getItem();
		int value = event.getItem().getItemStack().getAmount();
		if(hashmap.containsKey(item)){
			if(event.getPlayer() != hashmap.get(item)){
			player.sendMessage(ChatColor.YELLOW + "You got " + value + " " + ChatColor.AQUA +item.getItemStack().getType().name().toLowerCase().replace("_", " ") + ChatColor.YELLOW + " from " + hashmap.get(event.getItem()).getPlayer().getDisplayName());
			hashmap.get(item).sendMessage(ChatColor.DARK_GREEN + "You gave " + value + " " + ChatColor.AQUA +  item.getItemStack().getType().name().toLowerCase().replace("_", " ") + ChatColor.DARK_GREEN + " to " + player.getDisplayName());
			hashmap	.remove(item);
			}
			
	}
	}
	
}
