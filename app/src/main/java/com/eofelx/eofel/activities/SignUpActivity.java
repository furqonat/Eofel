package com.eofelx.eofel.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.eofelx.eofel.R;
import com.eofelx.eofel.activities.signup.SignUp;
import com.eofelx.eofel.adapters.SliderHomeAdapter;
import com.eofelx.eofel.models.SliderItem;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        SliderView sliderView = findViewById(R.id.sign_slider);
        int[] url = new int[] {
                R.raw.slider1, R.raw.slider2, R.raw.slider3, R.raw.slider4
        };
        List<SliderItem> items = new ArrayList<>();
        for (int j : url) {
            items.add(new SliderItem(j));
        }
        sliderView.setSliderAdapter(new SliderHomeAdapter(items, item -> {
        }));

        sliderView.startAutoCycle();
        nextFragment(new SignUp());
    }


    private void nextFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.next_register, fragment)
                .commit();
    }


}