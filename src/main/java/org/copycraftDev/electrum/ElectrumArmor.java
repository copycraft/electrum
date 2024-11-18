package org.copycraftDev.electrum;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ElectrumArmor extends ArmorItem implements IAnimatable {
    private static final ArmorMaterial material = null;
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    // Constructor with ArmorMaterial, EquipmentSlot, and Item.Settings
    public ElectrumArmor(EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);  // Pass the material to the ArmorItem constructor
    }

    @Override
    public void registerControllers(AnimationData data) {
        // Adding an animation controller
        data.addAnimationController(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    // Predicate for deciding the animation behavior
    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        // Example: Replace with your own animation resource path
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.electrum_armor.idle", true));
        return PlayState.CONTINUE;  // Continue the animation loop
    }

    // Returning the animation factory
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
