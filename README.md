# 🎮 Player Control Library

**Player Control Library** is a lightweight library for **Fabric 1.21.1** that provides convenient control over the player: keyboard, mouse, camera, and data tracking.

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| ⌨️ **Keyboard** | Emulate pressing, holding, and releasing any keys |
| 🖱️ **Mouse** | Move, click, scroll wheel emulation |
| 📷 **Camera** | Rotate camera up/down/left/right by degrees |
| 📊 **Player Data** | Track health, hunger, position, inventory |

---

## 📦 Installation

### For Developers (in your mod)

1. Download the latest `.jar` from [Releases](https://github.com/v11859752/player-control-lib/releases)
2. Place it in the `libs/` folder of your project
3. Add to `build.gradle`:

```gradle
dependencies {
    modImplementation files("libs/player-control-lib-1.0.0.jar")
}
```

For Players

Simply place the .jar in the mods/ folder and launch the game.

---

🚀 Usage Examples

Keyboard

```java
import com.playerlib.api.PlayerControlAPI;

// Single press
PlayerControlAPI.press("W");

// Hold down
PlayerControlAPI.holdDown("SHIFT");
Thread.sleep(2000);
PlayerControlAPI.release("SHIFT");

// Key combination
PlayerControlAPI.combo(100, "W", "A", "SPACE");
```

Camera

```java
// Rotate camera up by 45 degrees
PlayerControlAPI.camera().up(45);

// Rotate right by 90 degrees
PlayerControlAPI.camera().right(90);

// Set exact angles
PlayerControlAPI.camera().setPitch(0);
PlayerControlAPI.camera().setYaw(180);
```

Mouse

```java
// Move mouse to coordinates
PlayerControlAPI.mouse().moveTo(100, 200);

// Left click
PlayerControlAPI.mouse().clickLeft();

// Scroll
PlayerControlAPI.mouse().scroll(5);
```

Player Data

```java
import com.playerlib.api.PlayerDataProvider;

PlayerDataProvider.subscribe("mymod", data -> {
    System.out.println("Health: " + data.health());
    System.out.println("Hunger: " + data.hunger());
    System.out.println("Position: " + data.x() + ", " + data.y() + ", " + data.z());
});
```

---

📋 Requirements

· Minecraft 1.21.1
· Fabric Loader >=0.16.0
· Fabric API

---

📄 License

MIT License — free to use in any project.

---

👤 Author

kisiqrt
