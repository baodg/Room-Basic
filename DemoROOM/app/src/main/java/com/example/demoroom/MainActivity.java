package com.example.demoroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    EditText  editTextUser;
    Button btnAdd, btnDelete,btnCancel;
    ListView listViewUser;

    List<String> listUser;
    ArrayAdapter<String> adapter;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setFirstName(editTextUser.getText().toString());
                user.setUid(listUser.size());
                userDao.insertAll(user);

                getList();
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listUser);
                listViewUser.setAdapter(adapter);
            }
        });


    }

    private void mapping() {
        editTextUser = findViewById(R.id.editTextUser);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);
        btnDelete = findViewById(R.id.btnDelete);
        listViewUser = findViewById(R.id.listViewUser);

        userDao = AppDatabase.getDatabase(this).userDao();
        listUser = new ArrayList<>();

        getList();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listUser);
        listViewUser.setAdapter(adapter);

    }

    private void getList() {
        List<User> listUser = userDao.getAll();
        listUser = new ArrayList<>();
        for(User user: listUser){
            listUser.add(User.getFirstName());
        }
    }
}