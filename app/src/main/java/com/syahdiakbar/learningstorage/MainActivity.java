package com.syahdiakbar.learningstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String keyInternal = "KEY_INTERNAL_STORAGE";
    private String keyExternal = "KEY_EXTERNAL_STORAGE";

    private Button btnInternal, btnEksternal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInternal = findViewById(R.id.btn_internalS);
        btnEksternal = findViewById(R.id.btn_externalS);

        btnInternal.setOnClickListener(this);
        btnEksternal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        switch (i){
            case R.id.btn_internalS:
                Intent internal = new Intent(this, InternalStorageActivity.class);
                internal.putExtra(keyInternal, "Internal Storage");
                startActivity(internal);
            case R.id.btn_externalS:
                Intent eksternal = new Intent(this, EksternalStorageActivity.class);
                eksternal.putExtra(keyExternal, "Eksternal Storage");
                startActivity(eksternal);
        }
    }
}