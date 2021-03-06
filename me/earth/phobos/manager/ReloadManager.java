package me.earth.phobos.manager;

import me.earth.phobos.Phobos;
import me.earth.phobos.event.events.PacketEvent;
import me.earth.phobos.features.Feature;
import me.earth.phobos.features.command.Command;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ReloadManager extends Feature {
   public String prefix;

   public void init(String prefix) {
      this.prefix = prefix;
      MinecraftForge.EVENT_BUS.register(this);
      if (!fullNullCheck()) {
         Command.sendMessage("§cPhobos has been unloaded. Type " + prefix + "reload to reload.");
      }

   }

   public void unload() {
      MinecraftForge.EVENT_BUS.unregister(this);
   }

   @SubscribeEvent
   public void onPacketSend(PacketEvent.Send event) {
      if (event.getPacket() instanceof CPacketChatMessage) {
         CPacketChatMessage packet = (CPacketChatMessage)event.getPacket();
         if (packet.func_149439_c().startsWith(this.prefix) && packet.func_149439_c().contains("reload")) {
            Phobos.load();
            event.setCanceled(true);
         }
      }

   }
}
