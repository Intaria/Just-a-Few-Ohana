package jafohana;

import jafohana.registry.ModBlocks;
import jafohana.registry.ModItems;
import jafohana.world.gen.ModFeatures;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = JAFOhana.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusSubscriber
{
	@SubscribeEvent
	public static void setup(final FMLCommonSetupEvent event)
	{
		ModFeatures.FLOWER_PLAIN = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(JAFOhana.MODID, "flower_plain"), Feature.FLOWER.configured((new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).add(ModBlocks.DAYFLOWER.get().defaultBlockState(), 1).add(ModBlocks.EVENING_PRIMROSE.get().defaultBlockState(), 1).add(ModBlocks.MILK_VETCH.get().defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE));
		ModFeatures.FLOWER_FOREST = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(JAFOhana.MODID, "flower_forest"), Feature.FLOWER.configured((new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).add(ModBlocks.DAYFLOWER.get().defaultBlockState(), 2).add(ModBlocks.EVENING_PRIMROSE.get().defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).chance(2));
		ModFeatures.FLOWER_SPOOKY_FOREST = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(JAFOhana.MODID, "flower_spooky_forest"), Feature.FLOWER.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.DAYFLOWER.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).chance(6));
		ModFeatures.FLOWER_MOUNTAIN = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(JAFOhana.MODID, "flower_mountain"), Feature.FLOWER.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.EVENING_PRIMROSE.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).chance(8));
		ModFeatures.FLOWER_SWAMP = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(JAFOhana.MODID, "flower_swamp"), Feature.FLOWER.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.MILK_VETCH.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).chance(2));
	}

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		ComposterBlock.COMPOSTABLES.put(ModItems.DAYFLOWER.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(ModItems.EVENING_PRIMROSE.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MILK_VETCH.get(), 0.65F);
	}
}