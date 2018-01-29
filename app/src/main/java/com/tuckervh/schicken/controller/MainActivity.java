package com.tuckervh.schicken.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;

import com.tuckervh.schicken.R;
import com.tuckervh.schicken.model.Conversation;
import com.tuckervh.schicken.model.Message;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Conversation> conversationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        prepareConversationList();

        // specify an adapter (see also next example)
        mAdapter = new ConversationAdapter(conversationList);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mRecyclerView.setAdapter(mAdapter);
    }

    private void prepareConversationList() {
        conversationList.add(new Conversation("Will Crawford", "WC", new Message("Test")));
        conversationList.add(new Conversation("Tucker VH", "TV", new Message("Test123")));
        Conversation filler = new Conversation("Filler Convo", "FC",
                new Message("Words that are really long so they take up more than one line!!!"));

        for (int i = 0; i < 1; i++) {
            conversationList.add(filler);
        }
        conversationList.add(new Conversation(
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
                Integer.toString(CommonDataKinds.Phone.TYPE_HOME),
                new Message("Etc")));

    }

}
