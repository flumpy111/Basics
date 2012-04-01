package com.github.Sabersamus.Basic.Economy.API;

import org.bukkit.OfflinePlayer;
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
	private int transferedMoney = 0;
	
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
	 * Gets the balance of an offline player
	 * @param player - the offline player whose balance to be checked
	 * @return - the amount of money they have
	 */
	public int getBalance(OfflinePlayer player)
	{
		EconomyInfo info = plugin.getEconomyInfo();
		if(player != null)
		{
			return info.getMoney().getInt(player.getName() + ".Balance");
		}else{
		return 0;
		}
	}
	
	/**
	 * Transfers money from one player to another
	 * @param givingPlayer - the player to give the money
	 * @param receivingPlayer - the player to get the money
	 * @param value - the amount of money to be transferred
	 */
	public void transferMoney(Player givingPlayer, Player receivingPlayer, int value){
		EconomyInfo info = plugin.getEconomyInfo();
		if(this.transferedMoney == 0){
		this.transferedMoney = value;
			if(givingPlayer == null || receivingPlayer == null)return;
			if(info.getMoney().getInt(givingPlayer.getName() + ".Balance") - value < 0){
				return;
			}
			this.subtractMoney(givingPlayer, value);
			this.addMoney(receivingPlayer, value);
		}else{
			value = this.transferedMoney;
			if(givingPlayer == null || receivingPlayer == null)return;
			if(info.getMoney().getInt(givingPlayer.getName() + ".Balance") - value < 0){
				return;
			}
			this.subtractMoney(givingPlayer, value);
			this.addMoney(receivingPlayer, value);
		}
	}
	
	/**
	 * Transfers money between an online player and an offline player
	 * @param givingPlayer - the player giving the money
	 * @param receivingPlayer - the offline player getting money
	 * @param amount - the amount of money to be transferred
	 */
	public void transferMoney(Player givingPlayer, OfflinePlayer receivingPlayer, int amount)
	{
		EconomyInfo info = plugin.getEconomyInfo();
			if(this.transferedMoney == 0)
			{
				this.transferedMoney = amount;
				if(givingPlayer == null || receivingPlayer == null)return;
				if(info.getMoney().getInt(givingPlayer.getName() + ".Balance") - amount < 0)return;
				this.subtractMoney(givingPlayer, amount);
				this.addMoney(receivingPlayer, amount);
			}else{
				amount = this.transferedMoney;
				if(givingPlayer == null || receivingPlayer == null)return;
				if(info.getMoney().getInt(givingPlayer.getName() + ".Balance") - amount < 0)return;
				this.subtractMoney(givingPlayer, amount);
				this.addMoney(givingPlayer, amount);
			}
	}
	
	/**
	 * Sets the amount of money transferred
	 * @param amount - the amount of money to be set
	 */
	public void setTransferredAmount(int amount)
	{
		this.transferedMoney = amount;
	}
	
	/**
	 * Gets the amount of money transferred
	 * @return if a transaction has been set, returns the amount, else 0
	 */
	public int getTransferedAmount()
	{
		if(this.transferedMoney > 0)
		{
		return this.transferedMoney;
		}
		return 0;
	}
	
	/**
	 * Adds money to a players balance
	 * @param - player the player selected
	 * @param - amount the amount to be added
	 */
	public void addMoney(Player player, int amount){
		EconomyInfo info = plugin.getEconomyInfo();
		if(this.transferedMoney == 0){
		this.transferedMoney = amount;
		if(info.getMoney().contains(player.getName())){
			info.getMoney().set(player.getName() + ".Balance", plugin.getEconomyInfo().getMoney().getInt(player.getName() + ".Balance") + amount);
			info.saveMoney();
		}else{
		info.getMoney().set(player.getName() + ".Balance", amount);
		info.saveMoney();
			}
		}else{
			amount = this.transferedMoney;
			if(info.getMoney().contains(player.getName())){
				info.getMoney().set(player.getName() + ".Balance", plugin.getEconomyInfo().getMoney().getInt(player.getName() + ".Balance") + amount);
				info.saveMoney();
			}else{
			info.getMoney().set(player.getName() + ".Balance", amount);
			info.saveMoney();
			}
		}
	}
	
	/**
	 * Adds money to an offline players balance
	 * @param player - the offline player to get money
	 * @param amount - the amount of money to receive
	 */
	public void addMoney(OfflinePlayer player, int amount)
	{
		EconomyInfo info = plugin.getEconomyInfo();
		if(player == null)return;
		info.getMoney().set(player.getName() + ".Balance", info.getMoney().getInt(player.getName() + ".Balance") + amount);
		info.saveMoney();
	}
	
	/**
	 * Subtracts money from a players balance
	 * @param player - the player chosen
	 * @param amount - the money to be removed, can not make a players balance less than 0
	 */
	public void subtractMoney(Player player, int amount){
		EconomyInfo settings = plugin.getEconomyInfo();
		if(this.transferedMoney == 0){
		this.transferedMoney = amount;
		if(settings.getMoney().contains(player.getName())){
			if(settings.getMoney().getInt(player.getName() + ".Balance") - amount < 0){
				this.hasEnough = false;
				return;
			}else{
			this.hasEnough = true;
			settings.getMoney().set(player.getName() + ".Balance", settings.getMoney().getInt(player.getName() + ".Balance") - amount);
			settings.saveMoney();
			this.transferedMoney = amount;
				}
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
				this.transferedMoney = amount;
					}
				}
		}
	}
	
	/**
	 * Subtracts money from an offline player
	 * @param player - the offline player
	 * @param value - the amount of money to be subtracted
	 */
	public void subtractMoney(OfflinePlayer player, int value)
	{
		EconomyInfo info = plugin.getEconomyInfo();
		if(player == null)return;
		if(info.getMoney().getInt(player.getName() + ".Balance") - value < 0)return;
		info.getMoney().set((player.getName() + ".Balance"), info.getMoney().getInt(player.getName() + ".Balance") - value);
		info.saveMoney();
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
		this.transferedMoney = amount;
		}
	}
	
	/**
	 * Sets an offline players balance
	 * @param player - the offline player
	 * @param amount - the amount of money to be set
	 */
	public void setBalance(OfflinePlayer player, int amount)
	{
		EconomyInfo info = plugin.getEconomyInfo();
		if(amount < 0)return;
		info.getMoney().set(player.getName() + ".Balance", amount);
		info.saveMoney();
		this.transferedMoney = amount;
	}
}
