package org.copycraftDev.electrum.client;

import net.minecraft.util.Identifier;
import org.copycraftDev.electrum.ElectrumArmor;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ElectrumArmorModel extends AnimatedGeoModel<ElectrumArmor> {
    @Override
    public Identifier getModelResource(ElectrumArmor object) {
        return new Identifier("electrum", "geo/electrum_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(ElectrumArmor object) {
        return new Identifier("electrum", "textures/armor/electrum_armor.png");
    }

    @Override
    public Identifier getAnimationResource(ElectrumArmor animatable) {
        return new Identifier("electrum", "animations/electrum_armor.animation.json");
    }
}
