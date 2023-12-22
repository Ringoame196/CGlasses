package com.github.Ringoame196

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.plugin.Plugin

class Events(private val plugin: Plugin) : Listener {
    @EventHandler
    fun onPlayerMove(e: PlayerToggleSneakEvent) {
        val sneak = e.isSneaking
        val player = e.player
        val playerClass = Player(player)
        if (!sneak) { return }
        if (!player.isOp) { return }
        if (player.gameMode != GameMode.CREATIVE) { return }
        val commandBlockClass = CommandBlock()
        val commandBlocks = commandBlockClass.commandBlocks
        val block = player.getTargetBlockExact(5) ?: return
        if (!commandBlocks.contains(block.type)) { return }
        val commandBlock = block.state as org.bukkit.block.CommandBlock
        player.sendTitle("", commandBlockClass.acquisitionCommand(commandBlock), 0, 60, 0)
        playerClass.sendActionBar(
            "${ChatColor.YELLOW}種類:${commandBlocks[block.type]} " +
                "${ChatColor.YELLOW}条件:${ChatColor.GOLD}${commandBlock.blockData.toString().contains("conditional=true")}"
        )
        player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 0.5f, 0.5f)
    }
}
