package me.TastischerGamer.SignLagger.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import me.TastischerGamer.SignLagger.Utils.Util;

public class BookOpenListener implements Listener {
	
	@EventHandler
	public void onItemClick(PlayerInteractEvent e) {
		
		try {
		
			if(e.getItem().getType().equals(Material.WRITTEN_BOOK) || e.getItem().getType().equals(Material.ENCHANTED_BOOK)) {
				
				ItemStack book = e.getItem();
				
				BookMeta bookm = (BookMeta) book.getItemMeta();
				
				if(bookm.getPageCount() == 1) {
												
					if(bookm.getPage(1).length() >= 500) {
								
						e.getPlayer().sendMessage(Util.getPrefix() + " §cDas Buch, welches du angeklickt hattest, wurde entfernt, da dieses Buch ein 'Lagbuch' war!");
						
						Util.sendAlertBook(e.getPlayer());
						
						if(Util.checkDev() == true) {
							
							Bukkit.getConsoleSender().sendMessage("§cDEV OUTPUT:");
							
							Bukkit.getConsoleSender().sendMessage("" + bookm.getPage(1).length());
							
						}
						
						e.getPlayer().getInventory().remove(e.getItem());
						
						e.setCancelled(true);
								
					}
					
				}else {
					
					for(int i = 1; i < bookm.getPageCount(); i++) {
						
						if(bookm.getPage(i).length() >= 500) {
							
//							Bukkit.getConsoleSender().sendMessage("§cPage §6" + i + "§c: hatte mehr als 500 Zeichen!");
							
							e.getPlayer().sendMessage(Util.getPrefix() + " §cDas Buch, welches du angeklickt hattest, wurde entfernt, da dieses Buch ein 'Lagbuch' war!");
							
							Util.sendAlertBook(e.getPlayer());
							
							if(Util.checkDev() == true) {
								
								Bukkit.getConsoleSender().sendMessage("§cDEV OUTPUT:");
								
								Bukkit.getConsoleSender().sendMessage("" + bookm.getPage(i).length());
								
							}
													
							e.getPlayer().getInventory().remove(e.getItem());
							
							e.setCancelled(true);
							
						}
						
					}
					
				}
				
			}
		
		}catch(Exception e1) {
			

			
		}
		
	}

}
