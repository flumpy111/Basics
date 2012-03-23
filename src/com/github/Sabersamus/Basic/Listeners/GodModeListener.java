package com.github.Sabersamus.Basic.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import com.github.Sabersamus.Basic.Basic;

public class GodModeListener implements Listener{
public static Basic plugin;
public GodModeListener(Basic instance) {
plugin = instance;
}


@EventHandler
public void onPlayerDamageEvent(EntityDamageEvent event){
	if(event.getEntity() instanceof Player){
	Player player = (Player) event.getEntity();
		if(player.hasPermission("basic.god")){
			event.setCancelled(true);
		}
	}
}

@EventHandler
public void onFoodLevelChangeEvent(FoodLevelChangeEvent event){
	if(event.getEntity() instanceof Player){
	Player player = (Player) event.getEntity();
	if(player.hasPermission("basic.god")){
		event.setCancelled(true);
	}
	}
}
}