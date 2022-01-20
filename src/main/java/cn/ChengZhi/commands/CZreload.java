package cn.ChengZhi.commands;

import cn.ChengZhi.main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CZreload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        main.instance.reloadConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a&l重载成功!"));
        return false;
    }
}
