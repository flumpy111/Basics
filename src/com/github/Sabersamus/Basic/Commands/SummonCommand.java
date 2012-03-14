package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class SummonCommand implements CommandExecutor{
	public static Basic plugin;
	public SummonCommand(Basic instance) {
	plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("summon")){;
		if((cs instanceof Player) && (cs.hasPermission("basic.summon"))){
		if(args.length == 1){
			Player target = Bukkit.getServer().getPlayer(args[0]);
		if(target != null){
			cs.sendMessage(ChatColor.BLUE + "Summoning " + target.getDisplayName());
			target.teleport(((Player) cs).getLocation());
			target.sendMessage(((Player) cs).getDisplayName() + ChatColor.BLUE + " summoned you");
			return true;
		}else{
			cs.sendMessage(ChatColor.RED + "Invalid player");
			return false;
		}
	}else{
		return false;
	}
	}else{
		cs.sendMessage(ChatColor.RED + "You don't have permission");
		return true;
	}
	}
		return false;
	}
	}