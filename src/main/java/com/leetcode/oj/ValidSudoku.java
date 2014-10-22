/**
 * Source : http://oj.leetcode.com/problems/valid-sudoku
 * 			http://oj.leetcode.com/problems/sudoku-solver
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The 
 * Rules (via http://sudoku.com.au/TheRules.aspx).
 * The Sudoku board could be partially filled, where empty cells are 
 * filled with the character '.'.
 * 
 * 0.1
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * 1.Refer.:
 * 1.0 顺序
 * 每行/每列/每3*3内分别进行检查
 * 
 * 1.1 递归
 * 对每一个'.'分别填入'1..9'后应用1.0进行检查，通过后递归填入其他'.'处
 * 
 */
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
