package org.copycraftDev.electrum.client;

import org.copycraftDev.electrum.ElectrumArmor;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ElectrumArmorRenderer extends GeoArmorRenderer<ElectrumArmor> {
    // This holds the model provider
    private static final AnimatedGeoModel<ElectrumArmor> modelProvider = new ElectrumArmorModel();

    public ElectrumArmorRenderer() {
        // Pass the model provider to the super constructor
        super(modelProvider);

        // These values are what each bone name is in Blockbench. Customize according to your model.
        this.headBone = "helmet";  // For the head bone
        this.bodyBone = "chestplate";  // For the body bone
        this.rightArmBone = "rightArm";  // For the right arm bone
        this.leftArmBone = "leftArm";  // For the left arm bone
        this.rightLegBone = "rightLeg";  // For the right leg bone
        this.leftLegBone = "leftLeg";  // For the left leg bone
        this.rightBootBone = "rightBoot";  // For the right boot bone
        this.leftBootBone = "leftBoot";  // For the left boot bone
    }
}
