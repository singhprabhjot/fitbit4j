package com.fitbit.api.common.model.LeaderBoard;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by prabhjot.singh on 2/19/15.
 */

public class Friend {

    private String lastUpdateTime;

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Friend() {

    }
    public Friend(String lastUpdateTime) {
        this.lastUpdateTime=lastUpdateTime;
        System.out.print("wooohoooooo0000000oooooooooooooooo"+this.lastUpdateTime);

    }

    public Friend(JSONObject json) throws JSONException {
        this(json, true);
    }

    public Friend(JSONObject jsonObject, boolean wrapped) throws JSONException {
        System.out.print("1=== wooohooooooooooooooooooooo"+this.lastUpdateTime);
        this.lastUpdateTime = jsonObject.getString("lastUpdateTime");
        System.out.print("2 === wooohoooooo0000000oooooooooooooooo"+this.lastUpdateTime);

    }
}
