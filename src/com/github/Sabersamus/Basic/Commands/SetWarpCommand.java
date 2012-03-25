package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.WarpConfig;

public class SetWarpCommand implements CommandExecutor{

	public static Basic plugin;
	public SetWarpCommand(Basic instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("setwarp")){
			WarpConfig warps = plugin.getWarpInfo();
			if(cs instanceof Player){
				Player player = (Player)cs;
				Location loc = player.getLocation();
				int x = (int)loc.getX();
				int y = (int)loc.getY();
				int z = (int)loc.getZ();
				float yaw = loc.getYaw();
				float pitch = loc.getPitch();
				String world = loc.getWorld().getName();
					if(player.hasPermission("basic.setwarp")){
						if(args.length == 1){
							String warpName = String.valueOf(args[0].toLowerCase());
								if(warps.getWarps().contains(warpName)){
									player.sendMessage(ChatColor.RED + "The warp " + warpName + " already exists");
									return true;
						}
								warps.getWarps().set(warpName + ".world", world);
								warps.getWarps().set(warpName + ".x", x);
								warps.getWarps().set(warpName + ".y", y);
								warps.getWarps().set(warpName + ".z", z);
								warps.getWarps().set(warpName + ".yaw", yaw);
								warps.getWarps().set(warpName + ".pitch", pitch);
								warps.saveWarps();
								player.sendMessage(ChatColor.AQUA + "Warp " + ChatColor.GOLD + warpName + ChatColor.AQUA + " has been created");
								return true;
					}
				}
			}
		}else if(cmd.getName().equalsIgnoreCase("delwarp")){
			WarpConfig warps = plugin.getWarpInfo();
				if(cs instanceof Player){
					Player player = (Player)cs;
						if(player.hasPermission("basic.delwarp")){
							if(args.length == 1){
								String warpName = String.valueOf(args[0].toLowerCase());
									if(warps.getWarps().contains(warpName)){
										warps.getWarps().set(warpName, null);
										warps.saveWarps();
										player.sendMessage(ChatColor.RED + "The warp " + ChatColor.GOLD + warpName + ChatColor.RED + " has been deleted");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "The warp " + ChatColor.GOLD + warpName + ChatColor.RED + " does not exist");
										return true;
						}
					}
				}
			}
		}
		return false;
	}


}