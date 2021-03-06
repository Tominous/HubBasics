package net.notfab.hubbasics.spigot.managers;

import net.notfab.hubbasics.spigot.entities.EnumModules;
import net.notfab.hubbasics.spigot.entities.Manager;
import net.notfab.hubbasics.spigot.entities.Module;
import net.notfab.hubbasics.spigot.modules.*;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright (C) Fabricio20 2017 - All Rights Reserved.
 * Created by Fabricio20 on 2017-12-14.
 */
public class ModuleManager extends Manager {

    private Map<EnumModules, Module> modules = new HashMap<>();

    public ModuleManager() {
        this.modules.put(EnumModules.JoinItems, new JoinItems());
        this.modules.put(EnumModules.KeepHealth, new KeepHealth());
        this.modules.put(EnumModules.KeepFood, new KeepFood());
        this.modules.put(EnumModules.AntiVoid, new AntiVoid());
        this.modules.put(EnumModules.DoubleJump, new DoubleJump());
        this.modules.put(EnumModules.BossAnnouncer, new BossAnnouncer());
        this.modules.put(EnumModules.NoWeather, new NoWeather());
        this.modules.put(EnumModules.Holograms, new Holograms());
        this.modules.put(EnumModules.JumpPads, new JumpPads());
        this.modules.put(EnumModules.JoinMessages, new JoinMessages());
        this.modules.put(EnumModules.Lobby, new LobbyModule());
        this.onEnable();
    }

    public void onEnable() {
        AtomicInteger loaded = new AtomicInteger();
        this.modules.forEach((enumModule, module) -> {
            if(!module.getConfig().getBoolean("Enabled", true)) return;
            if(!HubBasics.getNMS().runningNewerThan(module.getMinimumVersion())) {
                Logger.warn("[ModuleManager] The " + enumModule.name() + " module requires at least version " +
                        module.getMinimumVersion() + ", which means it will not be enabled.");
            } else {
                module.onEnable();
                Bukkit.getPluginManager().registerEvents(module, HubBasics);
                loaded.getAndIncrement();
                Logger.debug("[ModuleManager] " + enumModule.name() + " is now enabled.");
            }
        });
        Logger.info("[ModuleManager] Loaded " + loaded.get() + " module(s).");
    }

    @Override
    public void onDisable() {
        this.modules.forEach(((enumModules, module) -> {
            module.onDisable();
            HandlerList.unregisterAll(module);
        }));
    }

    public Module getModule(EnumModules module) {
        return this.modules.get(module);
    }

    public Boolean isEnabled(EnumModules module) {
        return getModule(module) != null ? getModule(module).isEnabled() : false;
    }

}
