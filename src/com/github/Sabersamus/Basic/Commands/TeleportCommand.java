package com.github.Sabersamus.Basic.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class TeleportCommand implements CommandExecutor{
	public static Basic plugin;
	public TeleportCommand(Basic instance) {
	plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tp")){
		if((cs instanceof Player) && (cs.hasPermission("basic.tp"))){
		if(args.length == 1){
		Player target = Bukkit.getServer().getPlayer(args[0]);
		Player player = (Player)cs;
		if(target !=null){
			String tname = target.getName();
		if(!plugin.getPlayers().contains(tname)){
			player.teleport(target.getLocation());
			cs.sendMessage(ChatColor.AQUA + "Teleporting to " + target.getDisplayName());
			target.sendMessage(player.getDisplayName() + ChatColor.AQUA + " has teleported to you");
		return true;
		}else{
			if(!player.hasPermission("basic.tpblock.override")){
			player.sendMessage(target.getDisplayName() + ChatColor.RED + " does not allow teleportation at this time");
			target.sendMessage(player.getDisplayName() + ChatColor.RED + " failed at teleporting to you");
			return true;
			}else{
				player.teleport(target.getLocation());
				cs.sendMessage(ChatColor.AQUA + "Teleporting to " + target.getDisplayName());
				target.sendMessage(player.getDisplayName() + ChatColor.AQUA + " has teleported to you");
				return true;
			}
		}
	}else{
		String name = String.valueOf(args[0]);
		player.sendMessage(ChatColor.RED + name + " is not online");
	}
	}else{
		return false;
	}
	}else{
		return false;
	}

	}
		return false;
	}
}
