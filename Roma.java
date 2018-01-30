package com.Nanjing;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

/*
 * There are seven roma characters which are I V X L C D M represent 1 5 10 50 100 500 1000 respectively.
 * The algorithm need to satisfy two rules
 * 1.Calculation rule:
 * 	  1.1 the same character connection will be the plus operation
 *        like III = 3;
 *    1.2 smaller number before the larger number means the larger number minus the smaller number
 *        like IV = 4;
 *    1.3 smaller number after the larger number means the larger number plus the smaller number
 *        like VI = 6;
 * 2.Group rule:
 *    2.1 from the basic character I, X, C, self-connection number or after the larger number cannot more than three.
 *    2.2 while before the larger number can only have one position. 
 * the transferred decimal number is ranging from 1~3999.
 */
public class Roma {
public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	while(s.hasNext()) {
		String str = s.nextLine();
		Roma r = new Roma();
		int n = r.convert(str);
		if(n!=0) {
			System.out.println(n);
		}
		else {
			System.out.println("This is an error input");
		}
	}
	
}
public int convert(String string) {

	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	hm.put("I", 1);
	hm.put("V", 5);
	hm.put("X", 10);
	hm.put("L", 50);
	hm.put("C", 100);
	hm.put("D", 500);
	hm.put("M", 1000);
	int answer=0;
	//int temp = Integer.parseInt(string);
	if(compare(string)==1) {
		return 0;
	}
	
	Vector<Integer> v = new Vector<Integer>();
	for(int i=0;i<string.length();i++) {
		v.add(hm.get(String.valueOf(string.charAt(i))));
		
	}
	int max=0;
	for(Integer i:v) {
		if(i>max) {
			max=i;
		}
	}
	int index = v.indexOf(max);
	int count_left=0;
	for(int i=0;i<index;i++) {
		
		if(string.charAt(i)=='I'||string.charAt(i)=='X'||string.charAt(i)=='C') {
			count_left++;
		}
		if(count_left>1) {
			return 0;
		}
	}
	int count_right=0;
	for(int i=index;i<string.length();i++) {
		
		if(string.charAt(i)=='I'||string.charAt(i)=='X'||string.charAt(i)=='C') {
			count_right++;
		}
		if(count_right>3) {
			return 0;
		}
	}
	
	int addFlag = 0;
	for(int i=string.length()-1;i>=1;i--) {
		if(hm.get(String.valueOf(string.charAt(i)))>hm.get(String.valueOf(string.charAt(i-1)))) {
			answer=answer+(hm.get(String.valueOf(string.charAt(i)))-hm.get(String.valueOf(string.charAt(i-1))));
		}
		if(hm.get(String.valueOf(string.charAt(i)))<hm.get(String.valueOf(string.charAt(i-1)))) {
			answer=answer+(hm.get(String.valueOf(string.charAt(i)))+hm.get(String.valueOf(string.charAt(i-1))));
		}
		if(hm.get(String.valueOf(string.charAt(i)))==hm.get(String.valueOf(string.charAt(i-1)))) {
			addFlag++;
			
		}
	}
	
	if(addFlag!=0) {
		answer=(addFlag+1)*hm.get(String.valueOf(string.charAt(0)));
	}
	
	if(answer>=1&&answer<=3999) {
		return answer;
	}
	else {
		return 0;
	}
	
}

public static int compare(String string) {
	int[] compare = new int[10];
	for(int i=0;i<string.length();i++) {
		compare[i]=string.charAt(i); 
	}
	int num=0;
	for(int i=0;i<string.length()-1;i++) {
		if(compare[i]==compare[i+1]) {
			num++;
		}
	}
	if(num+1>3&&num==string.length()-1&&(string.charAt(0)=='I'||string.charAt(0)=='X'||string.charAt(0)=='C')) {
		return 1;
	}
	else {
		return 0;	
	}
	
}
}
