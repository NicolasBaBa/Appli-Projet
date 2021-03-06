package com.example.nicolas.smartride2.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nicolas.smartride2.R;
import com.example.nicolas.smartride2.SettingsManager;
import com.example.nicolas.smartride2.SmartRide;

/**
 * Created by Nicolas on 30/01/2017.
 */

public class RecordFragment extends Fragment implements View.OnClickListener {

    Button buttonMotion;
    Button buttonManual;
    TextView textGPSOn;
    TextView textGPSOff;
    TextView textBluetoothOn;
    TextView textBluetoothOff;
    SettingsManager settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View recordView = inflater.inflate(R.layout.record, container, false);
        ((SmartRide) getActivity())
                .setActionBarTitle("Record");
        settings = SmartRide.getSettingsManager();
        buttonMotion = (Button) recordView.findViewById(R.id.buttonMotion);
        buttonMotion.setOnClickListener(this);
        buttonManual = (Button) recordView.findViewById(R.id.buttonManual);
        buttonManual.setOnClickListener(this);
        textGPSOn = (TextView) recordView.findViewById(R.id.textGPSOn);
        textGPSOff = (TextView) recordView.findViewById(R.id.textGPSOff);
        textBluetoothOn = (TextView) recordView.findViewById(R.id.textBluetoothOn);
        textBluetoothOff = (TextView) recordView.findViewById(R.id.textBluetoothOff);
        if (settings.getGPSTrackPref()) {
            textGPSOff.setVisibility(View.INVISIBLE);
            textGPSOn.setVisibility(View.VISIBLE);
        }
        else {
            textGPSOn.setVisibility(View.INVISIBLE);
            textGPSOff.setVisibility(View.VISIBLE);
        }
        if (settings.getBluetoothStatePref()) {
            textBluetoothOff.setVisibility(View.INVISIBLE);
            textBluetoothOn.setVisibility(View.VISIBLE);
        }
        else {
            textBluetoothOn.setVisibility(View.INVISIBLE);
            textBluetoothOff.setVisibility(View.VISIBLE);
        }
        return recordView;
    }

    @Override
    public void onClick(View v) {

        if (v.hasOnClickListeners()) {

            switch (v.getId()) {

                case (R.id.buttonMotion):
                    System.out.println("Bouton Motion OK");
                    MotionCaptureFragment motionFrag= new MotionCaptureFragment();
                    this.getFragmentManager().beginTransaction()
                            .replace(R.id.frame, motionFrag,"Motion Fragment OK")
                            .addToBackStack(null)
                            .commit();
                    break;

                case (R.id.buttonManual):
                    System.out.println("Bouton Manual OK");
                    ManualModeFragment manualFrag= new ManualModeFragment();
                    this.getFragmentManager().beginTransaction()
                            .replace(R.id.frame, manualFrag,"Manual Fragment OK")
                            .addToBackStack(null)
                            .commit();
                    break;

            }

        }
    }

}
