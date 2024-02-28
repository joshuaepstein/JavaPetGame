/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.pets.tier1;

import uk.co.joshepstein.food.Food;
import uk.co.joshepstein.pets.basic.IPet;
import uk.co.joshepstein.pets.basic.PetTicker;
import uk.co.joshepstein.pets.basic.PetTier;
import uk.co.joshepstein.pets.basic.PetType;
import uk.co.joshepstein.utils.RandomHelper;

import java.util.Random;

public class Ant implements IPet {

	private int health;
	private int maxHealth;

	public Ant() {
		this.maxHealth = RandomHelper.between(1, 5);
		this.health = maxHealth;
	}

	@Override
	public String getName() {
		return "Ant";
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public boolean feed(Food food) {
		return false;
	}

	@Override
	public PetTier getTier() {
		return PetTier.ONE;
	}

	@Override
	public PetTicker getTicker() {
		return new PetTicker() {
			@Override
			public void applyChanceAbilities(long currentTick) {
			}

			@Override
			public void tick(long ticks) {

			}

			@Override
			public IPet getPet() {
				return Ant.this;
			}
		};
	}

	@Override
	public int getMaxHealth() {
		return maxHealth;
	}
}
