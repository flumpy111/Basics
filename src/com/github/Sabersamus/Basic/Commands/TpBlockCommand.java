package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.PlayerSettings;

public class TpBlockCommand implements CommandExecutor {
	public static Basic plugin;
	public TpBlockCommand(Basic instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tpblock")){
			PlayerSettings info = plugin.getPlayerInfo();
			if(!(cs instanceof Player))return false;
			Player player = (Player)cs;
			if(args.length == 1){
				if(player.hasPermission("basic.tpblock")){
				String usage = String.valueOf(args[0]);
					if(usage.equalsIgnoreCase("on")){
						info.getPlayers().set(player.getName() + ".TpBlock", true);
						player.sendMessage(ChatColor.AQUA + "Teleportation is now blocked to you");
						info.savePlayers();
					}else if(usage.equalsIgnoreCase("off")){
						info.getPlayers().set(player.getName(), null);
						player.sendMessage(ChatColor.AQUA + "Teleportation is now allowed to you");
						info.savePlayers();
					}else if(usage.equalsIgnoreCase("status")){
						if(info.getPlayers().contains(player.getName())){
							player.sendMessage(ChatColor.AQUA + "Your tpblock is on");
							return true;
						}else{
							player.sendMessage(ChatColor.AQUA + "Your tpblock is off");
							return true;
						}
					}
				}
			}
		}
		return false;
	} 
}
