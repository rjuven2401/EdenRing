package paulevs.edenring.registries;


import net.fabricmc.fabric.api.registry.TillableBlockRegistry;
import net.fabricmc.fabric.mixin.object.builder.AbstractBlockAccessor;
import net.fabricmc.fabric.mixin.object.builder.AbstractBlockSettingsAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import paulevs.edenring.EdenRing;
import paulevs.edenring.blocks.AquatusBlock;
import paulevs.edenring.blocks.AquatusRootsBlock;
import paulevs.edenring.blocks.AquatusSapling;
import paulevs.edenring.blocks.AuritisLeavesBlock;
import paulevs.edenring.blocks.BalloonMushroomBlock;
import paulevs.edenring.blocks.BalloonMushroomSmallBlock;
import paulevs.edenring.blocks.BalloonMushroomStemBlock;
import paulevs.edenring.blocks.BrainTreeBlock;
import paulevs.edenring.blocks.BrainTreeLogBlock;
import paulevs.edenring.blocks.BranchBlock;
import paulevs.edenring.blocks.EdenDoublePlantBlock;
import paulevs.edenring.blocks.EdenGrassBlock;
import paulevs.edenring.blocks.EdenMossBlock;
import paulevs.edenring.blocks.EdenPortalBlock;
import paulevs.edenring.blocks.EdenPortalCenterBlock;
import paulevs.edenring.blocks.GraviliteBlock;
import paulevs.edenring.blocks.GraviliteLampBlock;
import paulevs.edenring.blocks.GraviliteLanternBlock;
import paulevs.edenring.blocks.GraviliteShardsBlock;
import paulevs.edenring.blocks.GraviliteTallLanternBlock;
import paulevs.edenring.blocks.GravityCompressorBlock;
import paulevs.edenring.blocks.MossyStoneBlock;
import paulevs.edenring.blocks.MycoticGrass;
import paulevs.edenring.blocks.OverlayDoublePlantBlock;
import paulevs.edenring.blocks.OverlayPlantBlock;
import paulevs.edenring.blocks.OverlayVineBlock;
import paulevs.edenring.blocks.Parignum;
import paulevs.edenring.blocks.PulseTreeBlock;
import paulevs.edenring.blocks.ShadedVineBlock;
import paulevs.edenring.blocks.SymbioticMoldBlock;
import paulevs.edenring.blocks.TallBalloonMushroom;
import paulevs.edenring.blocks.TexturedTerrainBlock;
import paulevs.edenring.blocks.VolvoxBlock;
import paulevs.edenring.blocks.VolvoxBlockDense;
import ru.bclib.api.BonemealAPI;
import ru.bclib.api.ComposterAPI;
import ru.bclib.api.ShovelAPI;
import ru.bclib.api.tag.NamedBlockTags;
import ru.bclib.api.tag.NamedItemTags;
import ru.bclib.api.tag.NamedMineableTags;
import ru.bclib.api.tag.TagAPI;
import ru.bclib.blocks.BaseLeavesBlock;
import ru.bclib.blocks.BaseVineBlock;
import ru.bclib.blocks.FeatureSaplingBlock;
import ru.bclib.complexmaterials.ComplexMaterial;
import ru.bclib.complexmaterials.WoodenComplexMaterial;
import ru.bclib.config.PathConfig;
import ru.bclib.registry.BlockRegistry;

public class EdenBlocks {
	public static final BlockRegistry REGISTRY = new BlockRegistry(EdenRing.EDEN_TAB, new PathConfig(EdenRing.MOD_ID, "blocks"));
	
	public static final Block EDEN_GRASS_BLOCK = register("eden_grass", new EdenGrassBlock());
	public static final Block EDEN_MYCELIUM = register("eden_mycelium", new TexturedTerrainBlock());
	public static final Block MOSSY_STONE = register("mossy_stone", new MossyStoneBlock());
	
	public static final Block AURITIS_SAPLING = register("auritis_sapling", new FeatureSaplingBlock((state) -> EdenFeatures.AURITIS_TREE.getFeature()));
	public static final Block AURITIS_LEAVES = register("auritis_leaves", new AuritisLeavesBlock());
	public static final ComplexMaterial AURITIS_MATERIAL = new WoodenComplexMaterial(EdenRing.MOD_ID, "auritis", "eden", MaterialColor.COLOR_BROWN, MaterialColor.GOLD).init(REGISTRY, EdenItems.REGISTRY, new PathConfig(EdenRing.MOD_ID, "recipes"));
	
	public static final Block BALLOON_MUSHROOM_SMALL = register("balloon_mushroom_small", new BalloonMushroomSmallBlock());
	public static final Block BALLOON_MUSHROOM_BLOCK = register("balloon_mushroom_block", new BalloonMushroomBlock());
	public static final Block BALLOON_MUSHROOM_STEM = register("balloon_mushroom_stem", new BalloonMushroomStemBlock());
	public static final Block BALLOON_MUSHROOM_BRANCH = register("balloon_mushroom_branch", new BranchBlock(BALLOON_MUSHROOM_STEM));
	public static final ComplexMaterial BALLOON_MUSHROOM_MATERIAL = new WoodenComplexMaterial(EdenRing.MOD_ID, "balloon_mushroom", "eden", MaterialColor.COLOR_PURPLE, MaterialColor.COLOR_PURPLE).init(REGISTRY, EdenItems.REGISTRY, EdenRecipes.CONFIG);
	public static final Block BALLOON_MUSHROOM_HYMENOPHORE = register("balloon_mushroom_hymenophore", new ShadedVineBlock());
	
	public static final Block PULSE_TREE_SAPLING = register("pulse_tree_sapling", new FeatureSaplingBlock((state) -> EdenFeatures.PULSE_TREE.getFeature()));
	public static final Block PULSE_TREE = register("pulse_tree", new PulseTreeBlock());
	public static final ComplexMaterial PULSE_TREE_MATERIAL = new WoodenComplexMaterial(EdenRing.MOD_ID, "pulse_tree", "eden", MaterialColor.COLOR_CYAN, MaterialColor.COLOR_CYAN).init(REGISTRY, EdenItems.REGISTRY, EdenRecipes.CONFIG);
	
	public static final Block BRAIN_TREE_LOG = register("brain_tree_log", new BrainTreeLogBlock());
	public static final Block BRAIN_TREE_BLOCK_IRON = register("brain_tree_block_iron", new BrainTreeBlock(MaterialColor.COLOR_LIGHT_GRAY));
	public static final Block BRAIN_TREE_BLOCK_COPPER = register("brain_tree_block_copper", new BrainTreeBlock(MaterialColor.COLOR_ORANGE));
	public static final Block BRAIN_TREE_BLOCK_GOLD = register("brain_tree_block_gold", new BrainTreeBlock(MaterialColor.GOLD));
	
	public static final Block VOLVOX_BLOCK = register("volvox_block", new VolvoxBlock());
	public static final Block VOLVOX_BLOCK_DENSE = register("volvox_block_dense", new VolvoxBlockDense());
	
	public static final Block AQUATUS_SAPLING = register("aquatus_sapling", new AquatusSapling());
	public static final Block AQUATUS_BLOCK = register("aquatus_block", new AquatusBlock());
	public static final Block AQUATUS_ROOTS = registerBO("aquatus_roots", new AquatusRootsBlock());
	
	public static final Block EDEN_MOSS = register("eden_moss", new EdenMossBlock());
	public static final Block PARIGNUM = register("parignum", new Parignum());
	
	public static final Block MYCOTIC_GRASS = register("mycotic_grass", new MycoticGrass());
	public static final Block GOLDEN_GRASS = register("golden_grass", new OverlayPlantBlock(true));
	public static final Block IRON_GRASS = register("iron_grass", new OverlayPlantBlock(true));
	public static final Block COPPER_GRASS = register("copper_grass", new OverlayPlantBlock(true));
	public static final Block GOLD_GRASS = register("gold_grass", new OverlayPlantBlock(true));
	public static final Block LONLIX = register("lonlix", new OverlayPlantBlock(true));
	
	public static final Block VIOLUM = register("violum", new OverlayDoublePlantBlock());
	public static final Block TALL_BALLOON_MUSHROOM = register("tall_balloon_mushroom", new TallBalloonMushroom());
	public static final Block TALL_MYCOTIC_GRASS = register("tall_mycotic_grass", new EdenDoublePlantBlock());
	//public static final Block ALAESPES = register("alaespes", new AlaespesBlock());
	
	public static final Block EDEN_VINE = register("eden_vine", new OverlayVineBlock());
	
	public static final Block SYMBIOTIC_MOLD = register("symbiotic_mold", new SymbioticMoldBlock(0));
	public static final Block SYMBIOTIC_MOLD_EMISSIVE = register("symbiotic_mold_emissive", new SymbioticMoldBlock(13));
	
	public static final Block GRAVILITE_BLOCK = register("gravilite_block", new GraviliteBlock());
	public static final Block GRAVILITE_SHARDS = register("gravilite_shards", new GraviliteShardsBlock());
	public static final Block GRAVILITE_LAMP = register("gravilite_lamp", new GraviliteLampBlock());
	public static final Block GRAVILITE_LANTERN = register("gravilite_lantern", new GraviliteLanternBlock());
	public static final Block GRAVILITE_LANTERN_TALL = register("gravilite_lantern_tall", new GraviliteTallLanternBlock());
	
	public static final Block GRAVITY_COMPRESSOR = register("gravity_compressor", new GravityCompressorBlock());
	
	public static final Block PORTAL_BLOCK = registerBO("portal_block", new EdenPortalBlock());
	public static final Block PORTAL_CENTER = registerBO("portal_center", new EdenPortalCenterBlock());
	
	public static void init() {
		BlockRegistry.getModBlocks(EdenRing.MOD_ID).forEach(block -> {
			Properties properties = ((AbstractBlockAccessor) block).getSettings();
			Material material = ((AbstractBlockSettingsAccessor) properties).getMaterial();
			
			if (block instanceof BaseLeavesBlock) {
				TagAPI.addBlockTag(NamedMineableTags.HOE, block);
				TagAPI.addBlockTag(NamedBlockTags.LEAVES, block);
				TagAPI.addItemTag(NamedItemTags.LEAVES, block);
				ComposterAPI.allowCompost(0.3F, block);
			}
			else if (block instanceof GrassBlock) {
				TagAPI.addBlockTag(NamedMineableTags.SHOVEL, block);
				ShovelAPI.addShovelBehaviour(block, Blocks.DIRT_PATH.defaultBlockState());
				TillableBlockRegistry.register(block, HoeItem::onlyIfAirAbove, Blocks.FARMLAND.defaultBlockState());
			}
			else if (material == Material.PLANT || material == Material.REPLACEABLE_PLANT) {
				TagAPI.addBlockTag(NamedMineableTags.HOE, block);
				if (block.asItem() != Items.AIR) {
					ComposterAPI.allowCompost(0.1F, block);
				}
			}
			else if (material == Material.STONE || material == Material.METAL || material == Material.HEAVY_METAL || material == Material.AMETHYST) {
				TagAPI.addBlockTag(NamedMineableTags.PICKAXE, block);
			}
			
			if (block instanceof BaseVineBlock) {
				TagAPI.addBlockTag(NamedBlockTags.CLIMBABLE, block);
			}
		});
		
		BonemealAPI.addLandGrass(MYCOTIC_GRASS, EDEN_MYCELIUM);
		
		BonemealAPI.addLandGrass(EdenBiomes.GOLDEN_FOREST.getID(), GOLDEN_GRASS, EDEN_GRASS_BLOCK);
		BonemealAPI.addLandGrass(EdenBiomes.GOLDEN_FOREST.getID(), Blocks.GRASS, EDEN_GRASS_BLOCK);
		
		BonemealAPI.addSpreadableBlock(MOSSY_STONE, Blocks.STONE);
	}
	
	private static Block register(String name, Block block) {
		return REGISTRY.register(EdenRing.makeID(name), block);
	}
	
	private static Block registerBO(String name, Block block) {
		return REGISTRY.registerBlockOnly(EdenRing.makeID(name), block);
	}
	
	public static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
		return false;
	}
}
