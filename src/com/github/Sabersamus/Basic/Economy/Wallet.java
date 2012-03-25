package com.github.Sabersamus.Basic.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.EcoConfig;

public class Wallet implements CommandExecutor
{
	public static Basic plugin;
	public Wallet(Basic instance){
		plugin = instance;
	}
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("wallet")){
			Economy eco = plugin.getEconomyAPI();
			EcoConfig settings = plugin.getSettings();
			String mName = settings.getConf().getString("Economy.name");
				if(cs instanceof Player){
					Player player = (Player)cs;
					if(settings.getConf().getBoolean("Economy.enabled") == true){
						if(args.length == 0){
							int money = eco.getBalance(player);
							player.sendMessage(ChatColor.DARK_AQUA + "Your balance is " + ChatColor.GOLD + money + ChatColor.DARK_AQUA + " " + mName);
							return true;
						}else{
							String usage = String.valueOf(args[0]);
							if(args.length == 1){
								if(usage.equalsIgnoreCase("balance") || usage.equalsIgnoreCase("check")){
									int money = eco.getBalance(player);
									player.sendMessage(ChatColor.DARK_AQUA + "Your balance is " + ChatColor.GOLD + money + ChatColor.DARK_AQUA + " " + mName);
									return true;
								}else if(usage.equalsIgnoreCase("tell")){
									int money = eco.getBalance(player);
									player.getServer().broadcastMessage(player.getDisplayName() + ChatColor.AQUA  + " has " + ChatColor.GOLD + money + ChatColor.AQUA + " " + mName);
									return true;
						}
					}else if(args.length == 3){
						if(usage.equalsIgnoreCase("give") || usage.equalsIgnoreCase("pay")){
							Player target = Bukkit.getPlayer(args[1]);
								if(target != null){
									int value = Integer.parseInt(args[2]);
									if(value == 0){
										return true;
									}
										if(eco.getBalance(player) - value < 0){
											player.sendMessage(ChatColor.RED + "You dont have that much money!");
											return true;
								}
										eco.addMoney(target, value);
										eco.subtractMoney(player, value);
										player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + " " + ChatColor.GOLD + value + ChatColor.AQUA + " " + mName);
										target.sendMessage(player.getDisplayName() + ChatColor.AQUA + " gave you " + ChatColor.GOLD + value + ChatColor.AQUA + " " + mName);
										return true;
								}
							}
						}
					}
				}else if(settings.getConf().getBoolean("Economy.enabled") == false){
					player.sendMessage(ChatColor.RED + "Economy is disabled");
						return true;
				}
			}
		}
		return false;
	}
}
