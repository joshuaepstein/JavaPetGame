/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.utils;

public class RandomHelper {

	public static int between(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

}
