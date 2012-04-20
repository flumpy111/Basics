package com.github.Sabersamus.Basic.Commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import com.github.Sabersamus.Basic.Basic;

public class BlindCommand implements CommandExecutor {
	public static Basic plugin;
	public BlindCommand(Basic instance){
		plugin = instance;
}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
		if(cmd.getName().equalsIgnoreCase("blind")){
			if(cs instanceof Player){
				Player player = (Player)cs;
		if(player.hasPermission("basic.blind") || player.isOp()){
		if(args.length == 1){
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null){
			PotionEffectType effect = PotionEffectType.BLINDNESS;
			target.addPotionEffect(effect.createEffect(1500, 100));
			player.sendMessage(ChatColor.BLUE + "You have blinded " + target.getDisplayName());
		return true;
			}
		}
	}
		return false;
}
		return false;
	}else{
		if(cmd.getName().equalsIgnoreCase("unblind")){
			if(cs instanceof Player){
				Player player = (Player)cs;
				if(player.hasPermission("basic.unblind")){
					if(args.length == 1){
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null){
						target.removePotionEffect(PotionEffectType.BLINDNESS);
						return true;
						}
					}
				}
			}
		}
	}
		return false;
}
	}