package me.earth.phobos.features.modules.client;

import me.earth.phobos.features.modules.Module;
import me.earth.phobos.features.setting.Setting;

public class Screens extends Module {
   public Setting<Boolean> mainScreen = this.register(new Setting("MainScreen", true));
   public static Screens INSTANCE;

   public Screens() {
      super("Screens", "Controls custom screens used by the client", Module.Category.CLIENT, true, false, false);
      INSTANCE = this;
   }

   public void onTick() {
   }
}
