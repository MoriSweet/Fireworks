package net.casheh.fireworks.events;

import net.casheh.fireworks.Fireworks;
import org.bukkit.*;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

public class FireworkFire implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Location loc = p.getLocation();

        p.setVelocity(new Vector(0, 5, 0));
        Bukkit.getScheduler().scheduleSyncDelayedTask(Fireworks.instance, new Runnable() {
            @Override
            public void run() {
                p.teleport(loc);
            }
        }, 20L);

        Firework firework = p.getWorld().spawn(e.getBlock().getLocation(), Firework.class);
        FireworkMeta fireworkMeta = firework.getFireworkMeta();

        if (Fireworks.instance.getCfg().getUseOptionOne()) {
            fireworkMeta.addEffects(FireworkEffect.builder().withColor(Color.TEAL).withColor(Color.ORANGE).with(FireworkEffect.Type.CREEPER).withFlicker().build());
        } else {
            fireworkMeta.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.YELLOW).with(FireworkEffect.Type.BURST).withFlicker().build());
        }

        fireworkMeta.setPower(0);
        firework.setFireworkMeta(fireworkMeta);
    }


}


