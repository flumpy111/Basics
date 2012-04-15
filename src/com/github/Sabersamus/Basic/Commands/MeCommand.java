package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class MeCommand implements CommandExecutor{
	public static Basic plugin;
	public MeCommand(Basic instance) {
	plugin = instance;
}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("me")){
			if(args.length != 0){//make sure they actually typed something after /me
			int i=0;
			int para=args.length; String s="";
			while(i<para){
			s=s+" "+args[i];
			i++; //Bad loop I know I'm working on it
			}
			Bukkit.getServer().broadcastMessage("* " + ((Player)cs).getDisplayName() + ChatColor.WHITE + s);
	return true;
	}else{
		if(args.length == 0){
			cs.sendMessage(ChatColor.RED + "Please enter a message first");
	return true;
	}
	return false;
	}
	}
	return false;
	}
	}
