package greymerk.roguelike.treasure.loot.provider;

import greymerk.roguelike.util.IWeighted;

import java.util.Random;

import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public abstract class ItemBase implements IWeighted<ItemStack> {

	private int weight;
	int level;

	@Nullable
	public static ItemStack getIC2Item(String name, String variant) {
		return IC2Items.getItemAPI().getItemStack(name, variant);
	}
	
	public ItemBase(int weight, int level){
		this.weight = weight;
		this.level = level;
	}
	
	public abstract ItemStack getLootItem(Random rand, int level);

	@Override
	public int getWeight() {
		return weight;
	}
	
	@Override
	public ItemStack get(Random rand) {
		return getLootItem(rand, level);
	}
}
