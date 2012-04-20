package com.github.Sabersamus.Basic.Economy.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.Economy.API.EconomyMessages;

public class TransferMoneyEvent extends MoneyEvent implements Cancellable
{
	public static Basic plugin;
	public TransferMoneyEvent(Basic instance, Player player)
	{
		super(instance, player);
	}
	
	private EconomyMessages messages = new EconomyMessages();
	private String getMessage = messages.getReceiveMessage();
	private String giveMessage = messages.getGiveMessage();
	private Player player;
	private Player receiver;
	private boolean cancelled = false;
	private int amount = 0;
	
	
	public int getAmount()
	{
		return this.amount;
	}
	
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
	public Player getReceiver()
	{
		return this.receiver;
	}
	
	public void setReceiver(Player player)
	{
		this.receiver = player;
	}
	
	@Override
	public Player getPlayer()
	{
		return this.player;
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
