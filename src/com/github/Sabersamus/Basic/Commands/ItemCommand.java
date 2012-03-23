package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.Sabersamus.Basic.Basic;

public class ItemCommand implements CommandExecutor{
	public static Basic plugin;
	public ItemCommand(Basic instance){
		plugin = instance;
	
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if (cmd.getName().equalsIgnoreCase("item")){
			Material material = null;
			try {
			material = Material.getMaterial(Integer.parseInt(args[0]));
			} catch (NumberFormatException e) {
			material = Material.getMaterial(args[0].toUpperCase());
			}
			if(cs.hasPermission("basic.item") && (cs instanceof Player)){
			if(args.length !=0){
				if (material == null) {
					cs.sendMessage(ChatColor.RED + "Invalid item name");
				// no match found
				return true;
			}else{
				if(args.length == 1){
			ItemStack item = new ItemStack(material, 1);
			((Player)cs).getInventory().addItem(item);
			cs.sendMessage(ChatColor.BLUE + "You have gotten a " + material.name().toLowerCase().replace("_", " "));
			return true;
		}else{
			if(args.length == 2){
				Integer value = Integer.valueOf(args[1]);
				ItemStack item = new ItemStack(material, value);
				((Player)cs).getInventory().addItem(item);
				cs.sendMessage(ChatColor.BLUE + "You have gotten " + value + " " + material.name().toLowerCase().replace("_", " ") + "s");
				return true;
		}else{
			return false;
		}
			}
		}
			}else{
				cs.sendMessage(ChatColor.RED + "Invalid command usage");
				return true;
			}
			}
		}else{
			if(cmd.getName().equalsIgnoreCase("clear")){
				((Player)cs).getInventory().clear();
				cs.sendMessage(ChatColor.AQUA + "Your inventory is now clear");
				return true;
			}
		}
		return false;
	}
	}