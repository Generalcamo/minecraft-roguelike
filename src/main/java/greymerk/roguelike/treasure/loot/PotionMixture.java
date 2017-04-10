package greymerk.roguelike.treasure.loot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import greymerk.roguelike.util.DyeColor;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public enum PotionMixture {

	TEQUILA, MOONSHINE, ABSINTHE, VILE, 
	LAUDANUM, RAGE, STOUT, STAMINA, NECTAR, COFFEE, AURA;
	
	public static ItemStack getPotion(Random rand, PotionMixture type){
		ItemStack potion;
		switch(type){
		case TEQUILA:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.STRENGTH, 3, 30 + rand.nextInt(60));
			PotionEffect2.addCustomEffect(potion, PotionEffect2.FATIGUE, 1, 30 + rand.nextInt(60));
			Loot.setItemName(potion, "Tequila");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(255, 232, 196));
			return potion;
		case LAUDANUM:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.REGEN, 3, 8);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.WEAKNESS, 2, 5);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.SLOWNESS, 2, 5);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.FATIGUE, 2, 5);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.NAUSIA, 1, 5);
			Loot.setItemName(potion, "Laudanum");
			Loot.setItemLore(potion, "A medicinal tincture.");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(150, 50, 0));
			return potion;
		case MOONSHINE:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.DAMAGE, 1, 1);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.BLINDNESS, 1, 30 + rand.nextInt(60));
			PotionEffect2.addCustomEffect(potion, PotionEffect2.RESISTANCE, 2, 30 + rand.nextInt(30));
			Loot.setItemName(potion, "Moonshine");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(250, 240, 230));
			return potion;
		case ABSINTHE:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.POISON, 1, 3);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.NIGHTVISION, 1, 120);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.JUMP, 3, 120);
			Loot.setItemName(potion, "Absinthe");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(200, 250, 150));
			return potion;
		case VILE:
			potion = Potion.getSpecific(
					rand,
					PotionType.values()[rand.nextInt(PotionType.values().length)],
					Potion.values()[rand.nextInt(Potion.values().length)]
					);
			addRandomEffects(rand, potion, 2 + rand.nextInt(2));
			Loot.setItemName(potion, "Vile Mixture");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			return potion;
		case RAGE:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.STRENGTH, 3, 20);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.BLINDNESS, 1, 10);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.WITHER, 1, 3);
			Loot.setItemName(potion, "Animus");
			Loot.setItemLore(potion, "An unstable mixture.");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(255, 0, 0));
			return potion;
		case STAMINA:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.SATURATION, 10, 1);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.SPEED, 2, 120);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.HASTE, 2, 120);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.JUMP, 3, 120);
			Loot.setItemName(potion, "Vitae");
			Loot.setItemLore(potion, "Essence of life.");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(230, 50, 20));
			return potion;
		case STOUT:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.REGEN, 1, 5);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.SATURATION, 2, 1);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.HEALTHBOOST, 2, 120);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.RESISTANCE, 1, 120);
			Loot.setItemName(potion, "Stout");
			Loot.setItemLore(potion, "\"It's Good for You\"");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(50, 40, 20));
			return potion;
		case NECTAR:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.ABSORPTION, 10, 20);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.RESISTANCE, 3, 20);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.HEALTH, 2, 1);
			Loot.setItemName(potion, "Nectar");
			Loot.setItemLore(potion, "A Floral extract.");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(250, 150, 250));
			return potion;
		case COFFEE:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.HASTE, 2, 600);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.SPEED, 1, 600);
			Loot.setItemName(potion, "Coffee");
			Loot.setItemLore(potion, "A darkroast bean brew.");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(20, 20, 10));
			return potion;
		case AURA:
			potion = Potion.getSpecific(PotionType.REGULAR, null, false, false);
			PotionEffect2.addCustomEffect(potion, PotionEffect2.GLOWING, 1, 20*60);
			Loot.setItemName(potion, "Luma");
			Loot.setItemLore(potion, "A glowstone extract.");
			ItemHideFlags.set(ItemHideFlags.EFFECTS, potion);
			setColor(potion, DyeColor.RGBToColor(250, 250, 0));
			return potion;
		default:
		}
		
		return new ItemStack(Items.GLASS_BOTTLE);
	}
	
	public static ItemStack getBooze(Random rand){
		
		final PotionMixture[] booze = {TEQUILA, LAUDANUM, MOONSHINE, ABSINTHE, STOUT};
		List<PotionMixture> potions = Arrays.asList(booze);
		int choice = rand.nextInt(potions.size());
		PotionMixture type = potions.get(choice);
		return getPotion(rand, type);
	}
	
	public static ItemStack getRandom(Random rand){
		final PotionMixture[] potions = {LAUDANUM, RAGE, STAMINA, NECTAR, COFFEE, AURA};
		int choice = rand.nextInt(potions.length);
		PotionMixture type = potions[choice];
		return getPotion(rand, type);
	}
	
	public static void addRandomEffects(Random rand, ItemStack potion, int numEffects){
		
		List<PotionEffect2> effects = new ArrayList<PotionEffect2>(Arrays.asList(PotionEffect2.values()));
		Collections.shuffle(effects, rand);
		
		for(int i = 0; i < numEffects; ++i){
			
			PotionEffect2 type = effects.get(i);
			int duration;
			switch(type){
			case SATURATION:
			case HEALTH:
			case DAMAGE: duration = 1; break;
			case REGEN: duration = 10 + rand.nextInt(20); break;
			case HUNGER: duration = 5 + rand.nextInt(10); break;
			case WITHER:
			case POISON: duration = 5 + rand.nextInt(5); break;
			default: duration = 60 + rand.nextInt(120);
			}
			
			PotionEffect2.addCustomEffect(potion, type, rand.nextInt(3), duration);
		}	
	}
	
	public static void setColor(ItemStack potion, int color){
		potion.getTagCompound().setInteger("CustomPotionColor", color);
	}
}
