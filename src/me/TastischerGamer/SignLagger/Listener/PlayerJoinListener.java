package me.TastischerGamer.SignLagger.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.TastischerGamer.SignLagger.Utils.SpigotMC;
import me.TastischerGamer.SignLagger.main.PlayerLaggerPlugin;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		if(e.getPlayer().hasPermission(PlayerLaggerPlugin.getInstance().getConfig().getString("system.updatemessageperm"))) {
			
			SpigotMC.getUpdateInformations();
			
			if(SpigotMC.hasUpdate()) {
				
				SpigotMC.sendUpdateMessage(e.getPlayer(), PlayerLaggerPlugin.getInstance().getDescription().getName(), SpigotMC.LatestVersion, PlayerLaggerPlugin.getInstance().getDescription().getVersion(), SpigotMC.spigoturl);
				
			}
			
		}
		
	}

}
