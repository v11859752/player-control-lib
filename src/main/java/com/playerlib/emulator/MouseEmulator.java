package com.playerlib.emulator;

import com.playerlib.PlayerControlMod;
import java.awt.*;
import java.awt.event.InputEvent;

public class MouseEmulator {
    private static Robot robot = null;
    private static boolean available = false;
    private static Point lastPosition = new Point(0, 0);
    
    static {
        try {
            if (!GraphicsEnvironment.isHeadless()) {
                robot = new Robot();
                robot.setAutoDelay(10);
                available = true;
                lastPosition = MouseInfo.getPointerInfo().getLocation();
                PlayerControlMod.LOGGER.info("Mouse emulator initialized successfully");
            } else {
                PlayerControlMod.LOGGER.warn("Headless environment - mouse emulation disabled");
            }
        } catch (AWTException e) {
            PlayerControlMod.LOGGER.error("Failed to initialize Robot: " + e.getMessage());
        }
    }
    
    public static boolean isAvailable() {
        return available && robot != null;
    }
    
    public static void moveTo(int x, int y) {
        if (!isAvailable()) return;
        robot.mouseMove(x, y);
        lastPosition = new Point(x, y);
    }
    
    public static void moveRelative(int deltaX, int deltaY) {
        if (!isAvailable()) return;
        Point current = MouseInfo.getPointerInfo().getLocation();
        int newX = current.x + deltaX;
        int newY = current.y + deltaY;
        robot.mouseMove(newX, newY);
        lastPosition = new Point(newX, newY);
    }
    
    public static void click(int button) {
        if (!isAvailable()) return;
        int buttonMask = getButtonMask(button);
        robot.mousePress(buttonMask);
        robot.mouseRelease(buttonMask);
    }
    
    public static void hold(int button) {
        if (!isAvailable()) return;
        robot.mousePress(getButtonMask(button));
    }
    
    public static void release(int button) {
        if (!isAvailable()) return;
        robot.mouseRelease(getButtonMask(button));
    }
    
    public static void scroll(double amount) {
        if (!isAvailable()) return;
        robot.mouseWheel((int) amount);
    }
    
    public static double getX() {
        return MouseInfo.getPointerInfo().getLocation().getX();
    }
    
    public static double getY() {
        return MouseInfo.getPointerInfo().getLocation().getY();
    }
    
    private static int getButtonMask(int button) {
        return switch (button) {
            case 0 -> InputEvent.BUTTON1_DOWN_MASK;
            case 1 -> InputEvent.BUTTON2_DOWN_MASK;
            case 2 -> InputEvent.BUTTON3_DOWN_MASK;
            default -> InputEvent.BUTTON1_DOWN_MASK;
        };
    }
}