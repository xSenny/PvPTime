package me.xsenny.pvptime.command;

import me.xsenny.pvptime.PvPTime;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (sender instanceof Player){
                Player p = (Player) sender;
                if (p.hasPermission("pvptime.reload")){
                    PvPTime.plugin.reloadConfig();
                    p.sendMessage("Config reloaded");
                }
            }else{
                PvPTime.plugin.reloadConfig();
                System.out.println("Config reloaded");
            }

        return true;
    }
}
