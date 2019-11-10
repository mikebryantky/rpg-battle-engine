package com.millcreeksoftware.battle;

import com.millcreeksoftware.battle.character.actor.Character;
import com.millcreeksoftware.battle.character.characterclass.CharacterClass;
import com.millcreeksoftware.battle.character.characterclass.Mage;
import com.millcreeksoftware.battle.character.characterclass.Marksman;
import com.millcreeksoftware.battle.character.characterclass.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BattleTest {

    @Test
    void createRandomMonster() {
        Character monster = new Battle().createMonster();
        assertTrue(monster != null);
    }

    @Test
    void createMageMonster() {
        Character mage = new Battle().createMonster(Battle.MAGE);
        assertTrue(mage.getActorClass().getName().equals("Mage"));
    }

    @Test
    void createMarksmanMonster() {
        Character marksman = new Battle().createMonster(Battle.MARKSMAN);
        assertTrue(marksman.getActorClass().getName().equals("Marksman"));
    }

    @Test
    void createWarriorMonster() {
        Character warrior = new Battle().createMonster(Battle.WARRIOR);
        assertTrue(warrior.getActorClass().getName().equals("Warrior"));
    }

    @Test
    void alwaysAWinner() {
        Battle battle = new Battle();
        Character winner = battle.doBattle();

        assertTrue(winner != null);
    }

    @Test
    void strongestWins() {
        Battle battle = new Battle();

        CharacterClass heroClazz = new Mage();
        Character hero = new Character("The Mighty " + heroClazz.getName(), 1, 1, 1, 1,
                1, 1, heroClazz);

        Character monster = new Character("The Monster " + heroClazz.getName(), 100, 100, 100, 100,
                100, 100, heroClazz);

        Character winner = battle.doBattle(hero, monster);

        assertEquals(winner.getName(), monster.getName());
    }

    @Test
    void weaklingMageLoses() {
        Battle battle = new Battle();

        CharacterClass heroClazz = new Mage();
        Character hero = new Character("The Mighty " + heroClazz.getName(), 1, 1, 1, 1,
                1, 1, heroClazz);

        Character monster = battle.createMonster();

        Character winner = battle.doBattle(hero, monster);

        assertEquals(winner.getName(), monster.getName());
    }

    @Test
    void weaklingWarriorLoses() {
        Battle battle = new Battle();

        CharacterClass heroClazz = new Warrior();
        Character hero = new Character("The Mighty " + heroClazz.getName(), 1, 1, 1, 1,
                1, 1, heroClazz);

        Character monster = battle.createMonster();

        Character winner = battle.doBattle(hero, monster);

        assertEquals(winner.getName(), monster.getName());
    }

    @Test
    void weaklingMarksmanLoses() {
        Battle battle = new Battle();

        CharacterClass heroClazz = new Marksman();
        Character hero = new Character("The Mighty " + heroClazz.getName(), 1, 1, 1, 1,
                1, 1, heroClazz);

        Character monster = battle.createMonster();

        Character winner = battle.doBattle(hero, monster);

        assertEquals(winner.getName(), monster.getName());
    }
}
