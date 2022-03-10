package com.wwwday.boson;

import com.wwwday.boson.armor.ModArmorMaterial;
import com.wwwday.boson.crop.Soybean;
import com.wwwday.boson.food.GlassApple;
import com.wwwday.boson.food.ObsidianApple;
import com.wwwday.boson.group.ModGroup;
import com.wwwday.boson.item.ObsidianIngot;
import com.wwwday.boson.melee_weapons.ObsidianSword;
import com.wwwday.boson.missile.ItemInfiniteSnowball;
import com.wwwday.boson.tool.ObsidianPickaxe;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Boson.MOD_ID);

    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", ObsidianPickaxe::new);

    public static RegistryObject<Item> OBSIDIAN_FRAME = ITEMS.register("obsidian_frame", () -> new BlockItem(ModBlocks.OBSIDIAN_FRAME.get(), new Item.Properties().group(ModGroup.itemGroup)));

    public static final RegistryObject<Item> ITEM_INFINITE_SNOWBALL = ITEMS.register("item_infinite_snowball", ItemInfiniteSnowball::new);

    public static RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", ObsidianSword::new);

    public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot", ObsidianIngot::new);

    public static final RegistryObject<Item> OBSIDIAN_APPLE = ITEMS.register("obsidian_apple", ObsidianApple::new);
    public static final RegistryObject<Item> GLASS_APPLE = ITEMS.register("glass_apple", GlassApple::new);

    public static final RegistryObject<Item> OBSIDIAN_BLOCK = ITEMS.register("obsidian_block", () -> new BlockItem(ModBlocks.OBSIDIAN_BLOCK.get(), new Item.Properties().group(ModGroup.itemGroup)));
    public static final RegistryObject<Item> CUBE_BLOCK = ITEMS.register("cube_block", () -> new BlockItem(ModBlocks.CUBE_BLOCK.get(), new Item.Properties().group(ModGroup.itemGroup)));

    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD, (new Item.Properties()).group(ModGroup.itemGroup)));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST, (new Item.Properties()).group(ModGroup.itemGroup)));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.LEGS, (new Item.Properties()).group(ModGroup.itemGroup)));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.FEET, (new Item.Properties()).group(ModGroup.itemGroup)));

    public static final RegistryObject<Item> SOYBEAN = ITEMS.register("soybean", Soybean::new);

    public void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
