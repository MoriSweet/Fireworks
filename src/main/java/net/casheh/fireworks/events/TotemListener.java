package net.casheh.fireworks.events;

import net.casheh.fireworks.Fireworks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class TotemListener implements Listener {

    private int taskID;

    @EventHandler
        public void onPickupTotem(PlayerPickupItemEvent e) {
        ItemStack item = e.getItem().getItemStack();
        if (item.getType().equals(Material.TOTEM)) {
            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Fireworks.instance, new Runnable() {
                int counter = 10;
                Player p = e.getPlayer();
                @Override
                public void run() {
                    if (counter < 0) {
                        Bukkit.getScheduler().cancelTask(taskID);
                    } else if (counter == 5) {
                        p.sendTitle(ChatColor.GREEN + "YOU ARE GOING TO FUCKING DIE.", ChatColor.RED + "YOU WILL DIE NOW.", 30, 30, 30);
                    } else if (counter == 1) {
                        p.setHealth(0.0D);
                    }
                    counter--;
                }
            }, 0L, 20L);

        }
    }
}
