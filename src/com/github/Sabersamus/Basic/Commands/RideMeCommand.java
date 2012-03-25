package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.github.Sabersamus.Basic.Basic;

public class RideMeCommand implements CommandExecutor{
	public static Basic plugin;
	public RideMeCommand(Basic instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases,String[] args) {
		if(cmd.getName().equalsIgnoreCase("rideme")){
		if(cs instanceof Player && cs.hasPermission("basic.ride") || cs.isOp()){
		Player target = Bukkit.getPlayer(args[0]);
		if(args.length == 1){
		if(target != null){
		((Player) cs).setPassenger(target);
		cs.sendMessage(ChatColor.BLUE + target.getName() +" is now riding you." );
		return true;
	}else{
		cs.sendMessage(ChatColor.RED + "Invalid player");
		return true;
		}
	}else{
		cs.sendMessage(ChatColor.RED + "Pick a player");
		return true;
	}
	}
	}
		return false;
	}
	}
