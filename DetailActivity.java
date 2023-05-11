
// Created on April,2023 by Manpreet Kaur Sidhu
// Activity that set data in a edittextfields if mode is edit and get data from field if mode is add
package com.example.assignment6sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    Button btnSave, btnDelete;
    EditText etAgentId, etAgentFirstName, etAgentMiddleIntial, etAgentLastName, etAgentBusPhone,
            etAgentEmail,etAgentPosition,etAgentAgencyId;
    Agent agent;
    AgentDB agentDB;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        etAgentId=findViewById(R.id.etAgentid);
        etAgentFirstName = findViewById(R.id.etAgtFirstName);
        etAgentMiddleIntial =findViewById(R.id.etAgtMiddleIntial);
        etAgentLastName = findViewById(R.id.etAgtLastName);
        etAgentBusPhone = findViewById(R.id.etAgtPhone);
        etAgentEmail = findViewById(R.id.etAgtEmail);
        etAgentPosition = findViewById(R.id.etAgtPosition);
        etAgentAgencyId = findViewById(R.id.etAgtAgencyId);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        agentDB = new AgentDB(this);

        Intent intent = getIntent();
        mode=intent.getStringExtra("mode");
        if(mode.equals("edit"))
        {
            agent = (Agent) intent.getSerializableExtra("agent");
            etAgentId.setText(agent.getAgentId()+"");
            etAgentId.setEnabled(false);
            etAgentFirstName.setText(agent.getAgtFirstName());
            etAgentMiddleIntial.setText(agent.getAgtMiddleIntial());
            etAgentLastName.setText(agent.getAgtLastName());
            etAgentBusPhone.setText(agent.getAgtBusPhone());
            etAgentPosition.setText(agent.getAgtPosition());
            etAgentEmail.setText(agent.getAgtEmail());
            etAgentAgencyId.setText(agent.getAgencyId()+"");
            btnDelete.setEnabled(true);

        }
       else
       {
         btnDelete.setEnabled(false);
           etAgentId.setEnabled(false);
        }
       // when save button clicked data added or updated in a database
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode.equals("add"))
                {
                    agentDB.InsertAgents(new Agent(0,etAgentFirstName.getText().toString(),etAgentMiddleIntial.getText().toString(),etAgentLastName.getText().toString(),
                            etAgentBusPhone.getText().toString(),etAgentEmail.getText().toString(),
                            etAgentPosition.getText().toString(),Integer.parseInt(etAgentAgencyId.getText().toString())));
                }
                else {
                    agentDB.UpdateAgents(new Agent(Integer.parseInt(etAgentId.getText().toString()),etAgentFirstName.getText().toString(),etAgentMiddleIntial.getText().toString(),etAgentLastName.getText().toString(),
                            etAgentBusPhone.getText().toString(),etAgentEmail.getText().toString(),
                            etAgentPosition.getText().toString(),Integer.parseInt(etAgentAgencyId.getText().toString())));
                }
            }
        });
       // when delete button clicked call the delete method to delete data from database
       btnDelete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               agentDB.DeleteAgents(Integer.parseInt(etAgentId.getText().toString()));
           }
       });
    }
}