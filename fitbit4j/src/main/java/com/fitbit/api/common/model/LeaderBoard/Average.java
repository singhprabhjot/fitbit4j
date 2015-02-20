package com.fitbit.api.common.model.leaderboard;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by prabhjot.singh on 2/19/15.
 */
public class Average {
    private Steps steps;

    public Average(JSONObject jsonObject) throws JSONException {
        Steps step = new Steps(jsonObject);
        this.steps =step;

    }
}
