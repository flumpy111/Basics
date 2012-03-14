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

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("give")){
		Material material = null;
		try {
		material = Material.getMaterial(Integer.parseInt(args[1]));
		} catch (NumberFormatException e) {
		material = Material.getMaterial(args[1].toUpperCase());
		}
		Player target = Bukkit.getPlayer(args[0]);
		if(target != null){
		if(cs.hasPermission("basic.give")){
		if(args.length !=0){
		if(material !=null){
		if(args.length == 2){
			ItemStack item = new ItemStack(material, 1);
			target.getInventory().addItem(item);
			target.sendMessage(ChatColor.AQUA + "You have been recieved a gift from god!");
			cs.sendMessage(ChatColor.GREEN + "You gave "  + target.getDisplayName() + ChatColor.GREEN +" a "+ item.getType().name().toLowerCase().replace("_", " ").replace(" on", "") + ".");
			return true;
			}else{
				if(args.length == 3){
				Integer value = Integer.valueOf(args[2]);
				ItemStack item = new ItemStack(material, value);
				target.getInventory().addItem(item);
				target.sendMessage(ChatColor.AQUA + "You have recieved a gift from god!");
				cs.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + ChatColor.GREEN + " " + value + " " + item.getType().name().toLowerCase().replace("_", " ").replace(" on", "") + "s.");
				
				return true;
				}else{
					return false;
				}
			}
			}else{
				cs.sendMessage(ChatColor.RED + "Invalid item");
			}
			}else{
				cs.sendMessage(ChatColor.RED + "WTF are you even trying to do?");
			}
			}else{
				cs.sendMessage(ChatColor.RED + "You don't have permission");
				return true;
			}
			}else{
				cs.sendMessage(ChatColor.RED + "Invalid player");
				return true;
			}
			}
			return false;
		}
		}