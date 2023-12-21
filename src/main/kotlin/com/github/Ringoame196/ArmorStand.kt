package com.github.Ringoame196.Entity

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.ArmorStand
import org.bukkit.plugin.Plugin

class ArmorStand {
    fun summonArmorStand(location: Location, name: String = " "): ArmorStand {
        val world = location.world
        val armorStand: ArmorStand = world!!.spawn(location, org.bukkit.entity.ArmorStand::class.java)

        // アーマースタンドの設定
        armorStand.isVisible = false // 可視化するかどうか
        armorStand.isSmall = true // サイズを小さくするかどうか
        armorStand.isInvulnerable = true
        armorStand.customName = name
        armorStand.isCustomNameVisible = true
        armorStand.setGravity(false)
        armorStand.isMarker = true
        return armorStand
    }
    fun deletingAfterNseconds(plugin: Plugin, armorStand: ArmorStand, time: Int = 5) {
        Bukkit.getScheduler().runTaskLater(
            plugin,
            Runnable {
                armorStand.remove()
            },
            20L * time
        ) // 20Lは1秒を表す（1秒 = 20ticks）
    }
}
