package net.notfab.hubbasics.bungee.utils;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.notfab.hubbasics.bungee.HubBasics;
import net.notfab.spigot.simpleconfig.SimpleConfig;

/**
 * Copyright (c) HubBasics 2018.
 * <p>
 * The contents of this project are licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International.
 * Please read the information linked below before you attempt to use this project or it's contents to make sure you are abiding
 * by it's terms.
 * <p>
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 * <p>
 * File Created by Fabricio20 on 06/12/2017.
 */
public class Messages {

    public static String get(String name) {
        SimpleConfig config = HubBasics.getInstance().getConfigManager().getNewConfig("messages.yml");
        return config.getString(name, "<Internal Error - Unknown Message>");
    }

    public static String get(ProxiedPlayer player, String name) {
        return PlaceHolderUtil.replace(player, get(name));
    }

    public static String get(CommandSender sender, String name) {
        String message = get(name);
        message = message.replace("${Name}", sender.getName());
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String get(ProxiedPlayer player, String name, String... args) {
        return PlaceHolderUtil.replace(player, replaceArgs(get(name), args));
    }

    private static String replaceArgs(String message, String... args) {
        for(int i = 0; i < args.length; i++) {
            message = message.replace("{" + i + "}", args[i]);
        }
        return message;
    }

}
