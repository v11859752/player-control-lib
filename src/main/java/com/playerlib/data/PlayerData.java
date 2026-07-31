package com.playerlib.data;

import java.util.List;

public record PlayerData(
    double x,
    double y,
    double z,
    float yaw,
    float pitch,
    float health,
    int hunger,
    float saturation,
    int experienceLevel,
    int selectedSlot,
    List<String> inventory
) {
    @Override
    public String toString() {
        return String.format("PlayerData{x=%.2f, y=%.2f, z=%.2f, health=%.1f, hunger=%d, yaw=%.1f, pitch=%.1f}",
            x, y, z, health, hunger, yaw, pitch);
    }
}