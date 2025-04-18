package com.main.lutemon12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonAdapter extends RecyclerView.Adapter<LutemonAdapter.ViewHolder> {
    private ArrayList<Lutemon> lutemons;

    // 适配器构造函数
    public LutemonAdapter(ArrayList<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    // 创建 ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lutemon, parent, false);

        return new ViewHolder(view);
    }

    // 绑定数据到列表项
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.textName.setText(lutemon.getName());
        holder.textColor.setText("颜色: " + lutemon.getColor());
        holder.textLevel.setText("等级: " + lutemon.getExperience());
        holder.textHP.setText("生命值: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());

        // 根据颜色设置图标
        switch (lutemon.getColor()) {
            case "红色":
                holder.imageLutemon.setImageResource(R.drawable.ic_lutemon_red);
                break;
            case "蓝色":
                holder.imageLutemon.setImageResource(R.drawable.ic_lutemon_blue);
                break;
            case "白色":
                holder.imageLutemon.setImageResource(R.drawable.ic_lutemon_white);
                break;
            case "绿色":
                holder.imageLutemon.setImageResource(R.drawable.ic_lutemon_green);
                break;
            case "粉色":
                holder.imageLutemon.setImageResource(R.drawable.ic_lutemon_pink);
                break;
            case "橙色":
                holder.imageLutemon.setImageResource(R.drawable.ic_lutemon_orange);
                break;
            case "黑色":
                holder.imageLutemon.setImageResource(R.drawable.ic_lutemon_black);
                break;
            default:
                holder.imageLutemon.setImageResource(R.drawable.ic_lutemon_default);
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    // ViewHolder 类
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageLutemon;
        TextView textName, textColor, textLevel, textHP;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageLutemon = itemView.findViewById(R.id.imageLutemon);
            textName = itemView.findViewById(R.id.textName);
            textColor = itemView.findViewById(R.id.textColor);
            textLevel = itemView.findViewById(R.id.textLevel);
            textHP = itemView.findViewById(R.id.textHP);
        }
    }
}
