package com.playerlib.api;

import com.playerlib.data.PlayerData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PlayerDataProvider {
    private static final Map<String, Consumer<PlayerData>> listeners = new HashMap<>();
    private static PlayerData lastData = null;
    
    public static void subscribe(String modId, Consumer<PlayerData> callback) {
        listeners.put(modId, callback);
        if (lastData != null) {
            callback.accept(lastData);
        }
    }
    
    public static void unsubscribe(String modId) {
        listeners.remove(modId);
    }
    
    public static void updateData() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;
        
        PlayerEntity p = client.player;
        
        List<String> inventory = p.getInventory().main.stream()
                .filter(stack -> !stack.isEmpty())
                .map(stack -> stack.getItem().getTranslationKey())
                .collect(Collectors.toList());
        
        lastData = new PlayerData(
            p.getX(),
            p.getY(),
            p.getZ(),
            p.getYaw(),
            p.getPitch(),
            p.getHealth(),
            p.getHungerManager().getFoodLevel(),
            p.getHungerManager().getSaturationLevel(),
            p.experienceLevel,
            p.getInventory().selectedSlot,
            inventory
        );
        
        listeners.values().forEach(callback -> callback.accept(lastData));
    }
    
    public static PlayerData getLastData() {
        return lastData;
    }
}