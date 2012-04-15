package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class SurvivalCommand implements CommandExecutor{
	public static Basic plugin;
	public SurvivalCommand(Basic instance){
		plugin = instance;
}


	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("survival")){
		if(cs.hasPermission("basic.gamemode")){
		if(args.length == 0){
		Player player = (Player) cs; 
		GameMode survival = GameMode.SURVIVAL;
		player.setGameMode(survival);
		cs.sendMessage(ChatColor.DARK_GREEN + "You are now in survival mode");
		return true;
	}else{
		return false;
	}
		}else{
			cs.sendMessage(ChatColor.RED + "You dont have permission");
			return true;
		}
		}
		return false;
	}
	}
