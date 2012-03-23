package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class FeedCommand implements CommandExecutor {
	public static Basic plugin;
	public FeedCommand(Basic instance){
		plugin = instance;
	}
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("feed")){
			if(cs instanceof Player){
				Player player = (Player)cs;
			if(player.hasPermission("basic.feed")){
			if(args.length == 0){
			player.setFoodLevel(20);
		return true;
		}else{
		if(args.length == 1){
		if(player.hasPermission("basic.feed.other")){
		Player target = Bukkit.getPlayer(args[0]);
		if(target != null){
		target.setFoodLevel(20);
		target.sendMessage(ChatColor.YELLOW + "You have just been fed.");
		return true;
	}else{
			player.sendMessage(ChatColor.RED + "Invalid player");
			return true;
		}
	}
	}
			}
		}
			}
		}
		return false;
	}
	}
