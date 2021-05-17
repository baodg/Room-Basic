package com.example.demoroom;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


interface UserDao {
    @Query("SELECT * FROM user_table")
    List<User> getAll();



    @Query("SELECT * FROM user_table WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user_table WHERE first_name LIKE :first LIMIT 1")
    User findByName(String first);

    @Insert
    void insertAll(User... users);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Query("SELECT * FROM user_table ORDER BY first_name ASC")
    List<User> getAlphabetizedWords();
}
