package com.github.Sabersamus.Basic.Commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class KickCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Basic plugin;
	public KickCommand(Basic instance) {
		plugin = instance;
}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	        if(cmd.getName().equalsIgnoreCase("kick")){
	                if(args.length != 0){
	                        if ((sender.hasPermission("basic.kick")) || sender.isOp()) {
	                        	if(sender instanceof Player){
	                                Player player = (Player) sender;
	                                Player toKick = Bukkit.getPlayer(args[0]);
	                                if(toKick != null) { 
	                                        if(args.length <= 1){
	                                        toKick.kickPlayer(ChatColor.RED + "Kicked by " + player.getDisplayName());
	                                        }
	                                        else{
	                                        toKick.kickPlayer(ChatColor.RED + "Kicked by " + player.getDisplayName() + ChatColor.RED + " for " + args[1]);
	                                        }
	                                        player.getServer().broadcastMessage(toKick.getDisplayName() + ChatColor.RED + " was kicked by " + player.getDisplayName());
	                                        return true;
	                                        }else{
	                                        player.sendMessage(ChatColor.RED + "Player not online.");
	                                        return true;
	                                        }
	                                }else{
	                                	Player toKick = Bukkit.getPlayer(args[0]);
		                                if(toKick != null) {
		                                        String KickPlayer = (toKick.getDisplayName());
		                                        if(args.length <= 1){
		                                        toKick.kickPlayer(ChatColor.RED + "Kicked by GOD");
		                                        }
		                                        else{
		                                        toKick.kickPlayer(ChatColor.RED + "Kicked for " + args[1]);
		                                        }
		                                        sender.getServer().broadcastMessage(KickPlayer.toString() + ChatColor.RED + " was kicked by GOD ");
		                                        return true;
		                                        }else{
		                                        sender.sendMessage(ChatColor.RED + "Player not online.");
		                                        return true;
		                                        }
	                                }
	                        }
	                        }
	                        }else{
	                        	if(args.length == 0){
	                                sender.sendMessage(ChatColor.RED + "Invalid player");
	                                return true;
	                        	}
	                        return false;
	                }
	                
	                return false;

	}
	}
