package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class DisguiseCommand implements CommandExecutor {
	public static Basic plugin;
	public DisguiseCommand(Basic instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("disguise")){
			if(cs.hasPermission("basic.disguise") || cs.isOp()){
			ChatColor color = ChatColor.getByChar(args[0]);
			if(args.length == 2){
			if(color !=null){
				String target = args[1];
				((Player)cs).setDisplayName(color + target + ChatColor.WHITE);
				cs.sendMessage(ChatColor.YELLOW + "You have been disguised as " + color + target);
				((Player)cs).setPlayerListName(color + target);
				return true;
		}else{
			cs.sendMessage(ChatColor.RED + "Invalid command usage");
			return true;
			}
	}else{
	cs.sendMessage(ChatColor.RED + "Invalid command usage");
		return true;
	}
	}else{
	cs.sendMessage(ChatColor.RED + "You don't have permissons.");
		return true;
	}
		}
		return false;
	}
	}