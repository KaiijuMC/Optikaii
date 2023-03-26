package dev.kugge.optikaii.command;

import dev.kugge.optikaii.Optikaii;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WorldDumpCommand implements CommandExecutor {

    private static final String format = ChatColor.GRAY + "["
                                       + ChatColor.LIGHT_PURPLE + "%02d"
                                       + ChatColor.GRAY + "/"
                                       + ChatColor.LIGHT_PURPLE + "%02d"
                                       + ChatColor.GRAY + " | "
                                       + ChatColor.LIGHT_PURPLE + "%02d"
                                       + ChatColor.GRAY + "/"
                                       + ChatColor.LIGHT_PURPLE + "%02d"
                                       + ChatColor.GRAY + "]"
                                       + ChatColor.AQUA + " %s";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Optikaii" + ChatColor.GRAY + "] WORLDS");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "View: Current/Max" + ChatColor.GRAY + " | "
                         + ChatColor.LIGHT_PURPLE + "Simulation: Current/Max" + ChatColor.GRAY + "]" + ChatColor.AQUA + " name");
        Bukkit.getWorlds().forEach(world ->
                                   sender.sendMessage(String.format(format,
                                                                    world.getViewDistance(),
                                                                    Optikaii.worldConfig.get(world).mspt().viewDistance().max(),
                                                                    world.getSimulationDistance(),
                                                                    Optikaii.worldConfig.get(world).mspt().simulationDistance().max(),
                                                                    world.getName())));
        return true;
    }
}