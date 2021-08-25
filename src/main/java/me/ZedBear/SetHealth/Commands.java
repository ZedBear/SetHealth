package me.ZedBear.SetHealth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("sethealth.sethealth")) {
            if(cmd.getName().equalsIgnoreCase("sethealth")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "Incorrect usage! Use /sethealth <player> <health>!");
                    return true;
                } else if (args.length == 1) {
                    sender.sendMessage(ChatColor.RED + "Incorrect usage! Use /sethealth <player> <health>!");
                    return true;
                } else if (args.length == 2) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        int health = Integer.parseInt(args[1]);
                        int maxt = Integer.parseInt(Objects.requireNonNull(target.getAttribute(Attribute.GENERIC_MAX_HEALTH)).toString());
                        if (health > maxt) {
                            target.setHealth(health);
                            String tdisplay = target.getDisplayName();
                            sender.sendMessage(ChatColor.GREEN + "" + tdisplay + "'s health has been set to " + health + "!");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.RED + "The number you entered is above the players max health!");
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Incorrect usage! Use /sethealth <player> <health>!");
                    return true;
                }
            }
        }
        return true;
    }
}
