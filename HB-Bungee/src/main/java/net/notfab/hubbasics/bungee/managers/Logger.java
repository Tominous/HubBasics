package net.notfab.hubbasics.bungee.managers;

import ch.qos.logback.classic.Level;
import lombok.Getter;
import lombok.Setter;
import net.notfab.hubbasics.bungee.HubBasics;
import org.slf4j.LoggerFactory;

/**
 * Copyright (c) HubBasics 2018.
 * <p>
 * The contents of this project are licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International.
 * Please read the information linked below before you attempt to use this project or it's contents to make sure you are abiding
 * by it's terms.
 * <p>
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 * <p>
 * File Created by Fabricio20 on 13/12/2017.
 */
public class Logger {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HubBasics.getInstance().getClass());
    @Getter @Setter private Level level = Level.DEBUG;
    @Getter @Setter private boolean enabled = true;
    @Getter private final String prefix;

    public Logger(String prefix) {
        this.prefix = prefix == null ? "" : prefix;
        this.info("[Logger] Started.");
    }

    public void onDisable() {
        this.LOGGER.info("[Logger] Shutting down.");
    }

    public void trace(String msg) {
        if(this.level.isGreaterOrEqual(Level.TRACE)) {
            LOGGER.trace(this.prefix + msg);
        }
    }

    public void trace(String msg, Throwable t) {
        if(this.level.isGreaterOrEqual(Level.TRACE)) {
            LOGGER.trace(this.prefix + msg, t);
        }
    }

    public void debug(String msg) {
        if(this.level.isGreaterOrEqual(Level.DEBUG)) {
            LOGGER.debug(this.prefix + msg);
        }
    }

    public void debug(String msg, Throwable t) {
        if(this.level.isGreaterOrEqual(Level.DEBUG)) {
            LOGGER.debug(this.prefix + msg, t);
        }
    }

    public void info(String msg) {
        if(this.level.isGreaterOrEqual(Level.INFO)) {
            LOGGER.info(this.prefix + msg);
        }
    }

    public void info(String msg, Throwable t) {
        if(this.level.isGreaterOrEqual(Level.INFO)) {
            LOGGER.info(this.prefix + msg, t);
        }
    }

    public void warn(String msg) {
        if(this.level.isGreaterOrEqual(Level.WARN)) {
            LOGGER.warn(this.prefix + msg);
        }
    }

    public void warn(String msg, Throwable t) {
        if(this.level.isGreaterOrEqual(Level.WARN)) {
            LOGGER.warn(this.prefix + msg, t);
        }
    }

    public void error(String msg) {
        if(this.level.isGreaterOrEqual(Level.ERROR)) {
            LOGGER.error(this.prefix + msg);
        }
    }

    public void error(String msg, Throwable t) {
        if(this.level.isGreaterOrEqual(Level.ERROR)) {
            LOGGER.error(this.prefix + msg, t);
        }
    }

}