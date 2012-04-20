package com.github.Sabersamus.Basic.Economy.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.github.Sabersamus.Basic.Basic;

public class MoneyEvent extends Event
{
	protected Basic plugin;
	public MoneyEvent(Basic instance, Player player)
	{
		plugin = instance; this.player = player;
	}

	private final static HandlerList handlers = new HandlerList();
	protected Player player;
	
	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}
	
	public static HandlerList getHandlerList()
	{
		return handlers;
	}
	
	public Player getPlayer()
	{
		return player;
	}
}
