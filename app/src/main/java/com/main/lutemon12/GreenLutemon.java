package com.main.lutemon12;

public class GreenLutemon extends Lutemon {
    public GreenLutemon(String name) {
        super(name, "绿色", 6, 3, 19);
    }

    @Override
    public void specialAbility() {
        // 绿色特殊能力：恢复生命值
        this.health += 2;
        if (this.health > this.maxHealth) this.health = this.maxHealth;
    }
}