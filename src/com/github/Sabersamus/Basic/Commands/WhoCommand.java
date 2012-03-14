package com.github.Sabersamus.Basic.Commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class WhoCommand implements CommandExecutor{
	public static Basic plugin;
	public WhoCommand(Basic instance){
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("who")){ //command
		//permissions node here, if needed :3
		if(args.length == 0){
		Player[] who = Bukkit.getOnlinePlayers();
		for (Player p: who){
		cs.sendMessage(ChatColor.RED + "online players: " + Arrays.asList( p.getDisplayName().toString())); //sends sender a message of players online
		}
		}
		return true;
	}
		return false;
}
}
