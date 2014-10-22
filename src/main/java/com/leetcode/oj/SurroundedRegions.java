/**
 * Source : http://oj.leetcode.com/problems/surrounded-regions
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 1.Refer.:
 * 从外围'0'入口DFS遍历，将没有遍历到的'0'change成'X'
 */
package com.leetcode.oj;

public class SurroundedRegions {
    public static void solve(char[][] board) {
    	if (0 == board.length || 0 == board[0].length) {
    		return;
    	}
        int high = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[high][width];
        for (int i = 0; i < high; i++) {
        	if ('O' == board[i][0]) {visited[i][0] = true;}
        	if ('O' == board[i][width - 1]) {visited[i][width - 1] = true;}
        }
        for (int i = 0; i < width; i++) {
        	if ('O' == board[0][i]) {visited[0][i] = true;}
        	if ('O' == board[high - 1][i]) {visited[high - 1][i] = true;}
        }
        
        for (int i = 0; i < high; i++) {
        	if (visited[i][0]) {traversal(board, visited, i, 0);}
        	if (visited[i][width - 1]) {traversal(board, visited, i, width - 1);}
        }
        for (int i = 0; i < width; i++) {
        	if (visited[0][i]) {traversal(board, visited, 0, i);}
        	if (visited[high - 1][i]) {traversal(board, visited, high - 1, i);}
        }
        
        for (int i = 0; i < high; i++) {
        	for (int j = 0; j < width; j++) {
        		if (!visited[i][j] && 'O' == board[i][j]) {
        			board[i][j] = 'X';
        		}
        	}
        }
    }
    
    public static void traversal(char[][] board, boolean[][] visited, int i, int j) {
        int high = board.length;
        int width = board[0].length;
        if (i - 1 > 0 && !visited[i - 1][j] && 'O' == board[i - 1][j]) {
        	visited[i - 1][j] = true;
        	traversal(board, visited, i - 1, j);
        }
        if (i + 1 < high && !visited[i + 1][j] && 'O' == board[i + 1][j]) {
        	visited[i + 1][j] = true;
        	traversal(board, visited, i + 1, j);
        }
        if (j - 1 > 0 && !visited[i][j - 1] && 'O' == board[i][j - 1]) {
        	visited[i][j - 1] = true;
        	traversal(board, visited, i, j - 1);
        }
        if (j + 1 < width && !visited[i][j + 1] && 'O' == board[i][j + 1]) {
        	visited[i][j + 1] = true;
        	traversal(board, visited, i, j + 1);
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {};
		solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
