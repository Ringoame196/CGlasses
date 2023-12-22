package com.github.Ringoame196

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.block.CommandBlock

class CommandBlock() {
    val commandBlocks = mapOf(
        Material.COMMAND_BLOCK to "${ChatColor.GOLD}衝撃",
        Material.CHAIN_COMMAND_BLOCK to "${ChatColor.AQUA}チェーン",
        Material.REPEATING_COMMAND_BLOCK to "${ChatColor.LIGHT_PURPLE}反復"
    )
    fun acquisitionCommand(commandBlock: CommandBlock): String {
        val command = commandBlock.command
        return if (command != "") { "${ChatColor.GOLD}$command" } else { "${ChatColor.RED}コマンドが登録されていません" }
    }
    fun isConditional(commandBlock: CommandBlock): Boolean {
        return commandBlock.blockData.toString().contains("conditional=true")
    }
}
