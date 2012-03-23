package com.github.Sabersamus.Basic.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class Wallet implements CommandExecutor{
	public static Basic plugin;
	public Wallet(Basic instance){
		plugin = instance;
	}
	
	Economy eco = new Economy(plugin);
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("balance")){
			if(cs instanceof Player){
				Player player = (Player)cs;
				if(args.length == 0){
					int money = eco.getMoney(player);
						player.sendMessage(ChatColor.AQUA + "Your balance: " + money);
						return true;
				}else{
					String usage = String.valueOf(args[0]);
						if(usage.equalsIgnoreCase("check")){
							int money = eco.getMoney(player);
								player.sendMessage(ChatColor.AQUA + "Your balance: " + money);
								return true;
						}else if(usage.equalsIgnoreCase("give") && args.length == 3){
							int value = Integer.parseInt(args[1]);
							Player target = Bukkit.getPlayer(args[0]);
							if(eco.getMoney(player) - value <= 0){
								player.sendMessage(ChatColor.RED + "You dont have that much money");
								return true;
							}else{
								//eco.subtractMoney(player, value);
							//	eco.addMoney(target, value);
								String amount = " " + value + " ";
								String name = plugin.getConf().getString("Economy.name");
								player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + amount + name);
								target.sendMessage(player.getDisplayName() + " gave you" + amount + name);
								return true;
							}
						}
				}
			}
		}
		return false;
	}
}
