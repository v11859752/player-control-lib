package com.playerlib.utils;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyMappingHelper {
    private static final Map<String, Integer> KEY_MAP = new HashMap<>();
    
    static {
        for (char c = 'A'; c <= 'Z'; c++) {
            KEY_MAP.put(String.valueOf(c), KeyEvent.VK_A + (c - 'A'));
        }
        
        for (int i = 0; i <= 9; i++) {
            KEY_MAP.put(String.valueOf(i), KeyEvent.VK_0 + i);
        }
        
        for (int i = 1; i <= 12; i++) {
            KEY_MAP.put("F" + i, KeyEvent.VK_F1 + (i - 1));
        }
        
        KEY_MAP.put("SPACE", KeyEvent.VK_SPACE);
        KEY_MAP.put("ENTER", KeyEvent.VK_ENTER);
        KEY_MAP.put("SHIFT", KeyEvent.VK_SHIFT);
        KEY_MAP.put("CONTROL", KeyEvent.VK_CONTROL);
        KEY_MAP.put("CTRL", KeyEvent.VK_CONTROL);
        KEY_MAP.put("ALT", KeyEvent.VK_ALT);
        KEY_MAP.put("TAB", KeyEvent.VK_TAB);
        KEY_MAP.put("ESCAPE", KeyEvent.VK_ESCAPE);
        KEY_MAP.put("ESC", KeyEvent.VK_ESCAPE);
        KEY_MAP.put("BACKSPACE", KeyEvent.VK_BACK_SPACE);
        KEY_MAP.put("DELETE", KeyEvent.VK_DELETE);
        KEY_MAP.put("DEL", KeyEvent.VK_DELETE);
        KEY_MAP.put("HOME", KeyEvent.VK_HOME);
        KEY_MAP.put("END", KeyEvent.VK_END);
        KEY_MAP.put("PAGE_UP", KeyEvent.VK_PAGE_UP);
        KEY_MAP.put("PGUP", KeyEvent.VK_PAGE_UP);
        KEY_MAP.put("PAGE_DOWN", KeyEvent.VK_PAGE_DOWN);
        KEY_MAP.put("PGDN", KeyEvent.VK_PAGE_DOWN);
        KEY_MAP.put("INSERT", KeyEvent.VK_INSERT);
        KEY_MAP.put("INS", KeyEvent.VK_INSERT);
        KEY_MAP.put("PRINTSCREEN", KeyEvent.VK_PRINTSCREEN);
        KEY_MAP.put("PRTSC", KeyEvent.VK_PRINTSCREEN);
        KEY_MAP.put("SCROLL_LOCK", KeyEvent.VK_SCROLL_LOCK);
        KEY_MAP.put("SCROLL", KeyEvent.VK_SCROLL_LOCK);
        KEY_MAP.put("PAUSE", KeyEvent.VK_PAUSE);
        KEY_MAP.put("CAPS_LOCK", KeyEvent.VK_CAPS_LOCK);
        KEY_MAP.put("CAPS", KeyEvent.VK_CAPS_LOCK);
        KEY_MAP.put("NUM_LOCK", KeyEvent.VK_NUM_LOCK);
        KEY_MAP.put("NUMLOCK", KeyEvent.VK_NUM_LOCK);
        KEY_MAP.put("WINDOWS", KeyEvent.VK_WINDOWS);
        KEY_MAP.put("WIN", KeyEvent.VK_WINDOWS);
        KEY_MAP.put("CONTEXT_MENU", KeyEvent.VK_CONTEXT_MENU);
        KEY_MAP.put("MENU", KeyEvent.VK_CONTEXT_MENU);
        
        KEY_MAP.put("UP", KeyEvent.VK_UP);
        KEY_MAP.put("DOWN", KeyEvent.VK_DOWN);
        KEY_MAP.put("LEFT", KeyEvent.VK_LEFT);
        KEY_MAP.put("RIGHT", KeyEvent.VK_RIGHT);
        
        KEY_MAP.put("NUMPAD0", KeyEvent.VK_NUMPAD0);
        KEY_MAP.put("NUMPAD1", KeyEvent.VK_NUMPAD1);
        KEY_MAP.put("NUMPAD2", KeyEvent.VK_NUMPAD2);
        KEY_MAP.put("NUMPAD3", KeyEvent.VK_NUMPAD3);
        KEY_MAP.put("NUMPAD4", KeyEvent.VK_NUMPAD4);
        KEY_MAP.put("NUMPAD5", KeyEvent.VK_NUMPAD5);
        KEY_MAP.put("NUMPAD6", KeyEvent.VK_NUMPAD6);
        KEY_MAP.put("NUMPAD7", KeyEvent.VK_NUMPAD7);
        KEY_MAP.put("NUMPAD8", KeyEvent.VK_NUMPAD8);
        KEY_MAP.put("NUMPAD9", KeyEvent.VK_NUMPAD9);
    }
    
    public static int getKeyCode(String key) {
        return KEY_MAP.getOrDefault(key.toUpperCase(), -1);
    }
    
    public static boolean isValidKey(String key) {
        return KEY_MAP.containsKey(key.toUpperCase());
    }
    
    public static String[] getAllKeys() {
        return KEY_MAP.keySet().toArray(new String[0]);
    }
}