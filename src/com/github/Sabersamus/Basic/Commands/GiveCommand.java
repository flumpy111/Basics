package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.Sabersamus.Basic.Basic;


public class GiveCommand implements CommandExecutor{
	public static Basic plugin;
	public GiveCommand(Basic instance){
		plugin = instance;
	
}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("give") && args.length > 1){
			Material material = null;
			
			try{
				material = Material.getMaterial(Integer.parseInt(args[1]));
			}catch(NumberFormatException ex){
				material = Material.getMaterial(args[1].toUpperCase());
			}
			if(material != null){
				if(cs instanceof Player){
					Player player = (Player)cs;
						if(player.hasPermission("basic.give")){
							Player target = Bukkit.getPlayer(args[0]);
								if(target != null){
									if(args.length == 2){
										ItemStack item = new ItemStack(material, 1);
										target.getInventory().addItem(item);
										target.updateInventory();
										target.sendMessage(ChatColor.AQUA + "You have received a gift from god");
										player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + ChatColor.AQUA + " a " + material.name().replace("_", " ").toLowerCase());
										return true;
									}else if(args.length == 3){
										int value = Integer.parseInt(args[2]);
										ItemStack item = new ItemStack(material, value);
										target.getInventory().addItem(item);
										target.updateInventory();
										target.sendMessage(ChatColor.AQUA + "You have received a gift from god");
										player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + ChatColor.AQUA + value + material.name().replace("_", " ").toLowerCase() + "s");
										return true;
									}else if(args.length == 4){
										int value = Integer.parseInt(args[2]);
										short data = Short.parseShort(args[3]);
										ItemStack item = new ItemStack(material, value, data);
										target.getInventory().addItem(item);
										target.updateInventory();
										target.sendMessage(ChatColor.AQUA + "You have received a gift from god");
										player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + ChatColor.AQUA + value + material.name().replace("_", " ").toLowerCase() + "s");
										return true;
									}
								}
						}
				}else{
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
						if(args.length == 2){
							ItemStack item = new ItemStack(material, 1);
							target.getInventory().addItem(item);
							target.updateInventory();
							target.sendMessage(ChatColor.AQUA + "You have received a gift from god");
							cs.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + ChatColor.AQUA + " a " + material.name().replace("_", " ").toLowerCase());
							return true;
						}else if(args.length == 3){
							int value = Integer.parseInt(args[2]);
							ItemStack item = new ItemStack(material, value);
							target.getInventory().addItem(item);
							target.updateInventory();
							target.sendMessage(ChatColor.AQUA + "You have received a gift from god");
							cs.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + ChatColor.AQUA + value + material.name().replace("_", " ").toLowerCase() + "s");
							return true;
						}else if(args.length == 4){
							int value = Integer.parseInt(args[2]);
							short data = Short.parseShort(args[3]);
							ItemStack item = new ItemStack(material, value, data);
							target.getInventory().addItem(item);
							target.updateInventory();
							target.sendMessage(ChatColor.AQUA + "You have received a gift from god");
							cs.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + ChatColor.AQUA + value + material.name().replace("_", " ").toLowerCase() + "s");
							return true;
						}
					}
				}
			}
		}
			return false;
	}
}