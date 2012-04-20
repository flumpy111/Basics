package com.github.Sabersamus.Basic.Economy.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.Settings;

public class MoneyAddEvent extends MoneyEvent implements Cancellable
{
	public MoneyAddEvent(Basic instance, Player player)
	{
		super(instance, player);
	}
	
	private boolean cancelled = false;
	private final Settings settings = plugin.getSettings();
	private int amount = 0;
	private String message = ChatColor.AQUA + "You got " 
			+ ChatColor.GOLD + getAmount() + " " + settings.getSettings().getString("Economy.name");
	
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

	public String getMessage()
	{
		return this.message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
}
