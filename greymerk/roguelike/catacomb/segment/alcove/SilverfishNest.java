package greymerk.roguelike.catacomb.segment.alcove;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.World;
import greymerk.roguelike.catacomb.Catacomb;
import greymerk.roguelike.catacomb.segment.IAlcove;
import greymerk.roguelike.worldgen.BlockFactoryProvider;
import greymerk.roguelike.worldgen.BlockRandomizer;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.Door;
import greymerk.roguelike.worldgen.IBlockFactory;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.Spawner;
import greymerk.roguelike.worldgen.WorldGenPrimitive;

public class SilverfishNest implements IAlcove{

	private static int RECESSED = 6;
	
	@Override
	public void generate(World world, Random rand, int x, int y, int z, Cardinal dir) {
		
		Coord corridor = new Coord(x, y, z);
		Coord centre = new Coord(x, y, z);
		centre.add(dir, RECESSED);
		
		nest(world, rand, centre.getX(), centre.getY(), centre.getZ());
		
		Coord start = new Coord(corridor);
		start.add(Cardinal.UP, 1);
		
		Coord end = new Coord(centre);
		end.add(Cardinal.UP, 1);
		end.add(Cardinal.reverse(dir), 1);
		
		WorldGenPrimitive.fillRectSolid(world, start, end, new MetaBlock(0), true, true);

		Spawner type = rand.nextInt(5) == 0 ? Spawner.CAVESPIDER : Spawner.SILVERFISH;
		
		if(rand.nextBoolean()) Spawner.generate(world, rand, centre.getX(), centre.getY(), centre.getZ(), type);
		
	}

	@Override
	public boolean isValidLocation(World world, int x, int y, int z, Cardinal dir) {

		Coord centre = new Coord(x, y, z);
		centre.add(dir, RECESSED);
		x = centre.getX();
		y = centre.getY();
		z = centre.getZ();
		
		List<Coord> toCheck = WorldGenPrimitive.getRectSolid(x - 2, y + 1, z - 2, x + 2, y + 1, z + 2);

		for(Coord c : toCheck){
			if (world.isAirBlock(c.getX(), c.getY(), c.getZ())) return false;
		}
		
		return true;
	}
	
	private void nest(World world, Random rand, int x, int y, int z){
		BlockRandomizer fish = new BlockRandomizer(rand, new MetaBlock(Block.silverfish.blockID, 1));
		fish.addBlock(new MetaBlock(Block.slowSand.blockID), 5);
		WorldGenPrimitive.fillRectHollow(world, x - 2, y, z - 2, x + 2, y + 3, z + 2, fish, true, true);
		
		fish.setBlock(world, x - 1, y + 2, z);
		fish.setBlock(world, x + 1, y + 2, z);
		fish.setBlock(world, x, y + 2, z - 1);
		fish.setBlock(world, x, y + 2, z + 1);
		fish.setBlock(world, x, y + 1, z);
		
		WorldGenPrimitive.setBlock(world, x, y + 2, z, Block.waterMoving.blockID);
	}
}