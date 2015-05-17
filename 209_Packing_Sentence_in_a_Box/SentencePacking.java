package com.magnus.stackoverflow;

import java.util.Arrays;
import java.util.Collections;

public class SentencePacking {

	static String[][] box;

	static void printRow(String[] row) {
		for (String i : row) {
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
	}

	static void fillUpBox(String sentence) {
		boolean reverse = false;

		for (int y=0; y < box.length; y++) {

			for (int i=0; i < box[y].length; i++) {

				if (sentence.length() > 0) {
					box[y][i] = sentence.substring(0, 1);
				} else {
					return;
				}
				sentence = sentence.substring(1);
			}

			if (reverse) {
				Collections.reverse(Arrays.asList(box[y]));
			}
			reverse = !reverse;
		}
	}

	static void createBox(int length) {

		int height = length / 2;
		int width = height;

		while (length % width != 0) {
			width--;
		}
		while (height * width != length) {
			height--;
		}
		box = new String[height][width];
	}

	public static void main(String[] args) {

		String input = "IT IS RAINING CATS AND DOGS OUT THERE";

		String sentence = input.replaceAll("\\s+","");
		System.out.println("Input length: " + sentence.length());

		createBox(sentence.length());
		fillUpBox(sentence);

		System.out.println("1 1");
		for(String[] row : box) {
			printRow(row);
		}
	}

}
