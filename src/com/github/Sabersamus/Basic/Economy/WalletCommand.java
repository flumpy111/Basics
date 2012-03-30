package com.github.Sabersamus.Basic.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

/**
 * @deprecated - using Wallet now, uses the new Economy Api
 */
public class WalletCommand implements CommandExecutor {
	public static Basic plugin;
	public WalletCommand(Basic instance){
		plugin = instance;
	}
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("wallet")){
			if(!(cs instanceof Player))return false;
			String mname = plugin.getSettings().getSettings().getString("Economy.name");
			Player player = (Player)cs;
			String name = player.getName();
			if(args.length == 0){
				int amount = plugin.getEconomyInfo().getMoney().getInt(name + ".Balance");
				player.sendMessage(ChatColor.DARK_AQUA + "You have " + amount  + " " + mname);
				return true;
			}else{
			String usage = String.valueOf(args[0]);
			if(args.length == 1){
				if(usage.equalsIgnoreCase("check") || usage.equalsIgnoreCase("balance")){
					int amount = plugin.getEconomyInfo().getMoney().getInt(name + ".Balance");
					player.sendMessage(ChatColor.DARK_AQUA + "You have " + amount  + " " + mname);
					return true;
				}else if(usage.equalsIgnoreCase("tell")){
					int amount = plugin.getEconomyInfo().getMoney().getInt(name + ".Balance");
					Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.AQUA + " has " + amount + " " + mname);
					return true;
				}
			}else if(args.length == 3){
				if(usage.equalsIgnoreCase("pay") || usage.equalsIgnoreCase("give")){
					Player target = Bukkit.getPlayer(args[1]);
					int amount = Integer.parseInt(args[2]);
					if(target != null){
						plugin.getEconomyInfo().getMoney().set(name + ".Balance", plugin.getEconomyInfo().getMoney().getInt(name + ".Balance") - amount);
						plugin.getEconomyInfo().getMoney().set(target.getName() + ".Balance", plugin.getEconomyInfo().getMoney().getInt(target.getName() + ".Balance") + amount);
						player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + " " + amount + " " + mname);
						target.sendMessage(player.getDisplayName() + ChatColor.AQUA + " gave you " + amount + " " + mname);
						plugin.getEconomyInfo().saveMoney();
						return true;
					}
				}
			}else{
				return false;
			}
			}
			
	}
	return false;
}
}
