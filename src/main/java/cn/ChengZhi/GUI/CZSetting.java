package cn.ChengZhi.GUI;

import cn.ChengZhi.GuiHUB;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CZSetting implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            GuiHUB.CZSettingGui(player);
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c错误,这个命令只能在游戏里面使用"));
        }
        return false;
    }
}
