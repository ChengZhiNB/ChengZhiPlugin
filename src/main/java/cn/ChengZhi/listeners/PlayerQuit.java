package cn.ChengZhi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    @EventHandler
    public void playerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String PlayerName = e.getPlayer().getName();
        if (player.isOp()) {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&',"&e管理员&f &c&l" + PlayerName + "&f &e离开了服务器"));
        }else {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&',"&e玩家&f &f&l" + PlayerName + "&f &e离开了服务器"));
        }
    }
}
