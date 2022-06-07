package com.example.alarmappbyngoan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class CountDown_Fragment extends Fragment {


   TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_count_down_,container,false);
        textView =(TextView) rootView.findViewById(R.id.cout_down_txt);
        long duration = TimeUnit.MINUTES.toMillis(1);
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String sDuration = String.format(Locale.ENGLISH, "%02d:%02d"
                ,TimeUnit.MILLISECONDS.toMinutes(1)
                ,TimeUnit.MILLISECONDS.toSeconds(1)- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(1)));

                textView.setText(sDuration);
            }

            @Override
            public void onFinish() {
                textView.setVisibility(View.GONE);
                Toast.makeText(getActivity().getApplicationContext(), "End", Toast.LENGTH_LONG).show();
            }
        }.start();
        return rootView;
    }
}