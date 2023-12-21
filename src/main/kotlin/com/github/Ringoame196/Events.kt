package com.github.Ringoame196

import com.github.Ringoame196.Entity.ArmorStand
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.CommandBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.Plugin

class Events(private val plugin: Plugin) : Listener {
    @EventHandler
    fun onPlayerInteract(e: PlayerInteractEvent) {
        var commandBlock = e.clickedBlock ?: return
        val item = e.item ?: return
        val player = e.player
        val location = commandBlock.location.clone().add(0.5, 1.0, 0.5)
        val action = e.action
        if (action != Action.RIGHT_CLICK_BLOCK) { return }
        if (item.type != Material.GOLDEN_AXE) { return }
        val commandBlock2 = commandBlock.state as CommandBlock
        e.isCancelled = true
        val armorStandClass = ArmorStand()
        val commandBlockClass = CommandBlock()
        val playerClass = Player(player)
        val command = commandBlockClass.acquisitionCommand(commandBlock2)
        val armorStand = armorStandClass.summonArmorStand(location, command)
        playerClass.sendActionBar("${ChatColor.YELLOW}---コマンド表示---")
        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL, 1f, 1f)
        armorStandClass.deletingAfterNseconds(plugin, armorStand, 5)
    }
}
