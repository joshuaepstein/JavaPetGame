/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.pets.tier1;

import uk.co.joshepstein.food.Food;
import uk.co.joshepstein.pets.basic.IPet;
import uk.co.joshepstein.pets.basic.Pet;
import uk.co.joshepstein.pets.basic.PetTicker;
import uk.co.joshepstein.pets.basic.PetTier;
import uk.co.joshepstein.utils.RandomHelper;

import javax.swing.*;
import java.awt.*;

public class Ant extends Pet {

	private int health;
	private int maxHealth;

	private String texturePath = "src/resources/pets/default/ant.png";
	private Image texture = null;

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

	public String getTexturePath() {
		return texturePath;
	}

	public Image getTexture() {
		return texture;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}

	public void setTexturePath(String texturePath) {
		this.texturePath = texturePath;
	}

	public void loadTexture() {
		if (this.texture == null) {
			this.texture = new ImageIcon(this.texturePath).getImage();
			System.out.println("[" + this.getName() + " PET] Loaded texture from [" + this.texturePath + "]");
		} else {
			System.out.println("Texture already loaded");
		}
	}

	@Override
	public Image getOrLoadTexture() {
		if (this.texture == null) {
			this.loadTexture();
		}
		return this.texture;
	}
}
