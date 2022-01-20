package cn.ChengZhi.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CZAllChat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            String message = args[0];
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f[&c全体通知&f] &e" + message));
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c错误&f:&c参数有误"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a正确用法&f: /CZAllChat &f<&e文本&f>"));
        }
        return false;
    }
}
