package codechef.practice.tctctoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CodechefTest {

	private final static char X = 'X';
	private final static char O = 'O';
	private final static char U = '_';
	
	@Test
	void testSolve() {
		char[][] grid = {
					{X,O,X},
					{X,O,X},
					{X,O,X}};
		
		assertFalse(Codechef.isValidCount(grid));
		assertEquals(Codechef.solve(grid), 3);
	}

	@Test
	void testIsRowEq() {
		char[][] grid = {
				{X,X,X},
				{O,O,X},
				{O,O,X}};
		
		assertTrue(Codechef.isRowEq(grid, 0));
		assertFalse(Codechef.isRowEq(grid, 1));
		assertFalse(Codechef.isRowEq(grid, 2));
		
		char[][] grid2 = {
				{O,O,X},
				{X,X,X},
				{O,O,X}};
		
		assertFalse(Codechef.isRowEq(grid2, 0));
		assertTrue(Codechef.isRowEq(grid2, 1));
		assertFalse(Codechef.isRowEq(grid2, 2));
		
		char[][] grid3 = {
				{O,O,X},
				{O,O,X},
				{X,X,X}};
		
		assertFalse(Codechef.isRowEq(grid3, 0));
		assertFalse(Codechef.isRowEq(grid3, 1));
		assertTrue(Codechef.isRowEq(grid3, 2));
	}

	@Test
	void testIsColEq() {
		char[][] grid = {
				{X,X,X},
				{X,O,O},
				{X,O,O}};
		
		assertTrue(Codechef.isColEq(grid, 0));
		assertFalse(Codechef.isColEq(grid, 1));
		assertFalse(Codechef.isColEq(grid, 2));
		
		char[][] grid2 = {
				{X,X,X},
				{O,X,O},
				{O,X,O}};
		
		assertFalse(Codechef.isColEq(grid2, 0));
		assertTrue(Codechef.isColEq(grid2, 1));
		assertFalse(Codechef.isColEq(grid2, 2));
		
		char[][] grid3 = {
				{O,O,X},
				{X,O,X},
				{O,X,X}};
		
		assertFalse(Codechef.isColEq(grid3, 0));
		assertFalse(Codechef.isColEq(grid3, 1));
		assertTrue(Codechef.isColEq(grid3, 2));
	}

	@Test
	void testIsDiagona1Eq() {
		char[][] grid = {
				{X,O,X},
				{X,X,O},
				{X,O,O}};
		
		assertFalse(Codechef.isDiagona1Eq(grid));
		assertTrue(Codechef.isDiagona2Eq(grid));
		assertEquals(Codechef.solve(grid), 1);
		
		char[][] grid1 = {
				{X,O,X},
				{X,X,O},
				{O,O,X}};
		
		assertTrue(Codechef.isDiagona1Eq(grid1));
		assertFalse(Codechef.isDiagona2Eq(grid1));
		assertEquals(Codechef.solve(grid1), 1);
		
		char[][] grid2 = {
				{X,O,X},
				{O,X,O},
				{X,O,X}};
		
		assertTrue(Codechef.isDiagona1Eq(grid2));
		assertTrue(Codechef.isDiagona2Eq(grid2));
		assertEquals(Codechef.solve(grid2), 1);
	}

	@Test
	void testIsDiagona2Eq() {
	}

	@Test
	void testCountSymbol() {
	}

	@Test
	void testIsValidCount() {
	}

}
