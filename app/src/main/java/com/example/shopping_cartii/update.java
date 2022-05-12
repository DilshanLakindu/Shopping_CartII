package com.example.shopping_cartii;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

    public class UpdateCard extends AppCompatActivity {
        Button paymentUpdate;
        TextView CardNumUpd, cardNameUpdate, MMInputUpd, YYInputUpd,CVVInputUpd;
        String CardNumber;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_update_card);


            CardNumUpd = findViewById(R.id.CardNumUpd);
            cardNameUpdate = findViewById(R.id.cardNameUpdate);
            MMInputUpd = findViewById(R.id.MMInputUpd);
            YYInputUpd = findViewById(R.id.YYInputUpd);
            CVVInputUpd = findViewById(R.id.CVVInputUpd);
            paymentUpdate = findViewById(R.id.paymentUpdate);

            Bundle extras = getIntent().getExtras();
            String payment = extras.getString("CardNumber");

            CardNumber=payment;

            FirebaseDatabase.getInstance().getReference().child("fashionHubDB").child("Payment").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {


                    if(snapshot.hasChild(CardNumber)){
                        String PayCardNumber = snapshot.child(CardNumber).child("CardNumber").getValue().toString();
                        String PayCardName = snapshot.child(CardNumber).child("CardHolderName").getValue().toString();
                        String CardMM = snapshot.child(CardNumber).child("MM").getValue().toString();
                        String CardYY = snapshot.child(CardNumber).child("YY").getValue().toString();
                        String CardCVV = snapshot.child(CardNumber).child("CVV").getValue().toString();



                        CardNumUpd.setText(PayCardNumber);
                        cardNameUpdate.setText(PayCardName);
                        MMInputUpd.setText(CardMM);
                        YYInputUpd.setText(CardYY);
                        CVVInputUpd.setText(CardCVV);



                        paymentUpdate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                String NewCardNumb = CardNumUpd.getText().toString();
                                String NewCardName = cardNameUpdate.getText().toString();
                                String NewMM = MMInputUpd.getText().toString();
                                String NewYY = YYInputUpd.getText().toString();
                                String NewCVV = CVVInputUpd .getText().toString();

                                HashMap<String, Object> data = new HashMap<>();
                                data.put("CardNumber", NewCardNumb);
                                data.put("CardHolderName", NewCardName);
                                data.put("MM", NewMM);
                                data.put("YY", NewYY);
                                data.put("CVV", NewCVV);

                                FirebaseDatabase.getInstance().getReference().child("fashionHubDB").child("Payment").child(CardNumber).setValue(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(UpdateCard.this, "Update Complete", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), ViewCard.class);
                                        intent.putExtra("payment", CardNumber);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(UpdateCard.this, "Database Error" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });}}
}
