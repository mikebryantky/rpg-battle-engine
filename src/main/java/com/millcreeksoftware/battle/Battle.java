package com.millcreeksoftware.battle;

import java.util.Random;

import com.millcreeksoftware.battle.actor.Character;
import com.millcreeksoftware.battle.characterclass.CharacterClass;
import com.millcreeksoftware.battle.characterclass.Mage;
import com.millcreeksoftware.battle.characterclass.Marksman;
import com.millcreeksoftware.battle.characterclass.Warrior;
import com.millcreeksoftware.battle.util.Logger;

public class Battle {
	public static final int WARRIOR  = 0;
	public static final int MAGE     = 1;
	public static final int MARKSMAN = 2;
	
	
	public static void main(String[] args) {
		new Battle().doBattle();
	}


    public Character doBattle() {
        // Determine attributes for our hero
        int hp = new Random().nextInt(51) + 100;
        int strength = new Random().nextInt(19) + 1;
        int agility = new Random().nextInt(19) + 1;
        int intelligence = new Random().nextInt(19) + 1;
        int initiative = new Random().nextInt(2) + 1;
        int defense = new Random().nextInt(19) + 1;

        // Create the hero
        CharacterClass heroClazz = getRandomClass();
        Character hero = new Character("The Mighty " + heroClazz.getName(), hp, strength, agility, intelligence, initiative, defense, heroClazz);

        // Create the monster that the hero will battle.
        Character monster = createMonster();

        return doBattle(hero, monster);
    }


    public Character doBattle(Character hero, Character monster) {
        Logger.log("Battle: " + hero.toString() + " vs " + monster.toString());

        // Determine who will attack first.
        Character firstActor = null;
        Character secondActor = null;
        while(firstActor == null) {
            int actor1Roll = new Random().nextInt(19) + 1;
            int actor1InitiativeRoll = actor1Roll + hero.getInitiative();

            int actor2Roll = new Random().nextInt(19) + 1;
            int actor2InitiativeRoll = actor2Roll + monster.getInitiative();

            if(actor1InitiativeRoll > actor2InitiativeRoll) {
                firstActor = hero;
                secondActor = monster;
            } else if(actor1InitiativeRoll < actor2InitiativeRoll) {
                firstActor = monster;
                secondActor = hero;
            }
        }
        Logger.log(firstActor.getName() + " will attack first.");


        // Let the battle begin!
        while(firstActor.isAlive() && secondActor.isAlive()) {
            attack(firstActor, secondActor);
            attack(secondActor, firstActor);
        }

        return firstActor.isAlive() ? firstActor : secondActor;
    }

	
	
	/**
	 * Generate a random monster.
	 * 
	 * @return An <code>Character</code> with a random <code>CharacterClass</code>.
	 */
	public Character createMonster() {
		return createMonster(-1);
	}
	
	
	/**
	 * Generate a monster of the specified <code>CharacterClass</code>.
	 *  
	 * @param type Constant for which class to create.
	 * 
	 * @return An <code>Character</code> with the specified <code>CharacterClass</code>.
	 */
	public Character createMonster(int type) {
		Character monster = null;
		
		int hp = new Random().nextInt(50) + 100;
		int strength = new Random().nextInt(19) + 1;
		int agility = new Random().nextInt(19) + 1;
		int intelligence = new Random().nextInt(19) + 1;
		int initiative = new Random().nextInt(2) + 1;
		int defense = new Random().nextInt(19) + 1;
		
		CharacterClass actorClazz;
		if(type == -1) {
			actorClazz = getRandomClass();
		} else {
			actorClazz = getClassForType(type);
		}
		
		monster = new Character(actorClazz.getName() + " Monster", hp, strength, agility, intelligence, initiative, defense, actorClazz);
		
		return monster;
	}

	
	/**
	 * Attack.
	 * 
	 * @param attacker The <code>Character</code> that attacks.
	 * @param defender The <code>Character</code> that defends the attack.
	 */
	private void attack(Character attacker, Character defender) {
		int attackRoll = new Random().nextInt(19) + 1;
		int attack = attackRoll + attacker.getAttack();
		
		int defenseRoll = new Random().nextInt(19) + 1;
		int defense = defenseRoll + defender.getDefense();
		
		if(attack > defense) {
			// There was a hit, now roll for damage and compare with armor score.
			int damage = new Random().nextInt(19);
			int armor = defender.getArmor();
			
			if(damage > armor) {
				defender.takeDamage(attacker, damage);
			} else {
				Logger.log(attacker.getName() + " hit " + defender.getName() + " but did no damage.");
			}
		} else {
			Logger.log(defender.getName() + " dodged attack from " + attacker.getName());
		}

	}
	
	
	private CharacterClass getClassForType(int type) {
		CharacterClass actorClazz;
		
		switch(type) {
			case WARRIOR:
				actorClazz = new Warrior();
				break;
				
			case MAGE:
				actorClazz = new Mage();
				break;
				
			case MARKSMAN:
				actorClazz = new Marksman();
				break;
				
			default:
				actorClazz = new Warrior();
				break;
		}
		
		return actorClazz;
	}
	
	
	private CharacterClass getRandomClass() {
		return getClassForType(new Random().nextInt(2));
	}

}
