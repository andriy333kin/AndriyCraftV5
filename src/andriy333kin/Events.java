package andriy333kin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.TabCompleteEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("deprecation")

public class Events implements Listener {

    @EventHandler
    public void onjoin(PlayerJoinEvent event) {
    	event.getPlayer().sendMessage(ChatColor.GOLD + "Ви зараз граєте в дуелі на AndriyCraft");
    	event.setJoinMessage(ChatColor.GREEN + "+ " + ChatColor.GOLD + event.getPlayer().getDisplayName());
    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mw move " + event.getPlayer().getDisplayName() + " duels_lobby1");
    } 

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
    	if(event.getPlayer().getLocation().getY() < 30) {
    		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mw move " + event.getPlayer().getDisplayName() + " kill " + event.getPlayer().getDisplayName());
    		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mw move " + event.getPlayer().getDisplayName() + " duels_lobby1");
    	}
    } 
    
    @EventHandler
    public void onWeaterChange(WeatherChangeEvent event) {
    	event.setCancelled(true);
    }

    @EventHandler
    public void onLightningStrike(LightningStrikeEvent event) {
    	event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }

    @EventHandler
    public void onBlockbreak(BlockBreakEvent event) {
    	event.setCancelled(true);
    }

    @EventHandler
    public void onBlockplace(BlockPlaceEvent event) {
    	event.setCancelled(true);
    }

    @EventHandler
    public void onpvp(EntityDamageEvent event) {
    	World world = Bukkit.getWorld("duels_lobby1");
    	World entityworld = event.getEntity().getWorld();
    	if(world == entityworld) { event.setCancelled(true); }
    }

    @EventHandler
    public void onchat(PlayerChatEvent event) {
    	Bukkit.broadcastMessage(ChatColor.GRAY + event.getPlayer().getDisplayName() + ": " + event.getMessage());
    	event.setCancelled(true);
    }

    @EventHandler
    public void ontab(TabCompleteEvent event) {
    	event.setCancelled(true);
    }

    @EventHandler
    public void oncmd(PlayerCommandPreprocessEvent event) {
    	if(event.getMessage().contains(":") == true) { event.setCancelled(true); }
    	switch (event.getMessage()) {
    		case "/pl":
    			event.setCancelled(true);
    			break;
    		case "/plugins":
    			event.setCancelled(true);
    			break;
    		case "/bukkit:pl":
    			event.setCancelled(true);
    			break;
    		case "/bukkit:plugins":
    			event.setCancelled(true);
    			break;
    		case "/ver":
    			event.setCancelled(true);
    			break;
    		case "/version":
    			event.setCancelled(true);
    			break;
    		case "/bukkit:ver":
    			event.setCancelled(true);
    			break;
    		case "/bukkit:version":
    			event.setCancelled(true);
    			break;
    		case "/icanhasbukkit":
    			event.setCancelled(true);
    			break;
    		case "/bukkit:icanhasbukkit":
    			event.setCancelled(true);
    			break;
    	}
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
    	event.setQuitMessage(ChatColor.RED + "- " + ChatColor.GOLD + event.getPlayer().getDisplayName());
    }
}
