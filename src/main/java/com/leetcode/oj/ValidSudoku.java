package com.leetcode.oj;

public class ValidSudoku {
	
    public static boolean isValidSudoku(char[][] board) {
        boolean[] map = new boolean[10];
    	for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if ('.' != board[i][j]) {
        			if (map[board[i][j] - '0']) return false;
        			else map[board[i][j] - '0'] = true;
        		}
        	}
        	for (int j = 0; j < 10; j++) {
        		map[j] = false;
        	}
        }
    	for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if ('.' != board[j][i]) {
        			if (map[board[j][i] - '0']) return false;
        			else map[board[j][i] - '0'] = true;
        		}
        	}
        	for (int j = 0; j < 10; j++) {
        		map[j] = false;
        	}
        }
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			for (int k = 0; k < 3; k++) {
    				for (int l = 0; l < 3; l++) {
    					if ('.' != board[i*3+k][j*3+l]) {
    						if (map[board[i*3+k][j*3+l] - '0']) return false;
    						else map[board[i*3+k][j*3+l] - '0'] = true; 
    					}
    				}
    			}
            	for (int k = 0; k < 10; k++) {
            		map[k] = false;
            	}
    		}
    	}
    	return true;
    }
    
    public static boolean innersolveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length; j++) {
        		if ('.' == board[i][j]) {
        			for (int k = 0; k < 9; k++) {
        				board[i][j] = (char) ('1' + k);
        				if (isValidSudoku(board)) {
        					if (innersolveSudoku(board)) return true; 
        				}
        				board[i][j] = '.';
        			}
        			return false;
        		}
        	}
        }
        return true;
    }
    
    public static void solveSudoku(char[][] board) {
    	innersolveSudoku(board);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
