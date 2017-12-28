package com.example.aminsholeh.cletraadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView getArea;
    ArrayList<Book> books = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getArea = (TextView) findViewById(R.id.get_area);
        books = new ArrayList<>();
    }

    public void postData(View view){
        startActivity(new Intent(this, FormActivity.class));
    }

    public void updateData(View view){
        Intent it = new Intent(this, FormActivity.class);
        EditText editId = (EditText) findViewById(R.id.edit_id);
        int idx = Integer.parseInt(editId.getText().toString())-1;
        it.putExtra("bookedit", books.get(idx));
        startActivity(it);
    }

    public void getData(View view){
        getArea.setText("");
        books.clear();
        DatabaseReference mDb = FirebaseDatabase.getInstance().getReference();
        ChildEventListener childListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Book data = dataSnapshot.getValue(Book.class);
                getArea.append(data.toString());
                data.setId(dataSnapshot.getKey());
                books.add(data);
                Log.d("tambahdata", data.toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getArea.setText("Ada data yang dirubah, silahkan klik Get Data");

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("firebase.error", databaseError.toString());

            }
        };
        mDb.child("books").addChildEventListener(childListener);
    }
}
