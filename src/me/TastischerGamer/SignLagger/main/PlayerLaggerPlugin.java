package me.TastischerGamer.SignLagger.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.TastischerGamer.SignLagger.Listener.BookOpenListener;
import me.TastischerGamer.SignLagger.Listener.PlayerJoinListener;
import me.TastischerGamer.SignLagger.Listener.SignPlaceListener;
import me.TastischerGamer.SignLagger.Utils.ConfigUtil;
import me.TastischerGamer.SignLagger.Utils.SpigotMC;
import me.TastischerGamer.SignLagger.Utils.Util;

public class PlayerLaggerPlugin extends JavaPlugin {
	
	private static PlayerLaggerPlugin instance;
	
	public void onEnable() {
		
		PlayerLaggerPlugin.instance = this;
		
		ConfigUtil.onConfigLoad();
			
		PluginManager pm = Bukkit.getPluginManager();
		
		SpigotMC.getUpdateInformations();
		
		SpigotMC.sendPluginStartMessage(this.getDescription().getName(), this.getDescription().getVersion(), SpigotMC.hasUpdate());
		
		if(Util.checkDev() == true) {
			
			Bukkit.getConsoleSender().sendMessage(Util.getPrefix() + " §6DEVELOPMENT VERSION");
			
		}
				
		pm.registerEvents(new SignPlaceListener(), this);
		
		pm.registerEvents(new BookOpenListener(), this);
		
		pm.registerEvents(new PlayerJoinListener(), this);
		
	}
	
	public void onDisable() {
		
		
		
	}
	
	public static PlayerLaggerPlugin getInstance() {
		
		return PlayerLaggerPlugin.instance;
		
	}

}
