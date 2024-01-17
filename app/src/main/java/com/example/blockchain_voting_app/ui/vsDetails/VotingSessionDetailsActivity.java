package com.example.blockchain_voting_app.ui.vsDetails;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blockchain_voting_app.R;

import java.util.ArrayList;

public class VotingSessionDetailsActivity extends AppCompatActivity {
    RadioGroup optionsRG;
    TextView tvDetailsOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs_details);
        tvDetailsOptions = findViewById(R.id.tv_options);
        optionsRG = findViewById(R.id.vs_options_radio_group);
        ArrayList<String> vsOptions = getIntent().getSerializableExtra("vs_options") != null ? (ArrayList<String>) getIntent().getSerializableExtra("vs_options") : new ArrayList<String>();
        createRadioButton(vsOptions, optionsRG);

        optionsRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedOption = findViewById(checkedId);
                Toast.makeText(VotingSessionDetailsActivity.this, selectedOption.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void createRadioButton(ArrayList<String> options, RadioGroup rg) {
        final RadioButton[] rb = new RadioButton[options.size()];
        rg.setOrientation(RadioGroup.HORIZONTAL);
        for(int i=0; i<options.size(); i++){
            rb[i]  = new RadioButton(this);
            rb[i].setText(options.get(i));
            rb[i].setId(i + 100);
            rg.addView(rb[i]);
        }
    }

}
