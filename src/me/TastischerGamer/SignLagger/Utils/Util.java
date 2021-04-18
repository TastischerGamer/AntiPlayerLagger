package me.TastischerGamer.SignLagger.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.TastischerGamer.SignLagger.main.PlayerLaggerPlugin;

public class Util {
	
	public static String getPrefix() {
		
		String prefix = ChatColor.translateAlternateColorCodes('&', PlayerLaggerPlugin.getInstance().getConfig().getString("system.prefix"));
		
		return prefix;
		
	}
	
	public static void KickPlayer(Player p, String reason) {
				
		p.kickPlayer(ChatColor.translateAlternateColorCodes('&', reason));
		
	}
	
	public static void sendAlertSign(Player p) {
		
		FileConfiguration config = PlayerLaggerPlugin.getInstance().getConfig();
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			if(all.hasPermission(config.getString("system.alertperm"))) {
				
				all.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("system.alertmessage.sign").replace("%player%", p.getName()).replace("%prefix%", config.getString("system.prefix"))));
				Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("system.alertmessage.sign").replace("%player%", p.getName()).replace("%prefix%", config.getString("system.prefix"))));
				
				if(config.getBoolean("system.alerttitle") == true) {
					
					TitleAlert(p, "sign");
					
				}
				
			}
			
		}
		
	}
	
	public static void sendAlertBook(Player WhoOpenedBook) {
		
		FileConfiguration config = PlayerLaggerPlugin.getInstance().getConfig();
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			if(all.hasPermission(config.getString("system.alertperm"))) {
				
				all.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("system.alertmessage.book").replace("%player%", WhoOpenedBook.getName()).replace("%prefix%", config.getString("system.prefix"))));
				Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("system.alertmessage.book")
						.replace("%player%", WhoOpenedBook.getName()).replace("%prefix%", config.getString("system.prefix"))));
				
				if(config.getBoolean("system.alerttitle") == true) {
					
					TitleAlert(WhoOpenedBook, "book");
					
				}
				
			}
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void TitleAlert(Player p, String configmessage) {
		
		FileConfiguration config = PlayerLaggerPlugin.getInstance().getConfig();
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			if(all.hasPermission(config.getString("system.alertperm"))) {
				
				String Line1 = ChatColor.translateAlternateColorCodes('&', config.getString("system.titlealert.line1"));
				
				String Line2 = ChatColor.translateAlternateColorCodes('&', config.getString("system.alertmessage." + configmessage)
						.replace("%player%", p.getName())
						.replace("%prefix%", ""));
				
				all.sendTitle(Line1, Line2);
				
			}
			
		}
		
	}
	
	public static boolean checkDev() {
		
		boolean Value = false;
		
		File file = new File("dev.version");
		
		List<String> Content = new ArrayList<>();
		
		Content.add("Plugin: " + PlayerLaggerPlugin.getInstance().getDescription().getName());
		Content.add("Version: " + PlayerLaggerPlugin.getInstance().getDescription().getVersion());
		Content.add("DEV: on");
		
		if(file.exists()) {
			
			try {
				
				@SuppressWarnings("resource")
				Scanner s = new Scanner(file);
				
				for(int i = 0; i < 10; i++) {
					
					if(s.hasNext()) {
						
						if(s.nextLine().equals(Content.get(i))) {
							
							Value = true;
							
						}else {
							
							i = 11;
							
							Value = false;
							
						}
						
					}else {
						
						i = 11;
						
					}
					
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
//			Value = true;
			
		}else {
			
			Value = false;
			
		}
		
		return Value;
		
	}

}
