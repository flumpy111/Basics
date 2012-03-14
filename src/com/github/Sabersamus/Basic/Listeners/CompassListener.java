package com.github.Sabersamus.Basic.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.github.Sabersamus.Basic.Basic;

public class CompassListener implements Listener {
    //private final Basic plugin;

    public CompassListener(Basic instance) {
        //plugin = instance;
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
     Player player = event.getPlayer();
     	if (player == null) return;
    
     	if (!player.hasPermission("basic.compass.use")) return;
     Action action = event.getAction();
     	if (action != Action.RIGHT_CLICK_AIR) return;
     ItemStack item = event.getPlayer().getItemInHand();
     	if (item == null || item.getType() != Material.COMPASS) return;
     Block block = player.getTargetBlock(null, 256);
     	if (block == null || block.getType() == Material.AIR) return;
     Location dest = block.getLocation();
     	int y = dest.getBlockY();
     	if (y <= 0 || y > 128) return;
     	while (block.getType() != Material.AIR) {
     block = block.getRelative(BlockFace.UP);
     	if (block == null) return;
     dest = block.getLocation();
     	if (dest.getBlockY() >= 127) return;
}
     Location src = player.getLocation();
     dest.setPitch(src.getPitch());
     dest.setYaw(src.getYaw());
     dest.setX(dest.getX()+0.5);
     dest.setZ(dest.getZ()+0.5);
     player.teleport(dest);
     player.sendMessage(ChatColor.RED + "You have teleported using a compass");	
    
}
}