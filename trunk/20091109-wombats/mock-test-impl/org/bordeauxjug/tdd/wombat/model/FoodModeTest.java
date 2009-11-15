package org.bordeauxjug.tdd.wombat.model;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.verify;
import greenfoot.World;
import greenfoot.core.WorldHandler;

import java.util.ArrayList;
import java.util.List;

import org.bordeauxjug.tdd.wombat.greenfoot.WorldHelper;
import org.easymock.classextension.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

public class FoodModeTest {

	private static final int WORLD_WIDTH = 4;
	private static final int WORLD_HEIGHT = 4;
	
	@BeforeClass
	public static void setUp() throws Exception {
		WorldHelper.initializeWorld(WORLD_WIDTH, WORLD_HEIGHT);
	}

	@Test
	public void testVegetarianMode() throws NoSuchMethodException {
		List<Object> mocks = new ArrayList<Object>();
		
		/**
		 * INIT
		 */
		// Creating the wombat
		// Mocking move behaviour
		IMoveBehaviour mockMoveBehaviour = createMock(IMoveBehaviour.class);
		mocks.add(mockMoveBehaviour);
		
		IFoodMode vegetarianFoodMode = new UniqueFoodMode(Kingdom.VEGETAL);
		Wombat2 w = new Wombat2("wombat1", 
				new Move(CardinalPoint.SOUTH, new Coordinates(0, 0)),
				mockMoveBehaviour, vegetarianFoodMode);
		
		// Adding 2 leaves and 1 rabbit on the way : the 2 leaves should be eaten
		// and the rabbit should not !
		IPrey leaf1 = createMock(IPrey.class);
		mocks.add(leaf1);
		IPrey leaf2 = createMock(IPrey.class);
		mocks.add(leaf2);
		IPrey animal1 = createMock(IPrey.class);
		mocks.add(animal1);
		
		/**
		 * EXPECT
		 */
		// Expect wombat will move around the world
		expectMoveAroundTheWorld(WORLD_WIDTH, WORLD_HEIGHT, mockMoveBehaviour);
		// leaf1 and leaf2 should be VEGETABLES and gotEaten
		expect(leaf1.getKingdom()).andStubReturn(Kingdom.VEGETAL);
		leaf1.gotEaten(); expectLastCall();
		expect(leaf1.isAlive()).andReturn(Boolean.TRUE).andReturn(Boolean.FALSE);
		leaf1.setGreenfootActor((ActorDelegator<IPrey>)anyObject()); expectLastCall().anyTimes();
		
		expect(leaf2.getKingdom()).andStubReturn(Kingdom.VEGETAL);
		leaf2.gotEaten(); expectLastCall();
		expect(leaf2.isAlive()).andReturn(Boolean.TRUE).andReturn(Boolean.FALSE);
		leaf2.setGreenfootActor((ActorDelegator<IPrey>)anyObject()); expectLastCall().anyTimes();
		
		// animal1 should be ANIMAL and NOT gotEaten !
		expect(animal1.getKingdom()).andStubReturn(Kingdom.ANIMAL);
		expect(animal1.isAlive()).andStubReturn(Boolean.TRUE);
		animal1.setGreenfootActor((ActorDelegator<IPrey>)anyObject()); expectLastCall().anyTimes();
		
		// both leaves and animal's acts do nothing
		leaf1.act(); expectLastCall().anyTimes();
		leaf2.act(); expectLastCall().anyTimes();
		animal1.act(); expectLastCall().anyTimes();
		
		/**
		 * REPLAY THEN INVOKE
		 */
		// replay ...
		EasyMock.replay(mocks.toArray(new Object[0]));
		
		// ... then invoke ...
		// Creating the world
		World world = WorldHandler.getInstance().getWorld();
		// Adding actors in the world ... should be made here and not in the INIT since
		// some mocks could be called during this ...
		world.addObject(new ActorDelegator<IPredator>(w), w.getCoordinates().x, w.getCoordinates().y);
		world.addObject(new ActorDelegator<IPrey>(leaf1), 0, 2);
		world.addObject(new ActorDelegator<IPrey>(leaf2), 3, 2);
		world.addObject(new ActorDelegator<IPrey>(animal1), 2, 3);
		
		// Calling world's act N times
		int numberOfActs = (WORLD_WIDTH - 1) * 2 + (WORLD_HEIGHT - 1) * 2; // moving around the world
		numberOfActs += 4; // Number of rotations
		numberOfActs += 2; // Number of expected eatings 
		for(int i=0; i <  numberOfActs; i++){
			WorldHelper.runOneLoop();
		}
		
		/**
		 * VERIFY
		 */
		verify(mocks.toArray(new Object[0]));
	}
	
	/**
	 * Expect moves around the world
	 * (worldWidth -1) * 2 + (worldHeight - 1) * 2 + 4 calls to move() will be made
	 * @param worldWidth World's width
	 * @param worldHeight World's height
	 * @param mockMoveBehaviour IMoveBehaviour's mock
	 */
	private void expectMoveAroundTheWorld(int worldWidth, int worldHeight, IMoveBehaviour mockMoveBehaviour){
		// move south
		for(int y=1; y < worldHeight; y++){
			expect(mockMoveBehaviour.move((Move)anyObject()))
				.andReturn(new Move(CardinalPoint.SOUTH, new Coordinates(0, y)));
		}
		// rotate east
		expect(mockMoveBehaviour.move((Move)anyObject()))
			.andReturn(new Move(CardinalPoint.EAST, new Coordinates(0, worldHeight-1)));

		// move east
		for(int x=1; x < worldWidth; x++){
			expect(mockMoveBehaviour.move((Move)anyObject()))
				.andReturn(new Move(CardinalPoint.EAST, new Coordinates(x, worldHeight-1)));
		}
		// rotate north
		expect(mockMoveBehaviour.move((Move)anyObject()))
			.andReturn(new Move(CardinalPoint.NORTH, new Coordinates(worldWidth-1, worldHeight-1)));

		// move north
		for(int y=worldHeight-2; y >= 0; y--){
			expect(mockMoveBehaviour.move((Move)anyObject()))
				.andReturn(new Move(CardinalPoint.NORTH, new Coordinates(worldWidth-1, y)));
		}
		// rotate west
		expect(mockMoveBehaviour.move((Move)anyObject()))
			.andReturn(new Move(CardinalPoint.WEST, new Coordinates(worldWidth-1, 0)));

		// move west
		for(int x=worldWidth-2; x >= 0; x--){
			expect(mockMoveBehaviour.move((Move)anyObject()))
				.andReturn(new Move(CardinalPoint.WEST, new Coordinates(x, 0)));
		}
		// rotate east
		expect(mockMoveBehaviour.move((Move)anyObject()))
			.andReturn(new Move(CardinalPoint.WEST, new Coordinates(0, 0)));
	}
}
