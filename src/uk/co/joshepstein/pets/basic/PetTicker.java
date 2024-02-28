/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.pets.basic;

// PetTicker should be a class with the methods which are used to tick a pet, it should include something to store the pet as well as a apply chance abilities function
public interface PetTicker {

	/**
	 * @implNote Should be used to apply chance abilities
	 * @apiNote This method should be called every time the pet is ticked, it should apply any chance abilities to the pet
	 */
	void applyChanceAbilities(long currentTick);

	IPet getPet();

	void tick(long ticks);

}
