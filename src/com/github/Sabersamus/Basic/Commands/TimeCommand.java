package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class TimeCommand implements CommandExecutor{
	public static Basic plugin;
	public TimeCommand(Basic instance){
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("time")){
		if(cs.hasPermission("basic.time.self")){
		if(cs instanceof Player){
		if(args.length == 1){
		Player player = (Player) cs;
		String value = String.valueOf(args[0]);
		if(value.equalsIgnoreCase("day")){
		player.setPlayerTime(6000, true);
		return true;
		}else{
			if(value.equalsIgnoreCase("night")){
				player.setPlayerTime(19000, true);
				return true;
			}else{
				if(value.equalsIgnoreCase("normal")){
				player.resetPlayerTime();
				}
			}
		}
		return false;
	}else{
		cs.sendMessage(ChatColor.RED + "Invalid command use");
		return true;
	}
}else{
	cs.sendMessage("You must be a player to do this");
	return true;
}
}else{
	cs.sendMessage(ChatColor.RED + "You dont have permission");
	return true;
}
}
		return false;
	}
}
