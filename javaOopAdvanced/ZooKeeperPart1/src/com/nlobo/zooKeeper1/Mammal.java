package com.nlobo.zooKeeper1;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public void displayEnergyLevel() {
		System.out.println(energyLevel);
	}
}
