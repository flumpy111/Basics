package com.github.Sabersamus.Basic.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.Economy.API.TransferMoneyEvent;

public class Test implements Listener
{
	public static Basic plugin;
	public Test(Basic instance)
	{
		plugin = instance;
	}
	
	
	@EventHandler
	public void onTransfer(TransferMoneyEvent event)
	{
		Player player = event.getPlayer();
		plugin.getLogger().info("test");
		player.sendMessage("rawr: ");
	}	
}
