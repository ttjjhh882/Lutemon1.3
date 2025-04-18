package com.main.lutemon12;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// TrainingAdapter.java
public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.ViewHolder> {
    private ArrayList<Lutemon> lutemons;
    private Context context;

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
    public TrainingAdapter(ArrayList<Lutemon> lutemons, Context context) {
        this.lutemons = lutemons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_training, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
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

        holder.textName.setText(lutemon.getName());
        holder.textAttack.setText("攻击: " + lutemon.getCurrentAttack()); // 显示动态攻击力
        holder.textDefense.setText("防御: " + lutemon.getDefense());
        holder.textHealth.setText("生命: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());
        holder.textExperience.setText("经验值: " + lutemon.getExperience()); // 显示经验值

//        holder.btnTrain.setOnClickListener(v -> {
//            String attribute = lutemon.train(); // 执行训练（经验值+1，随机属性+1）
//            Storage.getInstance().updateLutemon(lutemon);
//
//            // 更新 UI
//            holder.textAttack.setText("攻击: " + lutemon.getCurrentAttack());
//            holder.textDefense.setText("防御: " + lutemon.getDefense());
//            holder.textHealth.setText("生命: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());
//            holder.textExperience.setText("经验值: " + lutemon.getExperience());
//
//            // 显示提升的属性
//            Toast.makeText(context,
//                    lutemon.getName() + " 训练完成！\n经验值+1，" + attribute + "+1",
//                    Toast.LENGTH_SHORT).show();
//        });
        holder.btnTrain.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.train_sound).start();

            // 显示训练对话框
            TrainingDialog dialog = new TrainingDialog();
            dialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "training_dialog");

            // 异步执行训练逻辑
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                String attribute = lutemon.train();
                Storage.getInstance().updateLutemon(lutemon);

                // 更新UI
                notifyItemChanged(position);
                Toast.makeText(context, "训练完成！" + attribute + "+1",
                        Toast.LENGTH_SHORT).show();
            }, 2500); // 与动画同步
        });

    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageLutemon;
        TextView textName, textAttack, textDefense, textHealth, textExperience;
        Button btnTrain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageLutemon = itemView.findViewById(R.id.imageLutemon);
            textName = itemView.findViewById(R.id.textName);
            textAttack = itemView.findViewById(R.id.textAttack);
            textDefense = itemView.findViewById(R.id.textDefense);
            textHealth = itemView.findViewById(R.id.textHealth);
            textExperience = itemView.findViewById(R.id.textExperience);
            btnTrain = itemView.findViewById(R.id.btnTrain);
        }
    }
}
