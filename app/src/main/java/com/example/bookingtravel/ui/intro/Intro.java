package com.example.bookingtravel.ui.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.viewpageradapters.IntroVPAdapter;
import com.example.bookingtravel.databinding.ActivityIntroBinding;
import com.example.bookingtravel.log.Splash;
import com.example.bookingtravel.ui.main.MainActivity;

import java.util.ArrayList;

public class Intro extends AppCompatActivity {

    ActivityIntroBinding binding ;

    ArrayList<String> list = new ArrayList<>();

    IntroVPAdapter adapter ;

    private TextView []dots ;

    private int lis[] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    binding = ActivityIntroBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        list.add("Let’s start your Vacation!");
        list.add("Let’s start your Pla!");
        list.add("Let’s start your Oll!");



        adapter = new IntroVPAdapter(list);

        binding.viewPagerIntro.setAdapter(adapter);

        lis = new int[3];

        lis[0] = getResources().getColor(R.color.orange);
        lis[1] = getResources().getColor(R.color.orange);
        lis[2] = getResources().getColor(R.color.orange);

        dots = new TextView[3];
        
        dotsIndicator ();




        binding.viewPagerIntro.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                selectIndicator(position);


                binding.btNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int Position = position ;
                        if(Position <2){
                            Position++;
                            binding.viewPagerIntro.setCurrentItem(Position);
                        }else if(Position == 2) {
                         binding.btNext.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                                 startActivity(new Intent(Intro.this, Splash.class));
                             }
                         });
                        }
                    }
                });

                super.onPageSelected(position);
            }
        });
    }


    private void selectIndicator(int position) {
        for (int i =0 ; i<dots.length ; i++)
        {

            if(i == position){

                dots[i].setTextColor(lis[position]);
            }else {
                dots[i].setTextColor(getResources().getColor(R.color.gray));
            }
        }

    }

    private void dotsIndicator() {
        for(int i=0 ; i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            binding.dotsLayout.addView(dots[i]);
        }
    }
}