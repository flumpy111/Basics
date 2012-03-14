package com.github.Sabersamus.Basic.Commands;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Sabersamus.Basic.Basic;

public class SayCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Basic plugin;
	public SayCommand(Basic instance) {
		plugin = instance;
	}//YES i copy , pasted you mad bro?
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("say")) {
			if(sender instanceof Player){
			Player player = (Player)sender;
			Player[] d = Bukkit.getOnlinePlayers();
			for(Player c: d){
			if(sender.hasPermission("basic.say.red")) {
				
				if(args.length != 0){//make sure they actually typed something after /say
						int i=0;
						int para=args.length; String s="";
						while(i<para){
						s=s+" "+args[i];
						i++; //Bad loop I know I'm working on it
		}
						Bukkit.getServer().broadcastMessage(ChatColor.RED + "<GOD>" + s);
						c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
						return true;
						}

				}else{
					if(sender.hasPermission("basic.say.blue")) {
					if(args.length != 0){//make sure they actually typed something after /say
						int i=0;
						int para=args.length; String s="";
						while(i<para){
						s=s+" "+args[i];
						i++; //Bad loop I know I'm working on it
		}
						Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "<GOD>" + s);
						c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
						return true;
						}

				}else{		
					if(sender.hasPermission("basic.say.pink")) {
						
						if(args.length != 0){//make sure they actually typed something after /say
							int i=0;
							int para=args.length; String s="";
							while(i<para){
							s=s+" "+args[i];
							i++; //Bad loop I know I'm working on it
			}
							Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "<GOD>" + s);
							c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
							return true;
							}

					}else{
						if(sender.hasPermission("basic.say.gold")) {		
						if(args.length != 0){//make sure they actually typed something after /say
							int i=0;
							int para=args.length; String s="";
							while(i<para){
							s=s+" "+args[i];
							i++; //Bad loop I know I'm working on it
			}
							Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "<GOD>" + s);
							c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
							return true;
							}

					}else{
						if(sender.hasPermission("basic.say.black")) {
					
						
						if(args.length != 0){//make sure they actually typed something after /say
							int i=0;
							int para=args.length; String s="";
							while(i<para){
							s=s+" "+args[i];
							i++; //Bad loop I know I'm working on it
			}
							Bukkit.getServer().broadcastMessage(ChatColor.BLACK + "<GOD>" + s);
							c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
							return true;
							}

					}else{
						if(sender.hasPermission("basic.say.darkblue")) {
							
							if(args.length != 0){//make sure they actually typed something after /say
								int i=0;
								int para=args.length; String s="";
								while(i<para){
								s=s+" "+args[i];
								i++; //Bad loop I know I'm working on it
				}
								Bukkit.getServer().broadcastMessage(ChatColor.DARK_BLUE + "<GOD>" + s);
								c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
								return true;
								}

						}else{	
							if(sender.hasPermission("basic.say.darkgreen")) {
								
								if(args.length != 0){//make sure they actually typed something after /say
									int i=0;
									int para=args.length; String s="";
									while(i<para){
									s=s+" "+args[i];
									i++; //Bad loop I know I'm working on it
					}
									Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "<GOD>" + s);
									c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
									return true;
									}

							}else{
								if(sender.hasPermission("basic.say.darkaqua")) {	
									if(args.length != 0){//make sure they actually typed something after /say
										int i=0;
										int para=args.length; String s="";
										while(i<para){
										s=s+" "+args[i];
										i++; //Bad loop I know I'm working on it
						}
										Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "<GOD>" + s);
										c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
										return true;
										}

								}else{
									if(sender.hasPermission("basic.say.darkred")) {
										
										if(args.length != 0){//make sure they actually typed something after /say
											int i=0;
											int para=args.length; String s="";
											while(i<para){
											s=s+" "+args[i];
											i++; //Bad loop I know I'm working on it
							}
											Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "<GOD>" + s);
											c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
											return true;
											}

									}else{
										if(sender.hasPermission("basic.say.aqua")) {
											
											if(args.length != 0){//make sure they actually typed something after /say
												int i=0;
												int para=args.length; String s="";
												while(i<para){
												s=s+" "+args[i];
												i++; //Bad loop I know I'm working on it
								}
												Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "<GOD>" + s);
												c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
												return true;
												}

										}else{
											if(sender.hasPermission("basic.say.yellow")) {
												
												if(args.length != 0){//make sure they actually typed something after /say
													int i=0;
													int para=args.length; String s="";
													while(i<para){
													s=s+" "+args[i];
													i++; //Bad loop I know I'm working on it
									}
													Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "<GOD>" + s);
													c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
													return true;
													}
												}else{	
													if(sender.hasPermission("basic.say.random")) {
														if(args.length != 0){//make sure they actually typed something after /say
															int i=0;
															int para=args.length; String s="";
															while(i<para){
															s=s+" "+args[i];
															i++; //Bad loop I know I'm working on it
											}
															Bukkit.getServer().broadcastMessage(ChatColor.MAGIC + "<GOD>" + s);
															c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
															return true;
															}
														}else{	
																if(sender.hasPermission("basic.say.purple")){
																	if(args.length != 0){//make sure they actually typed something after /say
																		int i=0;
																		int para=args.length; String s="";
																		while(i<para){
																		s=s+" "+args[i];
																		i++; //Bad loop I know I'm working on it
								}
																		Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "<GOD>" + s);
																		c.sendMessage(ChatColor.GOLD + "//Say used by " + player.getDisplayName());
																		return true;
																	}
																
															
				}else{
					sender.sendMessage(ChatColor.RED + "You don't have permissions.");
				return true;
				}
	}
		return false;
	}
		return false;
	}
		return false;
	}
		return false;
	}
		return false;
	}
	}
	}
		return false;
	}
	}
		return false;
	}
	}

	}
		return false;
		}else{
			if(args.length != 0){
				int i=0;
				int para=args.length; String s="";
				while(i<para){
				s=s+" "+args[i];
				i++;
}
				Bukkit.getServer().broadcastMessage(ChatColor.RED + "<GOD>" + s);
				return true;
				}
		}
		}
		return false;
	}
	}