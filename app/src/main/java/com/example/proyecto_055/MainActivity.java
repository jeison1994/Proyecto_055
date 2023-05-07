package com.example.proyecto_055;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private VideoView vv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editText1);
        vv1 = findViewById(R.id.videoView1);
    }

    public void tomarVideo(View v) {
        Intent intento1 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File videoFile = new File(getExternalFilesDir(null), et1.getText().toString());
        Uri videoUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".myFileProvider", videoFile);
        intento1.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
        intento1.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        startActivity(intento1);
    }

    public void recuperarVideo(View v) {
        vv1.setVideoURI(Uri.parse(new File(getExternalFilesDir(null), et1.getText().toString()).getAbsolutePath()));
        vv1.start();
    }

    public void ver(View v) {
        Intent intento1 = new Intent(this, Actividad2.class);
        startActivity(intento1);
    }
}
