package com.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "mod-de-poderzinnn";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Registar um item simples (Super Maçã)
    public static final Item SUPER_MACA = Registry.register(
        Registries.ITEM,
        Identifier.of(MOD_ID, "super_maca"),
        new Item(new Item.Settings())
    );

    @Override
    public void onInitialize() {
        LOGGER.info("O mod-de-poderzinnn foi carregado com sucesso!");
    }
}
