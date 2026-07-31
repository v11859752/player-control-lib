package com.playerlib.api;

import com.playerlib.emulator.MouseEmulator;
import org.lwjgl.glfw.GLFW;

public class MouseController {
    
    public static void moveTo(int x, int y) {
        MouseEmulator.moveTo(x, y);
    }
    
    public static void moveRelative(int deltaX, int deltaY) {
        MouseEmulator.moveRelative(deltaX, deltaY);
    }
    
    public static void clickLeft() {
        MouseEmulator.click(GLFW.GLFW_MOUSE_BUTTON_LEFT);
    }
    
    public static void clickRight() {
        MouseEmulator.click(GLFW.GLFW_MOUSE_BUTTON_RIGHT);
    }
    
    public static void clickMiddle() {
        MouseEmulator.click(GLFW.GLFW_MOUSE_BUTTON_MIDDLE);
    }
    
    public static void holdLeft() {
        MouseEmulator.hold(GLFW.GLFW_MOUSE_BUTTON_LEFT);
    }
    
    public static void releaseLeft() {
        MouseEmulator.release(GLFW.GLFW_MOUSE_BUTTON_LEFT);
    }
    
    public static void holdRight() {
        MouseEmulator.hold(GLFW.GLFW_MOUSE_BUTTON_RIGHT);
    }
    
    public static void releaseRight() {
        MouseEmulator.release(GLFW.GLFW_MOUSE_BUTTON_RIGHT);
    }
    
    public static void holdMiddle() {
        MouseEmulator.hold(GLFW.GLFW_MOUSE_BUTTON_MIDDLE);
    }
    
    public static void releaseMiddle() {
        MouseEmulator.release(GLFW.GLFW_MOUSE_BUTTON_MIDDLE);
    }
    
    public static int getX() {
        return (int) MouseEmulator.getX();
    }
    
    public static int getY() {
        return (int) MouseEmulator.getY();
    }
    
    public static int[] getPosition() {
        return new int[]{getX(), getY()};
    }
    
    public static void scroll(double amount) {
        MouseEmulator.scroll(amount);
    }
}