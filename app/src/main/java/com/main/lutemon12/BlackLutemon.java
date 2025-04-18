package com.main.lutemon12;

public class BlackLutemon extends Lutemon {
    public BlackLutemon(String name) {
        super(name, "黑色", 9, 0, 16);
    }

    @Override
    public void specialAbility() {
        // 黑色特殊能力：牺牲防御提升攻击
        this.defense = 0;
        this.attack += 3;
    }
}