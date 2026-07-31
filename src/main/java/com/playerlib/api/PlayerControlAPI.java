package com.playerlib.api;

import com.playerlib.emulator.KeyEmulator;
import com.playerlib.utils.KeyMappingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerControlAPI {
    public static final Logger LOGGER = LoggerFactory.getLogger("PlayerLib");
    
    public static void press(String key) {
        int code = KeyMappingHelper.getKeyCode(key);
        if (code != -1) {
            KeyEmulator.press(code);
        } else {
            LOGGER.warn("Unknown key: " + key);
        }
    }
    
    public static void holdDown(String key) {
        int code = KeyMappingHelper.getKeyCode(key);
        if (code != -1) {
            KeyEmulator.holdDown(code);
        }
    }
    
    public static void release(String key) {
        int code = KeyMappingHelper.getKeyCode(key);
        if (code != -1) {
            KeyEmulator.release(code);
        }
    }
    
    public static void pressWithDelay(String key, int delayMs) {
        int code = KeyMappingHelper.getKeyCode(key);
        if (code != -1) {
            KeyEmulator.pressWithDelay(code, delayMs);
        }
    }
    
    public static void combo(int delayBetween, String... keys) {
        for (String key : keys) {
            press(key);
            try {
                Thread.sleep(delayBetween);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static CameraController camera() {
        return new CameraController();
    }
    
    public static MouseController mouse() {
        return new MouseController();
    }
}