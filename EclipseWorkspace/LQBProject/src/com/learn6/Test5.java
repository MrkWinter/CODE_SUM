package com.learn6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Character, Character> hp = new HashMap<Character, Character>();
		//第一行
		hp.put('1','2');
		hp.put('2','3');
		hp.put('3','4');
		hp.put('4','5');
		hp.put('5','6');
		hp.put('6','7');
		hp.put('7','8');
		hp.put('8','9');
		hp.put('9','0');
		hp.put('0','-');
		hp.put('-','=');
		//第二行
		hp.put('Q','W');
		hp.put('W','E');
		hp.put('E','R');
		hp.put('R','T');
		hp.put('T','Y');
		hp.put('Y','U');
		hp.put('U','I');
		hp.put('I','O');
		hp.put('O','P');
		hp.put('P','[');
		hp.put('[',']');
		hp.put(']','\\');
		//第三行
		hp.put('A','S');
		hp.put('S','D');
		hp.put('D','F');
		hp.put('F','G');
		hp.put('G','H');
		hp.put('H','J');
		hp.put('J','K');
		hp.put('K','L');
		hp.put('L',';');
		hp.put(';','\'');
		//第四行
		hp.put('Z','X');
		hp.put('X','C');
		hp.put('C','V');
		hp.put('V','B');
		hp.put('B','N');
		hp.put('N','M');
		hp.put('M',',');
		hp.put(',','.');
		hp.put('.','/');
		hp.put(' ',' ');	
		
		hp = swapKeyValue(hp);
		while (scanner.hasNext()) {
			char[] arr = scanner.nextLine().toCharArray();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = hp.get(arr[i]);
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
	
    public static <K, V> HashMap<V, K> swapKeyValue(HashMap<K, V> map) {
        HashMap<V, K> swappedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }
        return swappedMap;
    }
}
