package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class SetWarpCommand implements CommandExecutor{


public static Basic plugin;
public SetWarpCommand(Basic instance){
	plugin = instance;
}

@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
if (!(sender instanceof Player) || args.length == 0)
return false;
 
if (cmd.getName().equalsIgnoreCase("setwarp")){
	Player player = (Player) sender;
if (sender.hasPermission("basic.setwarp")){
String Warps = args[0] + ".";
String WarpEx = args[0];
if (plugin.warps.contains(WarpEx)){
player.sendMessage(ChatColor.AQUA + "Warp already exists!");
return true;
	}else{
			int x = player.getLocation().getBlockX();
			int y = player.getLocation().getBlockY();
			int z = player.getLocation().getBlockZ();
	float yaw = player.getLocation().getYaw();
	float pitch = player.getLocation().getPitch();
		String curworld = player.getWorld().getName();
	plugin.getWarps().set(Warps + "world", curworld);
	plugin.getWarps().set(Warps + "x", x);
	plugin.getWarps().set(Warps + "y", y);
	plugin.getWarps().set(Warps + "z", z);
	plugin.getWarps().set(Warps + "yaw", yaw);
	plugin.getWarps().set(Warps + "pitch", pitch);
	plugin.saveWarps();
	player.sendMessage(ChatColor.DARK_GREEN + "Warp " + args[0] + ChatColor.GOLD + " is set!");
			return true;
}
}
}else{
	if(cmd.getName().equalsIgnoreCase("delwarp")){
		if(sender instanceof Player){
			Player player = (Player)sender;
			if(player.hasPermission("basic.delwarp")){
				if(args.length == 1){
					String warp = String.valueOf(args[0]);
					if(plugin.getWarps().contains(warp)){
						plugin.getWarps().set(warp, null);
						player.sendMessage(ChatColor.RED + "The warp " + warp + " has been deleted");
						plugin.saveWarps();
						return true;
					}else{
						player.sendMessage(ChatColor.RED + "The warp " + warp + " does not exist");
						return true;
					}
				}
			}
		}else{
			if(args.length == 1){
				String warp = String.valueOf(args[0]);
				if(plugin.getWarps().contains(warp)){
					plugin.getWarps().set(warp, null);
					plugin.saveWarps();
					sender.sendMessage("the warp " + warp + " has been deleted");
				}
			}
		}
	}
}
 
return false;
}
}