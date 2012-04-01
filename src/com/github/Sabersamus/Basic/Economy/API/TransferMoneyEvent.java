package com.github.Sabersamus.Basic.Economy.API;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class TransferMoneyEvent extends PlayerEvent implements Cancellable
{

	private HandlerList handlers;
	private boolean cancelled;
	private Economy economy;
	
	public TransferMoneyEvent(Player player)
	{
		super(player);
	}
	
	@Override
	public HandlerList getHandlers()
	{
		return this.handlers;
	}

	
	@Override
	public boolean isCancelled()
	{
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled)
	{
		this.cancelled = cancelled;
	}
	
	public int getAmountTransferred()
	{
		return economy.getTransferedAmount();
	}
	
	public void setAmountTransferred(int amount)
	{
		economy.setTransferredAmount(amount);
	}

}
