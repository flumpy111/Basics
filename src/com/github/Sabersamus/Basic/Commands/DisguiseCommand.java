package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class DisguiseCommand implements CommandExecutor {
	public static Basic plugin;
	public DisguiseCommand(Basic instance){
		plugin = instance;
	}
	
	StringBuilder newName = new StringBuilder();
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("disguise")){
			if(cs instanceof Player){
				Player player = (Player)cs;
					if(player.hasPermission("basic.disguise")){
						if(args.length >= 2){
							ChatColor color = ChatColor.getByChar(args[0]);
							String name = String.valueOf(args[1]);
							newName.append(name);
							player.setDisplayName(color + newName.toString() + ChatColor.WHITE);
							player.setPlayerListName(color + newName.toString());
							player.sendMessage(ChatColor.AQUA + "You have been disguise as " + color + newName.toString());
							return true;
						}
					}
			}
		}
		return false;
	}
}