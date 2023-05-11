// AgentDB class get all the methods to get data fom database, update data, delete data
//  Created on April,2023 by Manpreet Kaur Sidhu

package com.example.assignment6sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class AgentDB
{
    private Context context;
    private SQLiteDatabase db;
    private DBHelper helper;
    public AgentDB(Context context) {
        this.context = context;
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    // method to get agent data by agent id
        public Agent getAgents(int agentid)
        {
            String[] columns = { "AgtFirstName","AgtMiddleInitial","AgtLastName",
                    "AgtBusPhone","AgtEmail","AgtPosition","AgtPosition"};
            String[] args = {agentid+""};
            Cursor cursor = db.query("Agents",columns,"AgentId = ?",args,null,null,null);
            Agent agents = null;
            if (cursor.moveToNext())
            {
                agents = new Agent(agentid, cursor.getString(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getInt(6));
            }
            else
            {
                Log.d("manpreet","no agent info found for agent Id"+agentid);
            }
            return  agents;
        }

        // method to retrieve all agents and add in a array list
        public ArrayList<Agent> getAllAgents()
        {
            ArrayList<Agent> list = new ArrayList<>();
            String[] columns = { "AgentId","AgtFirstName","AgtMiddleInitial","AgtLastName","AgtBusPhone","AgtEmail","AgtPosition","AgencyId"};
            Cursor cursor = db.query("Agents",columns,null,null,null,null,null);
            while (cursor.moveToNext())
            {
                list.add(new Agent(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7) ));
            }
            return  list;
        }

        // method to insert data into database
        public  void InsertAgents(Agent agent)
            {
                ContentValues cv = new ContentValues();
                cv.put("AgtFirstName",agent.getAgtFirstName());
                cv.put("AgtMiddleInitial",agent.getAgtMiddleIntial());
                cv.put("AgtLastName",agent.getAgtLastName());
                cv.put("AgtBusPhone",agent.getAgtBusPhone());
                cv.put("AgtEmail",agent.getAgtEmail());
                cv.put("AgtPosition",agent.getAgtPosition());
                cv.put("AgencyId",agent.getAgencyId());
                long rowId = db.insert("Agents",null,cv);
                  if (rowId == -1)
                  {
                      Log.d("manpreet","unable to insert check values again");
                      Toast.makeText(context, "insert failed", Toast.LENGTH_LONG).show();
                  }
                  else
                  {
                      Log.d("manpreet","Insert Successfull");
                      Toast.makeText(context, "insert successfull", Toast.LENGTH_LONG).show();
                  }
            }

            // method to update agent data into the database
            public  void UpdateAgents(Agent agent)
            {
                ContentValues cv = new ContentValues();
                cv.put("AgtFirstName",agent.getAgtFirstName());
                cv.put("AgtMiddleInitial",agent.getAgtMiddleIntial());
                cv.put("AgtLastName",agent.getAgtLastName());
                cv.put("AgtBusPhone",agent.getAgtBusPhone());
                cv.put("AgtEmail",agent.getAgtEmail());
                cv.put("AgtPosition",agent.getAgtPosition());
                cv.put("AgencyId",agent.getAgencyId());
                String[] args = {agent.getAgentId()+""};
                String where = "AgentId= ?";
                long rowId = db.update("Agents",cv,where,args);
                if (rowId == -1)
                {
                    Log.d("manpreet","unable to update check values again");
                    Toast.makeText(context, "update failed", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Log.d("manpreet","update Successfull");
                    Toast.makeText(context, "update successfull", Toast.LENGTH_LONG).show();
                }
            }

            // method to delete agents from database
            public  void DeleteAgents(int agentId)
            {
                String[] args = {agentId+""};
                String where = "AgentId= ?";
                long rowId = db.delete("Agents",where,args);
                if (rowId == -1)
                {
                    Log.d("manpreet","unable to delete check values again");
                    Toast.makeText(context, "delete failed", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Log.d("manpreet","delete Successfull");
                    Toast.makeText(context, "delete successfull", Toast.LENGTH_LONG).show();
                }
            }
}
