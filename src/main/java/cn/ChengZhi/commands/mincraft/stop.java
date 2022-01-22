package cn.ChengZhi.commands.mincraft;

import cn.ChengZhi.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

import static cn.ChengZhi.main.*;

public class stop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String stopdone = (ChatColor.translateAlternateColorCodes('&', "&a正在关闭服务器!"));//发送给命令执行人
        String broadcaststop = (ChatColor.translateAlternateColorCodes('&', "&c&l服务器即将关闭!"));//广播消息"stopMessage"));//踢出信息
        String stopkick = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(main.instance.getConfig().getString("StopMessage")));
        if (Bukkit.getOnlinePlayers().size() == 0) {
            if (sender.isOp()) {
                sender.sendMessage(stopdone);
                Bukkit.broadcastMessage((broadcaststop));
                Bukkit.broadcastMessage((broadcaststop));
                Bukkit.broadcastMessage((broadcaststop));
                Bukkit.shutdown();
            }
        }else {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (sender.isOp()) {
                    sender.sendMessage(stopdone);
                    Bukkit.broadcastMessage((broadcaststop));
                    Bukkit.broadcastMessage((broadcaststop));
                    Bukkit.broadcastMessage((broadcaststop));
                    player.kickPlayer((stopkick));
                    Bukkit.shutdown();
                }
            }
        }
        return false;
    }
}
