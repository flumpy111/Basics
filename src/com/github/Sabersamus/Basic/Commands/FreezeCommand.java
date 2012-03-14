package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class FreezeCommand implements CommandExecutor{
	public static Basic plugin;
	public FreezeCommand(Basic instance){
		plugin = instance;
}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("freeze")){
			if(cs instanceof Player){
				Player player = (Player)cs;
		if(player.hasPermission("basic.freeze")){
		if(args.length == 1){
		Player target = Bukkit.getPlayer(args[0]);
		if(target != null){
			if(target.getPassenger() != target){
				target.setPassenger(target);	
				player.sendMessage(target.getDisplayName() + ChatColor.LIGHT_PURPLE + " is now frozen");
			}else{
				target.getPassenger().eject();
				player.sendMessage(target.getDisplayName() + ChatColor.LIGHT_PURPLE + " has been unfrozen");
			}
		}
		return true;
		}else{
			cs.sendMessage(ChatColor.RED + "Please select a player");
			return true;
		}
		}
		}
		}
	
return false;
	}
}

