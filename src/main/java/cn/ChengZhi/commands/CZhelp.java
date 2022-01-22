package cn.ChengZhi.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CZhelp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f---------&e橙汁插件&f---------"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e帮助界面 &f/&aCZhelp"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e重载插件 &f/&aCZreload"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e全体通知 &f/&aCZAllChat <内容>"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e关闭服务器 &f/&astop"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e将玩家踢出服务器 &f/&akick <玩家ID> [理由]"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e禁言玩家 &f/&amute <玩家ID> [理由]"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e解除禁言玩家 &f/&aunmute <玩家ID>"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7<>是必填 []是选填"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f---------&e橙汁插件&f---------"));
        return false;
    }
}
