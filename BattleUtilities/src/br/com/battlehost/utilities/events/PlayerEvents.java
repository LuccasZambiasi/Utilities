package br.com.battlehost.utilities.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import br.com.battlehost.utilities.Main;

public class PlayerEvents implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
	     if (Main.plugin.getConfig().getBoolean("Variaveis.JoinMessage")) {
	 		Player p = e.getPlayer();
	    	 e.setJoinMessage("§7[§a+§7]§8 " + p.getDisplayName());
	     } else {
	 		e.setJoinMessage(null);	    	 
	     }

	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
	     if (Main.plugin.getConfig().getBoolean("Variaveis.QuitMessage")) {
	 		Player p = e.getPlayer();
	    	 e.setQuitMessage("§7[§c-§7]§8 " + p.getDisplayName());
	     } else {
	 		e.setQuitMessage(null);	    	 
	     }
	}
	
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void onCommandPreProcess(PlayerCommandPreprocessEvent e)
	  {
	    String[] msg = e.getMessage().split(" ");
	    List<String> plugins = new ArrayList<>();
	    plugins.add("pl");
	    plugins.add("plugin");
	    plugins.add("ver" + msg);
	    plugins.add("help" + msg);
	    plugins.add("ver");
	    plugins.add("help");
	    plugins.add("?");
	    plugins.add("me");
	    plugins.add("bukkit:help");
	    plugins.add("plugins");
	    plugins.add("minecraft:me");
	    for (String Loop : plugins) {
	      if (msg[0].equalsIgnoreCase("/" + Loop))
	      {
	          e.getPlayer().sendMessage("§7Este plugin foi desenvolvido excluisivamente para o " + Main.getPlugin().getConfig().getString("Outros.Prefix").replace("&", "§"));
	          e.getPlayer().sendMessage("§7O Plugin foi desenvolvido pelo §3§lLippz§7!");
	        e.setCancelled(true);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onPlayerColor(SignChangeEvent e)
	  {
	    if (e.getLine(0).contains("&")) {
	      e.setLine(0, e.getLine(0).replace("&", "§"));
	    }
	    if (e.getLine(1).contains("&")) {
	      e.setLine(1, e.getLine(1).replace("&", "§"));
	    }
	    if (e.getLine(2).contains("&")) {
	      e.setLine(2, e.getLine(2).replace("&", "§"));
	    }
	    if (e.getLine(3).contains("&")) {
	      e.setLine(3, e.getLine(3).replace("&", "§"));
	    }
	  }

}
