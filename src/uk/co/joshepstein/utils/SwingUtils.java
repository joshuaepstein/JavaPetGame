/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.utils;

import javax.swing.*;
import java.awt.*;

public class SwingUtils {

	public static Pair<JFrame, JPanel> setup(JFrame root, JPanel panelRoot) {
		root = new JFrame();
		root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		root.setSize(1920/2, 1080/2);
		root.setResizable(false);
		root.setTitle("Super Auto Pets 2.0 - Joshua Epstein");
		panelRoot = new JPanel();
		root.add(panelRoot);
		root.setVisible(true);
		return new Pair<>(root, panelRoot);
	}

}
