package me.xsenny.pvptime.listeners;

import me.xsenny.pvptime.PvPTime;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvpListener implements Listener{

    public static PvPTime plugin = PvPTime.plugin;

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            Player entity = (Player) e.getEntity();
            Player damager = (Player) e.getDamager();
            if (plugin.getConfig().getBoolean("toggle")){
                if (plugin.getConfig().getBoolean("all-worlds")){
                    if (entity.getWorld().getTime() > 0 && entity.getWorld().getTime() < 13000){
                        e.setCancelled(true);
                    }
                }else{
                    for (int i = 0; i < plugin.getConfig().getList("worlds").size(); i++){
                        if (entity.getWorld().getTime() > 0 && entity.getWorld().getTime() < 13000){
                            if (plugin.getConfig().getList("worlds").get(i).equals(entity.getWorld().getName())){
                                e.setCancelled(true);
                            }
                        }
                    }
                }
            }else{
                if (plugin.getConfig().getBoolean("all-worlds")){
                    if (entity.getWorld().getTime() > 13000){
                        e.setCancelled(true);
                    }
                }else{
                    for (int i = 0; i < plugin.getConfig().getList("worlds").size(); i++){
                        if (entity.getWorld().getTime() > 13000){
                            if (plugin.getConfig().getList("worlds").get(i).equals(entity.getWorld().getName())){
                                e.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
