package com.millcreeksoftware.battle.character.actor;

import com.millcreeksoftware.battle.character.characterclass.CharacterClass;
import com.millcreeksoftware.battle.character.characterclass.Warrior;
import com.millcreeksoftware.battle.util.Logger;

public class Character {
	
	/**
	 * The name of the character.
	 */
	protected String name;
	
	/**
	 * Life. When hp is zero or less, character dies.
	 */
	protected int hp;
	
	/**
	 * How strong a character is. Main stat for Warrior.
	 */
	protected int strength;
	
	/**
	 * Nimbleness of character. Main stat for Marksman.
	 */
	protected int agility;
	
	/**
	 * How smart the character is. Main stat for Mage.
	 */
	protected int intelligence;
	
	/**
	 * Used to determine order of attack.
	 */
	protected int initiative;
	
	/**
	 * Ability to parry, dodge, etc. 
	 */
	protected int defense;
	
	/**
	 * If a hit is sustained, this determines the amount (if any)
	 * reduced from the attacker's damage roll. Default is 
	 * zero plus any class modifiers.
	 */
	protected int armor;
	
	/**
	 * The type of character, such as Mage, Warrior, etc.
	 */
	protected CharacterClass characterClass;
	
	
	
	public Character(String name, int hp, int strength, int agility,
			int intelligence, int initiative, int defense, CharacterClass characterClass) {
		
		super();
		this.name = name;
		
		if(characterClass == null) {
			characterClass = new Warrior();
		} else {
			this.characterClass = characterClass;
		}
		
		this.hp = hp + characterClass.getHpModifier();
		this.strength = strength + characterClass.getStrengthModifier();
		this.agility = agility + characterClass.getAgilityModifier();
		this.intelligence = intelligence + characterClass.getIntelligenceModifier();
		this.initiative = initiative + characterClass.getInitiativeModifier();
		this.defense = defense + characterClass.getDefenseModifier();
		this.armor = characterClass.getArmorModifier();
	}
	
	
	/**
	 * Gets the value for this attribute that this character uses for attacks.
	 * 
	 * @return Strength for Warriors, Intelligence for Mages, etc.
	 */
	public int getAttack() {
		int attack = 0;
		
		if("Strength".equals(this.characterClass.getAttackAttribute())) {
			attack = this.strength;
		} else if("Agility".equals(this.characterClass.getAttackAttribute())) {
			attack = this.agility;
		} else if("Intelligence".equals(this.characterClass.getAttackAttribute())) {
			attack = this.intelligence;
		}
		
		return attack;
	}
	
	public void takeDamage(Character fromActor, int damage) {
		if(damage < 1) {
			return;
		}
		
		this.hp = this.hp - damage;
		Logger.log(this.name + " took " + damage + " damage from " + fromActor.getName() + ". HP is now " + this.hp);
		
		if(this.hp <= 0) {
			this.die();
		}
	}
	
	protected void die(Character fromActor) {
		Logger.log(this.name + " died at the hands of " + fromActor.getName() + ".");
	}
	
	protected void die() {
		Logger.log(this.name + " died.");
	}
	
	public boolean isAlive() {
		return this.hp > 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getArmor() {
		return armor;
	}

	public CharacterClass getActorClass() {
		return characterClass;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", hp=" + hp + ", strength=" + strength
				+ ", agility=" + agility + ", intelligence=" + intelligence
				+ ", initiative=" + initiative + ", defense=" + defense
				+ ", armor=" + armor + ", characterClass=" + characterClass + "]";
	}
	
}
