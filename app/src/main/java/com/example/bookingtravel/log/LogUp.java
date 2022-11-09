package com.example.bookingtravel.log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookingtravel.R;
import com.example.bookingtravel.databinding.ActivityLogUpBinding;
import com.example.bookingtravel.ui.main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogUp extends AppCompatActivity implements View.OnClickListener {

    ActivityLogUpBinding binding ;
    private FirebaseAuth auth  ;
    private FirebaseFirestore firebaseFirestore ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityLogUpBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btSignUp.setOnClickListener(this);
        binding.tvSignIn.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();









    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_sign_up:




                String   email = binding.etYourEmailSignUp.getText().toString();
                String password = binding.etYourPasswordSignUp.getText().toString();

                String name = binding.etYourNameSignUp.getText().toString();


                if(email.isEmpty()){
                    Toast.makeText(LogUp.this, "ضع بريد الكتروني", Toast.LENGTH_SHORT).show();
                }

                else if(password.isEmpty()){
                    Toast.makeText(LogUp.this, "ضع كلمة السر", Toast.LENGTH_SHORT).show();
                }

                else if(email.isEmpty() && password.isEmpty()){
                    Toast.makeText(LogUp.this, "ضع بريد و كلمة سر", Toast.LENGTH_SHORT).show();
                }

                else {
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){


                                Toast.makeText(LogUp.this, "تم تسيجل الحساب", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LogUp.this,MainActivity.class));

                            }else {
                                Toast.makeText(LogUp.this, "ضع بريد صحيح و كلمة سر من 6 أحرف أو أكثر", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }





                break;
            case R.id.tv_sign_in:

                startActivity(new Intent(this, LogIn.class));

                break;
        }
    }
}