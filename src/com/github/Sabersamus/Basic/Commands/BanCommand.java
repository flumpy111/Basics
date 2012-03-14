package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class BanCommand implements CommandExecutor{
public static Basic plugin;
public BanCommand(Basic instance){
		plugin = instance;
}


@Override
public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
	if(cmd.getName().equalsIgnoreCase("ban")){
		if(cs instanceof Player){
			Player player = (Player)cs;
			if(player.hasPermission("basic.ban")){
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
					String name = target.getName().toLowerCase();
						target.kickPlayer(ChatColor.RED + "You have been banned by " + player.getDisplayName());
						plugin.getBans().set(name + ".Banned", true);
						plugin.saveBans();
						Bukkit.getServer().broadcastMessage(target.getDisplayName() + ChatColor.RED + " has been banned by " + player.getDisplayName());
						return true;
					}else{
						String banName = String.valueOf(args[0].toLowerCase());
						plugin.getBans().set(banName + ".Banned", true);
						plugin.saveBans();
						player.sendMessage(ChatColor.RED + banName + " has been banned");
						return true;
					}
				}
			}
		}else{
			if(args.length == 1){
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null){
				String name = target.getName().toLowerCase();
				target.kickPlayer(ChatColor.RED + "You have been banned");
				Bukkit.getServer().broadcastMessage(target.getDisplayName() + ChatColor.RED + " has been banned");
				plugin.getBans().set(name + ".Banned", true);
				plugin.saveBans();
				return true;
				}else{
					String name = String.valueOf(args[0].toLowerCase());
					plugin.getBans().set(name + ".Banned", true);
					plugin.saveBans();
					cs.sendMessage(name + " has been banned");
					return true;
				}
			}
		}
	}else{
		if(cmd.getName().equalsIgnoreCase("unban")){
			if(cs instanceof Player){
				Player player = (Player)cs;
				if(player.hasPermission("basic.unban")){
					if(args.length == 1){
						String name = String.valueOf(args[0].toLowerCase());
						if(plugin.getBans().contains(name)){
							plugin.getBans().set(name, null);
							plugin.saveBans();
							player.sendMessage(ChatColor.AQUA + name + " has been unbanned");
							return true;
						}else{
							player.sendMessage(ChatColor.RED + name + " is not banned");
							return true;
						}
					}
				}
			}else{
				if(args.length == 1){
					String name = String.valueOf(args[0].toLowerCase());
					if(plugin.getBans().contains(name)){
						plugin.getBans().set(name, null);
						plugin.saveBans();
						cs.sendMessage(name + " has been unbanned");
						return true;
					}else{
						cs.sendMessage(name + " is not banned");
						return true;
					}
				}
			}
		}else{
			if(cmd.getName().equals("rban")){
				if(cs instanceof Player){
					Player player = (Player)cs;
					if(player.hasPermission("basic.rban")){
						if(args.length == 0){
							plugin.reloadBans();
							player.sendMessage(ChatColor.AQUA + "Bans configuration reloaded");
							return true;
						}
					}
				}else{
					if(args.length == 0){
						plugin.reloadBans();
						cs.sendMessage("Bans configuration reloaded");
						return true;
					}
				}
			}
		}
	}
	
	return false;
}
}