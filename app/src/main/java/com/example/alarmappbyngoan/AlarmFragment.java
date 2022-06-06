package com.example.alarmappbyngoan;

import android.app.AlarmManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class AlarmFragment extends Fragment {


    TimePicker alarmTimePicker;
    Button btnHenGio;
    AlarmManager alarmManager;
    TextView txtHienThi;
    View view;
    Calendar calendar;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_alarm, container, false);
        btnHenGio = view.findViewById(R.id.alarm_btn);
        txtHienThi = view.findViewById(R.id.alarm_text);
        calendar = Calendar.getInstance();
        alarmTimePicker = view.findViewById(R.id.time_picker);
        btnHenGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
                int gio = alarmTimePicker.getCurrentHour();
                int phut = alarmTimePicker.getCurrentMinute();

                //Đổi int to String
                String string_gio = String.valueOf(gio);
                String string_phut = String.valueOf(phut);

                if(phut<10 ) string_phut = "0" + String.valueOf(phut);

                txtHienThi.setText("Giờ đã hẹn là: "+string_gio+ ":"+string_phut);
            }
        });
        return view;
    }


}