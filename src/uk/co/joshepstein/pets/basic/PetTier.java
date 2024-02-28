/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.pets.basic;

public enum PetTier {

	ONE(1, "Tier 1", 0.8, 3),
	;

	private int tier;
	private String displayName;
	private double chance;
	private int maxAbilities;

	PetTier(int tier, String displayName, double chance, int maxAbilities) {
		this.tier = tier;
		this.displayName = displayName;
		this.chance = chance;
		this.maxAbilities = maxAbilities;
	}

}
