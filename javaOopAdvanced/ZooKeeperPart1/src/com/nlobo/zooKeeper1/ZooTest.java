package com.nlobo.zooKeeper1;

public class ZooTest {
	
	public static void main(String[] args) {
		Gorilla gorilla = new Gorilla();
		gorilla.throwSomething(); // "look out..."
		gorilla.throwSomething(); // "look out..."
		gorilla.throwSomething(); // "look out..."

		gorilla.eatBananas(); // yep
		gorilla.eatBananas(); // yep
		
		gorilla.climb(); // "climbing"
		
		gorilla.displayEnergyLevel(); // 95
	}
}
