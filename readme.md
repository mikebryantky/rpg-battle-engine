### RPG Battle Engine

[![Codeship Status for mikebryantky/rpg-battle-engine](https://app.codeship.com/projects/aff7a5f0-e620-0137-084e-72596f44bac9/status?branch=master)](https://app.codeship.com/projects/373565)

This is a *very* basic start for a role-playing battle engine.  To call it anything more than a rough proof of concept/playground idea would be overkill.

Really, this was some code I had lying around from a few years ago when I spent an evening toying with some ideas to write an RPG game.

Use it for whatever you might think it's worth.

There are three classes: Mage, Marksman, and Warrior.   

Attributes:

    * strength
	* agility
	* intelligence
	* initiative
	* defense
	* armor
	
	
Each class has a modifier (+/-) to various attributes. For example, a Warrior might get +2 to Strength and +2 to armor.

## Next Steps
# Equipment 
Equipment with attribute modifiers.

Questions to consider:
1. Should equipment types be restricted to certain classes (should heavy armor be available only to Warriors, or instead require a minimum strength level to equip?)
2. Equipment classes: *Armor* (Type: cloth, leather, plate and Locations: head, body, legs, feet, etc.), *Weapon* (Types: mele, ranged, magic and one hand/two hand), Trinket (necklace, ring, book, etc.)
3. Should equipemnt have weight to allow for encumbrance, attack speed, etc.  Of course, Strength would be a factor in terms of how much this would affect the character.

# Leveling
1. Allow actor to spend X points for each level in attributes of their choice?

# Attributes
1. Consider adding Luck as an attribute. This would alter all other attributes (+/-) depending on how 'lukcy' the character is at the moment.

# Buff/Debuff
1. Determine buff/debuff mechanisms that can be used. Different types could be time-based, per-encounter, daily, permanent.

