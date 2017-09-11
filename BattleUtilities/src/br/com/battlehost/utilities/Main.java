package br.com.battlehost.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.battlehost.utilities.cmds.ComandosGerais;
import br.com.battlehost.utilities.events.PlayerEvents;


public class Main extends JavaPlugin implements Listener{
	
	public static Main getInstance() {
		return instance;
		
	}
	  public static Plugin getPlugin()
	  {
	    return plugin;
	  }
	
	public void onEnable() {
		Data();
}
	
		public void onDisable() {
	quitmessage();
	}

		
	
	public void Comandos() {
		getCommand("chuva").setExecutor(new ComandosGerais());
		getCommand("tarde").setExecutor(new ComandosGerais());
		getCommand("dia").setExecutor(new ComandosGerais());
		getCommand("invsee").setExecutor(new ComandosGerais());
		getCommand("spawn").setExecutor(new ComandosGerais());
		getCommand("matar").setExecutor(new ComandosGerais());
		getCommand("voar").setExecutor(new ComandosGerais());
    	getCommand("clearchat").setExecutor(new ComandosGerais());
		getCommand("morrer").setExecutor(new ComandosGerais());
		getCommand("creditos").setExecutor(new ComandosGerais());
		getCommand("aplicar").setExecutor(new ComandosGerais());
		getCommand("pvp").setExecutor(new ComandosGerais());
		getCommand("gm").setExecutor(new ComandosGerais());
		getCommand("tell").setExecutor(new ComandosGerais());
		getCommand("sc").setExecutor(new ComandosGerais());
		getCommand("echest").setExecutor(new ComandosGerais());

		

	}
	
	public void eventos() {
	    Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
	}
	
	public void joinmessage() {
		Bukkit.getConsoleSender().sendMessage("§a§l(UTILIDADES) §7§oPlugin habilitado!");
		Bukkit.getConsoleSender().sendMessage("§a§l(UTILIDADES) §7§oFeito por LuccasZambiasi.");
	}
	
	public void quitmessage() {
		Bukkit.getConsoleSender().sendMessage("§a§l(UTILIDADES) §7§oPlugin desabilitado!");
		Bukkit.getConsoleSender().sendMessage("§a§l(UTILIDADES) §7§oFeito por LuccasZambiasi.");
    	for(Player player : Bukkit.getOnlinePlayers()) {
    		player.kickPlayer("§6§lSEUSERVIDOR \n §f  Servidor reiniciando \n §fAguarde para retornar \n §eloja.seuservidor.com");
    	}
	}
	
	
	  public static Main instance;	
	  public static Plugin plugin; 
		  public static Plugin pl;
		  
			public void Data() {
				Comandos();
				eventos();
				joinmessage();
				
			    plugin = this;
			    instance = this;
			    pl = this;
			    saveDefaultConfig();
			}
	  
}