/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.ui.screen.impl;

import uk.co.joshepstein.App;

import javax.swing.*;
import java.util.Queue;
import java.util.UUID;

public abstract class Screen implements IScreen {

	private final String name;
	private final UUID id;
	private boolean loaded = false;
	private int width;
	private int height;
	private boolean shouldRemove = false;

	public Screen(String name) {
		this.name = name;
		this.id = UUID.randomUUID();
		this.width = 1920 / 2;
		this.height = 1080 / 2;
	}

	// Write out the lombok generated getters and setters
	public String getName() {
		return name;
	}

	public UUID getId() {
		return id;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public boolean shouldRemove() {
		return shouldRemove;
	}

	public void setShouldRemove(boolean shouldRemove) {
		this.shouldRemove = shouldRemove;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void onOpen(JFrame frame, JPanel rootPanel) {
		IScreen.super.onOpen(frame, rootPanel);
		setLoaded(true);
	}

	@Override
	public void onClose() {
		setShouldRemove(true);
	}

	@Override
	public void forceOpen(JFrame frame, JPanel rootPanel) {
//		setLoaded(false);
//		onOpen(frame, rootPanel);
		App.getScreens().peek().onClose();
		Queue<IScreen> screens = App.getScreens();
		// add to start of screens
		for (IScreen screen : screens) {
			if (screen.getId().equals(this.getId())) {
				screens.remove(screen);
				break;
			}
		}
	}
}
