package amazon;

// start time: 5:30pm
// end time:   6:40pm

// complexity O(1)

// assumptions:
// values are between 1 to 9

/*
5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 
Sudoku is valid

5 3 4 6 7 8 8 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 
Invalid row: 1
Invalid col: 7
Invalid sub-grid: 3
Sudoku is invalid

5 3 4 6 7 8 8 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 5 8 6 1 7 9 
Invalid row: 1
Invalid row: 9
Invalid col: 4
Invalid col: 7
Invalid sub-grid: 3
Invalid sub-grid: 8
Sudoku is invalid

 */
import java.util.HashSet;
import java.util.Set;

public class EventsSudoku {

	private static boolean isValid(int[][] in) {
		Set<Integer> s1;
		Set<Integer> s2;
		Set<Integer> s3;
		boolean r = true;
		
		for (int i = 0; i < 9; i++) {
			s1 = build();
			s2 = build();
			s3 = build();
			for (int j = 0; j < 9; j++) {
				// validate rows
				s1.remove(new Integer(in[i][j]));
				// validate columns
				s2.remove(new Integer(in[j][i]));
				// validate sub-grids
				s3.remove(new Integer(in[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)]));
			}
			if (s1.size() != 0) {
				System.out.println("Invalid row: " + (i + 1));
				r = false;
			}
			if (s2.size() != 0) {
				System.out.println("Invalid col: " + (i + 1));
				r = false;
			}
			if (s3.size() != 0) {
				System.out.println("Invalid sub-grid: " + (i + 1));
				r = false;
			}
		}
		
		return r;
	}
	
	// build 1-9 set for validation
	private static Set<Integer> build() {
		Set<Integer> s;
		s = new HashSet<Integer>();
		for (int j = 0; j < 9; j++) {
			s.add(new Integer(j + 1));
		}
		return s;
	}
	
	// print out sudoku
	public static void print(int[][] in) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(in[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] c = {
			{5, 3, 4, 6, 7, 8, 9, 1, 2},
			{6, 7, 2, 1, 9, 5, 3, 4, 8},
			{1, 9, 8, 3, 4, 2, 5, 6, 7},
			{8, 5, 9, 7, 6, 1, 4, 2, 3},
			{4, 2, 6, 8, 5, 3, 7, 9, 1},
			{7, 1, 3, 9, 2, 4, 8, 5, 6},
			{9, 6, 1, 5, 3, 7, 2, 8, 4},
			{2, 8, 7, 4, 1, 9, 6, 3, 5},
			{3, 4, 5, 2, 8, 6, 1, 7, 9}
		};

		int[][] w = {
			{5, 3, 4, 6, 7, 8, 8, 1, 2},
			{6, 7, 2, 1, 9, 5, 3, 4, 8},
			{1, 9, 8, 3, 4, 2, 5, 6, 7},
			{8, 5, 9, 7, 6, 1, 4, 2, 3},
			{4, 2, 6, 8, 5, 3, 7, 9, 1},
			{7, 1, 3, 9, 2, 4, 8, 5, 6},
			{9, 6, 1, 5, 3, 7, 2, 8, 4},
			{2, 8, 7, 4, 1, 9, 6, 3, 5},
			{3, 4, 5, 2, 8, 6, 1, 7, 9}
		};
		
		int[][] m = {
			{5, 3, 4, 6, 7, 8, 8, 1, 2},
			{6, 7, 2, 1, 9, 5, 3, 4, 8},
			{1, 9, 8, 3, 4, 2, 5, 6, 7},
			{8, 5, 9, 7, 6, 1, 4, 2, 3},
			{4, 2, 6, 8, 5, 3, 7, 9, 1},
			{7, 1, 3, 9, 2, 4, 8, 5, 6},
			{9, 6, 1, 5, 3, 7, 2, 8, 4},
			{2, 8, 7, 4, 1, 9, 6, 3, 5},
			{3, 4, 5, 5, 8, 6, 1, 7, 9}
		};
			
		print(c);
		System.out.println(isValid(c) ? "Sudoku is valid" : "Sudoku is invalid");
		System.out.println();
		
		print(w);
		System.out.println(isValid(w) ? "Sudoku is valid" : "Sudoku is invalid");
		System.out.println();

		print(m);
		System.out.println(isValid(m) ? "Sudoku is valid" : "Sudoku is invalid");
		System.out.println();

}

}
