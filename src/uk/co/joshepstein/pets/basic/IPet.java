/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.pets.basic;

import uk.co.joshepstein.food.Food;

public interface IPet {

	String getName();

	int getHealth();

	int getMaxHealth();

	boolean feed(Food food);

	PetTier getTier();

	PetTicker getTicker();

}
