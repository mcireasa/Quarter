package com.mcireasa.quizzapp.firebase;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mcireasa.quizzapp.Model.User;

import java.util.ArrayList;
import java.util.List;

public class FirebaseController implements FirebaseConstant {

    private DatabaseReference database;
    private FirebaseDatabase controller;
    private static FirebaseController firebaseController;

    private FirebaseController() {
        controller = FirebaseDatabase.getInstance();
    }

    private void open() {
        database = controller.getReference(USERS_TABLE_NAME);
    }

    public static FirebaseController getInstance() {
        if (firebaseController == null) {
            synchronized (FirebaseController.class) {
                if (firebaseController == null) {
                    firebaseController = new FirebaseController();
                }
            }
        }

        return firebaseController;
    }

    public String upsertUser(User user) {
        if (user == null) {
            return null;
        }

        open();

        if (user.getGlobalId() == null || user.getGlobalId().trim().isEmpty()) {
            user.setGlobalId(database.push().getKey());
        }

        database.child(user.getGlobalId()).setValue(user);

        database.child(user.getGlobalId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User temp = dataSnapshot.getValue(User.class);
                if (temp != null) {
                    Log.i("FireController", "User is updated " + temp.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("FirebaseController", "User is not saved");
            }
        });

        return user.getGlobalId();
    }


}
