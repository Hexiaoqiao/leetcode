package com.leetcode.oj;

public class SortColors {
    public static void sortColors(int[] A) {
    	int zindex = 0;
        int tindex = A.length - 1;
        int i = 0;
        while (i < A.length && 0 == A[i]) {
        	zindex = zindex + 1;
        	i = i + 1;
        }
        i = A.length - 1;
        while (i >= 0 && 2 == A[i]) {
        	tindex = tindex - 1;
        	i = i - 1;
        }
        if (tindex <= zindex) return;
        for (i = zindex; i <= tindex;) {
        	if (2 == A[i] && 0 == A[tindex]) {
        		A[zindex] = 0; A[tindex] = 2; 
        		if (i != zindex && i != tindex) A[i] = 1;
        		while (zindex < A.length && 0 == A[zindex]) zindex = zindex + 1;
        		while (tindex >= 0 && 2 == A[tindex]) tindex = tindex - 1;
        	} else if (2 == A[i]) {
        		A[tindex] = 2; 
        		if (i != tindex) A[i] = 1;
        		while (tindex >= 0 && 2 == A[tindex]) tindex = tindex - 1;
        	} else if (0 == A[i]) {
        		A[zindex] = 0; 
        		if (i != zindex) A[i] = 1;
        		while (zindex < A.length && 0 == A[zindex]) zindex = zindex + 1;
        	}
        	if (zindex > i) {
        		i = zindex;
        	} else {
        		i++;
        	}
        }
/*        for (i = zindex; i <= tindex; i++) {
        	A[i] = 1;
        }*/
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,2,0};
		sortColors(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
