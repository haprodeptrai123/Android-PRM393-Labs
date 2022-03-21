package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserApdater extends RecyclerView.Adapter<UserApdater.ViewHolder> {
    private ArrayList<User> userList;

    public UserApdater(UserActivity userActivity, ArrayList<User> userList) {
        this.userList = userList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater  layoutInflater= LayoutInflater.from(context);

        View view= layoutInflater.inflate(R.layout.item_user,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user= userList.get(position);
        holder.tvUsername.setText(user.getUsername());
        holder.tvFullname.setText(user.getFullname());
        holder.tvEmail.setText(user.getEmail());
        holder.imgHinh.setImageResource(user.getA());
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvUsername;
        TextView tvFullname;
        TextView tvEmail;
        ImageView imgHinh;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            tvUsername=itemView.findViewById(R.id.tv_username);
            tvFullname=itemView.findViewById(R.id.tv_fullname);
            tvEmail=itemView.findViewById(R.id.tv_email);
            imgHinh=itemView.findViewById(R.id.img_hinh);
        }
    }
}
