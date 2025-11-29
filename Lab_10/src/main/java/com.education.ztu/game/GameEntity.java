/**
 * Represents a game entity with attributes such as name, level, health, and weapon.
 * Implements the Serializable interface to allow the object to be serialized,
 * while excluding the health attribute from serialization using the transient keyword.
 */
package com.education.ztu.game;

import java.io.Serializable;

public class GameEntity implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during serialization

    private String name;       // Name of the game entity
    private int level;         // Level of the game entity
    private transient int health; // Health of the game entity (not serialized)
    private String weapon;     // Weapon used by the game entity

    /**
     * Constructs a GameEntity object with the specified attributes.
     *
     * @param name   the name of the entity
     * @param level  the level of the entity
     * @param health the health of the entity (not serialized)
     * @param weapon the weapon of the entity
     */
    public GameEntity(String name, int level, int health, String weapon) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.weapon = weapon;
    }

    /**
     * Returns a string representation of the GameEntity object.
     *
     * @return a string containing the entity's attributes
     */
    @Override
    public String toString() {
        return "GameEntity{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", health=" + health +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
