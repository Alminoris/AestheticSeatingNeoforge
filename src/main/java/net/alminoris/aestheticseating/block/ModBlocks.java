package net.alminoris.aestheticseating.block;

import net.alminoris.aestheticseating.AestheticSeating;
import net.alminoris.aestheticseating.block.custom.*;
import net.alminoris.aestheticseating.item.ModItems;
import net.alminoris.aestheticseating.util.helper.BlockSetsHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AestheticSeating.MOD_ID);

    public static final Dictionary<String, DeferredBlock<Block>> SEATING_LOGS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("seating_log_"+name, () -> new SeatingLog()));
        }
    }};

    public static final Dictionary<String, DeferredBlock<Block>> SIMPLE_CHAIRS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("simple_chair_"+name, () -> new SimpleChair()));
        }
    }};

    public static final Dictionary<String, DeferredBlock<Block>> SIMPLE_BENCHES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("simple_bench_"+name, () -> new SimpleBench(name)));
        }
    }};

    public static final Dictionary<String, DeferredBlock<Block>> STONE_BENCHES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("stone_bench_"+name, () -> new StoneBench()));
        }
    }};

    public static final Dictionary<String, DeferredBlock<Block>> SIMPLE_STOOLS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("simple_stool_"+name, () -> new SimpleStool(name)));
        }
    }};

    public static final Dictionary<String, DeferredBlock<Block>> SETTEES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("settee_"+name, () -> new Settee(name)));
        }
    }};

    public static final Dictionary<String, DeferredBlock<Block>> SOFAS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("sofa_"+name, () -> new Sofa(name)));
        }
    }};

    public static final Dictionary<String, DeferredBlock<Block>> CUSHIONS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("cushion_"+name, () -> new Cushion()));
        }
    }};
    
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}