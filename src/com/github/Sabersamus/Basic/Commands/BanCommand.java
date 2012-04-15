package com.github.Sabersamus.Basic.Commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.BanConfig;
import com.github.Sabersamus.Basic.Basic;

public class BanCommand implements CommandExecutor{
public static Basic plugin;
public BanCommand(Basic instance){
		plugin = instance;
}


@Override
public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
	if(cmd.getName().equalsIgnoreCase("ban")){
		Logger log = plugin.getLogger();
		BanConfig config = plugin.getBansInfo();
		if(cs instanceof Player){
			Player player = (Player)cs;
			if(player.hasPermission("basic.ban")){
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
					String name = target.getName().toLowerCase();
						target.kickPlayer(plugin.getMessages().getBanMessage().replace("%banner", player.getDisplayName()));
						config.getBans().set(name + ".Banned", true);
						config.saveBans();
						Bukkit.getServer().broadcastMessage(plugin.getMessages().getBanBroadCast().replace("%player", target.getDisplayName()).replace("%banner", player.getDisplayName()));
						log.info(name + " has been banned");
						return true;
					}else{
						String banName = String.valueOf(args[0].toLowerCase());
						config.getBans().set(banName + ".Banned", true);
						config.saveBans();
						player.sendMessage(ChatColor.RED + banName + " has been banned");
						log.info(banName + "has been banned");
						return true;
					}
				}
			}
		}else{
			if(args.length == 1){
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null){
				String name = target.getName().toLowerCase();
				target.kickPlayer(plugin.getMessages().getBanMessage().replace("%banner", "console"));
				Bukkit.getServer().broadcastMessage(plugin.getMessages().getKickBroadCast().replace("%player", target.getDisplayName()).replace("%banner", "console"));
				config.getBans().set(name + ".Banned", true);
				config.saveBans();
				return true;
				}else{
					String name = String.valueOf(args[0].toLowerCase());
					config.getBans().set(name + ".Banned", true);
					config.saveBans();
					cs.sendMessage(name + " has been banned");
					return true;
				}
			}
		}
	}else{
		if(cmd.getName().equalsIgnoreCase("unban")){
			Logger log = plugin.getLogger();
			BanConfig config = plugin.getBansInfo();
			if(cs instanceof Player){
				Player player = (Player)cs;
				if(player.hasPermission("basic.unban")){
					if(args.length == 1){
						String name = String.valueOf(args[0].toLowerCase());
						if(config.getBans().contains(name)){
							config.getBans().set(name, null);
							config.saveBans();
							player.sendMessage(ChatColor.AQUA + name + " has been unbanned");
							log.info(name + " has been unbanned");
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
					if(config.getBans().contains(name)){
						config.getBans().set(name, null);
						config.saveBans();
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
				BanConfig config = plugin.getBansInfo();
				if(cs instanceof Player){
					Player player = (Player)cs;
					if(player.hasPermission("basic.rban")){
						if(args.length == 0){
							config.reloadBans();
							player.sendMessage(ChatColor.AQUA + "Bans configuration reloaded");
							return true;
						}
					}
				}else{
					if(args.length == 0){
						config.reloadBans();
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