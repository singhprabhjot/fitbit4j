package com.fitbit.api.common.model.leaderboard;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Friends {

    private List<Friend> friendList;

    private String hideMeFromLeaderboard;


    public Friends() {
    }
    public Friends(JSONObject jsonObject) throws JSONException {
        this.friendList = jsonArrayToFriendsList(jsonObject.getJSONArray("friends"));
        this.hideMeFromLeaderboard=jsonObject.getString("hideMeFromLeaderboard");
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public String getHideMeFromLeaderboard() {
        return hideMeFromLeaderboard;
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
