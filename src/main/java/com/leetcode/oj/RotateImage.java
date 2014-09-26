package com.leetcode.oj;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
        	for (int j = i; j < matrix[i].length - i - 1; j++) {
        		int temp = matrix[j][matrix.length - i - 1];
        		
        		matrix[j][matrix.length - i - 1] = matrix[i][j];
        		
        		int t = matrix[matrix.length - i - 1][matrix.length - j - 1];
        		
        		matrix[matrix.length - i - 1][matrix.length - j - 1] = temp;
        		
        		temp = matrix[matrix.length - j - 1][i];
        		
        		matrix[matrix.length - j - 1][i] = t;
        		
        		matrix[i][j] = temp;
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
