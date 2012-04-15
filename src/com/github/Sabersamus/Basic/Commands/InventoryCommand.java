package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class InventoryCommand implements CommandExecutor{
	public static Basic plugin;
	public InventoryCommand(Basic instance){
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("inv")){
			if(cs instanceof Player){
				Player player = (Player)cs;
					if(args.length == 1){
						Player target = Bukkit.getPlayer(args[0]);
							if(target != null){
								player.openInventory(target.getInventory());
								return true;
							}
					}
			}
		}
		return false;
}
}