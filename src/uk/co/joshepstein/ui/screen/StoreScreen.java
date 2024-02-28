/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.ui.screen;

import uk.co.joshepstein.pets.basic.Pet;
import uk.co.joshepstein.ui.screen.impl.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.Queue;

public class StoreScreen extends Screen {

	private Queue<Pet> pets;

	public StoreScreen(Queue<Pet> pets) {
		super("Store");
		this.pets = pets;
	}

	@Override
	public void onTick(long ticks, JFrame frame, JPanel rootPanel) {

	}

	@Override
	public void onOpen(JFrame frame, JPanel rootPanel) {
//		super.onOpen(frame, rootPanel);
		System.out.println("StoreScreen.onOpen");
		display(frame, rootPanel);
		this.setLoaded(true);
	}

	@Override
	public void display(JFrame frame, JPanel rootPanel) {
		int x = 20;
		int y = 225;
		for (Pet pet : pets) {
			JLabel label = new JLabel();
			label.setBounds(x, y, 75, 75);
			if (pet == null) {
				label.setIcon(new ImageIcon(new ImageIcon("src/resources/PET_SQUARE-100.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
			} else {
				label.setIcon(new ImageIcon(new ImageIcon(pet.getTexturePath()).getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
			}
			label.setVisible(true);
			label.repaint();
			rootPanel.add(label);
			x += 100;
		}
		JLabel bgLabel = new JLabel(new ImageIcon("src/resources/shop_background.png"));
		bgLabel.setBounds(0, 0, 1920/2, 1080/2);
		rootPanel.add(bgLabel);
		rootPanel.repaint();
	}
}
