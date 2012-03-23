package com.github.Sabersamus.Basic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
import com.github.Sabersamus.Basic.Commands.TpToggleCommand;
import com.github.Sabersamus.Basic.Commands.WarpCommand;
import com.github.Sabersamus.Basic.Commands.WarpReloadCommand;
import com.github.Sabersamus.Basic.Commands.WeatherCommand;
import com.github.Sabersamus.Basic.Commands.WhoCommand;
import com.github.Sabersamus.Basic.Economy.MoneyListener;
import com.github.Sabersamus.Basic.Economy.Wallet;
import com.github.Sabersamus.Basic.Economy.WalletCommand;
import com.github.Sabersamus.Basic.Listeners.BasicPlayerListener;
import com.github.Sabersamus.Basic.Listeners.CompassListener;
import com.github.Sabersamus.Basic.Listeners.DropsListener;
import com.github.Sabersamus.Basic.Listeners.GodModeListener;

public class Basic extends JavaPlugin {
public final Logger logger = Logger.getLogger("Minecraft");
private final BasicPlayerListener playerListener = new BasicPlayerListener(this);
private final CompassListener compassListener = new CompassListener(this);
private final GodModeListener godModeListener = new GodModeListener(this);
private final MoneyListener mlist = new MoneyListener(this);
private final DropsListener drops = new DropsListener(this);
public FileConfiguration warps = null;
public FileConfiguration conf = null;
public FileConfiguration players = null;
public File warpsFile = null;
public File confFile = null;
public File playersFile = null;


@Override
public void onDisable() {
	saveWarps();
	saveConf();
	savePlayers();
	saveBans();
}


@Override
public void onEnable() {
	this.registerCommands(this);
	PluginManager pm = getServer().getPluginManager();
				pm.registerEvents(this.playerListener, this);
				pm.registerEvents(this.compassListener, this);
				pm.registerEvents(this.playerListener,this);
				pm.registerEvents(this.godModeListener, this);
				pm.registerEvents(this.drops, this);
				pm.registerEvents(this.mlist, this);
	loadWarps();
	loadPlayers();
	loadBans();
	loadMoney();
	loadConf();
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
				this.getCommand("clear").setExecutor(new ItemCommand(this));
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
				this.getCommand("tpblock").setExecutor(new TpToggleCommand(this));
				this.getCommand("who").setExecutor(new WhoCommand(this));
				this.getCommand("freeze").setExecutor(new FreezeCommand(this));
				this.getCommand("pos").setExecutor(new PositionCommand(this));
				this.getCommand("wallet").setExecutor(new WalletCommand(this));
				this.getCommand("pants").setExecutor(new WalletCommand(this));
				this.getCommand("balance").setExecutor(new Wallet(this));
		}

		public void loadWarps() {
		this.getWarps().options().copyDefaults(true);
		saveWarps();
		}

		public void reloadWarps() {
			if (warpsFile == null) {
			warpsFile = new File(getDataFolder(), "warps.yml");
			}
			warps = YamlConfiguration.loadConfiguration(warpsFile);

			InputStream defConfigStream = getResource("warps.yml");
	if (defConfigStream != null) {
		YamlConfiguration defConfig = YamlConfiguration
	.loadConfiguration(defConfigStream);
		warps.setDefaults(defConfig);
	}
}

		
		public FileConfiguration getWarps() {
			if (warps == null) {
				reloadWarps();
			}
			return warps;
	}

		public void saveWarps() {
			if (warps == null || warpsFile == null) {
				return;
			}
			try{
				warps.save(warpsFile);
			} catch (IOException ex) {
					Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
							"Error saving warps to " + warpsFile, ex);
					ex.printStackTrace();
}
}

		public void loadPlayers() {
				this.getPlayers().options().copyDefaults(true);
				savePlayers();
				}

				public void reloadPlayers(	) {
					if (playersFile == null) {
					playersFile = new File(getDataFolder(), "teleblock.yml");
					}
					players = YamlConfiguration.loadConfiguration(playersFile);

					InputStream defConfigStream = getResource("teleblock.yml");
			if (defConfigStream != null) {
				YamlConfiguration defConfig = YamlConfiguration
			.loadConfiguration(defConfigStream);
				players.setDefaults(defConfig);
			}
		}

				public FileConfiguration getPlayers() {
					if (players == null) {
						reloadPlayers();
					}
					return players;
			}

				public void savePlayers() {
					if (players == null || playersFile == null) {
						return;
					}
					try {
						players.save(playersFile);
					} catch (IOException ex) {
							Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
									"Error saving players to " + playersFile, ex);
							ex.printStackTrace();
		}
		}
				
				public FileConfiguration bans = null;
				File bansFile = null;
				

				public void loadBans() {
					this.getBans().options().copyDefaults(true);
				saveBans();
				}

				public void reloadBans(	) {
					if (bansFile == null) {
					bansFile = new File(getDataFolder(), "BannedPlayers.yml");
					}
					bans = YamlConfiguration.loadConfiguration(bansFile);

					InputStream defConfigStream = getResource("BannedPlayers.yml");
			if (defConfigStream != null) {
				YamlConfiguration defConfig = YamlConfiguration
			.loadConfiguration(defConfigStream);
				bans.setDefaults(defConfig);
			}
			}


				public FileConfiguration getBans() {
					if (bans == null) {
						reloadBans();
					}
					return bans;
			}

				public void saveBans() {
					if (bans == null || bansFile == null) {
						return;
					}
					try {
						bans.save(bansFile);
					} catch (IOException ex) {
							Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
									"Error saving players to " + bansFile, ex);
							ex.printStackTrace();
			}
			}
				public FileConfiguration money = null;
				File moneyFile = null;
				

				public void loadMoney() {
					this.getMoney().options().copyDefaults(true);
				saveMoney();
				}

				public void reloadMoney() {
					if (moneyFile == null) {
					moneyFile = new File(getDataFolder(), "Balance.yml");
					}
					money = YamlConfiguration.loadConfiguration(moneyFile);

					InputStream defConfigStream = getResource("Balance.yml");
			if (defConfigStream != null) {
				YamlConfiguration defConfig = YamlConfiguration
			.loadConfiguration(defConfigStream);
				money.setDefaults(defConfig);
			}
			}


				public FileConfiguration getMoney() {
					if (money == null) {
						reloadMoney();
					}
				return money;
			}

				public void saveMoney() {
					if (money == null || moneyFile == null) {
						return;
					}
					try {
						money.save(moneyFile);
					} catch (IOException ex) {
							ex.printStackTrace();
			}
			}
				

				public void loadConf() {
					this.getConf().options().copyDefaults(true);
				saveConf();
				}

				public void reloadConf() {
					if (confFile == null) {
					confFile = new File(getDataFolder(), "Economy.yml");
					}
					conf = YamlConfiguration.loadConfiguration(confFile);

					InputStream defConfigStream = getResource("Economy.yml");
			if (defConfigStream != null) {
				YamlConfiguration defConfig = YamlConfiguration
			.loadConfiguration(defConfigStream);
				conf.setDefaults(defConfig);
			}
			}


				public FileConfiguration getConf() {
					if (conf == null) {
						reloadConf();
					}
					return conf;
			}

				public void saveConf() {
					if (conf == null || confFile == null) {
						return;
					}
					try {
						conf.save(confFile);
					} catch (IOException ex) {
							ex.printStackTrace();
			}
			}
}