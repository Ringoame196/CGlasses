package com.github.Ringoame196

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        val eventListener = Events(this)

        server.pluginManager.registerEvents(eventListener, this)
    }

    override fun onDisable() {
        super.onDisable()
    }
}
