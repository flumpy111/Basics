package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class CreativeCommand implements CommandExecutor{
	public static Basic plugin;
	public CreativeCommand(Basic instance){
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("creative")){
			if(!(cs instanceof Player))return false;
			Player player = (Player) cs; 
		if(cs.hasPermission("basic.gamemode")){
		if(args.length == 0){
				GameMode creative = GameMode.CREATIVE;
				player.setGameMode(creative);
				player.sendMessage(ChatColor.DARK_GREEN + "You are now in creative mode");
				return true;
			}
				}
				}
				return false;
			}
			}
