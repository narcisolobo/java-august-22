package com.nlobo;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}

	public int displayEnergyLevel() {
		System.out.println(energyLevel);
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
