package com.wwwday.boson.melee_weapons;

import java.util.function.Supplier;

import com.wwwday.boson.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public enum ModItemTier implements IItemTier {
    OBSIDIAN(3, 2000, 10.0F, 4.0F, 30, () -> {
        return Ingredient.fromItems(ModItems.OBSIDIAN_INGOT.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;

    ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Nonnull
    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ModItems.OBSIDIAN_INGOT.get());
    }
}
