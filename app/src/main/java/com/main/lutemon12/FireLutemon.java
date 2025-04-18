package com.main.lutemon12;

public class FireLutemon extends Lutemon {
    public FireLutemon(String name) {
        super(name, "红色", 8, 2, 15); // 参数：名称、颜色、攻击、防御、最大生命值
    }

    @Override
    public void specialAbility() {
        // 实现特殊技能（暂时留空）
    }
}