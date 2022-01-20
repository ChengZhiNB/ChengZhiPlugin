package cn.ChengZhi.commands.mincraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class list implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a在线人数&f：&e" + Bukkit.getOnlinePlayers().size() + "&f/&e" + Bukkit.getMaxPlayers()));
        return false;
    }
}
