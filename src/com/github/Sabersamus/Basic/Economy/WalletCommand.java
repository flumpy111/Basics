package com.github.Sabersamus.Basic.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class WalletCommand implements CommandExecutor {
	public static Basic plugin;
	public WalletCommand(Basic instance){
		plugin = instance;
	}
	
	Economy eco = new Economy(plugin);
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("wallet")){
			if(!(cs instanceof Player))return false;
			String mname = plugin.getConf().getString("Economy.name");
			Player player = (Player)cs;
			String name = player.getName();
			if(args.length == 0){
				int amount = plugin.getMoney().getInt(name + ".Balance");
				player.sendMessage(ChatColor.DARK_AQUA + "You have " + amount  + " " + mname);
			}else{
			String usage = String.valueOf(args[0]);
			if(args.length == 1){
				if(usage.equalsIgnoreCase("check") || usage.equalsIgnoreCase("balance")){
					int amount = plugin.getMoney().getInt(name + ".Balance");
					player.sendMessage(ChatColor.DARK_AQUA + "You have " + amount  + " " + mname);
					return true;
				}else if(usage.equalsIgnoreCase("tell")){
					int amount = plugin.getMoney().getInt(name + ".Balance");
					Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.AQUA + " has " + amount + " " + mname);
					return true;
				}
			}else if(args.length == 3){
				if(usage.equalsIgnoreCase("pay") || usage.equalsIgnoreCase("give")){
					Player target = Bukkit.getPlayer(args[1]);
					int amount = Integer.parseInt(args[2]);
					if(target != null){
						plugin.getMoney().set(name + ".Balance", plugin.getMoney().getInt(name + ".Balance") - amount);
						plugin.getMoney().set(target.getName() + ".Balance", plugin.getMoney().getInt(target.getName() + ".Balance") + amount);
						player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + " " + amount + " " + mname);
						target.sendMessage(player.getDisplayName() + ChatColor.AQUA + " gave you " + amount + " " + mname);
						plugin.saveMoney();
						return true;
					}
				}
			}else{
				return false;
			}
			}
			
	}else if(cmd.getName().equalsIgnoreCase("pants")){
		if(args.length == 0){
			if(cs instanceof Player){
				Player player = (Player)cs;
				player.sendMessage(ChatColor.GOLD + "Your money: " + eco.getMoney(player));
				return true;
			}
		}
	}
	return false;
}
}