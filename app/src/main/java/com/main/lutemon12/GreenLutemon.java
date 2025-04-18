package com.main.lutemon12;

public class GreenLutemon extends Lutemon {
    public GreenLutemon(int id, String name) {
        super(id, name, "绿色", 6, 3, 19,6);
    }

    @Override
    public void specialAbility() {
        // 绿色特殊能力：恢复生命值
        this.health += 2;
        if (this.health > this.maxHealth) this.health = this.maxHealth;
    }
}