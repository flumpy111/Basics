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
		spawn.setX(spawn.getX() + 0.5);
		spawn.setZ(spawn.getZ() + 0.5);
		((Player)cs).teleport(spawn); 
		cs.sendMessage(ChatColor.AQUA + "Weclome to spawn");
		return true;
	}
		}else if(cmd.getName().equalsIgnoreCase("setspawn") && (cs instanceof Player)){
			Player player = (Player)cs;
			if(args.length == 0){
				if(player.hasPermission("basic.setpawn")){
				int x = (int)(player.getLocation().getX() + 0.5);
				int y = (int)(player.getLocation().getY());
				int z = (int) (player.getLocation().getZ() + 0.5);
				player.getWorld().setSpawnLocation(x, y, z);
				cs.sendMessage(ChatColor.AQUA + "Spawn is set!");
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
