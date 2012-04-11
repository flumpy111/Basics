package com.github.Sabersamus.Basic.Economy.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.EconomyInfo;
import com.github.Sabersamus.Basic.Economy.Events.MoneyAddEvent;
import com.github.Sabersamus.Basic.Economy.Events.TransferMoneyEvent;

/**
 * Methods to manage the economy
 */
public class Economy 
{
	public static Basic plugin;
	public Economy(Basic instance){
		plugin = instance;
	}
	
	public Economy()
	{
		
	}
	
	private boolean hasEnough;
	
	public boolean hasEnough(){
		if(hasEnough){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Gets the balance of a player
	 * @param - player the player chosen
	 * @return - the players balance
	 */
	public int getBalance(Player player){
		EconomyInfo info = plugin.getEconomyInfo();
		if(info.getMoney().contains(player.getName())){
			return info.getMoney().getInt(player.getName() + ".Balance");
		}
		return 0;
	}
	
	/**
	 * Transfers money from one player to another
	 * @param givingPlayer - the player to give the money
	 * @param receivingPlayer - the player to get the money
	 * @param value - the amount of money to be transferred
	 */
	public void transferMoney(Player givingPlayer, Player receivingPlayer, int value){
		TransferMoneyEvent event = new TransferMoneyEvent(plugin, givingPlayer);
		Bukkit.getPluginManager().callEvent(event);
		if(event.isCancelled()) return;
		EconomyInfo info = plugin.getEconomyInfo();
		if(event.getReceiver() == null)
		{
			if(event.getAmount() == 0){
			info.getMoney().set(givingPlayer.getName() + ".Balance", this.getBalance(givingPlayer) - value);
			info.getMoney().set(receivingPlayer.getName() + ".Balance", this.getBalance(receivingPlayer) + value);
			info.saveMoney();
			return;
			}else{
				event.setAmount(value);
				info.getMoney().set(givingPlayer.getName() + ".Balance", this.getBalance(givingPlayer) - event.getAmount());
				info.getMoney().set(receivingPlayer.getName() + ".Balance", this.getBalance(receivingPlayer) + event.getAmount());
				info.saveMoney();
			}
		}else{
			if(event.getAmount() == 0){
			info.getMoney().set(givingPlayer.getName() + ".Balance", this.getBalance(givingPlayer) - value);
			info.getMoney().set(event.getReceiver().getName() + ".Balance", this.getBalance(event.getReceiver()) + value);
			info.saveMoney();
			return;
			}else{
				event.setAmount(value);
				info.getMoney().set(givingPlayer.getName() + ".Balance", this.getBalance(givingPlayer) - event.getAmount());
				info.getMoney().set(event.getReceiver().getName() + ".Balance", this.getBalance(event.getReceiver()) + event.getAmount());
				info.saveMoney();
			}
		}
	}
	
	/**
	 * Adds money to a players balance
	 * @param - player the player selected
	 * @param - amount the amount to be added
	 */
	public void addMoney(Player player, int amount){
		EconomyInfo info = plugin.getEconomyInfo();
		MoneyAddEvent event = new MoneyAddEvent(plugin, player);
		Bukkit.getPluginManager().callEvent(event);
		if(event.isCancelled())return;
		if(event.getAmount() == 0)
		{
			event.setAmount(amount);
			info.getMoney().set(player.getName() + ".Balance", getBalance(player) + amount);
			info.saveMoney();
			return;
		}else{
			info.getMoney().set(player.getName() + ".Balance", getBalance(player) + event.getAmount());
			info.saveMoney();
			return;
		}
	}
	
	/**
	 * Subtracts money from a players balance
	 * @param player - the player chosen
	 * @param amount - the money to be removed, can not make a players balance less than 0
	 */
	public void subtractMoney(Player player, int amount){
		EconomyInfo settings = plugin.getEconomyInfo();
		if(settings.getMoney().contains(player.getName())){
			if(settings.getMoney().getInt(player.getName() + ".Balance") - amount < 0){
				this.hasEnough = false;
				return;
			}else{
			this.hasEnough = true;
			settings.getMoney().set(player.getName() + ".Balance", settings.getMoney().getInt(player.getName() + ".Balance") - amount);
			settings.saveMoney();
			}
		}else{
			if(settings.getMoney().contains(player.getName())){
				if(settings.getMoney().getInt(player.getName() + ".Balance") - amount < 0){
					this.hasEnough = false;
					return;
				}else{
				this.hasEnough = true;
				settings.getMoney().set(player.getName() + ".Balance", settings.getMoney().getInt(player.getName() + ".Balance") - amount);
				settings.saveMoney();
					}
				}
		}
	}
	
	/**
	 * Sets a players balance
	 * @param player - the player
	 * @param amount - the amount to be set, can not be less than 0
	 */
	public void setBalance(Player player, int amount){
		EconomyInfo settings = plugin.getEconomyInfo();
		if(amount < 0){
			return;
		}else{
		settings.getMoney().set(player.getName() + ".Balance", amount);
		settings.saveMoney();
		}
	}
}
