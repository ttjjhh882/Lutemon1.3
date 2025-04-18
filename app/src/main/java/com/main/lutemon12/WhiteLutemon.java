package com.main.lutemon12;

public class WhiteLutemon extends Lutemon {
    public WhiteLutemon(String name) {
        super(name, "白色", 5, 4, 20);
    }

    @Override
    public void specialAbility() {
        // 白色特殊能力：增加防御
        this.defense += 1;
    }
}