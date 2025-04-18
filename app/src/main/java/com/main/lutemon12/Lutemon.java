package com.main.lutemon12;

import java.util.Random;

public abstract class Lutemon {
    public int id;
    public String name;
    public String color;
    public int attack;
    public int defense;
    public int maxHealth;
    public int health;
    public int experience;
    private int baseAttack;

    public Lutemon(int id, String name, String color, int attack, int defense, int maxHealth, int baseAttack) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.experience = 0;
        this.baseAttack = baseAttack;

    }
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void restoreHealth() {
        health = maxHealth;
    }

    public int getCurrentAttack() {
        return baseAttack + experience;
    }

    public int getBaseAttack() { return baseAttack; }
    public int getDefense() { return defense; }

    // 训练方法
    public String train() {
        Random random = new Random();
        int attributeIndex = random.nextInt(3); // 0:攻击, 1:防御, 2:生命
        String attributeName = "";

        switch (attributeIndex) {
            case 0:
                baseAttack += 1;
                experience += 1;
                attributeName = "攻击力";
                break;
            case 1:
                defense += 1;
                experience += 1;
                attributeName = "防御力";
                break;
            case 2:
                maxHealth += 1;
                health = Math.min(health + 1, maxHealth); // 生命值同步增加
                experience += 1;
                attributeName = "最大生命值";
                break;
        }

        return attributeName;
    }

}


