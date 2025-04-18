package com.main.lutemon12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class LutemonDetailDialog extends DialogFragment {
    public interface OnDeleteListener {
        void onDeleteConfirmed(int lutemonId);
    }

    private final Lutemon lutemon;
    private final OnDeleteListener deleteListener;

    public LutemonDetailDialog(Lutemon lutemon, OnDeleteListener listener) {
        this.lutemon = lutemon;
        this.deleteListener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_lutemon_detail, null);

        // 初始化视图
        ImageView imgAvatar = view.findViewById(R.id.imgAvatar);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtAttack = view.findViewById(R.id.txtAttack);
        TextView txtDefense = view.findViewById(R.id.txtDefense);
        TextView txtHealth = view.findViewById(R.id.txtHealth);

        // 设置数据
        imgAvatar.setImageResource(getAvatarResource(lutemon.getColor()));
        txtName.setText(lutemon.getName());
        txtAttack.setText("攻击: " + lutemon.getCurrentAttack());
        txtDefense.setText("防御: " + lutemon.getDefense());
        txtHealth.setText("生命: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());

        // 删除按钮逻辑
        view.findViewById(R.id.btnDelete).setOnClickListener(v -> showDeleteConfirmation());

        builder.setView(view);
        return builder.create();
    }

    private int getAvatarResource(String color) {
        switch (color) {
            case "红色":
                return R.drawable.ic_lutemon_red;
            case "蓝色":
                return R.drawable.ic_lutemon_blue;
            case "白色":
                return R.drawable.ic_lutemon_white;
            case "绿色":
                return R.drawable.ic_lutemon_green;
            case "粉色":
                return R.drawable.ic_lutemon_pink;
            case "橙色":
                return R.drawable.ic_lutemon_orange;
            case "黑色":
                return R.drawable.ic_lutemon_black;
            default:
                return R.drawable.ic_lutemon_default; // 默认图标
        }
    }

    private void showDeleteConfirmation() {
        new AlertDialog.Builder(getContext())
                .setTitle("删除确认")
                .setMessage("确定要删除" + lutemon.getName() + "吗？")
                .setPositiveButton("删除", (dialog, which) -> {
                    if (deleteListener != null) {
                        deleteListener.onDeleteConfirmed(lutemon.getId());
                    }
                    dismiss();
                })
                .setNegativeButton("取消", null)
                .show();
    }
}
