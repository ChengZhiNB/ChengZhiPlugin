package cn.ChengZhi.commands;

import cn.ChengZhi.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class unmute implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);
            if(Bukkit.getPlayer(pname) == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c这个玩家不存在或不在线"));
            }else{
                if (!player.isOp()) {
                    List<String> mutes = new ArrayList<>();
                    main.instance.getConfig().getStringList("mutelist").forEach(s -> mutes.add(s));

                    for (String mute : mutes) {
                        if (player.getName().equals(mute)) {
                            List<String> list = main.instance.getConfig().getStringList("mutelist");
                            list.remove(pname);
                            main.instance.getConfig().set("mutelist",list);

                            main.instance.saveConfig();
                            main.instance.reloadConfig();
                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f[&c全体通知&f] &e玩家&f:&a" + pname + "&e被解除了禁言"));
                            return false;
                        }
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c这个玩家没有被禁言"));
                }else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c你不能怎么做!"));
                }
            }
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a正确用法&f: /unmute &f<&e玩家ID&f>"));
        }
        return false;
    }
}
