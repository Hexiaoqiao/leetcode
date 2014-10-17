/*
0.Problem:
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent 
cell, where "adjacent" cells are those horizontally or vertically 
neighboring. The same letter cell may not be used more than once.

For example,
Given board =
[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

1.Refer.:DFS深度优先遍历
从字符数组中的每一个位置为入口进行深度优先遍历
*/
package com.leetcode.oj;

public class WordSearch {
	public static boolean dfs(char[][] board, String word, int i, int j, int n, boolean[][] used) {
		if (n == word.length()) return true;
		int r = board.length;
		int c = board[0].length;
		boolean ret = false;
		if (i < r && i >= 0 && j < c && j >= 0) {
			if (!used[i][j] && board[i][j] == word.charAt(n)) {
				used[i][j] = true;
				if (dfs(board, word, i + 1, j, n + 1, used)) ret = true;
				else if (dfs(board, word, i - 1, j, n + 1, used)) ret = true;
				else if (dfs(board, word, i, j - 1, n + 1, used)) ret = true;
				else if (dfs(board, word, i, j + 1, n + 1, used)) ret = true;
				used[i][j] = false;
			}
		}
		return ret;
	}
    public static boolean exist(char[][] board, String word) {
    	if (null == word || 0 == word.length()) return true; 
    	if (null == board || 0 == board.length) return false; 
    	int r = board.length;
    	int c = board[0].length;
        boolean[][] used = new boolean[r][c];
        for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++) {
        		if (dfs(board, word, i, j, 0, used)) return true; 
        	}
        }
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word1 = "ABCCED";
		String word2 = "SEE";
		String word3 = "ABCB";
		String word4 = "";
		System.out.println(exist(board, word1));
		System.out.println(exist(board, word2));
		System.out.println(exist(board, word3));
		System.out.println(exist(board, word4));
	}
}