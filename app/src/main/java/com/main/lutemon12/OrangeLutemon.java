package com.main.lutemon12;

public class OrangeLutemon extends Lutemon {
    public OrangeLutemon(String name) {
        super(name, "橙色", 8, 1, 17);
    }

    @Override
    public void specialAbility() {
        // 橙色特殊能力：爆发伤害
        this.attack *= 1.5;
    }
}