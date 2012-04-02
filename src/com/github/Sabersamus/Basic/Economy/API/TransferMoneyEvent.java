package com.github.Sabersamus.Basic.Economy.API;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.github.Sabersamus.Basic.Basic;

public class TransferMoneyEvent extends Event implements Cancellable
{
	public static Basic plugin;
	private Economy economy = new Economy();
	public TransferMoneyEvent(Basic instance)
	{
		plugin = instance;
	}
	
	private static final HandlerList handlers = new HandlerList();
	private EconomyMessages messages = new EconomyMessages();
	private String getMessage = messages.getReceiveMessage();
	private String giveMessage = messages.getGiveMessage();
	private Player player;
	private boolean cancelled = false;
	private int amount = economy.transferedMoney;
	
	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}
	
	public int getAmountTransferred()
	{
		return this.amount;
	}
	
	/** @deprecated */
	public void setAmountTransferred(int amount)
	{
		this.amount = amount;
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	protected void setPlayer(Player player)
	{
		this.player = player;
	}
	
	@Override
	public boolean isCancelled()
	{
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		this.cancelled = cancel;
	}
	
	public String getGiveMoneyMessage()
	{
		return this.giveMessage;
	}
	
	public String getGetMoneyMessage()
	{
		return this.getMessage;
	}
	
	public void setGiveMoneyMessage(String message)
	{
		this.giveMessage = message;
	}
	
	public void setGetMoneyMessage(String message)
	{
		this.getMessage = message;
	}
}
