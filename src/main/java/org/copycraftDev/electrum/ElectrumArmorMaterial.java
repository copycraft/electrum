package org.copycraftDev.electrum;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ElectrumArmorMaterial implements ArmorMaterial {
    public static final ElectrumArmorMaterial INSTANCE = new ElectrumArmorMaterial();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return new int[]{13, 15, 16, 11}[slot.getEntitySlotId()] * 33; // Adjust as needed
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return new int[]{4, 7, 9, 4}[slot.getEntitySlotId()]; // Increased by 2 for each slot
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ElectrumMod.ELECTRUM_INGOT);
    }

    @Override
    public String getName() {
        return "electrum"; // This should match the texture folder name
    }

    @Override
    public float getToughness() {
        return 2.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }
}
