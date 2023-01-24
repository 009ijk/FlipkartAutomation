package com.org.base;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;

public class BasicProgram {

	public static void main(String[] args) throws ParseException {

		// Call the method for character occurence count
		// characterRepeatation();
		// stringRepeatation();

		// firstsCharCapital();
		// Reverse the each word

		// reverseWord();

		// toGGLE();
		// reverseString();
		// dateConvertion();
		// numberRepeation();
		// apSeries();
		// removeDuplicateValues();
		// readOnlyListCreation();
		// pyramindStructure();
		// pyramidNumericReverse();
		// multipleCatchBlock();
		//selectLargest();
		// rotateArray(4);
	
	}

	public static void rotateArray(int num) {
		// Input:N = 9
//		 Scanner sc = new Scanner(System.in);
//		 sc.nextLine();
//		 
//		 int input = 
		int A[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };

//			 for(int a: A)
//			 {
//				
//			 }

		// K = 10Output: 5
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == 1) {
				System.out.println("Value of i" + i);
			}

			else {
				System.out.println("Not found");
			}
		}

	}

	public static void selectLargest() {
		int b[] = { 44, 66, 99, 77, 33, 22, 55 };
		int k = b.length;

		int temp;

		for (int i = 0; i < k; i++)

		{
			for (int j = i + 1; j < k; j++)

			{
				if (b[i] > b[j]) {
					temp = b[i];
					b[i] = b[j];
					b[j] = temp;
				}
			}
		}
		System.out.println(b[k - 2]);
	}

	public static void shellowDeepCopy() {
		int length = 3;
		int breadth = 5;

	}

	public static void multipleCatchBlock() {
		try {
			int i = 10;
			// int j=i/0;
			int[] ru = { 1, 2 };
			System.out.println(ru[4]);
		} catch (ArithmeticException e) {
			System.out.println("AE");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("OutBound");
		}
	}

	public static void pyramidNumericReverse() {
		int row = 6;

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			for (int j = i; j <= row; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void pyramindStructure() {
		int n = 10;
		for (int i = 0; i < n; i++) {
			for (int j = n - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}

	public static void readOnlyListCreation() {
		List<String> readOnlyString = new ArrayList<>();
		readOnlyString.add("Java");
		readOnlyString.add("Python");

		List unmodifiedable = Collections.unmodifiableList(readOnlyString);

		// unmodifiedable.add("C");

		System.out.println(readOnlyString);
		System.out.println(unmodifiedable);

	}

	// Remove Duplicate values
	public static void removeDuplicateValues() {
		int[] numbers = { 1, 2, 6, 3, 9, 10 };

		List<Integer> listnumbers = new ArrayList<>();

		// Adding all values in arrayList

		for (int number : numbers) {
			listnumbers.add(number);
		}

		System.out.println(listnumbers);
		Collections.reverse(listnumbers);

		System.out.println("Reverse" + listnumbers);

		// Convert the List into the Set

		Set<Integer> numberSet = new HashSet<Integer>();

		numberSet.addAll(listnumbers);

		// Printing the Set from the list
		System.out.println(numberSet);

		// Clear the above created list.
		listnumbers.clear();

		// Add the set items to the list.
		listnumbers.addAll(numberSet);

		// Printing the list items
		System.out.println(listnumbers);

	}

	// Method to find occurence of any character.
	public static void characterRepeatation() throws IOException {
		String s = "Inderjeeti";
		String s1 = s.toLowerCase();

		char[] strArray = s1.toCharArray();

		HashMap<Character, Integer> hashMap = new HashMap();

		// checking each char of string
		for (char a : strArray) {

			if (hashMap.containsKey(a)) {
				// if character is present in charCountMap
				// incrementing it's count by 1
				hashMap.put(a, hashMap.get(a) + 1);

			}

			else
				// If char is not present in charCounting,
				// Putting this char to HashMap with as it's value
				hashMap.put(a, 1);

		}

		System.out.println(hashMap);

	}

	// How to get the first non-repeating character from a string
	public static void stringRepeatation() {
		String s = "inderjeeti";

		char[] strArray = s.toCharArray();

		for (int i = 0; i < strArray.length - 1; i++) {
			// System.out.print(c);
			for (int j = 0; j < i; j++)
				if (strArray[j] == strArray[i]) {
					System.out.println("Equal D :" + strArray[j] + ": C" + strArray[i]);
				}
		}
	}

	public static void firstsCharCapital() {

		String s = "New game with the new team welcome to the party ";

		String[] s1 = s.split("\\s");
		String sentence = "";
		for (String s2 : s1) {
			// System.out.println(s2);
			String first = s2.substring(0, 1);
			String remainString = s2.substring(1);

			sentence += first.toUpperCase() + remainString.toLowerCase() + " ";
			// System.out.println(sentence);

		}

		System.out.println(sentence);

	}

	public static void reverseWord() {
		String reverseWord = "We got the new sentence";

		String[] reWord = reverseWord.split("\\s");
		for (String sr : reWord) {
			char[] chararr = sr.toCharArray();

			for (int i = chararr.length - 1; i >= 0; i--) {
				System.out.print(chararr[i]);
			}
			System.out.print(" ");
//			StringBuilder sb = new StringBuilder(sr);
//
//			sb.reverse();
//			System.out.print(sb + " ");
		}
		// System.out.println(sb);
	}

	// First word is small and rest of the words are capital
	public static void toGGLE() {
		String inputString = "New way to right the toggle words";

		String[] arrayString = inputString.split("\\s");
		String outputString = "";

		for (String toggleString : arrayString) {
			String firstChar = toggleString.substring(0, 1);
			String restChar = toggleString.substring(1);

			outputString += firstChar.toLowerCase() + restChar.toUpperCase() + " ";

		}

		System.out.println(outputString);

	}

	public static void reverseString() {
		String ss = "Using the for loop reverse the string";

		String[] ssf = ss.split("\\s");

		for (String sa : ssf) {

			char[] ch = sa.toCharArray();
			for (int i = ch.length - 1; i >= 0; i--) {

				System.out.print(ch[i]);
			}
			System.out.print(" ");

		}
	}

	// Simple convert the date
	public static void dateConvertion() throws ParseException {
		String sDate = "31/06/2023";
		Date date = null;

		try {
			date = new SimpleDateFormat("dd/MM/YYYY").parse(sDate);
		}

		catch (ParseException e) {
			System.out.println("Parse Error getting the wrong value");
		}
		// throw new ParseException("Getting parse exception");

		System.out.println(date);
	}

	// find the repeating integer values

	public static void numberRepeation() {

		String str = "new delgi is herer";

		char[] chararr = str.toCharArray();

		HashMap<Character, Integer> hashMap = new HashMap<>();

		for (char c : chararr) {
			if (hashMap.containsKey(c))
				hashMap.put(c, hashMap.get(c) + 1);

			else
				hashMap.put(c, 1);
		}

		System.out.println(hashMap);
	}

	// print the 1,3,5
	// 1,3
	// 1

	public static void apSeries() {

		for (int i = 15; i > 0; i = i - 2) {
			for (int j = 1; j <= i; j = j + 2) {
				System.out.print(j + " ");
			}
			System.out.println(" ");
		}
	}
}
