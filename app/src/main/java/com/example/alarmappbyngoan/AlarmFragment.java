package com.example.alarmappbyngoan;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class AlarmFragment extends Fragment {


    TimePicker alarmTimePicker;
    Button btnHenGio,btnTat;
    AlarmManager alarmManager;
    TextView txtHienThi;
    View view;
    Calendar calendar;
    PendingIntent pendingIntent;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_alarm, container, false);
        btnHenGio = view.findViewById(R.id.alarm_btn);
        btnTat = view.findViewById(R.id.alarm_btn_off);
        txtHienThi = view.findViewById(R.id.alarm_text);
        calendar = Calendar.getInstance();
        alarmTimePicker = view.findViewById(R.id.time_picker);

        //Sử dụng getActivity() thay cho context nếu ở fragments
        alarmManager= (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);;
        Intent intent = new Intent(getActivity(), AlarmReceiver.class);

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
                //Sử dụng getActivity() thay cho context nếu ở fragments

                pendingIntent =PendingIntent.getBroadcast(getActivity(), 0, intent, 0);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                txtHienThi.setText("Giờ đã hẹn là: "+string_gio+ ":"+string_phut);
            }
        });
        btnTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHienThi.setText("Đã dừng báo thức");
                alarmManager.cancel(pendingIntent);


            }
        });
        return view;
    }


}