package org.millenaire.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.millenaire.common.village.Village;

/**
 * Житель деревни Millénaire
 * 
 * Основная сущность мода - NPC с профессией, культурой и поведением
 */
public class MillVillager extends PathAwareEntity {
    
    // Данные жителя
    private String culture = "norman";
    private String profession = "farmer";
    private String firstName = "";
    private String familyName = "";
    private boolean isMale = true;
    private int villageId = -1;
    
    // Репутация с игроками
    // Map<UUID, Integer> playerReputation
    
    public MillVillager(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
    
    public static DefaultAttributeContainer.Builder createVillagerAttributes() {
        return PathAwareEntity.createMobAttributes()
            .add(EntityAttributes.MAX_HEALTH, 20.0)
            .add(EntityAttributes.MOVEMENT_SPEED, 0.5)
            .add(EntityAttributes.ATTACK_DAMAGE, 2.0)
            .add(EntityAttributes.FOLLOW_RANGE, 48.0);
    }
    
    @Override
    protected void initGoals() {
        // Базовые цели
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(4, new LookAroundGoal(this));
        
        // TODO: Добавить специфичные цели Millénaire
        // - GoalWork: работа по профессии
        // - GoalBuild: строительство
        // - GoalGather: сбор ресурсов
        // - GoalTrade: торговля с игроком
        // - GoalSleep: сон в доме
    }
    
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putString("Culture", culture);
        nbt.putString("Profession", profession);
        nbt.putString("FirstName", firstName);
        nbt.putString("FamilyName", familyName);
        nbt.putBoolean("IsMale", isMale);
        nbt.putInt("VillageId", villageId);
    }
    
    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        culture = nbt.getString("Culture");
        profession = nbt.getString("Profession");
        firstName = nbt.getString("FirstName");
        familyName = nbt.getString("FamilyName");
        isMale = nbt.getBoolean("IsMale");
        villageId = nbt.getInt("VillageId");
    }
    
    // ==================== ГЕТТЕРЫ/СЕТТЕРЫ ====================
    
    public String getCulture() { return culture; }
    public void setCulture(String culture) { this.culture = culture; }
    
    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getFamilyName() { return familyName; }
    public void setFamilyName(String familyName) { this.familyName = familyName; }
    
    public String getFullName() { return firstName + " " + familyName; }
    
    public boolean isMale() { return isMale; }
    public void setMale(boolean male) { isMale = male; }
    
    public int getVillageId() { return villageId; }
    public void setVillageId(int villageId) { this.villageId = villageId; }
}
