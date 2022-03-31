package andriy333kin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onDisable() {}

    @Override
    public void onEnable() {
    	getCommand("hub").setExecutor(new HubCommand());
    	Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
    }
}
