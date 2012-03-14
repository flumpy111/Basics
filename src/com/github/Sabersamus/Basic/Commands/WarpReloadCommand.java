package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.github.Sabersamus.Basic.Basic;

public class WarpReloadCommand implements CommandExecutor{
	public static Basic plugin;
	public WarpReloadCommand(Basic instance){
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("warpsreload")){
			if(cs.hasPermission("basic.reloadwarps")){
			plugin.reloadWarps();
			cs.sendMessage(ChatColor.YELLOW + "Warps reloaded");
			return true;
			}else{
				return false;
			}
		}
		return false;
	}

}