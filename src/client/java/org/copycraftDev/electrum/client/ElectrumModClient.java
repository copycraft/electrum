package org.copycraftDev.electrum.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import org.copycraftDev.electrum.ElectrumArmor;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ElectrumModClient implements ClientModInitializer {

    public static void registerRenderers() {
        // Create an instance of the armor renderer
        GeoArmorRenderer<ElectrumArmor> armorRenderer = new ElectrumArmorRenderer();

        // Create the ElectrumArmor item
        ArmorItem armorItem = new ElectrumArmor(EquipmentSlot.HEAD, new Item.Settings());

        // Register the armor renderer with the armor item
        GeoArmorRenderer.registerArmorRenderer(armorRenderer, armorItem);
    }

    @Override
    public void onInitializeClient() {
        
    }
}
