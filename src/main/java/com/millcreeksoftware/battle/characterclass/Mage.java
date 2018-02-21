package com.millcreeksoftware.battle.characterclass;

public class Mage extends CharacterClass {
	
	public Mage() {
		this.name = "Mage";
		
		this.hpModifier = 10;
		this.intelligenceModifier = 3;
		this.armorModifier = -3;
		
		this.attackAttribute = "Intelligence";
	}
	
}
