package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class PositionCommand implements CommandExecutor {
	public static Basic plugin;
	public PositionCommand(Basic instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("pos")){
			if(cs instanceof Player){
				Player player = (Player)cs;
					if(args.length == 0){
						ChatColor green = ChatColor.DARK_GREEN;
						ChatColor white = ChatColor.WHITE;
					int x = (int)player.getLocation().getX();
					int y = (int)player.getLocation().getY();
					int z = (int)player.getLocation().getZ();
					float yaw = player.getLocation().getYaw();
					float pitch = player.getLocation().getPitch();
					String world = player.getWorld().getName();
					double blocks = player.getLocation().distance(player.getWorld().getSpawnLocation());
					player.sendMessage(green + "----------");
					player.sendMessage(green + "World: " + white + world);
					player.sendMessage(green + "X: " + white + x);
					player.sendMessage(green + "Y: " + white + y);
					player.sendMessage(green + "Z: " + white + z);
					player.sendMessage(green + "Yaw: " + white + yaw);
					player.sendMessage(green + "Pitch: " + white + pitch);
					player.sendMessage(green + "Distance from spawn: " + white + blocks);
					return true;
				}
			}
		}
		return false;
	}
	
}
