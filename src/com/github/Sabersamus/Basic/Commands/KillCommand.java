package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class KillCommand implements CommandExecutor {
	public static Basic plugin;
	public KillCommand(Basic instance){
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kill")){
		if(args.length == 0){
		if(cs.hasPermission("basic.kill")){
		((Player)cs).setHealth(0);
		return true;
		}else{
			cs.sendMessage(ChatColor.RED + "You aren't allowed to kill yourself!");
			return true;
		}
		}else{
		if(args.length == 1){
		if(cs.hasPermission("basic.kil.other")){
		Player target = Bukkit.getPlayer(args[0]);
		target.setHealth(0);
		cs.sendMessage(ChatColor.BLUE + "You just kill " + target.getDisplayName());
		return true;
		}else{
			Player target = Bukkit.getPlayer(args[0]);
			cs.sendMessage(ChatColor.RED + "You aren't allowed to kill " + target.getDisplayName());
		}
		}
		}
		return false;
	}
		return false;
	}
	}