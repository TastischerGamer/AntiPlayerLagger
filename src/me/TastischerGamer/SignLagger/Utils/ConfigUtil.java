package me.TastischerGamer.SignLagger.Utils;

import org.bukkit.configuration.file.FileConfiguration;

import me.TastischerGamer.SignLagger.main.PlayerLaggerPlugin;

public class ConfigUtil {
	
	public static void onConfigLoad() {
		
		FileConfiguration config = PlayerLaggerPlugin.getInstance().getConfig();
		
		config.options().copyDefaults(true);
		
		config.addDefault("system.prefix", "&c&lAntiPlayerLagger &8| ");
		config.addDefault("system.kickmessage", "&cDu wurdest gekickt, da du einen Sign Exploit nutzen wolltest!");
		config.addDefault("system.alertmessage.sign", "%prefix% &7Der Spieler &6%player% &7wollte den Server zum Laggen bringen!");
		config.addDefault("system.alertmessage.book", "%prefix% &7Der Spieler &6%player% &7wollte gerade ein Lagbuch öffnen!");
		config.addDefault("system.alertperm", "system.alert");
		config.addDefault("system.updatemessageperm", "system.updatenotify");
		config.addDefault("system.updatenotification", true);
		config.addDefault("system.alerttitle", false);
		config.addDefault("system.titlealert.line1", "&4Warnung!");
		config.addDefault("system.titlealert.line2", "INFO: in der Zweiten linie stehen die alertmessages drin! (system.alertmessage. ...) und der Prefix wird nicht angezeigt!");
		
		PlayerLaggerPlugin.getInstance().saveConfig();
		PlayerLaggerPlugin.getInstance().saveDefaultConfig();
		
	}

}
