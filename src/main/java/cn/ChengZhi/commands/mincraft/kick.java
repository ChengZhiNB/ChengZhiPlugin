package cn.ChengZhi.commands.mincraft;

import cn.ChengZhi.GuiHUB;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);
            if(Bukkit.getPlayer(pname) == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c这个玩家不存在或不在线"));
            }else {
                if (player.isOnline()) {
                    if (sender instanceof Player) {
                        if (!player.isOp()) {
                            if (!player.getName().equals(player.getName())) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&',"&c你被踢出服务器" ));
                            }else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c你不能踢出自己"));
                            }
                        }else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c你不能踢出管理员"));
                        }
                    }else {
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&',"&c你被踢出服务器" ));
                    }
                }
            }
        }else {
            if (args.length == 2) {
                String pname = args[0];
                String message = args[1];
                Player player = Bukkit.getPlayer(pname);
                if(Bukkit.getPlayer(pname) == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c这个玩家不存在或不在线"));
                }else {
                    if (player.isOnline()) {
                        if (sender instanceof Player) {
                            if (!player.isOp()) {
                                if (!player.getName().equals(player.getName())) {
                                    player.kickPlayer(ChatColor.translateAlternateColorCodes('&', message));
                                }else {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c你不能踢出自己"));
                                }
                            }else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c你不能踢出管理员"));
                            }
                        }else {
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', message));
                        }
                    }
                }
            }else {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    GuiHUB.KickGui(player);
                }else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a正确用法&f: /kick &f<&e玩家ID&f> &f[&e理由&f]"));
                }
            }
        }
        return false;
    }
}
