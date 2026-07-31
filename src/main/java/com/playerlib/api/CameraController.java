package com.playerlib.api;

import net.minecraft.client.MinecraftClient;

public class CameraController {
    private static final MinecraftClient client = MinecraftClient.getInstance();
    
    public static void up(float degrees) {
        if (client.player == null) return;
        float currentPitch = client.player.getPitch();
        float newPitch = Math.max(-90, Math.min(90, currentPitch - degrees));
        setPitch(newPitch);
    }
    
    public static void down(float degrees) {
        if (client.player == null) return;
        float currentPitch = client.player.getPitch();
        float newPitch = Math.max(-90, Math.min(90, currentPitch + degrees));
        setPitch(newPitch);
    }
    
    public static void right(float degrees) {
        if (client.player == null) return;
        float currentYaw = client.player.getYaw();
        float newYaw = (currentYaw + degrees) % 360;
        setYaw(newYaw);
    }
    
    public static void left(float degrees) {
        if (client.player == null) return;
        float currentYaw = client.player.getYaw();
        float newYaw = (currentYaw - degrees) % 360;
        setYaw(newYaw);
    }
    
    public static void setPitch(float pitch) {
        if (client.player == null) return;
        pitch = Math.max(-90, Math.min(90, pitch));
        client.player.setPitch(pitch);
    }
    
    public static void setYaw(float yaw) {
        if (client.player == null) return;
        client.player.setYaw(yaw);
    }
    
    public static float getPitch() {
        return client.player != null ? client.player.getPitch() : 0;
    }
    
    public static float getYaw() {
        return client.player != null ? client.player.getYaw() : 0;
    }
    
    public static float[] getLookVector() {
        if (client.player == null) return new float[]{0, 0, 0};
        return new float[]{
            client.player.getYaw(),
            client.player.getPitch(),
            0
        };
    }
}