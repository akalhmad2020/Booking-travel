package com.example.bookingtravel.log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookingtravel.R;
import com.example.bookingtravel.databinding.ActivityLogInBinding;
import com.example.bookingtravel.ui.main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    ActivityLogInBinding binding ;
    private FirebaseAuth auth  ;
    private FirebaseFirestore firebaseFirestore ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      binding = ActivityLogInBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btSignIn.setOnClickListener(this);
        binding.tvSignUp.setOnClickListener(this);


        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_sign_in:


                String   email = binding.etEmailSignIn.getText().toString();
                String password = binding.etPasswordSignIn.getText().toString();



                if(email.isEmpty()){
                    Toast.makeText(this, "ضع بريد الكتروني", Toast.LENGTH_SHORT).show();
                }

                else if(password.isEmpty()){
                    Toast.makeText(this, "ضع كلمة السر", Toast.LENGTH_SHORT).show();
                }

                else if(email.isEmpty() && password.isEmpty()){
                    Toast.makeText(this, "ضع بريد و كلمة سر", Toast.LENGTH_SHORT).show();
                }

                else {

                    auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(LogIn.this,MainActivity.class));
                            }
                        }
                    });

                }


                break;
            case R.id.tv_sign_up:
                startActivity(new Intent(this, LogUp.class));
                break;
        }
    }
}