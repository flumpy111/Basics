package com.github.Sabersamus.Basic.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;

import com.github.Sabersamus.Basic.Basic;

public class CompassListener implements Listener {
	public static Basic plugin;
    public CompassListener(Basic instance) {
    	plugin = instance;
    }
    
    Player player;
    Location loc;
    Block block;
    Action action;
    ItemStack item;
    float pitch;
    float yaw;
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent ev){
    	player = ev.getPlayer();
    	block = player.getTargetBlock(null, 1000);
    	loc = block.getLocation();
    	action = ev.getAction();
    	item = player.getItemInHand();
    	if(item.getType() == Material.COMPASS){
    	if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK ){
    	if(loc != null){
    		
    		pitch = player.getLocation().getPitch();
    		yaw = player.getLocation().getYaw();
    		loc.setPitch(pitch);
    		loc.setYaw(yaw);
    			player.teleport(loc.add(0.5, 1, 0.5), TeleportCause.PLUGIN);
    			player.sendMessage(ChatColor.AQUA + "You have teleported using a compass");
    			ev.setCancelled(true);
    			}
    		}
    	}
    }
}