package com.github.Sabersamus.Basic.User;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Server;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.github.Sabersamus.Basic.Basic;

public class User implements BUser 
{
	private static Basic plugin;
	private Player player;
	public User(Basic instance, Player player)
	{
		this.player = player; plugin = instance;
	}
	
	@Override
	public void awardAchievement(Achievement arg0)
	{
		player.awardAchievement(arg0);
	}

	@Override
	public boolean canSee(Player arg0) 
	{
		return player.canSee(arg0);
	}

	@Override
	public void chat(String arg0) 
	{
		player.chat(arg0);
	}

	@Override
	public InetSocketAddress getAddress() 
	{
		return player.getAddress();
	}

	@Override
	public boolean getAllowFlight() 
	{
		return player.getAllowFlight();
	}

	@Override
	public Location getBedSpawnLocation() 
	{
		return player.getBedSpawnLocation();
	}

	@Override
	public Location getCompassTarget() 
	{
		return player.getCompassTarget();
	}

	@Override
	public String getDisplayName() 
	{
		return player.getDisplayName();
	}

	@Override
	public float getExhaustion() 
	{
		return player.getExhaustion();
	}

	@Override
	public float getExp() 
	{
		return player.getExp();
	}

	@Override
	public int getFoodLevel() 
	{
		return player.getFoodLevel();
	}

	@Override
	public int getLevel()
	{
		return player.getLevel();
	}

	@Override
	public String getPlayerListName()
	{
		return player.getPlayerListName();
	}

	@Override
	public long getPlayerTime() 
	{
		return player.getPlayerTime();
	}

	@Override
	public long getPlayerTimeOffset() 
	{
		return player.getPlayerTimeOffset();
	}

	@Override
	public float getSaturation() 
	{
		return player.getSaturation();
	}

	@Override
	public int getTotalExperience()
	{
		return player.getTotalExperience();
	}

	@Override
	public void giveExp(int arg0)
	{
		player.giveExp(arg0);
	}

	@Override
	public void hidePlayer(Player arg0) 
	{
		player.hidePlayer(arg0);
	}

	@Override
	public void incrementStatistic(Statistic arg0) 
	{
		player.incrementStatistic(arg0);
	}

	@Override
	public void incrementStatistic(Statistic arg0, int arg1) 
	{
		player.incrementStatistic(arg0, arg1);
	}

	@Override
	public void incrementStatistic(Statistic arg0, Material arg1) 
	{
		player.incrementStatistic(arg0, arg1);
	}

	@Override
	public void incrementStatistic(Statistic arg0, Material arg1, int arg2)
	{
		player.incrementStatistic(arg0, arg1, arg2);
	}

	@Override
	public boolean isFlying() 
	{
		return player.isFlying();
	}

	@Override
	public boolean isPlayerTimeRelative()
	{
		return player.isPlayerTimeRelative();
	}

	@Override
	public boolean isSleepingIgnored() 
	{
		return player.isSleepingIgnored();
	}

	@Override
	public boolean isSneaking() 
	{
		return player.isSneaking();
	}

	@Override
	public boolean isSprinting() 
	{
		return player.isSprinting();
	}

	@Override
	public void kickPlayer(String arg0) 
	{
		player.kickPlayer(arg0);
	}

	@Override
	public void loadData() 
	{
		player.loadData();
	}

	@Override
	public boolean performCommand(String arg0) 
	{
		return player.performCommand(arg0);
	}

	@Override
	public void playEffect(Location arg0, Effect arg1, int arg2) 
	{
		player.playEffect(arg0, arg1, arg2);
	}

	@Override
	public <T> void playEffect(Location arg0, Effect arg1, T arg2) 
	{
		player.playEffect(arg0, arg1, arg2);
	}

	@Override
	public void playNote(Location arg0, byte arg1, byte arg2) 
	{
		player.playNote(arg0, arg1, arg2);
	}

	@Override
	public void playNote(Location arg0, Instrument arg1, Note arg2) 
	{
		player.playNote(arg0, arg1, arg2);
	}

	@Override
	public void resetPlayerTime() 
	{
		player.resetPlayerTime();
	}

	@Override
	public void saveData() 
	{
		player.saveData();
	}

	@Override
	public void sendBlockChange(Location arg0, Material arg1, byte arg2) 
	{
		player.sendBlockChange(arg0, arg1, arg2);
	}

	@Override
	public void sendBlockChange(Location arg0, int arg1, byte arg2) 
	{
		player.sendBlockChange(arg0, arg1, arg2);
	}

	@Override
	public boolean sendChunkChange(Location arg0, int arg1, int arg2, int arg3, byte[] arg4)
	{
		return player.sendChunkChange(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void sendMap(MapView arg0) 
	{
		player.sendMap(arg0);
	}

	@Override
	public void sendRawMessage(String arg0) 
	{
		player.sendRawMessage(arg0);
	}

	@Override
	public void setAllowFlight(boolean arg0) 
	{
		player.setAllowFlight(arg0);
	}

	@Override
	public void setBedSpawnLocation(Location arg0) 
	{
		player.setBedSpawnLocation(arg0);
	}

	@Override
	public void setCompassTarget(Location arg0) 
	{
		player.setCompassTarget(arg0);
	}

	@Override
	public void setDisplayName(String arg0) 
	{
		player.setDisplayName(arg0);
	}

	@Override
	public void setExhaustion(float arg0) 
	{
		player.setExhaustion(arg0);
	}

	@Override
	public void setExp(float arg0)
	{
		player.setExp(arg0);
	}

	@Override
	public void setFlying(boolean arg0)
	{
		player.setFlying(arg0);
	}

	@Override
	public void setFoodLevel(int arg0)
	{
		player.setFoodLevel(arg0);
	}

	@Override
	public void setLevel(int arg0)
	{
		player.setLevel(arg0);
	}

	@Override
	public void setPlayerListName(String arg0)
	{
		player.setPlayerListName(arg0);
	}

	@Override
	public void setPlayerTime(long arg0, boolean arg1)
	{
		player.setPlayerTime(arg0, arg1);
	}

	@Override
	public void setSaturation(float arg0)
	{
		player.setSaturation(arg0);
	}

	@Override
	public void setSleepingIgnored(boolean arg0)
	{
		player.setSleepingIgnored(arg0);
	}

	@Override
	public void setSneaking(boolean arg0)
	{
		player.setSneaking(arg0);
	}

	@Override
	public void setSprinting(boolean arg0)
	{
		player.setSprinting(arg0);
	}

	@Override
	public void setTotalExperience(int arg0)
	{
		player.setTotalExperience(arg0);
	}

	@Override
	public void showPlayer(Player arg0)
	{
		player.showPlayer(arg0);
	}

	@Override
	@Deprecated
	public void updateInventory() 
	{
		player.updateInventory();
	}

	@Override
	public void closeInventory() 
	{
		player.closeInventory();
	}

	@Override
	public GameMode getGameMode()
	{
		return player.getGameMode();
	}

	@Override
	public PlayerInventory getInventory()
	{
		return player.getInventory();
	}

	@Override
	public ItemStack getItemInHand()
	{
		return player.getItemInHand();
	}

	@Override
	public ItemStack getItemOnCursor()
	{
		return player.getItemOnCursor();
	}

	@Override
	public String getName()
	{	
		return player.getName();
	}

	@Override
	public InventoryView getOpenInventory()
	{
		return player.getOpenInventory();
	}

	@Override
	public int getSleepTicks()
	{
		return player.getSleepTicks();
	}

	@Override
	public boolean isBlocking()
	{
		return player.isBlocking();
	}

	@Override
	public boolean isSleeping()
	{
		return player.isSleeping();
	}

	@Override
	public InventoryView openEnchanting(Location arg0, boolean arg1)
	{
		return player.openEnchanting(arg0, arg1);
	}

	@Override
	public InventoryView openInventory(Inventory arg0)
	{
		return player.openInventory(arg0);
	}

	@Override
	public void openInventory(InventoryView arg0)
	{
		player.openInventory(arg0);
	}

	@Override
	public InventoryView openWorkbench(Location arg0, boolean arg1)
	{
		return player.openWorkbench(arg0, arg1);
	}

	@Override
	public void setGameMode(GameMode arg0)
	{
		player.setGameMode(arg0);
	}

	@Override
	public void setItemInHand(ItemStack arg0)
	{
		player.setItemInHand(arg0);
	}

	@Override
	public void setItemOnCursor(ItemStack arg0) 
	{
		player.setItemOnCursor(arg0);
	}

	@Override
	public boolean setWindowProperty(Property arg0, int arg1) 
	{
		return player.setWindowProperty(arg0, arg1);
	}

	@Override
	public boolean addPotionEffect(PotionEffect arg0) 
	{
		return player.addPotionEffect(arg0);
	}

	@Override
	public boolean addPotionEffect(PotionEffect arg0, boolean arg1) 
	{
		return player.addPotionEffect(arg0, arg1);
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> arg0) 
	{
		return player.addPotionEffects(arg0);
	}

	@Override
	public void damage(int arg0) 
	{
		player.damage(arg0);
	}

	@Override
	public void damage(int arg0, Entity arg1) 
	{
		player.damage(arg0, arg1);
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() 
	{
		return player.getActivePotionEffects();
	}

	@Override
	public double getEyeHeight() 
	{
		return player.getEyeHeight();
	}

	@Override
	public double getEyeHeight(boolean arg0) 
	{
		return player.getEyeHeight(arg0);
	}

	@Override
	public Location getEyeLocation() 
	{
		return player.getEyeLocation();
	}

	@Override
	public int getHealth() 
	{
		return player.getHealth();
	}

	@Override
	public Player getKiller()
	{
		return player.getKiller();
	}

	@Override
	public int getLastDamage() 
	{
		return player.getLastDamage();
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> arg0, int arg1)
	{
		return player.getLastTwoTargetBlocks(arg0, arg1);
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> arg0, int arg1) 
	{
		return player.getLineOfSight(arg0, arg1);
	}

	@Override
	public int getMaxHealth()
	{
		return player.getMaxHealth();
	}

	@Override
	public int getMaximumAir() 
	{
		return player.getMaximumAir();
	}

	@Override
	public int getMaximumNoDamageTicks() 
	{
		return player.getMaximumNoDamageTicks();
	}

	@Override
	public int getNoDamageTicks() 
	{
		return player.getNoDamageTicks();
	}

	@Override
	public int getRemainingAir()
	{
		return player.getRemainingAir();
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> arg0, int arg1)
	{
		return player.getTargetBlock(arg0, arg1);
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType arg0)
	{
		return player.hasPotionEffect(arg0);
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0)
	{
		return player.launchProjectile(arg0);
	}

	@Override
	public void removePotionEffect(PotionEffectType arg0) 
	{
		player.removePotionEffect(arg0);
	}

	@Override
	public void setHealth(int arg0) 
	{
		player.setHealth(arg0);
	}

	@Override
	public void setLastDamage(int arg0)
	{
		player.setLastDamage(arg0);
	}

	@Override
	public void setMaximumAir(int arg0) 
	{
		player.setMaximumAir(arg0);
	}

	@Override
	public void setMaximumNoDamageTicks(int arg0) 
	{
		player.setMaximumNoDamageTicks(arg0);
	}

	@Override
	public void setNoDamageTicks(int arg0)
	{
		player.setNoDamageTicks(arg0);
	}

	@Override
	public void setRemainingAir(int arg0)
	{
		player.setRemainingAir(arg0);
	}

	@Override
	@Deprecated
	public Arrow shootArrow() 
	{
		return player.shootArrow();
	}

	@Override
	@Deprecated
	public Egg throwEgg() 
	{
		return player.throwEgg();
	}

	@Override
	@Deprecated
	public Snowball throwSnowball() 
	{
		return player.throwSnowball();
	}

	@Override
	public boolean eject()
	{
		return player.eject();
	}

	@Override
	public int getEntityId() 
	{
		return player.getEntityId();
	}

	@Override
	public float getFallDistance() 
	{
		return player.getFallDistance();
	}

	@Override
	public int getFireTicks()
	{
		return player.getFireTicks();
	}

	@Override
	public EntityDamageEvent getLastDamageCause() 
	{
		return player.getLastDamageCause();
	}

	@Override
	public Location getLocation()
	{
		return player.getLocation();
	}

	@Override
	public int getMaxFireTicks() 
	{
		return player.getMaxFireTicks();
	}

	@Override
	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) 
	{
		return player.getNearbyEntities(arg0, arg1, arg2);
	}

	@Override
	public Entity getPassenger()
	{
		return player.getPassenger();
	}

	@Override
	public Server getServer() 
	{
		return player.getServer();
	}

	@Override
	public int getTicksLived() 
	{
		return player.getTicksLived();
	}

	@Override
	public EntityType getType() 
	{
		return player.getType();
	}

	@Override
	public UUID getUniqueId() 
	{
		return player.getUniqueId();
	}

	@Override
	public Entity getVehicle() 
	{
		return player.getVehicle();
	}

	@Override
	public Vector getVelocity() 
	{
		return player.getVelocity();
	}

	@Override
	public World getWorld() 
	{
		return player.getWorld();
	}

	@Override
	public boolean isDead()
	{
		return player.isDead();
	}

	@Override
	public boolean isEmpty()
	{
		return player.isEmpty();
	}

	@Override
	public boolean isInsideVehicle() 
	{
		return player.isInsideVehicle();
	}

	@Override
	public boolean leaveVehicle() 
	{
		return player.leaveVehicle();
	}

	@Override
	public void playEffect(EntityEffect arg0) 
	{
		player.playEffect(arg0);
	}

	@Override
	public void remove() 
	{
		player.remove();
	}

	@Override
	public void setFallDistance(float arg0) 
	{
		player.setFallDistance(arg0);
	}

	@Override
	public void setFireTicks(int arg0) 
	{
		player.setFireTicks(arg0);
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent arg0) 
	{
		player.setLastDamageCause(arg0);
	}

	@Override
	public boolean setPassenger(Entity arg0) 
	{
		return player.setPassenger(arg0);
	}

	@Override
	public void setTicksLived(int arg0) 
	{
		player.setTicksLived(arg0);
	}

	@Override
	public void setVelocity(Vector arg0) 
	{
		player.setVelocity(arg0);
	}

	@Override
	public boolean teleport(Location arg0) 
	{
		return player.teleport(arg0);
	}

	@Override
	public boolean teleport(Entity arg0)
	{
		return player.teleport(arg0);
	}

	@Override
	public boolean teleport(Location arg0, TeleportCause arg1) 
	{
		return player.teleport(arg0, arg1);
	}

	@Override
	public boolean teleport(Entity arg0, TeleportCause arg1)
	{
		return player.teleport(arg0, arg1);
	}

	@Override
	public List<MetadataValue> getMetadata(String arg0) 
	{
		return player.getMetadata(arg0);
	}

	@Override
	public boolean hasMetadata(String arg0) 
	{
		return player.hasPermission(arg0);
	}

	@Override
	public void removeMetadata(String arg0, Plugin arg1) 
	{
		player.removeMetadata(arg0, arg1);
	}

	@Override
	public void setMetadata(String arg0, MetadataValue arg1)
	{
		player.setMetadata(arg0, arg1);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin arg0)
	{
		return player.addAttachment(arg0);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin arg0, int arg1) 
	{
		return player.addAttachment(arg0, arg1);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2) 
	{
		return player.addAttachment(arg0, arg1, arg2);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) 
	{
		return player.addAttachment(arg0, arg1, arg2, arg3);
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() 
	{
		return player.getEffectivePermissions();
	}

	@Override
	public boolean hasPermission(String arg0)
	{
		return player.hasPermission(arg0);
	}

	@Override
	public boolean hasPermission(Permission arg0)
	{
		return player.hasPermission(arg0);
	}

	@Override
	public boolean isPermissionSet(String arg0) 
	{
		return player.isPermissionSet(arg0);
	}

	@Override
	public boolean isPermissionSet(Permission arg0) 
	{
		return player.isPermissionSet(arg0);
	}

	@Override
	public void recalculatePermissions()
	{
		player.recalculatePermissions();
	}

	@Override
	public void removeAttachment(PermissionAttachment arg0) 
	{
		player.removeAttachment(arg0);
	}

	@Override
	public boolean isOp() 
	{
		return plugin.getServer().getOperators().contains(Bukkit.getPlayer(new User(plugin, player).getName()));
	}

	@Override
	public void setOp(boolean arg0)
	{
		player.setOp(arg0);
	}

	@Override
	public void abandonConversation(Conversation arg0)
	{
		player.abandonConversation(arg0);
	}

	@Override
	public void abandonConversation(Conversation arg0, ConversationAbandonedEvent arg1) 
	{
		player.abandonConversation(arg0, arg1);
	}

	@Override
	public void acceptConversationInput(String arg0) 
	{
		player.acceptConversationInput(arg0);
	}

	@Override
	public boolean beginConversation(Conversation arg0) 
	{
		return player.beginConversation(arg0);
	}

	@Override
	public boolean isConversing() 
	{
		return player.isConversing();
	}

	@Override
	public void sendMessage(String arg0) 
	{
		player.sendMessage(arg0);
	}

	@Override
	public void sendMessage(String[] arg0) 
	{
		player.sendMessage(arg0);
	}

	@Override
	public long getFirstPlayed()
	{
		return player.getFirstPlayed();
	}

	@Override
	public long getLastPlayed() 
	{
		return player.getLastPlayed();
	}

	@Override
	public Player getPlayer() 
	{
		return player.getPlayer();
	}
	
	@Override
	public User getUser()
	{
		return this;
	}

	@Override
	public boolean hasPlayedBefore() 
	{
		return player.hasPlayedBefore();
	}

	@Override
	public boolean isBanned() 
	{
		return plugin.getBansInfo().getBans().contains(getName());
	}

	@Override
	public boolean isOnline() 
	{
		return player.isOnline();
	}

	@Override
	public boolean isWhitelisted() 
	{
		return player.isWhitelisted();
	}

	@Override
	public void setWhitelisted(boolean arg0) 
	{
		player.setWhitelisted(arg0);
	}

	@Override
	public Map<String, Object> serialize() 
	{
		return player.serialize();
	}

	@Override
	public Set<String> getListeningPluginChannels() 
	{
		return player.getListeningPluginChannels();
	}

	@Override
	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) 
	{
		player.sendPluginMessage(arg0, arg1, arg2);
	}

	@Override
	public int getBalance() 
	{
		return plugin.getEconomyAPI().getBalance(getPlayer());
	}

	@Override
	public void resetBalance() 
	{
		plugin.getEconomyAPI().setBalance(getPlayer(), plugin.getEcoManager().getDefaltAmount());
	}

	@Override
	public void setBalance(int amount) 
	{
		plugin.getEconomyAPI().setBalance(getPlayer(), amount);
	}

	@Override
	public void addMoney(int amount) 
	{
		plugin.getEconomyAPI().addMoney(getPlayer(), amount);
	}

	@Override
	public void subtractMoney(int amount) 
	{
		plugin.getEconomyAPI().addMoney(getPlayer(), amount);
	}

	@Override
	public boolean getTeleportBlock() 
	{
		return plugin.getPlayerInfo().getPlayers().contains(getName());
	}

	@Override
	public void setTeleportBlock(boolean arg0) 
	{
		if(arg0)
		{
			plugin.getPlayerInfo().getPlayers().set(getName() + ".TpBlock", true);
			plugin.getPlayerInfo().savePlayers();
		}else{
			plugin.getPlayerInfo().getPlayers().set(getName(), null);
			plugin.getPlayerInfo().savePlayers();
		}
	}

	@Override
	public void setBanned(boolean arg0) 
	{
		if(arg0){
			plugin.getBansInfo().getBans().set(getName() + ".Banned", true);
			plugin.getBansInfo().saveBans();
		}else{
			plugin.getBansInfo().getBans().set(getName(), null);
			plugin.getBansInfo().saveBans();
		}
	}

}
