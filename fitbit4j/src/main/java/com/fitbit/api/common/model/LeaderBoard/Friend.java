package com.fitbit.api.common.model.leaderboard;

import com.fitbit.api.common.model.user.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by prabhjot.singh on 2/19/15.
 */

public class Friend {

    private String lastUpdateTime;
    private Average average;
    private Lifetime lifetime;
    private Summary summary;
    private UserInfo userInfo;
    private Rank rank;

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
    }

    public Friend(JSONObject json) throws JSONException {
        this(json, true);
    }

    public Friend(JSONObject jsonObject, boolean wrapped) throws JSONException {
        this.lastUpdateTime = jsonObject.getString("lastUpdateTime");
        this.summary=new Summary(jsonObject.getJSONObject("summary"));
        this.rank = new Rank(jsonObject.getJSONObject("rank"));
        this.average=new Average(jsonObject.getJSONObject("average"));
        this.lifetime=new Lifetime(jsonObject.getJSONObject("lifetime"));
        this.userInfo=new UserInfo(jsonObject);
    }
}
