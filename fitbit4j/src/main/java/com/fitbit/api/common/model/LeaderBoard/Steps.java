package com.fitbit.api.common.model.leaderboard;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by prabhjot.singh on 2/19/15.
 */
public class Steps {
    private Integer steps;

    public Steps(){
        this.steps=0;
    }
    public Steps(Integer Steps){
        this.steps=steps;
    }
    public Steps(JSONObject jsonObject) throws JSONException{
        this.steps=jsonObject.getInt("steps");
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }



}
