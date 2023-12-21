package com.github.Ringoame196

import net.md_5.bungee.api.ChatMessageType
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import java.awt.TextComponent

class Player(private val player: Player) {
    fun sendActionBar(title: String) {
        val actionBarMessage = ChatColor.translateAlternateColorCodes('&', title)
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent(actionBarMessage))
    }
}
