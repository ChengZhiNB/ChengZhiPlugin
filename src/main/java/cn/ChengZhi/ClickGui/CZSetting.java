package cn.ChengZhi.ClickGui;

import cn.ChengZhi.GuiHUB;
import cn.ChengZhi.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class CZSetting implements Listener {
    @EventHandler
    public void ClickGUI(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&a插件设置"))) {
            event.setCancelled(true);

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.GLASS)) {
                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a这只是一个边框,你为什么要点"));
            }

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.REDSTONE_BLOCK)) {
                Player player = (Player) event.getWhoClicked();
                player.closeInventory();
            }

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.EMERALD_BLOCK)) {
                Player player = (Player) event.getWhoClicked();
                main.instance.getConfig().set("Chat", false);
                main.instance.saveConfig();
                main.instance.reloadConfig();
                player.closeInventory();
                GuiHUB.CZSettingGui(player);
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&e管理员关闭了聊天功能"));
            }

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.BARRIER)) {
                Player player = (Player) event.getWhoClicked();
                main.instance.getConfig().set("Chat", true);
                main.instance.saveConfig();
                main.instance.reloadConfig();
                player.closeInventory();
                GuiHUB.CZSettingGui(player);
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&e管理员开启了聊天功能"));
            }
        }
    }
}
