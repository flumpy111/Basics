package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class RideCommand implements CommandExecutor{
	public static Basic plugin;
	public RideCommand(Basic instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases,String[] args) {
		if(cmd.getName().equalsIgnoreCase("ride")){
		if((cs instanceof Player) && (cs.hasPermission("basic.ride"))){
		if(args.length == 1){
		Player target = Bukkit.getPlayer(args[0]);
		if(target != null) {
		((Player)target).setPassenger((Player) cs);
		cs.sendMessage(ChatColor.BLUE + "You are now riding " + target.getName());
		return true;
		}else{
			return true;
		}
		}else{
			cs.sendMessage(ChatColor.RED + "Y u no select player?");
			return true;
		}
		}else{
			cs.sendMessage(ChatColor.RED + "You don't have permission");
			return true;
		}
		}
		return false;
	}
	}