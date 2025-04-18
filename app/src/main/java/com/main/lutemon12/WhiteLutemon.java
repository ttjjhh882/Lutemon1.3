package com.main.lutemon12;

public class WhiteLutemon extends Lutemon {
    public WhiteLutemon(int id, String name) {
        super(id, name, "白色", 5, 4, 20, 5);
    }

    @Override
    public void specialAbility() {
        // 白色特殊能力：增加防御
        this.defense += 1;
    }
}