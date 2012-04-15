package com.github.Sabersamus.Basic.User;

import org.bukkit.entity.Player;

public interface BUser extends Player
{

	public int getBalance();
	
	public void resetBalance();
	
	public void setBalance(int amount);
	
	public void addMoney(int amount);
	
	public void subtractMoney(int amount);
	
	public boolean getTeleportBlock();
	
	public void setTeleportBlock(boolean arg0);
	
}
