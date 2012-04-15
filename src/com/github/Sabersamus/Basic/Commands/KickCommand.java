package com.github.Sabersamus.Basic.Commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.Messages;

public class KickCommand implements CommandExecutor {
	public static Basic plugin;
	public KickCommand(Basic instance) {
		plugin = instance;
}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("kick")){
			Messages messages = plugin.getMessages();
			if(cs instanceof Player){
				Player player = (Player)cs;
					if(player.hasPermission("basic.kick")){
						String kickMessage = messages.getKickMessage();
						String kickBroadcast = messages.getKickBroadCast();
						if(args.length == 1){
							Player target = Bukkit.getPlayer(args[0]);
								if(target != null){
									target.kickPlayer(kickMessage.replace("%kicker", player.getDisplayName()));
									Bukkit.getServer().broadcastMessage(kickBroadcast.replace("%player", target.getDisplayName()).replace("%kicker", player.getDisplayName()));
									return true;
								}else{
									player.sendMessage(ChatColor.RED + String.valueOf(args[0]) + " is not online");
									return true;
								}
						}
					}
			}else{
				String kickMessage = messages.getKickMessage();
				String kickBroadcast = messages.getKickBroadCast();
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
						if(target != null){
							target.kickPlayer(kickMessage.replace("%kicker", "console"));
							Bukkit.getServer().broadcastMessage(kickBroadcast.replace("%player", target.getDisplayName()).replace("%kicker", "console"));
							return true;
						}else{
							cs.sendMessage(ChatColor.RED + String.valueOf(args[0]) + " is not online");
							return true;
					}
				}
			}
		}
	return false;
	}
}
