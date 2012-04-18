package com.github.Sabersamus.Basic;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Sabersamus.Basic.Commands.ClearCommand;
import com.github.Sabersamus.Basic.Commands.DisguiseCommand;
import com.github.Sabersamus.Basic.Commands.FakeQuitCommand;
import com.github.Sabersamus.Basic.Commands.BanCommand;
import com.github.Sabersamus.Basic.Commands.BlindCommand;
import com.github.Sabersamus.Basic.Commands.CreativeCommand;
import com.github.Sabersamus.Basic.Commands.FeedCommand;
import com.github.Sabersamus.Basic.Commands.BoomCommand;
import com.github.Sabersamus.Basic.Commands.FreezeCommand;
import com.github.Sabersamus.Basic.Commands.GiveCommand;
import com.github.Sabersamus.Basic.Commands.InventoryCommand;
import com.github.Sabersamus.Basic.Commands.ItemCommand;
import com.github.Sabersamus.Basic.Commands.KickCommand;
import com.github.Sabersamus.Basic.Commands.KillCommand;
import com.github.Sabersamus.Basic.Commands.MeCommand;
import com.github.Sabersamus.Basic.Commands.MessageCommand;
import com.github.Sabersamus.Basic.Commands.PositionCommand;
import com.github.Sabersamus.Basic.Commands.RideCommand;
import com.github.Sabersamus.Basic.Commands.RideMeCommand;
import com.github.Sabersamus.Basic.Commands.SayCommand;
import com.github.Sabersamus.Basic.Commands.SetWarpCommand;
import com.github.Sabersamus.Basic.Commands.SpawnCommand;
import com.github.Sabersamus.Basic.Commands.SpawnMob;
import com.github.Sabersamus.Basic.Commands.SummonCommand;
import com.github.Sabersamus.Basic.Commands.SurvivalCommand;
import com.github.Sabersamus.Basic.Commands.TeleportCommand;
import com.github.Sabersamus.Basic.Commands.TimeCommand;
import com.github.Sabersamus.Basic.Commands.TpBlockCommand;
import com.github.Sabersamus.Basic.Commands.WarpCommand;
import com.github.Sabersamus.Basic.Commands.WarpReloadCommand;
import com.github.Sabersamus.Basic.Commands.WeatherCommand;
import com.github.Sabersamus.Basic.Commands.WhoCommand;
import com.github.Sabersamus.Basic.Economy.ManageCommand;
import com.github.Sabersamus.Basic.Economy.MoneyListener;
import com.github.Sabersamus.Basic.Economy.Wallet;
import com.github.Sabersamus.Basic.Economy.API.Economy;
import com.github.Sabersamus.Basic.Economy.API.EconomyManager;
import com.github.Sabersamus.Basic.Listeners.BasicPlayerListener;
import com.github.Sabersamus.Basic.Listeners.CompassListener;
import com.github.Sabersamus.Basic.Listeners.DropsListener;
import com.github.Sabersamus.Basic.Listeners.GodModeListener;
import com.github.Sabersamus.Basic.Listeners.SignColorListener;

public class Basic extends JavaPlugin {
	
	private final BasicPlayerListener playerListener = new BasicPlayerListener(this);
	private final CompassListener compassListener = new CompassListener(this);
	private final GodModeListener godModeListener = new GodModeListener(this);
	private final MoneyListener mlist = new MoneyListener(this);
	private final DropsListener drops = new DropsListener(this);
	private final SignColorListener signs = new SignColorListener(this);
	
	@Override
	public void onDisable() {
		getWarpInfo().saveWarps();
		getSettings().saveSettings();
		getPlayerInfo().savePlayers();
		getBansInfo().saveBans();
	}
	
	
	@Override
	public void onEnable() {
		this.registerCommands(this);
		this.registerEvents(this);
		getWarpInfo().loadWarps();
		getPlayerInfo().loadPlayers();
		getBansInfo().loadBans();
		getEconomyInfo().loadMoney();
		getSettings().loadSettings();
	    }
	
	private void registerCommands(Basic basic) {
					this.getCommand("say").setExecutor(new SayCommand(this));
					this.getCommand("kick").setExecutor(new KickCommand(this));
					this.getCommand("fakequit").setExecutor(new FakeQuitCommand(this));
					this.getCommand("tp").setExecutor(new TeleportCommand(this));
					this.getCommand("summon").setExecutor(new SummonCommand(this));
					this.getCommand("m").setExecutor(new MessageCommand(this));
					this.getCommand("me").setExecutor(new MeCommand(this));
					this.getCommand("disguise").setExecutor(new DisguiseCommand(this));
					this.getCommand("blind").setExecutor(new BlindCommand(this));
					this.getCommand("unblind").setExecutor(new BlindCommand(this));
					this.getCommand("ride").setExecutor(new RideCommand(this));
					this.getCommand("rideme").setExecutor(new RideMeCommand(this));
					this.getCommand("ban").setExecutor(new BanCommand(this));
					this.getCommand("unban").setExecutor(new BanCommand(this));
					this.getCommand("rban").setExecutor(new BanCommand(this));
					this.getCommand("kill").setExecutor(new KillCommand(this));
					this.getCommand("feed").setExecutor(new FeedCommand(this));
					this.getCommand("creative").setExecutor(new CreativeCommand(this));
					this.getCommand("survival").setExecutor(new SurvivalCommand(this));
					this.getCommand("boom").setExecutor(new BoomCommand(this));
					this.getCommand("item").setExecutor(new ItemCommand(this));
					
					this.getCommand("clear").setExecutor(new ClearCommand(this));
					
					this.getCommand("give").setExecutor(new GiveCommand(this));
					this.getCommand("spawn").setExecutor(new SpawnCommand(this));
					this.getCommand("setspawn").setExecutor(new SpawnCommand(this));
					this.getCommand("inv").setExecutor(new InventoryCommand(this));
					this.getCommand("warp").setExecutor(new WarpCommand(this));
					this.getCommand("setwarp").setExecutor(new SetWarpCommand(this));
					this.getCommand("delwarp").setExecutor(new SetWarpCommand(this));
					this.getCommand("warpsreload").setExecutor(new WarpReloadCommand(this));
					this.getCommand("time").setExecutor(new TimeCommand(this));
					this.getCommand("weather").setExecutor(new WeatherCommand(this));
					this.getCommand("spawnmob").setExecutor(new SpawnMob(this));
					this.getCommand("tpblock").setExecutor(new TpBlockCommand(this));
					this.getCommand("who").setExecutor(new WhoCommand(this));
					this.getCommand("freeze").setExecutor(new FreezeCommand(this));
					this.getCommand("pos").setExecutor(new PositionCommand(this));
					this.getCommand("wallet").setExecutor(new Wallet(this));
					this.getCommand("economy").setExecutor(new ManageCommand(this));
					this.getCommand("ecomessage").setExecutor(new ManageCommand(this));
			}
	
	private void registerEvents(Basic instance)
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.playerListener, this);
		pm.registerEvents(this.compassListener, this);
		pm.registerEvents(this.playerListener,this);
		pm.registerEvents(this.godModeListener, this);
		pm.registerEvents(this.drops, this);
		pm.registerEvents(this.mlist, this);
		pm.registerEvents(this.signs, this);
	}
	
			public WarpConfig getWarpInfo(){
				return new WarpConfig(this);
			}
			
			public BanConfig getBansInfo(){
				return new BanConfig(this);
			}
	
			public Settings getSettings(){
				return new Settings(this);
			}
			
	
			public EconomyInfo getEconomyInfo(){
				return new EconomyInfo(this);
			}
			
	
			public PlayerSettings getPlayerInfo(){
				return new PlayerSettings(this);
			}
			
	
			public Economy getEconomyAPI(){
				return new Economy(this);
			}
			
			public EconomyManager getEcoManager(){
				return new EconomyManager(this);
			}
			
			public Messages getMessages(){
				return new Messages(this);
			}
	}