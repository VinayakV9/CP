package codechef.practice.tctctoe;
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Set;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder result = new StringBuilder();
		
		while(t-->0) {
			char[][] arr = new char[3][];
			arr[0] = br.readLine().toCharArray();
			arr[1] = br.readLine().toCharArray();
			arr[2] = br.readLine().toCharArray();
			
			System.out.println(solve(arr));
		}
	}
	
	public static int solve(char[][] grid) {
		if(!isValidCount(grid)) {
			return 3;
		}
		
		boolean isWinnerFound = false;
		boolean isColWinnerFound = false;
		int count = 0;
		for(int i = 0 ; i < 3; i++) {
			boolean foundWinner = isRowEq(grid, i);
			if( isWinnerFound && foundWinner) {
				return 3;
			}
			if(foundWinner) {
				count++;
			}
			isWinnerFound = isWinnerFound || foundWinner;
		}
		for(int i = 0 ; i < 3; i++) {
			boolean foundWinner = isColEq(grid, i);
			if( isColWinnerFound && foundWinner) {
				return 3;
			}
			if(foundWinner) {
				count++;
			}
			isColWinnerFound = isColWinnerFound || foundWinner;
		}

		isWinnerFound = isWinnerFound || isColWinnerFound;
		
		int diagonalCount = 0;
		if( isDiagona1Eq(grid) ) {
			diagonalCount++;
		}
		if( isDiagona2Eq(grid) ) {
			diagonalCount++;
		} 
		
		if( count >= 2 && diagonalCount > 0 ) {
			return 3;
		} else if( count > 0 && diagonalCount > 1) { 
			return 3;
		}
		else if (diagonalCount > 0 ) {
			isWinnerFound = true;
		}
		
		boolean isEmptyTilePresent = tilePresent(grid);
		
		if( isWinnerFound || !isEmptyTilePresent) {
			return 1;
		} else {
			return 2;
		}
	}
	
	private static boolean tilePresent(char[][] grid) {
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] == '_') {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isRowEq(char[][] grid, int i) {
		return grid[i][0] != '_' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2];
	}
	
	public static boolean isColEq(char[][] grid, int j) {
		return grid[0][j] != '_' && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j];
	}
	
	public static boolean isDiagona1Eq(char[][] grid) {
		return grid[1][1] != '_' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2];
	}
	
	public static boolean isDiagona2Eq(char[][] grid) {
		return grid[1][1] != '_' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0];
	}
	
	public static int countSymbol(char[][] grid, char c) {
		int count =0;
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] == c) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean isValidCount(char[][] grid) {
		int xCount = countSymbol(grid, 'X');
		int oCount = countSymbol(grid, 'O');
		
		if( xCount == oCount || xCount == (oCount+1)) {
			return true;
		} else {
			return false;
		}
	}
}
