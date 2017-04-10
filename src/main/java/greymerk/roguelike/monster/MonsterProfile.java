package greymerk.roguelike.monster;

import java.util.Random;

import greymerk.roguelike.monster.profiles.*;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;
import vazkii.quark.world.entity.EntityAshen;
import vazkii.quark.world.entity.EntityDweller;

public enum MonsterProfile {

	TALLMOB, ZOMBIE, PIGMAN, SKELETON, VILLAGER, HUSK, BABY, ASHLEA, RLEAHY, 
	ARCHER, WITHER, POISONARCHER, MAGICARCHER, SWORDSMAN, WITCH, ASHEN, DWELLER;
	
	public static IMonsterProfile get(MonsterProfile profile){
		switch(profile){
		case TALLMOB: return new ProfileTallMob();
		case ZOMBIE: return new ProfileZombie();
		case PIGMAN: return new ProfilePigman();
		case SKELETON: return new ProfileSkeleton();
		case VILLAGER: return new ProfileVillager();
		case HUSK: return new ProfileHusk();
		case BABY: return new ProfileBaby();
		case ASHLEA: return new ProfileAshlea();
		case RLEAHY: return new ProfileRleahy();
		case ARCHER: return new ProfileArcher();
		case WITHER: return new ProfileWither();
		case POISONARCHER: return new ProfilePoisonArcher();
		case MAGICARCHER: return new ProfileMagicArcher();
		case SWORDSMAN: return new ProfileSwordsman();
		case WITCH: return new ProfileWitch();
		case ASHEN: return new ProfileAshen();
		case DWELLER: return new ProfileDweller();
		default: return new ProfileTallMob();
		}
	}
	
	public static void equip(World world, Random rand, int level, IEntity mob){
		
		IMonsterProfile profile = null;
		
		if(mob.instance(EntityZombie.class)) profile = get(ZOMBIE);
		
		if(mob.instance(EntitySkeleton.class)) profile = get(SKELETON);

		if(mob.instance(EntityAshen.class)) profile = get(ASHEN);

		if(mob.instance(EntityDweller.class)) profile = get(DWELLER);
		
		if(profile == null) return;
		
		profile.addEquipment(world, rand, level, mob);
	}
	

	
}
