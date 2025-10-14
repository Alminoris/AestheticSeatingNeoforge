package net.alminoris.aestheticseating.item;

import net.alminoris.aestheticseating.AestheticSeating;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AestheticSeating.MOD_ID);

    public static final DeferredItem<Item> CUSHION_REMOVER = registerItem("cushion_remover", () -> new TieredItem(Tiers.IRON, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WRENCH = registerItem("wrench", () -> new TieredItem(Tiers.IRON, new Item.Properties().stacksTo(1)));

    private static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> item)
    {
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}