package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class WeatherCommand implements CommandExecutor{
	public static Basic plugin;
	public WeatherCommand(Basic instance){
		plugin = instance;
	}


	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliaes, String[] args) {
		if(cmd.getName().equalsIgnoreCase("weather")){
		if(args.length == 1){
		if(cs.hasPermission("basic.weather")){
		String weather = String.valueOf(args[0]);
		if(weather.equalsIgnoreCase("rain")){
		((Player)cs).getWorld().setStorm(true);
		}else{
			if(weather.equalsIgnoreCase("thunder")){
		((Player)cs).getWorld().setThundering(true);
			}else{
				if(weather.equalsIgnoreCase("sun")){
					((Player)cs).getWorld().setStorm(false);
				}else{
					return false;
				}
			}
		}
		}
		}else{
		cs.sendMessage(ChatColor.RED + "Invalid use");
		}
		
		return false;
	}
		return false;
}
}
