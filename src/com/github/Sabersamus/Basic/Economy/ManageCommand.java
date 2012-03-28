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
			EconomyManager settings = plugin.getEcoManager();
			if(cs instanceof Player){
				Player player = (Player)cs;
						if(args.length != 0){
							if(player.hasPermission("basic.economy.manage")){
							String usage = String.valueOf(args[0]);
								if(usage.equalsIgnoreCase("enable") && args.length == 1){
									if(settings.getEconomyStatus() == true){
										player.sendMessage(ChatColor.DARK_AQUA + "The economy is already enabled");
										return true;
									}else if(settings.getEconomyStatus() == false){
										player.sendMessage(ChatColor.DARK_AQUA + "Enabling economy");
										settings.enableEconomy();
										return true;
									}
								}else if(usage.equalsIgnoreCase("disable") && args.length == 1){
									if(settings.getEconomyStatus() == true){
										player.sendMessage(ChatColor.DARK_AQUA + "Disabling economy");
										settings.disableEconomy();
										return true;
									}else if(settings.getEconomyStatus() == false){
										player.sendMessage(ChatColor.DARK_AQUA + "The economy is already disabled");
										return true;
							}
						}else if(usage.equalsIgnoreCase("rename") && args.length > 1){
							String s = "";
							for (int i = 1; i < args.length - 1; i++) {
							s += args[i] + ' ';
							}
							s += args[args.length - 1];
							settings.setEconomyName(s);
								player.sendMessage(ChatColor.AQUA + "Ecnonomy renamed to " + ChatColor.YELLOW + s);
								return true;
						}else if(usage.equalsIgnoreCase("reload") && args.length == 1){
							settings.reloadEconomy();
							player.sendMessage(ChatColor.AQUA + "Economy reloaded");
							return true;
						}
					}
				} else { 
					player.sendMessage(ChatColor.DARK_AQUA + "Basics-Economy: " + ChatColor.YELLOW + plugin.getSettings().getConf().getDouble("version"));
					return true;
				}
			}
		}else if(cmd.getName().equalsIgnoreCase("ecomessage")){
			if(cs instanceof Player && args.length > 0){
				Player player = (Player)cs;
					if(player.hasPermission("basic.economy.manage")){
						String s = "";
						for (int i = 2; i < args.length - 1; i++) {
						s += args[i] + ' ';
						}
						s += args[args.length - 1];
						EconomyMessages messages = plugin.getEcoManager().getEconomyMessages();
							String usage = String.valueOf(args[0]);
								if(usage.equalsIgnoreCase("tell")){
									if(args.length > 1){
									messages.setTellMessage(s);
									return true;
									}else{
										player.sendMessage(messages.getTellMessage());
										return true;
									}
								}
					}
			}
		}
		return false;
	}
}
