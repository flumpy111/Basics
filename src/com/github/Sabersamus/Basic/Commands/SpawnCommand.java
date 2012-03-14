package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class SpawnCommand implements CommandExecutor{
	public static Basic plugin;
	public SpawnCommand(Basic instance){
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
	if(cmd.getName().equalsIgnoreCase("spawn") && (cs instanceof Player)){
	if(args.length == 0){
	Location spawn = ((Player)cs).getWorld().getSpawnLocation();
		((Player)cs).teleport(spawn); 
		cs.sendMessage(ChatColor.AQUA + "Weclome to spawn");
		return true;
	}else{
		cs.sendMessage(ChatColor.RED + "Invalid command use");
		return true;
			}
		}if(cmd.getName().equalsIgnoreCase("setspawn") && (cs instanceof Player)){
			if(args.length == 0){
				if(cs.hasPermission("basic.setpawn")){
				double x = ((Player)cs).getLocation().getX();
				double y = ((Player)cs).getLocation().getY();
				double z = ((Player)cs).getLocation().getZ();
				((Player)cs).getWorld().setSpawnLocation((int)x, (int)y, (int)z);
				cs.sendMessage(ChatColor.AQUA + "Spawn set!");
				return true;
	}
		return false;
	}else{
		return false;
	}
}
		return false;
	}
}
