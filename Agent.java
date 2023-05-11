// agent class contain getter and setter for agent
// // Created on April,2023 by Manpreet Kaur Sidhu

package com.example.assignment6sqlite;

import java.io.Serializable;

public class Agent implements Serializable {

    private int agentId;
    private String agtFirstName;
    private String agtMiddleIntial;
    private String agtLastName;
    private String agtBusPhone;
    private String agtEmail;
    private String agtPosition;
    private int agencyId;

    public Agent(int agentId, String agtFirstName, String agtMiddleIntial, String agtLastName, String agtBusPhone, String agtEmail, String agtPosition, int agencyId) {
        this.agentId = agentId;
        this.agtFirstName = agtFirstName;
        this.agtMiddleIntial = agtMiddleIntial;
        this.agtLastName = agtLastName;
        this.agtBusPhone = agtBusPhone;
        this.agtEmail = agtEmail;
        this.agtPosition = agtPosition;
        this.agencyId = agencyId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgtFirstName() {
        return agtFirstName;
    }

    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName = agtFirstName;
    }

    public String getAgtMiddleIntial() {
        return agtMiddleIntial;
    }

    public void setAgtMiddleIntial(String agtMiddleIntial) {
        this.agtMiddleIntial = agtMiddleIntial;
    }

    public String getAgtLastName() {
        return agtLastName;
    }

    public void setAgtLastName(String agtLastName) {
        this.agtLastName = agtLastName;
    }

    public String getAgtBusPhone() {
        return agtBusPhone;
    }

    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone = agtBusPhone;
    }

    public String getAgtEmail() {
        return agtEmail;
    }

    public void setAgtEmail(String agtEmail) {
        this.agtEmail = agtEmail;
    }

    public String getAgtPosition() {
        return agtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition = agtPosition;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public  String toString()
    {
        return getAgentId()+" "+getAgtFirstName();
    }
}
