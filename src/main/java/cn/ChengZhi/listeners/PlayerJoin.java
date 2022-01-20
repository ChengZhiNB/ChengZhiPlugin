package cn.ChengZhi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String PlayerName = e.getPlayer().getName();
        if (player.isOp()) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&',"&e欢迎管理员&f &c&l" + PlayerName + "&f &e进入服务器"));
        }else {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&',"&e欢迎玩家&f &f&l" + PlayerName + "&f &e进入服务器"));
        }
    }
}
