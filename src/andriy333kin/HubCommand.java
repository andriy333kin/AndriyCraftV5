package andriy333kin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.md_5.bungee.api.ChatColor;

public class HubCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(ChatColor.YELLOW + "ўоб вернутис€ в нормальне лобб≥ використовуйте /fhub");
		sender.sendMessage(ChatColor.YELLOW + "If you want to teleport to normal lobby use /fhub");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mw move " + sender.getName() + " duels_lobby1");
		return true;
	}
}