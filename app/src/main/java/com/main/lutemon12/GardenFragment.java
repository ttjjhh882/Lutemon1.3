package com.main.lutemon12;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class GardenFragment extends Fragment {
    private RecyclerView recyclerView;
    private LutemonAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_garden, container, false);

        // 初始化 RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewGarden);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 获取数据并设置适配器
        ArrayList<Lutemon> lutemons = Storage.getInstance().getAllLutemons();
        adapter = new LutemonAdapter(lutemons);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fabAdd = view.findViewById(R.id.fabAddLutemon);
        fabAdd.setOnClickListener(v -> showCreateLutemonDialog());
    }

    private void showCreateLutemonDialog() {
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_create_lutemon, null);
        EditText editName = dialogView.findViewById(R.id.editName);
        Button btnColorRed = dialogView.findViewById(R.id.btnColorRed);
        Button btnColorBlue = dialogView.findViewById(R.id.btnColorBlue);
        Button btnColorWhite = dialogView.findViewById(R.id.btnColorWhite);
        Button btnColorGreen = dialogView.findViewById(R.id.btnColorGreen);
        Button btnColorPink = dialogView.findViewById(R.id.btnColorPink);
        Button btnColorOrange = dialogView.findViewById(R.id.btnColorOrange);
        Button btnColorBlack = dialogView.findViewById(R.id.btnColorBlack);

        AtomicReference<String> selectedColor = new AtomicReference<>("");

        // 统一颜色选择监听器
        View.OnClickListener colorClickListener = v -> {
            resetAllColorButtons(dialogView); // 重置所有按钮样式
            if (v.getId() == R.id.btnColorRed) {
                selectedColor.set("红色");
                btnColorRed.setBackgroundResource(R.drawable.bg_selected_color);
            } else if (v.getId() == R.id.btnColorBlue) {
                selectedColor.set("蓝色");
                btnColorBlue.setBackgroundResource(R.drawable.bg_selected_color);
            } else if (v.getId() == R.id.btnColorWhite) {
                selectedColor.set("白色");
                btnColorWhite.setBackgroundResource(R.drawable.bg_selected_color);
            } else if (v.getId() == R.id.btnColorGreen) {
                selectedColor.set("绿色");
                btnColorGreen.setBackgroundResource(R.drawable.bg_selected_color);
            } else if (v.getId() == R.id.btnColorPink) {
                selectedColor.set("粉色");
                btnColorPink.setBackgroundResource(R.drawable.bg_selected_color);
            } else if (v.getId() == R.id.btnColorOrange) {
                selectedColor.set("橙色");
                btnColorOrange.setBackgroundResource(R.drawable.bg_selected_color);
            } else if (v.getId() == R.id.btnColorBlack) {
                selectedColor.set("黑色");
                btnColorBlack.setBackgroundResource(R.drawable.bg_selected_color);
            }
        };

        // 绑定监听器
        btnColorRed.setOnClickListener(colorClickListener);
        btnColorBlue.setOnClickListener(colorClickListener);
        btnColorWhite.setOnClickListener(colorClickListener);
        btnColorGreen.setOnClickListener(colorClickListener);
        btnColorPink.setOnClickListener(colorClickListener);
        btnColorOrange.setOnClickListener(colorClickListener);
        btnColorBlack.setOnClickListener(colorClickListener);

        // 创建对话框
        AlertDialog dialog = new AlertDialog.Builder(requireContext())
                .setTitle("创建新的Lutemon")
                .setView(dialogView)
                .setPositiveButton("确定", (dialogInterface, which) -> {
                    String name = editName.getText().toString().trim();
                    String color = selectedColor.get();

                    if (name.isEmpty() || color.isEmpty()) {
                        Toast.makeText(getContext(), "请输入名称并选择颜色", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Lutemon newLutemon;
                    switch (color) {
                        case "红色":
                            newLutemon = new FireLutemon(name);
                            break;
                        case "蓝色":
                            newLutemon = new WaterLutemon(name);
                            break;
                        case "白色":
                            newLutemon = new WhiteLutemon(name);
                            break;
                        case "绿色":
                            newLutemon = new GreenLutemon(name);
                            break;
                        case "粉色":
                            newLutemon = new PinkLutemon(name);
                            break;
                        case "橙色":
                            newLutemon = new OrangeLutemon(name);
                            break;
                        case "黑色":
                            newLutemon = new BlackLutemon(name);
                            break;
                        default:
                            newLutemon = new FireLutemon(name);
                    }

                    Storage.getInstance().addLutemon(newLutemon);
                    adapter.notifyItemInserted(adapter.getItemCount() - 1);
                })
                .setNegativeButton("取消", null)
                .create();
        dialog.show();
    }

    // 重置所有颜色按钮的样式
    private void resetAllColorButtons(View dialogView) {
        // 通过传入的 dialogView 查找按钮
        int[] colorButtonIds = {
                R.id.btnColorRed, R.id.btnColorBlue,
                R.id.btnColorWhite, R.id.btnColorGreen,
                R.id.btnColorPink, R.id.btnColorOrange,
                R.id.btnColorBlack
        };
        for (int id : colorButtonIds) {
            Button btn = dialogView.findViewById(id);
            btn.setBackground(null);
        }
    }


    // 当数据变化时刷新列表（例如返回家园页面时）
    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
