package com.tuckervh.schicken.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tuckervh.schicken.R;

public class ConversationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getIntent().getExtras().getString("name", "dafuq"));
        setContentView(R.layout.activity_conversation);
    }
}
