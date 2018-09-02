package com.example;

/**
 * @author Daniele Pasquini
 *
 */
public class CharacterSheet {

	private String name;
	private String playerName;
	private String alignment;
	private Integer level;
	private Integer hp;
	private Integer[] strength;
	private Integer[] dexterity;
	private Integer[] constitution;
	private Integer[] intelligence;
	private Integer[] wisdom;
	private Integer[] charisma;
	private String race;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the player name
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @param playerName the player name
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return alignment;
	}
	/**
	 * @param alignment the alignment
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level
	 */
	/**
	 * @param level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @return the hp
	 */
	public Integer getHp() {
		return hp;
	}
	/**
	 * @param hp the hp
	 */
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	/**
	 * @return the array with [value, modifier] for strength
	 */
	public Integer[] getStrength() {
		return strength;
	}
	/**
	 * @param strength the array with [value, modifier] for strength
	 */
	public void setStrength(Integer[] strength) {
		this.strength = strength;
	}
	/**
	 * @return the array with [value, modifier] for dexterity
	 */
	public Integer[] getDexterity() {
		return dexterity;
	}
	/**
	 * @param dexterity the array with [value, modifier] for dexterity
	 */
	public void setDexterity(Integer[] dexterity) {
		this.dexterity = dexterity;
	}
	/**
	 * @return the array with [value, modifier] for constitution
	 */
	public Integer[] getConstitution() {
		return constitution;
	}
	/**
	 * @param constitution the array with [value, modifier] for constitution
	 */
	public void setConstitution(Integer[] constitution) {
		this.constitution = constitution;
	}
	/**
	 * @return the array with [value, modifier] for intelligence
	 */
	public Integer[] getIntelligence() {
		return intelligence;
	}
	/**
	 * @param intelligence the array with [value, modifier] for intelligence
	 */
	public void setIntelligence(Integer[] intelligence) {
		this.intelligence = intelligence;
	}
	/**
	 * @return the array with [value, modifier] for wisdom
	 */
	public Integer[] getWisdom() {
		return wisdom;
	}
	/**
	 * @param wisdom the array with [value, modifier] for wisdom
	 */
	public void setWisdom(Integer[] wisdom) {
		this.wisdom = wisdom;
	}
	/**
	 * @return the array with [value, modifier] for charisma
	 */
	public Integer[] getCharisma() {
		return charisma;
	}
	/**
	 * @param charisma the array with [value, modifier] for charisma
	 */
	public void setCharisma(Integer[] charisma) {
		this.charisma = charisma;
	}
	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}
	/**
	 * @param race the race
	 */
	public void setRace(String race) {
		this.race = race;
	}
}
