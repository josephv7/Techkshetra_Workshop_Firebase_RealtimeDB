package com.iamjosephvarghese.firebaseworkshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddQuote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("quotes");

//        TODO Step 1

//        ref.child("data1").setValue("hi");

//        TODO Step 2
//        ref.child("data2").child("1").setValue("new data");

//        TODO Step 3

        Quote quote = new Quote("This is a quote","iamjosephvarghese");
        ref.child("data3").child("1").setValue(quote);

//        TODO Step4
        String pushId = ref.push().getKey();
//        ref.child("data4").child(pushId).setValue(new Quote("Second Quote","jv"));

//        TODO Step 5
        ref.child("data4").child(pushId).setValue(quote).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(AddQuote.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddQuote.this, "Task Failed!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
