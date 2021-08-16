package com.syahdiakbar.learningstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity implements View.OnClickListener{
    private String keyInternal = "KEY_INTERNAL_STORAGE";
    private String FILE_NAME = "nama_file.txt";

    private TextView txtResult;
    private EditText edtInternal;

    private Button btnCreate,btnUbah,btnRead,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        txtResult = findViewById(R.id.tv_result);
        edtInternal = findViewById(R.id.edtInternalS);

        btnCreate = findViewById(R.id.btn_createI);
        btnUbah = findViewById(R.id.btn_ubahI);
        btnRead = findViewById(R.id.btn_readI);
        btnDelete = findViewById(R.id.btn_deleteI);

        btnCreate.setOnClickListener(this);
        btnUbah.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String newTitle = extras.getString(keyInternal);
            setTitle(newTitle);
        }


    }


    @Override
    public void onClick(View view) {
        int i = view.getId();
        File file;
        FileOutputStream outputStream;
        switch (i){
            case R.id.btn_createI:
                String isFile = "Membuat file baru";
                file = new File(getFilesDir(), FILE_NAME);
                outputStream = null;

                try {
                    file.createNewFile();
                    outputStream = new FileOutputStream(file, true);
                    outputStream.write(isFile.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            case R.id.btn_ubahI:
                String ubah = edtInternal.getText().toString();

                if (!ubah.isEmpty()){
                    file = new File(getFilesDir(), FILE_NAME);
                    outputStream = null;
                    try {
                        file.createNewFile();
                        outputStream = new FileOutputStream(file, true);
                        outputStream.write(ubah.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(this, "INput TexT kOsoNg!", Toast.LENGTH_SHORT).show();
                }
            case R.id.btn_readI:
                File sdcard = getFilesDir();
                file = new File(sdcard, FILE_NAME);

                if (file.exists()){
                    StringBuilder text = new StringBuilder();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line = br.readLine();
                        while (line != null){
                            text.append(line);
                            line = br.readLine();
                        }
                        br.close();
                    }catch (IOException e){
                        System.out.println("Error : " + e.getMessage());
                    }
                    txtResult.setText(text.toString());
                }
            case R.id.btn_deleteI:
                file = new File(getFilesDir(), FILE_NAME);
                if (file.exists()){
                    file.delete();
                }
        }
    }

}