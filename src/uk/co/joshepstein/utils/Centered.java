/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.utils;

import javax.swing.*;

public class Centered {

	public static int width(JPanel panel, int width) {
		return (panel.getWidth()/2) - (width/2);
	}

	public static int height(JPanel panel, int height) {
		return (panel.getHeight()/2) - (height/2);
	}
}
