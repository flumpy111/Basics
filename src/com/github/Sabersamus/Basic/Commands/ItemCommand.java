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
			if(cs.hasPermission("basic.item") && (cs instanceof Player)){
				Player player = (Player)cs;
				if(args.length == 0){
					player.sendMessage(ChatColor.RED + "Please select an item first");
					return true;
				}
			Material material = null;
			try {
			material = Material.getMaterial(Integer.parseInt(args[0]));
			} catch (NumberFormatException e) {
			material = Material.getMaterial(args[0].toUpperCase());
			}
				if (material == null){
					player.sendMessage(ChatColor.RED + "Invalid item name");
				return true;
			}else{
				if(args.length == 1){
			ItemStack item = new ItemStack(material, 1);
			player.getInventory().addItem(item);
			player.sendMessage(ChatColor.BLUE + "You have gotten a " + material.name().toLowerCase().replace("_", " "));
			return true;
		}else{
			if(args.length == 2){
				Integer value = Integer.valueOf(args[1]);
				ItemStack item = new ItemStack(material, value);
				player.getInventory().addItem(item);
				if(value == 1){
					player.sendMessage(ChatColor.BLUE + "You have gotten " + value + " " + material.name().toLowerCase().replace("_", " "));
				}else{
				player.sendMessage(ChatColor.BLUE + "You have gotten " + value + " " + material.name().toLowerCase().replace("_", " ") + "s");
			}
			return true;
		}else{
			if(args.length == 3){
				Integer value = Integer.valueOf(args[1]);
				short data = Short.parseShort(args[2]);
				ItemStack item = new ItemStack(material, value, data);
				player.getInventory().addItem(item);
				if(value == 1){
					player.sendMessage(ChatColor.BLUE + "You have gotten " + value + " " + material.name().toLowerCase().replace("_", " "));
				}else{
				player.sendMessage(ChatColor.BLUE + "You have gotten " + value + " " + material.name().toLowerCase().replace("_", " ") + "s");
				}
				return true;
			}else{
				return false;
			}
		}
			}
		}
			}
		}
		return false;
	}
	}