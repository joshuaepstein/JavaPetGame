/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.pets;

import uk.co.joshepstein.food.Food;

public interface Pet {

	PetType getType();

	String getName();

	int getHealth();

	boolean feed(Food food);

}
