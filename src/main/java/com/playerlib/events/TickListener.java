package com.playerlib.events;

import com.playerlib.api.PlayerDataProvider;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class TickListener implements ClientTickEvents.EndTick {
    private int tickCounter = 0;
    
    @Override
    public void onEndTick(MinecraftClient client) {
        tickCounter++;
        if (tickCounter % 5 == 0) {
            PlayerDataProvider.updateData();
        }
    }
}