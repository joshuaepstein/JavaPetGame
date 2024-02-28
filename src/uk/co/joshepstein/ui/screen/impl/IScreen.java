/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.ui.screen.impl;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public interface IScreen {

	String getName();

	UUID getId();

	default void onOpen(JFrame frame, JPanel rootPanel) {
		display(frame, rootPanel);
	}

	boolean isLoaded();

	void onClose();

	void onTick(long ticks, JFrame frame, JPanel rootPanel);

	void display(JFrame frame, JPanel rootPanel);

	int getWidth();

	int getHeight();

	default Dimension getDimension() {
		return new Dimension(getWidth(), getHeight());
	}

	default void onResize() {}

	default void onResize(int width, int height) {}

	boolean shouldRemove();

	void setLoaded(boolean loaded);

	void forceOpen(JFrame frame, JPanel rootPanel);

}
