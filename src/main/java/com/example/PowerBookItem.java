package com.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PowerBookItem extends Item {

    public PowerBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient()) {
            // Sorteia um dos 50 poderes com base na porcentagem
            Power drawnPower = Power.rollRandomPower(world.getRandom());

            // Toca som de nível/conquista
            world.playSound(
                null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, SoundCategory.PLAYERS, 1.0F, 1.0F
            );

            // Mensagem do Poder sorteado
            user.sendMessage(Text.literal("==================================").formatted(Formatting.GOLD), false);
            user.sendMessage(Text.literal("✨ LIVRO DE PODERES UTILIZADO! ✨").formatted(Formatting.YELLOW, Formatting.BOLD), false);
            user.sendMessage(
                Text.literal("Poder Obtido: ").formatted(Formatting.WHITE)
                    .append(Text.literal(drawnPower.getDisplayName()).formatted(drawnPower.getRarity().getColor(), Formatting.BOLD)),
                false
            );
            user.sendMessage(
                Text.literal("Raridade: ").formatted(Formatting.GRAY)
                    .append(Text.literal(drawnPower.getRarity().getName()).formatted(drawnPower.getRarity().getColor())),
                false
            );
            user.sendMessage(Text.literal("--- Árvore de Habilidades Desbloqueada (6 Formas) ---").formatted(Formatting.DARK_AQUA), false);

            // Mostra as 6 formas da árvore de habilidades no chat
            String[] forms = drawnPower.getSkillTreeForms();
            for (String form : forms) {
                user.sendMessage(Text.literal(" └▸ " + form).formatted(Formatting.AQUA), false);
            }
            user.sendMessage(Text.literal("==================================").formatted(Formatting.GOLD), false);

            // Consome 1 livro no modo sobrevivência
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
