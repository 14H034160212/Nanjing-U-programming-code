package com.Qiming;

public class TestEqual {
public static void main(String[] args) {
	int [] arr = new int[] {10,11};
	//arr[0] = 1;
	int a = 1;
	arr[0] = a = 2;
	System.out.println(arr[0]+" "+arr[1]);
}
}
