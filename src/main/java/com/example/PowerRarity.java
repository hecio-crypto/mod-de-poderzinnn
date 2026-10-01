package com.example;

import net.minecraft.util.Formatting;

public enum PowerRarity {
    COMUM("⚪ Comum", Formatting.WHITE),
    INCOMUM("🟢 Incomum", Formatting.GREEN),
    RARO("🔵 Raro", Formatting.BLUE),
    LENDARIO("🟣 Lendário", Formatting.DARK_PURPLE),
    MITICO("🔴 Mítico", Formatting.RED);

    private final String name;
    private final Formatting color;

    PowerRarity(String name, Formatting color) {
        this.name = name;
        this.color = color;
    }

    public String getName() { return name; }
    public Formatting getColor() { return color; }
}
