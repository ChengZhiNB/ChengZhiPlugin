package cn.ChengZhi.tasks;

import cn.ChengZhi.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class timeboardcast extends BukkitRunnable {
    main pluginmain;

    public timeboardcast(main main) {
        this.pluginmain = main;
    }

    private static int order(int i) {
        i = i +1;
        return i;
    }
    private  int i = 0;

    @Override
    public void run() {
        if (main.instance.getConfig().getBoolean("TimeMessage")) {
            if (i < main.instance.getConfig().getStringList("TimeMessageList").size()) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',main.instance.getConfig().getStringList("TimeMessageList").get(i)));
                i = order(i);
            }else {
                i = 0;
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',main.instance.getConfig().getStringList("TimeMessageList").get(i)));
                i = order(i);
            }
        }
    }
}
