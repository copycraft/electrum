package org.copycraftDev.electrum;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class GavelBlock extends Block {
    public static final BooleanProperty CHARGED = BooleanProperty.of("charged");

    public GavelBlock() {
        super(AbstractBlock.Settings.of(Material.STONE).strength(3.0f));
        this.setDefaultState(this.getStateManager().getDefaultState().with(CHARGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHARGED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);

        // Check if the block is uncharged and player is holding a small full battery
        if (!state.get(CHARGED) && heldItem.getItem() == ElectrumMod.SMALL_BATTERY_FULL) {
            if (!world.isClient) {
                // Set the block to charged
                world.setBlockState(pos, state.with(CHARGED, true), 3);

                // Replace the full battery with an empty one
                heldItem.decrement(1); // Decrease the count of full batteries
                player.giveItemStack(new ItemStack(ElectrumMod.SMALL_BATTERY_EMPTY)); // Add an empty battery to the inventory
            }
            return ActionResult.SUCCESS;
        }

        // Check if the block is charged and the player is holding an uncharged gavel
        if (state.get(CHARGED) && heldItem.getItem() == ElectrumMod.ELECTRUM_GAVEL) {
            if (!world.isClient) {
                // Set the block to uncharged
                world.setBlockState(pos, state.with(CHARGED, false), 3);

                // Replace the uncharged gavel with the charged gavel
                heldItem.decrement(1); // Remove the uncharged gavel from the player's hand
                player.giveItemStack(new ItemStack(ElectrumMod.ELECTRUM_GAVEL_CHARGED)); // Add the charged gavel to the inventory
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}
