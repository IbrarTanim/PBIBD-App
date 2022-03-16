
package com.pbilbd.dto.responses.agents;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class AgentsResponse implements Serializable
{

    @SerializedName("agents")
    @Expose
    private List<Agent> agents = null;

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

}
