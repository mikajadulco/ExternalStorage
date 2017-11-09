package com.example.mikaa.externalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText et_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_data = (EditText) findViewById(R.id.et_data);
    }

    public void saveInternalCache (View view) {
        File folder = getCacheDir();
        File file = new File(folder, "data.txt");
        String msg = et_data.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(msg.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
    }

    public void saveExternalCache (View view) {
        File folder = getExternalCacheDir();
        File file = new File(folder, "data2.txt");
        String msg = et_data.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(msg.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
    }

    public void SaveExternalStorage (View view) {
        File folder = getExternalFilesDir("Temp");
        File file = new File(folder, "data3.text");
        String msg = et_data.getText().toString();
        writeData(file, msg);
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
    }

    public void saveExternalPublic() {
        File folder = getExternalFilesDir("Temp");
        File file = new File(folder, "data4.text");
        String msg = et_data.getText().toString();
        writeData(file, msg);
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
    }

    private void writeData(File file, String msg) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(msg.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   /** public void displayMessage(View view) {
        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput("output.txt");
            while ((read= fis.read()) != -1) {
                buffer.append((char)read);
            }
            fis.close();
        }

        tvDisplay.setText(buffer.toString());

    } **/

    }

