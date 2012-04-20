package com.github.Sabersamus.Basic.Economy.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

import com.github.Sabersamus.Basic.Basic;

public class MoneySubtractEvent extends MoneyEvent implements Cancellable{

	public MoneySubtractEvent(Basic instance, Player player)
	{
		super(instance, player);
	}
	
	private int amount = 0;
	private boolean cancelled = false;

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
	
	@Override
	public Player getPlayer()
	{
		return this.player;
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	
	public void setAmount(int amount)
	{
		this.amount = amount;
	}

}
