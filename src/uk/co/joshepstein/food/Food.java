package uk.co.joshepstein.food;

import uk.co.joshepstein.pets.basic.IPet;

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

	public abstract void onFeed(IPet pet);
}
