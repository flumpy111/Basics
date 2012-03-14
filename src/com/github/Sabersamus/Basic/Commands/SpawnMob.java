package com.github.Sabersamus.Basic.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;


public class SpawnMob implements CommandExecutor{
	public static Basic plugin;
	public SpawnMob(Basic instance){
		plugin = instance;
	}
		@Override
		public boolean onCommand(CommandSender cs, Command cmd, String aliases, String[] args) {
			if((cmd.getName().equalsIgnoreCase("spawnmob")) && (args.length == 1)){
			if(cs.hasPermission("basic.spawnmob")){
				Player player = (Player) cs;
				World world = player.getWorld();
				int x = player.getEyeLocation().getBlockX();
				int y = player.getEyeLocation().getBlockY();
				int z = player.getEyeLocation().getBlockZ();
				Location eye = new Location(world, x, y, z);
			String mob = String.valueOf(args[0]);
			if(mob.equalsIgnoreCase("cow")){
				player.getWorld().spawnCreature(eye, EntityType.COW);
			}else{
				if(mob.equalsIgnoreCase("chicken")){
					player.getWorld().spawnCreature(eye, EntityType.CHICKEN);
					return true;
				}else{
					if(mob.equalsIgnoreCase("wolf")){
						player.getWorld().spawnCreature(eye, EntityType.WOLF);
						return true;
					}else{
						if(mob.equalsIgnoreCase("sheep")){
							player.getWorld().spawnCreature(eye, EntityType.SHEEP);
							return true;
						}else{
							if(mob.equalsIgnoreCase("pig")){
								player.getWorld().spawnCreature(eye, EntityType.PIG);
								return true;
							}else{
								if(mob.equalsIgnoreCase("snowman")){
									player.getWorld().spawnCreature(eye, EntityType.SNOWMAN);
									return true;
								}else{
									if(mob.equalsIgnoreCase("squid")){
										player.getWorld().spawnCreature(eye, EntityType.SQUID);
										return true;
									}else{
										if(mob.equalsIgnoreCase("creeper")){
											player.getWorld().spawnCreature(eye, EntityType.CREEPER);
											return true;
										}else{
											if(mob.equalsIgnoreCase("spider")){
												player.getWorld().spawnCreature(eye, EntityType.SPIDER);
												return true;
											}else{
												if(mob.equalsIgnoreCase("cavespider")){
													player.getWorld().spawnCreature(eye, EntityType.CAVE_SPIDER);
													return true;
												}else{
													if(mob.equalsIgnoreCase("ghast")){
														player.getWorld().spawnCreature(eye, EntityType.GHAST);
														return true;
													}else{
														if(mob.equalsIgnoreCase("enderman")){
															player.getWorld().spawnCreature(eye, EntityType.ENDERMAN);
															return true;
														}else{
															if(mob.equalsIgnoreCase("enderdragon")){
																player.getWorld().spawnCreature(eye, EntityType.ENDER_DRAGON);
																return true;
															}else{
																if(mob.equalsIgnoreCase("blaze")){
																	player.getWorld().spawnCreature(eye, EntityType.BLAZE);
																	return true;
																}else{
																	if(mob.equalsIgnoreCase("magmacube")){
																		player.getWorld().spawnCreature(eye, EntityType.MAGMA_CUBE);
																		return true;
																	}else{
																		if(mob.equalsIgnoreCase("mooshroom")){
																			player.getWorld().spawnCreature(eye, EntityType.MUSHROOM_COW);
																			return true;
																		}else{
																			if(mob.equalsIgnoreCase("pigzombie")){
																				player.getWorld().spawnCreature(eye, EntityType.PIG_ZOMBIE);
																				return true;
																			}else{
																				if(mob.equalsIgnoreCase("silverfish")){
																					player.getWorld().spawnCreature(eye, EntityType.SILVERFISH);
																					return true;
																				}else{
																					if(mob.equalsIgnoreCase("skeleton")){
																						player.getWorld().spawnCreature(eye, EntityType.SKELETON);
																						return true;
																					}else{
																						if(mob.equalsIgnoreCase("slime")){
																							player.getWorld().spawnCreature(eye, EntityType.SLIME);
																						}else{
																							if(mob.equalsIgnoreCase("zombie")){
																								player.getWorld().spawnCreature(eye, EntityType.ZOMBIE);
																								return true;
																							}else{
																								cs.sendMessage(ChatColor.RED + "unknown mob type");
																								return true;
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			}else{
				return false;
			}
			}else{
				cs.sendMessage(ChatColor.RED + "Invalid Command use");
				return true;
			}
			return false;
		}
}
