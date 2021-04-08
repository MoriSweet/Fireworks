package net.casheh.fireworks.commands;

import net.casheh.fireworks.Fireworks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FireworkCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender || sender.hasPermission("firework.reload")) {
            Fireworks.instance.getCfg().assign();
            sender.sendMessage(ChatColor.DARK_AQUA.toString() + ChatColor.ITALIC + "fireworks.yml has been reloaded!");
            sender.sendMessage(ChatColor.BLACK.toString() + ChatColor.BOLD + "AltF4 Pussy");
            Player p = (Player) sender;
            p.sendTitle(ChatColor.RED + "YOU HAVE RELOADED THE CONFIG", ChatColor.RED + "YOU HAVE RELOADED THE CONFIG, bitch.", 10, 10, 10);
            Bukkit.broadcastMessage(ChatColor.BLUE.toString() + "DO YOU LIKE PIE???");
        } else {
            sender.sendMessage(ChatColor.RED.toString() + ChatColor.ITALIC + ChatColor.BOLD + "You do not have permission to use this command dumbass!");
        }

        return true;
    }
}
