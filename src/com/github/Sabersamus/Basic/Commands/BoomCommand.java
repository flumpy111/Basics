package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class BoomCommand implements CommandExecutor{
	public static Basic plugin;
	public BoomCommand(Basic instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("boom") && cs.hasPermission("basic.boom") && cs instanceof Player){
			Player player = (Player)cs;
			if(args.length == 0){
			player.getWorld().createExplosion(player.getLocation(), 10);
			Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.DARK_PURPLE + " JUST EXPLODED!");
			return true;
		}else{
			if(args.length == 1){
				Player target = Bukkit.getPlayer(args[0]);
				target.getWorld().createExplosion(target.getLocation(), 10);
				target.sendMessage(ChatColor.DARK_GREEN + "LOLZ YOU JUST GOT BLOWN UP!");
				player.sendMessage(ChatColor.DARK_GREEN + "LOLZ you just blew up " + target.getDisplayName());
				Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + target.getDisplayName() + ChatColor.DARK_PURPLE + " JUST EXPLODED!");
				return true;
				}
			}
		}
		return false;
		}
	}