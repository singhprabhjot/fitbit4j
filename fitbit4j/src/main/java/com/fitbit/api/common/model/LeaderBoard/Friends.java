package com.fitbit.api.common.model.LeaderBoard;

import java.util.ArrayList;
import java.util.List;

import com.fitbit.api.common.model.foods.WaterLogSummary;
import com.fitbit.api.common.model.user.UserInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fitbit.api.FitbitAPIException;
import com.fitbit.api.client.http.Response;
import com.fitbit.api.common.model.sleep.SleepLog;
import com.fitbit.api.common.model.sleep.SleepSummary;

public class Friends {

    private List<Friend> friendList;

    private String hideMeFromLeaderboard;

    public Friends() {
    }
    public Friends(JSONObject jsonObject) throws JSONException {
        this.friendList = jsonArrayToFriendsList(jsonObject.getJSONArray("friends"));
    }
    private static List<Friend> jsonArrayToFriendsList(JSONArray array) throws JSONException {
        List<Friend> friendsList = new ArrayList<Friend>(array.length());
        for (int i = 0; i < array.length(); i++) {
            JSONObject user = array.getJSONObject(i);
            friendsList.add(new Friend(user));
        }
        return friendsList;
    }
}
