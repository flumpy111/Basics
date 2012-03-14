package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.github.Sabersamus.Basic.Basic;

public class MessageCommand implements CommandExecutor{
	@SuppressWarnings("unused")
	private Basic plugin;
	public MessageCommand(Basic instance) {
		plugin = instance;
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("m")){
		Player target = Bukkit.getServer().getPlayer(args[0]);
		if(target != null){
			String msg = "";
			for (int i = 1; i < args.length - 1; i++) {
			msg += args[i] + ' ';
			}
			msg += args[args.length - 1];
			if((args.length != 0) && (args.length != 1)){
			cs.sendMessage(ChatColor.RED + "(to): " + ChatColor.DARK_GREEN + "[" + target.getDisplayName() + ChatColor.DARK_GREEN + "]" + ": " + ChatColor.WHITE + msg);
			target.sendMessage(ChatColor.RED + "(from): " + ChatColor.DARK_GREEN + "[" + ((Player) cs).getDisplayName() +ChatColor.DARK_GREEN + "]" + ": " + ChatColor.WHITE + msg);
			return true;
			}else{
				cs.sendMessage(ChatColor.RED +  "Y U NO ENTER MESSAGE?");
				return true;
			}
		}else{
			cs.sendMessage(ChatColor.RED + "That player is offline");
		return true;
		}
	}
		return false;
	}
	}