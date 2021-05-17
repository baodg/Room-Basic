package com.example.demoroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "user_table")
public class User {

    @PrimaryKey
    private  int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public static User getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User(int uid, String firstName) {
        this.uid = uid;
        this.firstName = firstName;
    }

    public User(String firstName) {
        this.firstName = firstName;
    }

    public User() {
    }
}
