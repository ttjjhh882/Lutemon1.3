package com.main.lutemon12;

public class WaterLutemon extends Lutemon {
    public WaterLutemon(int id, String name) {
        super(id, name, "蓝色", 5, 5, 20, 5); // 参数：名称、颜色、攻击、防御、最大生命值
    }

    @Override
    public void specialAbility() {
        // 实现水属性特殊技能（例如恢复生命值）
        this.health += 3; // 每次触发技能恢复3点生命值
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
}
