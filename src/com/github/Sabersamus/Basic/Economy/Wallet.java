package com.github.Sabersamus.Basic.Economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.Settings;
import com.github.Sabersamus.Basic.Economy.API.Economy;
import com.github.Sabersamus.Basic.Economy.API.EconomyMessages;

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
			Settings settings = plugin.getSettings();
			EconomyMessages message = plugin.getEcoManager().getEconomyMessages();
			String mName = settings.getSettings().getString("Economy.name");
				if(cs instanceof Player){
					Player player = (Player)cs;
					if(settings.getSettings().getBoolean("Economy.enabled") == true){
						if(args.length == 0){
							int money = eco.getBalance(player);
							String checkMessage = message.getCheckMessage().replaceAll("(&([a-fk0-9]))", "\u00A7$2");
							player.sendMessage(checkMessage.replace("%name", mName).replace("%money", String.valueOf(money)));
							return true;
						}else{
							String usage = String.valueOf(args[0]);
							if(args.length == 1){
								if(usage.equalsIgnoreCase("balance") || usage.equalsIgnoreCase("check")){
									int money = eco.getBalance(player);
									String checkMessage = message.getCheckMessage().replaceAll("(&([a-fk0-9]))", "\u00A7$2");
									player.sendMessage(checkMessage.replace("%name", mName).replace("%money", String.valueOf(money)));
									return true;
								}else if(usage.equalsIgnoreCase("tell")){
									String tellMessage = message.getTellMessage().replaceAll("(&([a-fk0-9]))", "\u00A7$2");
									int money = eco.getBalance(player);
									player.getServer().broadcastMessage(tellMessage.replace("%p", player.getDisplayName()).replace("%name", mName).replace("%money", String.valueOf(money)));
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
											String notEnough = message.getInvalidMoneyMessage().replaceAll("(&([a-fk0-9]))", "\u00A7$2");
											player.sendMessage(notEnough.replace("%name", mName));
											return true;
								}
										eco.transferMoney(player, target, value);
										return true;
								}
							}
						}
					}
				}else if(settings.getSettings().getBoolean("Economy.enabled") == false){
					String disabledMessage = message.getDisabledMessage().replaceAll("(&([a-fk0-9]))", "\u00A7$2");
					player.sendMessage(disabledMessage);
						return true;
				}
			}
		}
		return false;
	}
}
