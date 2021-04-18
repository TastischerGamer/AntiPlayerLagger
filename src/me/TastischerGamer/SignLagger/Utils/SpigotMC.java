package me.TastischerGamer.SignLagger.Utils;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.TastischerGamer.SignLagger.main.PlayerLaggerPlugin;

public class SpigotMC {
	
	public static String spigoturl = "";
	public static String LatestVersion = "";
	
	public static void sendPluginStartMessage(String Pluginname, String PluginVersion, boolean hasUpdate) {
		
		if(hasUpdate == false) {
		
			Bukkit.getConsoleSender().sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Bukkit.getConsoleSender().sendMessage("§6" + Pluginname + ":");
			Bukkit.getConsoleSender().sendMessage(" §8- §7Coder: §6TastischerGamer");
			Bukkit.getConsoleSender().sendMessage(" §8- §7Version: §6" + PluginVersion);
			Bukkit.getConsoleSender().sendMessage(" §8- §7Running on: §6" + Bukkit.getBukkitVersion());
			Bukkit.getConsoleSender().sendMessage(" §8- §7SpigotURL: §6" + spigoturl);
			Bukkit.getConsoleSender().sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			if(PluginVersion.contains("BETA")) {
				
				Bukkit.getConsoleSender().sendMessage("§cThis Plugin is in Beta and it may has some Bugs!");
				
			}else if(PluginVersion.contains("ALPHA")) {
				
				Bukkit.getConsoleSender().sendMessage("§cThis Plugin is in Alpha and it may has some Bugs!");
				
			}
		
		}else {
			
			Bukkit.getConsoleSender().sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Bukkit.getConsoleSender().sendMessage("§6" + Pluginname + ":");
			Bukkit.getConsoleSender().sendMessage(" §8- §7Coder: §6TastischerGamer");
			Bukkit.getConsoleSender().sendMessage(" §8- §7Version: §6" + PluginVersion);
			Bukkit.getConsoleSender().sendMessage(" §8- §7Running on: §6" + Bukkit.getBukkitVersion());
			Bukkit.getConsoleSender().sendMessage(" §8- §7SpigotURL: §6" + spigoturl);
			Bukkit.getConsoleSender().sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			if(PluginVersion.contains("BETA")) {
				
				Bukkit.getConsoleSender().sendMessage("§cThis Plugin is in Beta and it may has some Bugs!");
				
			}else if(PluginVersion.contains("ALPHA")) {
				
				Bukkit.getConsoleSender().sendMessage("§cThis Plugin is in Alpha and it may has some Bugs!");
				
			}

			Bukkit.getConsoleSender().sendMessage(Util.getPrefix() + " §7Es ist ein Update auf die Version §6" + LatestVersion + " §7verfügbar!");
			
		}
			
	}
	
	public static void getUpdateInformations() {
		
		try {
			
			InputStream is = new URL("Private URL").openStream();
			
			@SuppressWarnings("resource")
			Scanner s = new Scanner(is);
			
			if(s.hasNext()) {
				
				String Version = s.nextLine();
				
				LatestVersion = Version.replace("<VERSION>:", "");
				
				String SpigotURL = s.nextLine();
				
				spigoturl = SpigotURL.replace("<SpigotURL>:", "");
				
			}
			
		}catch(Exception e) {
			
	    	Bukkit.getConsoleSender().sendMessage("§7Das Plugin konnte keine Verbindung zum Webspace herstellen");
			
		}
		
	}
	
	public static boolean hasUpdate() {
		
		String PVersion = PlayerLaggerPlugin.getInstance().getDescription().getVersion();
		
		if(PlayerLaggerPlugin.getInstance().getConfig().getBoolean("system.updatenotification") == true) {
		
			if(PVersion.equals(LatestVersion)) {
				
				return false;
				
			}else {
				
				return true;
				
			}
		
		}else {
			
			return false;
			
		}
		
	}
	
	public static void sendUpdateMessage(Player p, String Pluginname, String LatestVersion, String PluginVersion, String SpigotURL) {
		
    	p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	p.sendMessage(" §cEs ist ein neues Update für das Plugin: §6" + Pluginname + " §cverfügbar!");
    	p.sendMessage(" §8- §7Neue Version: §6" + LatestVersion);
    	p.sendMessage(" §8- §7Alte Version: §6" + PluginVersion);
    	p.sendMessage(" §8- §7Download Website:    §6" + SpigotURL);
    	p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}

}
