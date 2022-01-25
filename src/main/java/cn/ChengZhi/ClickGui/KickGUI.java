package cn.ChengZhi.ClickGui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class KickGUI implements Listener {
    @EventHandler
    public void ClickGUI(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&a选择你要踢出的玩家"))) {
            event.setCancelled(true);

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.GLASS)) {
                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a这只是一个边框,你为什么要点"));
            }

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.REDSTONE_BLOCK)) {
                Player player = (Player) event.getWhoClicked();
                player.closeInventory();
            }

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.NAME_TAG)) {
                Player player = (Player) event.getWhoClicked();
                String pname = Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName();
                Player kickplayer = Bukkit.getPlayer(pname);
                if(Bukkit.getPlayer(pname) == null) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c这个玩家不存在或不在线"));
                }else {
                    if (kickplayer.isOnline()) {
                        if (!kickplayer.isOp()) {
                            if (!kickplayer.getName().equals(player.getName())) {
                                kickplayer.kickPlayer(ChatColor.translateAlternateColorCodes('&',"&c你被踢出服务器" ));
                            }else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c你不能踢出自己"));
                            }
                        }else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c你不能踢出管理员"));
                        }
                    }
                }
            }
        }
    }
}
