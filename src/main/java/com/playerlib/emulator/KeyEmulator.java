package com.playerlib.emulator;

import com.playerlib.PlayerControlMod;
import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyEmulator {
    private static Robot robot = null;
    private static boolean available = false;
    
    static {
        try {
            if (!GraphicsEnvironment.isHeadless()) {
                robot = new Robot();
                robot.setAutoDelay(20);
                available = true;
                PlayerControlMod.LOGGER.info("Key emulator initialized successfully");
            } else {
                PlayerControlMod.LOGGER.warn("Headless environment - key emulation disabled");
            }
        } catch (AWTException e) {
            PlayerControlMod.LOGGER.error("Failed to initialize Robot: " + e.getMessage());
        }
    }
    
    public static boolean isAvailable() {
        return available && robot != null;
    }
    
    public static void press(int keyCode) {
        if (!isAvailable()) return;
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }
    
    public static void holdDown(int keyCode) {
        if (!isAvailable()) return;
        robot.keyPress(keyCode);
    }
    
    public static void release(int keyCode) {
        if (!isAvailable()) return;
        robot.keyRelease(keyCode);
    }
    
    public static void pressWithDelay(int keyCode, int delayMs) {
        if (!isAvailable()) return;
        robot.keyPress(keyCode);
        try {
            Thread.sleep(delayMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        robot.keyRelease(keyCode);
    }
}