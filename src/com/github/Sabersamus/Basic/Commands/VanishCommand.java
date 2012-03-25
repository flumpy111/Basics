package com.github.Sabersamus.Basic.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.github.Sabersamus.Basic.Basic;

public class VanishCommand implements CommandExecutor{
	public static Basic plugin;
	public VanishCommand(Basic instance) {
	plugin = instance;
}
	
	public HashMap<Player, VanishCommand> vanish = new HashMap<Player, VanishCommand>();
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("vanish")){
			if(!(cs instanceof Player))return false;
			if(cs.hasPermission("basic.vanish"));
			if(args.length == 0) {
				Player[] p = Bukkit.getOnlinePlayers();
				Player player = (Player)cs;
				for(Player b : p){
					if(!b.hasPermission("basic.vanish")){
						if(!vanish.containsKey(player)){
						b.hidePlayer(player);
						vanish.put(player, this);
						player.sendMessage(ChatColor.GREEN + "You have vanished");
						return true;
					}else{
						vanish.remove(player);
						player.sendMessage(ChatColor.GREEN + "You have reappeared");
						b.showPlayer(player);
						return true;
					}
				}
			}
		}
	}
		return false;
	}
}
