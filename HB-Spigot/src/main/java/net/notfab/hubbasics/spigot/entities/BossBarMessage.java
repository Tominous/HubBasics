package net.notfab.hubbasics.spigot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;

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
@AllArgsConstructor
public class BossBarMessage {

    @Getter private String message;
    @Getter private BarStyle style;
    @Getter private BarColor color;

}
