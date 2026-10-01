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

    // Registra o Livro de Poderes
    public static final Item LIVRO_DE_PODERES = Registry.register(
        Registries.ITEM,
        Identifier.of(MOD_ID, "livro_de_poderes"),
        new PowerBookItem(new Item.Settings().maxCount(16))
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Mod de Poderes carregado com sucesso!");
    }
}
