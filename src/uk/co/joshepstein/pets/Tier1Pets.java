/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.pets;

import uk.co.joshepstein.pets.basic.IPet;
import uk.co.joshepstein.pets.tier1.Ant;

public enum Tier1Pets {

	ANT(Ant.class),
	;

	private Class<? extends IPet> petClass;

	Tier1Pets(Class<? extends IPet> petClass) {
		this.petClass = petClass;
	}

	public Class<? extends IPet> getPetClass() {
		return petClass;
	}

	public static Tier1Pets getTier1Pet(Class<? extends IPet> petClass) {
		for (Tier1Pets tier1Pet : values()) {
			if (tier1Pet.getPetClass().equals(petClass)) {
				return tier1Pet;
			}
		}
		return null;
	}

}
