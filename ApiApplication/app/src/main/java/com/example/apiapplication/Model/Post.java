package com.example.apiapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;



import org.json.JSONObject;

public class Post implements Parcelable {
    private int userId;

    private int id;

    private String title;


    private String body;

    protected Post(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public Post(JSONObject object){
        id=object.optInt("id");
        userId=object.optInt("userId");
        title=object.optString("title");
        body=object.optString("body");

    }


    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };


    public String getBody() {
        return body;
    }

    public void setBody(String text) {
        this.body = text;
    }




    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.userId);
        parcel.writeString(this.title);
        parcel.writeString(this.body);
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt("id", getId());
            jsonObject.putOpt("userId", getUserId());
            jsonObject.putOpt("title", getTitle());
            jsonObject.putOpt("text", getBody());

            return jsonObject;
        } catch (Exception Ex) {
            Ex.printStackTrace();
            return null;
        }
    }
    @Override
    public String toString(){
        return  "Post{"+"id"+id+"userId"+userId+"title"+title+"text"+body+"}";
            }
        }



