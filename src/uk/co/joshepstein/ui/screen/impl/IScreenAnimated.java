/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.ui.screen.impl;

public interface IScreenAnimated extends IScreen {

	void play();

	void pause();

	void stop();

	void onAnimationComplete();

}
