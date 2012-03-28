package com.github.Sabersamus.Basic.Economy;

import org.bukkit.Bukkit;
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
							String checkMessage = settings.getConf().getString("Messages.check-message").replaceAll("(&([a-fk0-9]))", "\u00A7$2");
							player.sendMessage(checkMessage.replace("%name", mName).replace("%money", String.valueOf(money)));
							return true;
						}else{
							String usage = String.valueOf(args[0]);
							if(args.length == 1){
								if(usage.equalsIgnoreCase("balance") || usage.equalsIgnoreCase("check")){
									int money = eco.getBalance(player);
									String checkMessage = settings.getConf().getString("Messages.check-message").replaceAll("(&([a-fk0-9]))", "\u00A7$2");
									player.sendMessage(checkMessage.replace("%name", mName).replace("%money", String.valueOf(money)));
									return true;
								}else if(usage.equalsIgnoreCase("tell")){
									String tellMessage = settings.getConf().getString("Messages.tell-message").replaceAll("(&([a-fk0-9]))", "\u00A7$2");
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
											String notEnough = settings.getConf().getString("Messages.not-enough-money").replaceAll("(&([a-fk0-9]))", "\u00A7$2");
											player.sendMessage(notEnough.replace("%name", mName));
											return true;
								}
										//eco.addMoney(target, value);
										//eco.subtractMoney(player, value);
										eco.transferMoney(player, target, value);
										String giveMessage = settings.getConf().getString("Messages.give-message").replaceAll("(&([a-fk0-9]))", "\u00A7$2");
										String getMessage = settings.getConf().getString("Messages.receive-message").replaceAll("(&([a-fk0-9]))", "\u00A7$2");
										player.sendMessage(giveMessage.replace("%t", target.getDisplayName()).replace("%money", String.valueOf(value)).replace("%name", mName));
										target.sendMessage(getMessage.replace("%p", player.getDisplayName()).replace("%money", String.valueOf(value)).replace("%name", mName));
										return true;
								}
							}
						}
					}
				}else if(settings.getConf().getBoolean("Economy.enabled") == false){
					String disabledMessage = settings.getConf().getString("Messages.disabled-message").replaceAll("(&([a-fk0-9]))", "\u00A7$2");
					player.sendMessage(disabledMessage);
						return true;
				}
			}
		}
		return false;
	}
}
