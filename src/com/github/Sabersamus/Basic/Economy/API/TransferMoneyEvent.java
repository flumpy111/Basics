package com.github.Sabersamus.Basic.Economy.API;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.github.Sabersamus.Basic.Basic;

public class TransferMoneyEvent extends Event
{
	public static Basic plugin;
	public TransferMoneyEvent()
	{
		
	}
	
	private static final HandlerList handlers = new HandlerList();
	private Economy economy = new Economy();
	private Player player = economy.player;
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
	
	public void setAmountTransferred(int amount)
	{
		economy.setTransferredAmount(amount);
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
}
