package com.main.lutemon12;

public class PinkLutemon extends Lutemon {
    public PinkLutemon(int id, String name) {
        super(id, name, "粉色", 7, 2, 18, 7);
    }

    @Override
    public void specialAbility() {
        // 粉色特殊能力：提升攻击
        this.attack += 1;
    }
}