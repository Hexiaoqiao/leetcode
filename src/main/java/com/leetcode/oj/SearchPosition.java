package com.leetcode.oj;

public class SearchPosition {
    public static int searchInsert(int[] A, int target) {
    	if (null == A || 0 == A.length) return 0;
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
        	int mid = (low + high)/2;
        	if (A[mid] == target) return mid;
        	else if (A[mid] < target) low = mid + 1;
        	else if (A[mid] > target) high = mid - 1; 
        }
    	return A[low] < target ? low + 1 : low;
    }
    
    public static int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
    	if (null == A || 0 == A.length) return res;
    	int index = 0;
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
        	int mid = (low + high)/2;
        	if (A[mid] == target) {
        		index = mid;
        		while(index >= 0 && A[index] == target) {index = index - 1;}
        		res[0] = index + 1;
        		index = mid;
        		while(index < A.length && A[index] == target) {index = index + 1;}
        		res[1] = index - 1;
        		return res;
        	}
        	else if (A[mid] < target) low = mid + 1;
        	else if (A[mid] > target) high = mid - 1; 
        }
    	return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5, 7, 7, 8, 8, 10};
		int target = 10;
		int[] res = searchRange(A, target);
		System.out.println(res[0] + "," + res[1]);
	}

}
