package net.casheh.fireworks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class EggThrow implements Listener {

    @EventHandler
    public void onEggThrow(PlayerEggThrowEvent e) {
        Location loc = e.getEgg().getLocation();
        loc.getWorld().spawnEntity(loc, EntityType.SLIME);
        loc.add(0, 5, 0).getBlock().setType(Material.ANVIL);

    }
}
