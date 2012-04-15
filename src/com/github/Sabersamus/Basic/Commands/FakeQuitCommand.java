package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class FakeQuitCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Basic plugin;
	public FakeQuitCommand(Basic instance) {
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("fakequit")){
		if(cs instanceof Player && (cs.hasPermission("basic.fakequit")) || cs.isOp()){
		String player = ((Player)cs).getDisplayName();
		 Bukkit.getServer().broadcastMessage(player + " has left the server");
		 ((Player)cs).hidePlayer((Player) cs);
		return true;
			}else{
		if(!cs.hasPermission("fakequit")){
			cs.sendMessage(ChatColor.RED + "You don't have permissions.");
		return true;
		}
	}
		return false;
	}
		return false;
	}
	}