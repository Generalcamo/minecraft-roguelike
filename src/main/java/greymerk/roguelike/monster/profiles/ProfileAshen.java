package greymerk.roguelike.monster.profiles;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import greymerk.roguelike.monster.MobType;
import greymerk.roguelike.treasure.loot.*;
import greymerk.roguelike.treasure.loot.provider.ItemArmour;
import greymerk.roguelike.treasure.loot.provider.ItemWeapon;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ProfileAshen implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {
		
		mob.setMobClass(MobType.ASHEN, false);

		mob.setSlot(EntityEquipmentSlot.OFFHAND, TippedArrow.get(64));
		mob.setSlot(EntityEquipmentSlot.MAINHAND, ItemWeapon.getBow(rand, level, Enchant.canEnchant(world.getDifficulty(), rand, level)));
		
		for(EntityEquipmentSlot slot : new EntityEquipmentSlot[]{
				EntityEquipmentSlot.HEAD,
				EntityEquipmentSlot.CHEST,
				EntityEquipmentSlot.LEGS,
				EntityEquipmentSlot.FEET
				}){
			ItemStack item = ItemArmour.get(rand, Slot.getSlot(slot), Quality.IRON);
			Enchant.enchantItem(rand, item, 30);
			ItemArmour.dyeArmor(item, 51, 0, 102);
			mob.setSlot(slot, item);
		}
	}

}
