package org.millenaire.common.village;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.millenaire.common.entity.MillVillager;
import org.millenaire.common.culture.Culture;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Класс деревни Millénaire
 * 
 * Управляет всеми жителями, зданиями и ресурсами деревни
 */
public class Village {
    
    private int id;
    private String name;
    private String cultureName;
    private Culture culture;
    private BlockPos centerPos;
    private ServerWorld world;
    
    // Жители деревни
    private List<UUID> villagerIds = new ArrayList<>();
    
    // Здания
    private List<Building> buildings = new ArrayList<>();
    
    // Ресурсы деревни
    private VillageResources resources = new VillageResources();
    
    // Репутация с игроками
    // Map<UUID, Integer> playerReputation
    
    // Состояние деревни
    private VillageState state = VillageState.DEVELOPING;
    
    public Village(int id, String name, Culture culture, BlockPos center, ServerWorld world) {
        this.id = id;
        this.name = name;
        this.culture = culture;
        this.cultureName = culture.getId();
        this.centerPos = center;
        this.world = world;
    }
    
    /**
     * Обновление деревни каждый тик
     */
    public void tick() {
        // Проверка жителей
        // Обновление строительства
        // Управление ресурсами
        // Генерация новых жителей если нужно
    }
    
    /**
     * Добавить жителя в деревню
     */
    public void addVillager(MillVillager villager) {
        villagerIds.add(villager.getUuid());
        villager.setVillageId(this.id);
    }
    
    /**
     * Удалить жителя из деревни
     */
    public void removeVillager(UUID villagerId) {
        villagerIds.remove(villagerId);
    }
    
    /**
     * Начать строительство здания
     */
    public void startBuilding(Building building) {
        buildings.add(building);
    }
    
    /**
     * Получить репутацию игрока
     */
    public int getPlayerReputation(UUID playerId) {
        // TODO: реализовать систему репутации
        return 0;
    }
    
    /**
     * Изменить репутацию игрока
     */
    public void changePlayerReputation(UUID playerId, int change) {
        // TODO: реализовать
    }
    
    // ==================== СЕРИАЛИЗАЦИЯ ====================
    
    public NbtCompound toNbt() {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("Id", id);
        nbt.putString("Name", name);
        nbt.putString("Culture", cultureName);
        nbt.putInt("CenterX", centerPos.getX());
        nbt.putInt("CenterY", centerPos.getY());
        nbt.putInt("CenterZ", centerPos.getZ());
        nbt.putString("State", state.name());
        
        // TODO: сохранить здания и жителей
        
        return nbt;
    }
    
    public static Village fromNbt(NbtCompound nbt, ServerWorld world) {
        // TODO: загрузить деревню из NBT
        return null;
    }
    
    // ==================== ГЕТТЕРЫ ====================
    
    public int getId() { return id; }
    public String getName() { return name; }
    public Culture getCulture() { return culture; }
    public BlockPos getCenterPos() { return centerPos; }
    public List<UUID> getVillagerIds() { return villagerIds; }
    public List<Building> getBuildings() { return buildings; }
    public VillageResources getResources() { return resources; }
    public VillageState getState() { return state; }
    
    public enum VillageState {
        DEVELOPING,  // Развивается
        STABLE,      // Стабильная
        DECLINING,   // Упадок
        ABANDONED    // Заброшенная
    }
}
