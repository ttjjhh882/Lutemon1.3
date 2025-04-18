package com.main.lutemon12;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static Storage instance;
    private HashMap<Integer, Lutemon> lutemonsMap = new HashMap<>(); // 使用 HashMap
    private ArrayList<Lutemon> lutemons = new ArrayList<>();     // 用于 RecyclerView
    private static int nextId = 1; // 自增 ID 生成器


    private Storage() {}



    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public static int getNextId() {
        return nextId;
    }
    // 添加 Lutemon
    public void addLutemon(Lutemon lutemon) {
        lutemon.setId(nextId); // 分配唯一 ID（假设 Lutemon 有 setId 方法）
        lutemonsMap.put(nextId, lutemon);
        lutemons.add(lutemon); // 保持与 ArrayList 同步
        nextId++;
    }




    // 获取所有 Lutemon 列表
    public ArrayList<Lutemon> getAllLutemons() {
        return lutemons;
    }

    public void updateLutemon(Lutemon updatedLutemon) {
        // 通过ID更新HashMap
        lutemonsMap.put(updatedLutemon.getId(), updatedLutemon);

        // 更新ArrayList
        for (int i = 0; i < lutemons.size(); i++) {
            if (lutemons.get(i).getId() == updatedLutemon.getId()) {
                lutemons.set(i, updatedLutemon);
                break;
            }
        }
    }
    public void removeLutemon(int id) {
        lutemonsMap.remove(id);
        for (int i = 0; i < lutemons.size(); i++) {
            if (lutemons.get(i).getId() == id) {
                lutemons.remove(i);
                break;
            }
        }
    }
}
