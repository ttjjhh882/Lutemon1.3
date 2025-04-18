package com.main.lutemon12;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static Storage instance;
    private ArrayList<Lutemon> lutemons = new ArrayList<>(); // 使用 ArrayList 方便遍历

    private Storage() {}

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    // 添加 Lutemon
    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    // 获取所有 Lutemon 列表
    public ArrayList<Lutemon> getAllLutemons() {
        return lutemons;
    }
}
