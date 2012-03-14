package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class WarpCommand implements CommandExecutor
{
	public static Basic plugin;
	public WarpCommand(Basic instance)
	{
		plugin = instance;
	}
	
	
    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, final String[] args) {
    if (!(sender instanceof Player) || args.length == 0)
    return false;
    if (cmd.getName().equalsIgnoreCase("warp")){
    	if (sender.hasPermission("basic.warp")){
    String warp = args[0];
    if (plugin.warps.contains(warp)){
    sender.sendMessage(ChatColor.DARK_GREEN + "warping to " + warp + "!");
     
    plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
    Player player = (Player) sender;
    String Warps = args[0] + ".";
     
    @Override
    public void run() {
    String world = plugin.warps.getString(Warps + "world");
    int x = plugin.warps.getInt(Warps + "x");
    int y = plugin.warps.getInt(Warps + "y");
    int z = plugin.warps.getInt(Warps + "z");
    float yaw = plugin.warps.getInt(Warps + "yaw");
    float pitch = plugin.warps.getInt(Warps+ "pitch");
    Location warpto = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    player.getWorld().loadChunk(x, y);
    player.teleport(warpto);
    }
    }, 0L);
    }else{
    sender.sendMessage(ChatColor.RED + "Warp does not exist!");
    return true;
    }
    return true;
    }
    }
    return false;
    }
}
