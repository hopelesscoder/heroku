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
	public void setLevel(Integer level) {
		this.level = level;
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
