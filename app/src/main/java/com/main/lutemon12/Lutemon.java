package com.main.lutemon12;

public abstract class Lutemon {
    public String name;
    public String color;
    public int attack;
    public int defense;
    public int maxHealth;
    public int health;
    public int experience;

    public Lutemon(String name, String color, int attack, int defense, int maxHealth) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.experience = 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // 公共方法：训练、攻击、恢复等
    public abstract void specialAbility(); // 抽象方法（多态）

    public void train() {
        experience++;
        attack += 1; // 每次训练攻击+1
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void restoreHealth() {
        health = maxHealth;
    }


}


