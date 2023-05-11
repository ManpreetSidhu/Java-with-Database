// Created on April,2023 by Manpreet Kaur Sidhu
// Main activity loads when app started
package com.example.assignment6sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lvAgents;
    Button btnAdd;
    AgentDB agentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            lvAgents = findViewById(R.id.listviewagents);
            btnAdd = findViewById(R.id.btnAdd);
            agentDB = new AgentDB(this);

        // for detail activity pass control
        lvAgents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("agent",(Agent)lvAgents.getAdapter().getItem(position));
                intent.putExtra("mode","edit");
                startActivity(intent);
            }
        });
        // if Add button Clicked
         btnAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                 intent.putExtra("mode","add");
                 startActivity(intent);
             }
         });
    }
      // on start and resume call the LoadAgents method to load data in a listview
        @Override
        protected void onStart() {
            super.onStart();
            LoadAgents();
        }
        @Override
        protected void onResume() {
            super.onResume();
            LoadAgents();
        }
       // method get the data of all agents frm database
        private void LoadAgents() {
            ArrayAdapter<Agent> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,agentDB.getAllAgents());
            // read data from the database and load adapter
            lvAgents.setAdapter(adapter);
        }
}