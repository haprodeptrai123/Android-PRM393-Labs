package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
private ArrayList<User> user;
private RecyclerView mUser;
private UserApdater mUserApdater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mUser= findViewById(R.id.userRecycler);
        user = new ArrayList<>();
        createUserList();
        mUserApdater= new UserApdater(this,user);
        mUser.setAdapter(mUserApdater);
        mUser.setLayoutManager(new LinearLayoutManager(this));
    }

    private void createUserList() {
        user.add(new User("hatran123","Ha Tran", "IOS",R.drawable.a));
        user.add(new User("longtran123","Long123", "Android",R.drawable.a));


    }
}