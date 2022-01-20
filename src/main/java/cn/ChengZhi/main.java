package cn.ChengZhi;

import cn.ChengZhi.commands.CZAllChat;
import cn.ChengZhi.commands.CZhelp;
import cn.ChengZhi.commands.CZreload;
import cn.ChengZhi.commands.mincraft.list;
import cn.ChengZhi.commands.mincraft.stop;
import cn.ChengZhi.listeners.PlayerChat;
import cn.ChengZhi.listeners.PlayerJoin;
import cn.ChengZhi.listeners.PlayerQuit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class main extends JavaPlugin {
    public static main instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();
        reloadConfig();
        getLogger().info("---------橙汁插件---------");
        //分割线
        getServer().getPluginManager().registerEvents(new PlayerChat(), this);
        getLogger().info("已启动屏蔽词功能");
        //分割线
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getLogger().info("已启动更好的进入提示");
        //分割线
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        getLogger().info("已启动更好的退出提示");
        //分割线
        Objects.requireNonNull(getCommand("CZhelp")).setExecutor(new CZhelp());
        getLogger().info("已启动帮助命令(/CZhelp)");
        //分割线
        Objects.requireNonNull(getCommand("CZAllChat")).setExecutor(new CZAllChat());
        getLogger().info("已启动全体消息(/CZAllChat 或 /say)");
        //分割线
        Objects.requireNonNull(getCommand("CZreload")).setExecutor(new CZreload());
        getLogger().info("已启动重载命令(/CZreload)");
        //分割线
        Objects.requireNonNull(getCommand("stop")).setExecutor(new stop());
        getLogger().info("已启动更好的stop命令");
        //分割线
        Objects.requireNonNull(getCommand("list")).setExecutor(new list());
        getLogger().info("已启动更好的list命令");
        //分割线
        getLogger().info("---------橙汁插件---------");
        System.out.println("");
        getLogger().info("橙汁插件已启动成功!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        getLogger().info("橙汁插件卸载!");
    }
}