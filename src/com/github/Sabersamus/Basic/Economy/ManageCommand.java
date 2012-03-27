package com.github.Sabersamus.Basic.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class ManageCommand implements CommandExecutor
{
	public static Basic plugin;
	public ManageCommand(Basic instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("economy")){
			Economy api = plugin.getEconomyAPI();	
			if(cs instanceof Player){
				Player player = (Player)cs;
					if(player.hasPermission("basic.economy.manage")){
						if(args.length != 0){
							String usage = String.valueOf(args[0]);
								if(usage.equalsIgnoreCase("enable") && args.length == 1){
									if(api.getEconomyStatus() == true){
										player.sendMessage(ChatColor.DARK_AQUA + "The economy is already enabled");
										return true;
									}else if(api.getEconomyStatus() == false){
										player.sendMessage(ChatColor.DARK_AQUA + "Enabling economy");
										api.enableEconomy();
										return true;
									}
								}else if(usage.equalsIgnoreCase("disable") && args.length == 1){
									if(api.getEconomyStatus() == true){
										player.sendMessage(ChatColor.DARK_AQUA + "Disabling economy");
										api.disableEconomy();
										return true;
									}else if(api.getEconomyStatus() == false){
										player.sendMessage(ChatColor.DARK_AQUA + "The economy is already disabled");
										return true;
							}
						}else if(usage.equalsIgnoreCase("name") && args.length > 1){
							String s = "";
							for (int i = 1; i < args.length - 1; i++) {
							s += args[i] + ' ';
							}
							s += args[args.length - 1];
								api.setEconomyName(s);
								player.sendMessage(ChatColor.AQUA + "Economy name set to " + ChatColor.YELLOW + s);
								return true;
						}
					}
				} 
			}
		}
		return false;
	}
}
