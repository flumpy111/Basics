package com.github.Sabersamus.Basic.Economy;

import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;
import com.github.Sabersamus.Basic.EconomyInfo;

/**
 * Methods to manage the economy
 */
public class Economy 
{
	public static Basic plugin;
	public Economy(Basic instance){
		plugin = instance;
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
		EconomyInfo info = plugin.getEconomyInfo();
			if(givingPlayer == null || receivingPlayer == null)return;
			if(info.getMoney().getInt(givingPlayer.getName()) - value < 0){
				return;
			}
			this.subtractMoney(givingPlayer, value);
			this.addMoney(receivingPlayer, value);
	}
	
	/**
	 * Adds money to a players balance
	 * @param - player the player selected
	 * @param - amount the amount to be added
	 */
	public void addMoney(Player player, int amount){
		EconomyInfo info = plugin.getEconomyInfo();
		if(info.getMoney().contains(player.getName())){
			info.getMoney().set(player.getName() + ".Balance", plugin.getEconomyInfo().getMoney().getInt(player.getName() + ".Balance") + amount);
			info.saveMoney();
		}else{
		info.getMoney().set(player.getName() + ".Balance", amount);
		info.saveMoney();
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
			}
			this.hasEnough = true;
			settings.getMoney().set(player.getName() + ".Balance", settings.getMoney().getInt(player.getName() + ".Balance") - amount);
			settings.saveMoney();
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
		}
			settings.getMoney().set(player.getName() + ".Balance", amount);
			settings.saveMoney();
	}
}
