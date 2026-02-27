package org.millenaire.common.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import org.millenaire.Millenaire;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Регистрация всех блоков мода Millénaire
 * 
 * Портировано с оригинального MillBlocks.java (1.12.2 Forge)
 */
public class MillBlocks {
    
    // Карта всех блоков для регистрации
    private static final Map<String, Block> BLOCKS = new LinkedHashMap<>();
    
    // ==================== ДЕКОРАТИВНЫЕ БЛОКИ ====================
    
    // Камень/Кирпич
    public static final Block STONE_DECORATION = registerBlock("stone_decoration",
        new Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)
            .mapColor(MapColor.STONE_GRAY)));
    
    public static final Block PAINTED_BRICK_WHITE = registerBlock("painted_brick_white",
        new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)
            .mapColor(MapColor.WHITE)));
    
    public static final Block PAINTED_BRICK_ORANGE = registerBlock("painted_brick_orange",
        new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)
            .mapColor(MapColor.ORANGE)));
    
    public static final Block PAINTED_BRICK_YELLOW = registerBlock("painted_brick_yellow",
        new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)
            .mapColor(MapColor.YELLOW)));
    
    public static final Block PAINTED_BRICK_BLUE = registerBlock("painted_brick_blue",
        new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)
            .mapColor(MapColor.BLUE)));
    
    public static final Block PAINTED_BRICK_RED = registerBlock("painted_brick_red",
        new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)
            .mapColor(MapColor.RED)));
    
    // Византийские блоки
    public static final Block BYZANTINE_TILES = registerBlock("byzantine_tiles",
        new Block(AbstractBlock.Settings.copy(Blocks.TERRACOTTA)
            .mapColor(MapColor.TERRACOTTA_ORANGE)));
    
    public static final Block BYZANTINE_STONE = registerBlock("byzantine_stone",
        new Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)));
    
    // ==================== ДЕРЕВЯННЫЕ БЛОКИ ====================
    
    public static final Block TIMBER_FRAME = registerBlock("timber_frame",
        new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
            .mapColor(MapColor.OAK_TAN)));
    
    public static final Block TIMBER_FRAME_CROSS = registerBlock("timber_frame_cross",
        new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    
    // ==================== ЗЕМЛЯНЫЕ БЛОКИ ====================
    
    public static final Block MUD_BRICK = registerBlock("mud_brick",
        new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)
            .mapColor(MapColor.DIRT_BROWN)
            .strength(1.5f, 3.0f)));
    
    public static final Block MUD_BRICK_WET = registerBlock("mud_brick_wet",
        new Block(AbstractBlock.Settings.copy(Blocks.CLAY)
            .mapColor(MapColor.DIRT_BROWN)));
    
    public static final Block DIRT_WALL = registerBlock("dirt_wall",
        new Block(AbstractBlock.Settings.copy(Blocks.DIRT)
            .strength(0.5f)));
    
    // ==================== СНЕЖНЫЕ/ЛЕДЯНЫЕ БЛОКИ (Инуиты) ====================
    
    public static final Block SNOW_BRICK = registerBlock("snow_brick",
        new Block(AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK)
            .strength(0.4f)));
    
    public static final Block ICE_BRICK = registerBlock("ice_brick",
        new Block(AbstractBlock.Settings.copy(Blocks.PACKED_ICE)));
    
    public static final Block SOD_BLOCK = registerBlock("sod_block",
        new Block(AbstractBlock.Settings.copy(Blocks.DIRT)
            .mapColor(MapColor.DARK_GREEN)));
    
    // ==================== РАСТЕНИЯ/КУЛЬТУРЫ ====================
    
    public static final Block RICE_CROP = registerBlock("rice_crop",
        new BlockMillCrop(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    
    public static final Block TURMERIC_CROP = registerBlock("turmeric_crop",
        new BlockMillCrop(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    
    public static final Block MAIZE_CROP = registerBlock("maize_crop",
        new BlockMillCrop(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    
    public static final Block VINE_CROP = registerBlock("vine_crop",
        new BlockMillCrop(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    
    // ==================== ФУНКЦИОНАЛЬНЫЕ БЛОКИ ====================
    
    public static final Block LOCKED_CHEST = registerBlock("locked_chest",
        new BlockLockedChest(AbstractBlock.Settings.copy(Blocks.CHEST)));
    
    public static final Block FIRE_PIT = registerBlock("fire_pit",
        new BlockFirePit(AbstractBlock.Settings.copy(Blocks.CAMPFIRE)
            .luminance(state -> 15)));
    
    public static final Block IMPORT_TABLE = registerBlock("import_table",
        new BlockImportTable(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    
    // ==================== КРОВАТИ ====================
    
    public static final Block STRAW_BED = registerBlock("straw_bed",
        new BlockMillBed(AbstractBlock.Settings.copy(Blocks.WHITE_BED)));
    
    public static final Block BYZANTINE_BED = registerBlock("byzantine_bed",
        new BlockMillBed(AbstractBlock.Settings.copy(Blocks.WHITE_BED)));
    
    public static final Block INUIT_BED = registerBlock("inuit_bed",
        new BlockMillBed(AbstractBlock.Settings.copy(Blocks.WHITE_BED)));
    
    // ==================== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ====================
    
    private static Block registerBlock(String name, Block block) {
        BLOCKS.put(name, block);
        return block;
    }
    
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Millenaire.id(name),
            new BlockItem(block, new Item.Settings()));
    }
    
    public static void register() {
        Millenaire.LOGGER.info("[{}] Регистрация блоков...", Millenaire.MOD_ID);
        
        for (Map.Entry<String, Block> entry : BLOCKS.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue();
            
            // Регистрация блока
            Registry.register(Registries.BLOCK, Millenaire.id(name), block);
            
            // Регистрация предмета блока
            registerBlockItem(name, block);
        }
        
        // Добавление в творческую вкладку
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.add(STONE_DECORATION);
            content.add(PAINTED_BRICK_WHITE);
            content.add(BYZANTINE_TILES);
            content.add(TIMBER_FRAME);
            content.add(MUD_BRICK);
            content.add(SNOW_BRICK);
            content.add(ICE_BRICK);
        });
        
        Millenaire.LOGGER.info("[{}] Зарегистрировано {} блоков", Millenaire.MOD_ID, BLOCKS.size());
    }
}
