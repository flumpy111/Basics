package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class ClearCommand implements CommandExecutor
{
	public static Basic plugin;
	public ClearCommand(Basic instance){
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("clear")){
			if(cs instanceof Player){
				Player player = (Player)cs;
					player.getInventory().clear();
					player.updateInventory();
					player.sendMessage(ChatColor.AQUA + "Your inventory has been cleared");
					return true;
			}
		}
		return false;
	}
	
	
}
