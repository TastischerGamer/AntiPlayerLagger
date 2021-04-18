package me.TastischerGamer.SignLagger.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.TastischerGamer.SignLagger.Utils.Util;
import me.TastischerGamer.SignLagger.main.PlayerLaggerPlugin;

public class SignPlaceListener implements Listener {
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {

		String line1 = e.getLine(0);
		String line2 = e.getLine(1);
		String line3 = e.getLine(2);
		String line4 = e.getLine(3);	
		
		if(line1.length() >= 49) {
			
			e.getBlock().setType(Material.AIR);
			Util.KickPlayer(e.getPlayer(), PlayerLaggerPlugin.getInstance().getConfig().getString("system.kickmessage"));
			Util.sendAlertSign(e.getPlayer());
			e.setCancelled(true);
			
		}else if(line2.length() >= 49) {
			e.getBlock().setType(Material.AIR);
			Util.KickPlayer(e.getPlayer(), PlayerLaggerPlugin.getInstance().getConfig().getString("system.kickmessage"));
			Util.sendAlertSign(e.getPlayer());
			e.setCancelled(true);
			
		}else if(line3.length() >= 49) {
			e.getBlock().setType(Material.AIR);
			Util.KickPlayer(e.getPlayer(), PlayerLaggerPlugin.getInstance().getConfig().getString("system.kickmessage"));
			Util.sendAlertSign(e.getPlayer());
			e.setCancelled(true);
			
		}else if(line4.length() >= 49) {
			e.getBlock().setType(Material.AIR);
			Util.KickPlayer(e.getPlayer(), PlayerLaggerPlugin.getInstance().getConfig().getString("system.kickmessage"));
			Util.sendAlertSign(e.getPlayer());
			e.setCancelled(true);
			
		}
		
		if(Util.checkDev() == true) {
			
			Bukkit.getConsoleSender().sendMessage("§cDEV OUTPUT:");
			
			for(int i = 0; i < e.getLines().length; i++) {
				
				Bukkit.getConsoleSender().sendMessage("" + e.getLine(i).length());
				
			}
			
		}
		
	}

}
