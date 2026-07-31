package com.playerlib;

import com.playerlib.events.TickListener;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class PlayerControlMod implements ClientModInitializer {
    public static final String MOD_ID = "playerlib";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Player Control Library v1.0.0 initialized!");
        LOGGER.info("Camera & Mouse control enabled!");
        
        ClientTickEvents.END_CLIENT_TICK.register(new TickListener());
    }
}