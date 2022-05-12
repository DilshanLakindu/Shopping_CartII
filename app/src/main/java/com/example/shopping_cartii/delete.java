package com.example.shopping_cartii;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewCard extends AppCompatActivity {

    TextView editText,update,textView10delete,cardNumb;
    Button AddAno;
    DatabaseReference reff;
    String CardNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar();
        setContentView(R.layout.activity_view_card);
        editText=(TextView)findViewById(R.id.editText);
        update=(TextView) findViewById(R.id.update);
        textView10delete=(TextView) findViewById(R.id.textView10delete);
        AddAno=(Button) findViewById(R.id.AddAno);
        cardNumb=(TextView)findViewById(R.id.cardNumber);



        Bundle extras = getIntent().getExtras();
        String cardNumber = extras.getString("cardnumber");
        cardNumb.setText(cardNumber);

        AddAno.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCard.this,activity_add_card.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCard.this,UpdateCard.class);
                startActivity(intent);
            }


        });

        textView10delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteRecord(cardNumber);
            }


            private void DeleteRecord(String cardNumber){
                FirebaseDatabase.getInstance().getReference().child("fashionHubDB").child("Payment").child(cardNumber).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "Card Removed Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), activity_add_card.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error in Removing the Card" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }}