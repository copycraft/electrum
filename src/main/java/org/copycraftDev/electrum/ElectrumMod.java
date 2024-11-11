package org.copycraftDev.electrum;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.EquipmentSlot;

public class ElectrumMod implements ModInitializer {
    public static final String MOD_ID = "electrum";

    // Electrum Ingot, Block, and Lithium Powder
    public static final Item ELECTRUM_INGOT = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item LITHIUM_POWDER = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Block ELECTRUM_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).strength(5.0f));
    public static final Item ELECTRUM_BLOCK_ITEM = new BlockItem(ELECTRUM_BLOCK, new Item.Settings().group(ItemGroup.MISC));

    // Define battery items
    public static final Item SMALL_BATTERY_EMPTY = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item SMALL_BATTERY_FULL = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item LARGE_BATTERY_EMPTY = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item LARGE_BATTERY_FULL = new Item(new Item.Settings().group(ItemGroup.MISC));

    // Define weapons with custom settings
    public static final Item ELECTRUM_CLEAVER = new SwordItem(ToolMaterials.NETHERITE, 8, -2.4f, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1));
    public static final Item ELECTRUM_GAVEL = new Item(new Item.Settings().group(ItemGroup.COMBAT).maxCount(1));
    public static final Item ELECTRUM_GAVEL_CHARGED = new Item(new Item.Settings().group(ItemGroup.COMBAT).maxCount(1));

    // Define Electrum Armor
    public static final Item ELECTRUM_HELMET = new ArmorItem(ElectrumArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item ELECTRUM_CHESTPLATE = new ArmorItem(ElectrumArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item ELECTRUM_LEGGINGS = new ArmorItem(ElectrumArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item ELECTRUM_BOOTS = new ArmorItem(ElectrumArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    @Override
    public void onInitialize() {
        // Register items and blocks
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_ingot"), ELECTRUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lithium_powder"), LITHIUM_POWDER);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "electrum_block"), ELECTRUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_block"), ELECTRUM_BLOCK_ITEM);

        // Register battery items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "small_battery_empty"), SMALL_BATTERY_EMPTY);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "small_battery_full"), SMALL_BATTERY_FULL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "large_battery_empty"), LARGE_BATTERY_EMPTY);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "large_battery_full"), LARGE_BATTERY_FULL);

        // Register weapons/tools
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_cleaver"), ELECTRUM_CLEAVER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_gavel"), ELECTRUM_GAVEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_gavel_charged"), ELECTRUM_GAVEL_CHARGED);

        // Register armor items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_helmet.json"), ELECTRUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_chestplate"), ELECTRUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_leggings"), ELECTRUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "electrum_boots"), ELECTRUM_BOOTS);
    }
}
