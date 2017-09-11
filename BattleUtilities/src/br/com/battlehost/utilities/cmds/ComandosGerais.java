package br.com.battlehost.utilities.cmds;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlehost.utilities.Main;

public class ComandosGerais implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

		if (cmd.getName().equalsIgnoreCase("chuva")){
			Player p = (Player)sender;
			if (args.length == 0){
				if (p.hasPermission("battleutilities.clima")){
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "toggledownfall");
					p.sendMessage(Main.getPlugin().getConfig().getString("Gerais.TempoAlterado").replace("&", "§"));

				} else {
					p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
					
				}
				return true;
			}

		}
		
		if (cmd.getName().equalsIgnoreCase("tarde")){
			Player p = (Player)sender;
			if (args.length == 0){
				if (p.hasPermission("battleutilities.clima")){
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set 12500");
					p.sendMessage(Main.getPlugin().getConfig().getString("Gerais.TempoAlterado").replace("&", "§"));
				} else {
					p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
					
				}
				return true;
			}
		}
		
		
		if (cmd.getName().equalsIgnoreCase("dia")){
			Player p = (Player)sender;
			if (args.length == 0){
				if (p.hasPermission("battleutilities.clima")){
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set 0");
					p.sendMessage(Main.getPlugin().getConfig().getString("Gerais.TempoAlterado").replace("&", "§"));

				} else {
					p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
					
				}
				return true;
			}
		}
		
		
		if (cmd.getName().equalsIgnoreCase("invsee")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				if(!player.hasPermission("battleutilities.inventario")) {
					player.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
					return true;
				}
				if(args.length == 0) {
					player.sendMessage(Main.getPlugin().getConfig().getString("Sintaxes.Invsee").replace("&", "§"));
					return true;
				}
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null) {
					player.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.JogadorOffline").replace("&", "§"));
					return true;
				}
				player.openInventory(target.getInventory());
				player.sendMessage(Main.getPlugin().getConfig().getString("Gerais.AbriuInventario").replace("&", "§").replace("<jogador>", target.getName()));
			}
		}
		
		
		
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				if(args.length == 0) {
					player.sendMessage(Main.getPlugin().getConfig().getString("Gerais.TeleportouSpawn").replace("&", "§"));
					player.teleport(Bukkit.getWorld(Main.getPlugin().getConfig().getString("Outros.NomeMundo")).getSpawnLocation());
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("matar") || (cmd.getName().equalsIgnoreCase("kill") 
				|| (cmd.getName().equalsIgnoreCase("suicidar")))) {
			Player p = (Player)sender;
	        if (!p.hasPermission("battleutilities.kill"))
	        {
	          p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
	        }
	        else if (args.length == 0)
	        {
	          p.setHealth(0.0D);
	          p.sendMessage(Main.getPlugin().getConfig().getString("Gerais.SeMatou").replace("&", "§"));
	          if (!p.hasPermission("battleutilities.killother")) {
	            sender.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
	          }
	        }
	        else
	        {
	          Player target = Bukkit.getServer().getPlayer(args[0]);
	          target.setHealth(0.0D);
	          p.sendMessage(Main.getPlugin().getConfig().getString("Gerais.MatouJogador").replace("&", "§").replace("<morto>", target.getName()));
	          target.sendMessage(Main.getPlugin().getConfig().getString("Gerais.MortoPorAdmin").replace("&", "§"));
	        }
		}
		
		
		
		  if (cmd.getName().equalsIgnoreCase("voar")) {
			  Player player = (Player)sender;
			  if(args.length ==  0) {
				  if(sender.hasPermission("luccasapi.voar")) {
					  if(!player.getAllowFlight()) {
						  player.sendMessage(Main.getPlugin().getConfig().getString("Gerais.VoarAtivado").replace("&", "§"));
						  player.setAllowFlight(true);
					  } else {
						  player.sendMessage(Main.getPlugin().getConfig().getString("Gerais.VoarDesativado").replace("&", "§"));
						  player.setAllowFlight(false);  

					  }
				  } else {
					  player.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
					  return true;
				  }
			  } else {
				  player.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
				  return true;
			  }
		  }
		
	
		  
		  
		if (cmd.getName().equalsIgnoreCase("clearchat")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.ExecutadoConsole").replace("&", "§"));
				return true;
			}
			Player p = (Player)sender;
			if (!p.hasPermission("luccasapi.chat")) {
				p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
				return true;
			}
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage(Main.getPlugin().getConfig().getString("Gerais.ChatLimpo").replace("&", "§"));
			return false;
		}
		
	    if (cmd.getName().equalsIgnoreCase("morrer"))
	    {
	    	Player p = (Player)sender;
	      p.setHealth(0.0D);
	      p.sendMessage(Main.getPlugin().getConfig().getString("Gerais.SeMatou").replace("&", "§"));
	    }
	    
	    if (cmd.getName().equalsIgnoreCase("creditos")) {
	    Player p = (Player)sender;
	    p.sendMessage(" ");
	    p.sendMessage("§a* §7Olá, Você sabia que este plugin foi feito pelo Luccas?!");
	    p.sendMessage("§7 Você pode encontrar diversos tutoriais no youtube pesquisando BattleHostBR!");
	    p.sendMessage("§2 www.battlehost.com.br");
	    p.sendMessage("");
	    p.sendMessage("§7 Agradecemos pelo uso de nosso plugin <3 ");
	    return false;
		
	    }
	    
	    
	    
        if (cmd.getName().equalsIgnoreCase("aplicar")) {
        	Player p = (Player)sender;
            p.sendMessage(Main.getPlugin().getConfig().getString("Gerais.Formulario").replace("&", "§"));
        }

        if (cmd.getName().equalsIgnoreCase("pvp")) {
        	Player p = (Player)sender;
            if (p.hasPermission("battleutilities.admin")) {
                if (args.length == 0) {
                    p.sendMessage(Main.getPlugin().getConfig().getString("Sintaxes.Pvp").replace("&", "§"));
                    return true;
                }
                if (args[0].equalsIgnoreCase("on")) {
                    Bukkit.getWorld(Main.getPlugin().getConfig().getString("Outros.NomeMundo")).setPVP(true);
                    Bukkit.broadcastMessage(Main.getPlugin().getConfig().getString("Gerais.PvpAtivado").replace("&", "§"));
                }
                if (args[0].equalsIgnoreCase("off")) {
                    Bukkit.getWorld(Main.getPlugin().getConfig().getString("Outros.NomeMundo")).setPVP(false);
                    Bukkit.broadcastMessage(Main.getPlugin().getConfig().getString("Gerais.PvpDesativado").replace("&", "§"));
                }
            }
            else {
                p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
            }
        }
        
		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.ExecutadoConsole").replace("&", "§"));
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (args.length == 0) {
				Player p = (Player) sender;
				if (!p.hasPermission("battleutilities.gm")) {
					p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
					return true;
				}
				p.sendMessage(Main.getPlugin().getConfig().getString("Sintaxes.Gamemode").replace("&", "§"));
				return true;
			}
			if (args[0].equalsIgnoreCase("1")) {
				Player p = (Player) sender;
				p.sendMessage(Main.getPlugin().getConfig().getString("Gamemodes.Creative").replace("&", "§"));
				p.setGameMode(GameMode.CREATIVE);
			} else {
				if (args[0].equalsIgnoreCase("0")) {
					Player p = (Player) sender;
					p.sendMessage(Main.getPlugin().getConfig().getString("Gamemodes.Survival").replace("&", "§"));
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("tell")) {
		    if (args.length == 0)
		    {
		      sender.sendMessage(Main.getPlugin().getConfig().getString("Sintaxes.Tell").replace("&", "§"));
		      return true;
		    }
		    if (args.length == 1)
		    {
		      sender.sendMessage(Main.getPlugin().getConfig().getString("Sintaxes.Tell").replace("&", "§"));
		      return true;
		    }
		    if (args.length > 1)
		    {
		      Player target = Bukkit.getPlayerExact(args[0]);
		      if ((target == null) || (!(target instanceof Player)))
		      {
		        sender.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.JogadorOffline").replace("&", "§"));
		        return true;
		      }
		      StringBuilder sb = new StringBuilder();
		      for (int i = 1; i < args.length; i++) {
		        sb.append(args[i] + " ");
		      }
		      String msg = sb.toString();
		      target.sendMessage(String.format("§a%s §7para §7Você§3>>§e %s", new Object[] { sender.getName(), msg }));
		      sender.sendMessage(String.format("§7Você §7para §a%s§3>>§e %s", new Object[] { target.getName(), msg }));
		    return false;
		  }
		}
		
		if (cmd.getName().equalsIgnoreCase("sc")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.ExecutadoConsole").replace("&", "§"));
				return true;
			}
			Player p = (Player)sender;
			if (!(p.hasPermission("battleutilities.staffchat"))) {
				p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
				return true;
		}
			if (args.length == 0) {
			p.sendMessage(Main.getPlugin().getConfig().getString("Sintaxes.StaffChat").replace("&", "§"));
			return true;
		} else {
			String message = "";
			for (int i = 0; i < args.length; i++) {
				if (i == args.length - 1) {
					message = message + args[i];
			} else {
				message = message + args[i] + " ";
			}
		}
			for (Player s : Bukkit.getOnlinePlayers()) {
				if (s.hasPermission("battleutilities.staffchat")) {
					s.sendMessage("§7[§6§lSTAFFCHAT§7] " + p.getName() + " §7» " + message.replace("&", "§"));
				}
			}
			return true;
		}
		}
		if (cmd.getName().equalsIgnoreCase("echest")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				if(!player.hasPermission("battleutilities.echest")) {
					player.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
					return true;
				}
				player.openInventory(player.getEnderChest());
				player.sendMessage(Main.getPlugin().getConfig().getString("Gerais.AbriuEchest").replace("&", "§"));
			}
		}

		return false;	
	}
}