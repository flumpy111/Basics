package com.github.Sabersamus.Basic.Economy;

import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

/**
 * @author Sabersamus
 */

public class Economy 
{
	public static Basic plugin;
	public Economy(Basic instance){
		plugin = instance;
	}
	private Player player;
	private int money;
	
	/**
	 * Gets the amount of money a player has
	 * @param arg0 - the player to check
	 * @return - the amount of money they have
	 */
	public int getMoney(Player arg0){
		this.player = arg0;
		this.money = plugin.getMoney().getInt(player.getName() + ".Balance");
		return money;
	}
	
	/**
	 * Removes a set amount of money from a player
	 * @param arg0 - the player to subtract money from
	 * @param arg1 - the amount of money
	 */
	public void subtractMoney(Player arg0, int arg1){
		this.player = arg0;
		plugin.getMoney().set(arg0.getName() + ".Balance", plugin.getMoney().getInt(arg0.getName() + ".Balance") - arg1);
		plugin.saveMoney();
	}
	
	/**
	 * Gives a player more money
	 * @param arg0 - the player to give money
	 * @param arg1 - the amount of money to be added
	 */
	public void addMoney(Player arg0, int arg1){
		this.player = arg0;
		plugin.getMoney().set(arg0.getName() + ".Balance", plugin.getMoney().getInt(arg0.getName() + ".Balance") + arg1);
		plugin.saveMoney();
	}
}
