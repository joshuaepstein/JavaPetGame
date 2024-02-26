package uk.co.joshepstein.food;

import uk.co.joshepstein.pets.Pet;

import java.util.function.Supplier;

public abstract class Food {

	private final String name;
	private final int additionalHealth;
	private final int cost;

	public Food(String name, int additionalHealth, int cost) {
		this.name = name;
		this.additionalHealth = additionalHealth;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public int getAdditionalHealth() {
		return additionalHealth;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return name;
	}

	public abstract void onFeed(Pet pet);
}
