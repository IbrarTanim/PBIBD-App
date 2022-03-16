
package com.pbilbd.dto.responses.thana;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ThanaResponse implements Serializable
{

    @SerializedName("thanas")
    @Expose
    private List<Thana> thanas = null;
    @SerializedName("agents")
    @Expose
    private List<Agent> agents = null;

    public List<Thana> getThanas() {
        return thanas;
    }

    public void setThanas(List<Thana> thanas) {
        this.thanas = thanas;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

}
