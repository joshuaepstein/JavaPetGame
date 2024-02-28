/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.ui.screen;

import uk.co.joshepstein.pets.basic.IPet;
import uk.co.joshepstein.ui.screen.impl.Screen;

import javax.swing.*;
import java.util.Queue;

public class StoreScreen extends Screen {

	private Queue<IPet> pets;

	public StoreScreen() {
		super("Store");
	}

	@Override
	public void onTick(long ticks, JFrame frame, JPanel rootPanel) {

	}

	@Override
	public void onOpen(JFrame frame, JPanel rootPanel) {
		super.onOpen(frame, rootPanel);
	}

	public void onOpen(JFrame frame, JPanel rootPanel, Queue<IPet> pets) {
		super.onOpen(frame, rootPanel);
		this.pets = pets;
	}

	@Override
	public void display(JFrame frame, JPanel rootPanel) {

	}
}
