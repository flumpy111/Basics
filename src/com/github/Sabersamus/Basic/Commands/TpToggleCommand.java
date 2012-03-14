package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class TpToggleCommand implements CommandExecutor{
	public static Basic plugin;
	public TpToggleCommand(Basic instance){plugin = instance;}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tpblock")){
		if(cs.hasPermission("basic.tpblock")){
		if(args.length == 1){
			String toggle = String.valueOf(args[0]);
			Player player = (Player)cs;
			String name = player.getName();
		if(toggle.equalsIgnoreCase("on")){
			plugin.getPlayers().set(name +  ".TpBlock", true);
			player.sendMessage(ChatColor.AQUA + "Teleportation is now blocked to you");
			plugin.savePlayers();
			return true;
		}else{
			if(toggle.equalsIgnoreCase("off")){
				plugin.getPlayers().set(name, null);
				player.sendMessage(ChatColor.AQUA + "Players can now teleport to you again");
				plugin.savePlayers();
				return true;
			}else{
				if(toggle.equalsIgnoreCase("status")){
				if(plugin.getPlayers().contains(name)){
					player.sendMessage(ChatColor.AQUA + "Your TpBlock is on");
					return true;
				}else{
					if(!plugin.getPlayers().contains(name)){
						player.sendMessage(ChatColor.AQUA +"Your TpBlock is off");
						return true;
					}
				}
				}
			}
		}
		}
			
		}
		}
		return false;
	}

}
