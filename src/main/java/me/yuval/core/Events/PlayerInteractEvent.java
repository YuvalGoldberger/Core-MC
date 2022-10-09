package me.yuval.core.Events;

import me.yuval.core.Core;
import me.yuval.core.Utils.Permissions;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void OnBlockRightClick(org.bukkit.event.player.PlayerInteractEvent event) {
        if(!event.getAction().isRightClick()) { return; }
        if(event.getClickedBlock() == null) { return; }
        if(event.getClickedBlock().getType() == Material.OAK_SIGN) {
            Permissions perms = Core.getPlugin().getPerms();
            Player player = event.getPlayer();
            if (perms.PermissionCheck(player, "primecore.signedit", "RightClick - Edit Sign")) {
                Sign sign = (Sign) event.getClickedBlock().getState();
                sign.setEditable(true);
                player.openSign(sign);


            }
        }

    }
}
