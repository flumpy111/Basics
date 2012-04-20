package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.WarpConfig;

public class WarpCommand implements CommandExecutor
{
	public static Basic plugin;
	public WarpCommand(Basic instance)
	{
		plugin = instance;
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("warp")){
			WarpConfig warps = plugin.getWarpInfo();
			if(!(cs instanceof Player))return false;
			Player player = (Player)cs;
			if(player.hasPermission("basic.warp")){
			if(args.length == 1){
				String warp = String.valueOf(args[0].toLowerCase());
					if(warps.getWarps().contains(warp)){
						String world = warps.getWarps().getString(warp + ".world");
						int x = warps.getWarps().getInt(warp + ".x");
						int y = warps.getWarps().getInt(warp + ".y");
						int z = warps.getWarps().getInt(warp + ".z");
						float yaw = warps.getWarps().getInt(warp + ".yaw");
						float pitch = warps.getWarps().getInt(warp + ".pitch");
						Location loc = new Location(Bukkit.getWorld(world), x + 0.5 , y , z + 0.5, yaw , pitch);
						player.sendMessage(ChatColor.DARK_GREEN + "Warping to " + ChatColor.GOLD + warp);
						player.teleport(loc);
						return true;
					}else{
						player.sendMessage(ChatColor.RED + "The warp " + ChatColor.GOLD + warp + ChatColor.RED + " doesn't exist");
						return true;
					}
				}
			}
		}
		return false;
	}
}
