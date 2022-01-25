package cn.ChengZhi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GuiHUB {
    public static void CZSettingGui(Player player) {
        Inventory UI = Bukkit.createInventory(player,45, ChatColor.translateAlternateColorCodes('&',"&a插件设置"));

        ItemStack Bk = new ItemStack(Material.GLASS);
        ItemMeta Bk_Meta = Bk.getItemMeta();
        Bk_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&e这只是一个边框"));
        ArrayList<String> Bk_Lore = new ArrayList<>();
        Bk_Lore.add(null);
        Bk_Lore.add(ChatColor.translateAlternateColorCodes('&',"&e这只是一个边框"));
        Bk_Meta.setLore(Bk_Lore);
        Bk.setItemMeta(Bk_Meta);

        for (int i1 = 0 ; i1 <9 ; i1++) {
            UI.setItem(i1,Bk);
        }

        for (int i2 = 36 ; i2 <40 ; i2++) {
            UI.setItem(i2,Bk);
        }

        for (int i3 = 41 ; i3 <45 ; i3++) {
            UI.setItem(i3,Bk);
        }

        UI.setItem(9,Bk);
        UI.setItem(17,Bk);

        UI.setItem(18,Bk);
        UI.setItem(26,Bk);

        UI.setItem(27,Bk);
        UI.setItem(35,Bk);

        ItemStack Gb = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta Gb_Meta = Gb.getItemMeta();
        Gb_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&c关闭菜单"));
        ArrayList<String> Gb_Lore = new ArrayList<>();
        Gb_Lore.add(null);
        Gb_Lore.add(ChatColor.translateAlternateColorCodes('&',"&e点击关闭菜单"));
        Gb_Meta.setLore(Gb_Lore);
        Gb.setItemMeta(Gb_Meta);

        UI.setItem(40,Gb);

        ItemStack LT = new ItemStack(Material.NAME_TAG);
        ItemMeta LT_Meta = LT.getItemMeta();
        LT_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&e聊天开关"));
        LT.setItemMeta(LT_Meta);

        UI.setItem(10,LT);

        ItemStack LTTrue = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta LTTrue_Meta = LTTrue.getItemMeta();
        LTTrue_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&e聊天开关"));
        LTTrue.setItemMeta(LTTrue_Meta);

        ItemStack LTFalse = new ItemStack(Material.BARRIER);
        ItemMeta LTFalse_Meta = LTFalse.getItemMeta();
        LTFalse_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&e聊天开关"));
        LTFalse.setItemMeta(LTFalse_Meta);

        if (main.instance.getConfig().getBoolean("Chat")) {
            UI.setItem(19,LTTrue);
        }else {
            UI.setItem(19,LTFalse);
        }

        player.openInventory(UI);
    }

    public static void KickGui(Player player) {
        Inventory UI = Bukkit.createInventory(player,45, ChatColor.translateAlternateColorCodes('&',"&a选择你要踢出的玩家"));

        ItemStack Bk = new ItemStack(Material.GLASS);
        ItemMeta Bk_Meta = Bk.getItemMeta();
        Bk_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&e这只是一个边框"));
        ArrayList<String> Bk_Lore = new ArrayList<>();
        Bk_Lore.add(null);
        Bk_Lore.add(ChatColor.translateAlternateColorCodes('&',"&e这只是一个边框"));
        Bk_Meta.setLore(Bk_Lore);
        Bk.setItemMeta(Bk_Meta);

        for (int i1 = 0 ; i1 <9 ; i1++) {
            UI.setItem(i1,Bk);
        }

        for (int i2 = 36 ; i2 <40 ; i2++) {
            UI.setItem(i2,Bk);
        }

        for (int i3 = 41 ; i3 <45 ; i3++) {
            UI.setItem(i3,Bk);
        }

        UI.setItem(9,Bk);
        UI.setItem(17,Bk);

        UI.setItem(18,Bk);
        UI.setItem(26,Bk);

        UI.setItem(27,Bk);
        UI.setItem(35,Bk);

        ItemStack Gb = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta Gb_Meta = Gb.getItemMeta();
        Gb_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&c关闭菜单"));
        ArrayList<String> Gb_Lore = new ArrayList<>();
        Gb_Lore.add(null);
        Gb_Lore.add(ChatColor.translateAlternateColorCodes('&',"&e点击关闭菜单"));
        Gb_Meta.setLore(Gb_Lore);
        Gb.setItemMeta(Gb_Meta);

        UI.setItem(40,Gb);

        ArrayList<Player> players = new ArrayList<>(player.getServer().getOnlinePlayers());
        for (int i = 0 ; i < players.size() ; i++) {
            ItemStack PlayerHead = new ItemStack(Material.NAME_TAG);
            ItemMeta PlayerHead_meta = PlayerHead.getItemMeta();
            PlayerHead_meta.setDisplayName(players.get(i).getDisplayName());
            ArrayList<String> PlayerHead_Lore = new ArrayList<>();
            PlayerHead_Lore.add(null);
            PlayerHead_Lore.add(ChatColor.translateAlternateColorCodes('&',"&e点击踢出玩家"));
            PlayerHead_meta.setLore(PlayerHead_Lore);
            PlayerHead.setItemMeta(PlayerHead_meta);

            UI.addItem(PlayerHead);
        }
        player.openInventory(UI);
    }
}
