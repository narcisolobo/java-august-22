package com.nlobo.zooKeeper1;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("Look out! The gorilla is about to throw something!!");
		setEnergyLevel(getEnergyLevel() - 5);
	}
	
	public void eatBananas() {
		System.out.println("Yep.");
		setEnergyLevel(getEnergyLevel() + 10);
	}
	
	public void climb() {
		System.out.println("The gorilla is climbing!");
		setEnergyLevel(getEnergyLevel() - 10);
	}
}
