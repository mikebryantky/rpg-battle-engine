package com.millcreeksoftware.battle.character.characterclass;

public abstract class CharacterClass {
	
	protected String name;
	
	protected int hpModifier;
	
	protected int strengthModifier;
	
	protected int agilityModifier;
	
	protected int intelligenceModifier;
	
	protected int initiativeModifier;
	
	protected int defenseModifier;

	protected int armorModifier;
	
	/**
	 * Which of Strength, Intelligence, or Agility this
	 * class uses to fight.
	 */
	protected String attackAttribute;

	

	public String getName() {
		return name;
	}

	public int getHpModifier() {
		return hpModifier;
	}

	public int getStrengthModifier() {
		return strengthModifier;
	}

	public int getAgilityModifier() {
		return agilityModifier;
	}

	public int getIntelligenceModifier() {
		return intelligenceModifier;
	}

	public int getInitiativeModifier() {
		return initiativeModifier;
	}

	public int getDefenseModifier() {
		return defenseModifier;
	}

	public String getAttackAttribute() {
		return attackAttribute;
	}

	public int getArmorModifier() {
		return armorModifier;
	}

	@Override
	public String toString() {
		return "CharacterClass [name=" + name + ", hpModifier=" + hpModifier
				+ ", strengthModifier=" + strengthModifier
				+ ", agilityModifier=" + agilityModifier
				+ ", intelligenceModifier=" + intelligenceModifier
				+ ", initiativeModifier=" + initiativeModifier
				+ ", defenseModifier=" + defenseModifier + ", armorModifier="
				+ armorModifier + ", attackAttribute=" + attackAttribute + "]";
	}
	
}
