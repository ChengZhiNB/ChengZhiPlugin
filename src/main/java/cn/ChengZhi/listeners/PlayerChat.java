package cn.ChengZhi.listeners;

import cn.ChengZhi.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerChat implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent Chat){
        String message = Chat.getMessage();
        Player Player = Chat.getPlayer();

        if(main.instance.getConfig().getBoolean("Chat")) {
            Chat.setCancelled(false);
        }else {
            Player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c&l发送失败&f,&a&l原因&f:&c&l该服务器禁止发送信息"));
            Chat.setCancelled(true);
        }

        List<String> keywords = new ArrayList<>();
        main.instance.getConfig().getStringList("AntiKeyWords").forEach(s -> keywords.add(s));

        for (String keyword : keywords) {
            if (message.contains(keyword)) {
                if (!Player.isOp()) {
                    Player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c&l发送失败&f,&a&l原因&f:&c&l遇到未知错误"));
                    Chat.setCancelled(true);
                } else {
                    Chat.setCancelled(false);
                }
                return;
            }
        }
    }
}
