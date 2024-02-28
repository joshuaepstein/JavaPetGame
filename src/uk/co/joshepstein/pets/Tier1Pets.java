/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.pets;

import uk.co.joshepstein.pets.basic.Pet;
import uk.co.joshepstein.pets.tier1.Ant;

public enum Tier1Pets {

	ANT(Ant.class),
	;

	private Class<? extends Pet> petClass;

	Tier1Pets(Class<? extends Pet> petClass) {
		this.petClass = petClass;
	}

	public Class<? extends Pet> getPetClass() {
		return petClass;
	}

	public static Tier1Pets getTier1Pet(Class<? extends Pet> petClass) {
		for (Tier1Pets tier1Pet : values()) {
			if (tier1Pet.getPetClass().equals(petClass)) {
				return tier1Pet;
			}
		}
		return null;
	}

	public static void loadAllTextures() {
		for (Tier1Pets tier1Pet : values()) {
			try {
				tier1Pet.getPetClass().getDeclaredConstructor().newInstance().loadTexture();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
