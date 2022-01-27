package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    AtomicBoolean currentlyRecording = new AtomicBoolean(false);
    AtomicBoolean currentlyPlaying = new AtomicBoolean(false);
    Thread audio = null;
    Thread storage = null;
    MediaRecorder mr=new MediaRecorder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 0);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void toggleRecording(View v) {
        currentlyRecording.set(!currentlyRecording.get());
        if (!currentlyRecording.get()) {
            stopRecording();
        } else {
            startRecording();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startRecording() {
        ((TextView) findViewById(R.id.Current_State)).setText(("Recording started"));
        ((Button) findViewById(R.id.button)).setText(("Start"));


        LinkedBlockingDeque<byte[]> queue = new LinkedBlockingDeque<>();

        audio = new Thread(() -> {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            AudioRecord r = new AudioRecord(
                    MediaRecorder.AudioSource.MIC, 44100,
                    AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_8BIT, 16 * 1024
            );
            r.startRecording();


            while (currentlyRecording.get()){
                byte[] buffer = new byte[16 * 1024];
                int rc = r.read(buffer, 0, buffer.length);
                if(rc < 0){
                    //ERROR
                }else{
                    try {
                        queue.put(buffer);
                    } catch (InterruptedException e) {

                    }
                }
            }

            try {
                queue.put(new byte[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        storage = new Thread(()-> {
            ArrayList<byte[]> content = new ArrayList<>();
            byte[] buffer;

            try{
                while (currentlyRecording.get()){
                    content.add(queue.take());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            File directory = this.getFilesDir();
            Path p;

            try {
                p = Files.createFile(directory.toPath().resolve("recording2.wav"));
                OutputStream os = new FileOutputStream(p.toFile());
                writeHeader(os, content);
                for(byte[] b: content){
                    os.write(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        audio.start();
        storage.start();
    }

    private void writeHeader(OutputStream output, ArrayList<byte[]> content) throws IOException{
        int dataLen=0;
        for(byte[] b: content){
            dataLen +=b.length;
        }
        int totalLen=dataLen+36;
        int byteRate=44100;
        byte[] header =new byte[44];
        header[0]='R';
        header[1]='I';
        header[2]='F';
        header[3]='F';
        header[4]=(byte)(totalLen&0xff);
        header[5]=(byte)((totalLen>>8)&0xff);
        header[6]=(byte)((totalLen>>16)&0xff);
        header[7]=(byte)((totalLen>>24)&0xff);
        header[8]='W';
        header[9]='A';
        header[10]='V';
        header[11]='E';
        header[12]='f';
        header[13]='m';
        header[14]='t';
        header[15]=' ';
        header[16]=16;
        header[17]=0;
        header[18]=0;
        header[19]=0;
        header[20]=1;
        header[21]=0;
        header[22]=1;
        header[23]=0;
        header[24]=(byte)(44100&0xff);
        header[25]=(byte)((44100>>8)&0xff);
        header[26]=(byte)((44100>>16)&0xff);
        header[27]=(byte)((44100>>24)&0xff);
        header[28]=(byte)(byteRate&0xff);
        header[29]=(byte)((byteRate>>8)&0xff);
        header[30]=(byte)((byteRate>>16)&0xff);
        header[31]=(byte)((byteRate>>24)&0xff);
        header[32]=1;
        header[33]=0;
        header[34]=0;
        header[35]=0;
        header[36]='d';
        header[37]='a';
        header[38]='t';
        header[39]='a';
        header[40]=(byte)(dataLen&0xff);
        header[41]=(byte)((dataLen>>8)&0xff);
        header[42]=(byte)((dataLen>>8)&0xff);
        header[43]=(byte)((dataLen>>8)&0xff);
    }


    public void stopRecording(){
        ((TextView) findViewById(R.id.Current_State)).setText(("Would you like to record ?"));
        ((Button) findViewById(R.id.button2)).setText(("Stop"));

        try{
            audio.join();
            storage.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void TogglePlaying(View view){
        currentlyPlaying.set(!currentlyPlaying.get());
        if (!currentlyPlaying.get()) {
            stopPlay();
        } else {
            playRecord();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void playRecord(){
        ((TextView) findViewById(R.id.Current_State)).setText(("Recording..."));
        ((Button) findViewById(R.id.button3)).setText(("Start"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 0);
        }else {

            mr.setAudioSource(MediaRecorder.AudioSource.MIC);
            mr.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            String dirPath=getApplicationContext().getFilesDir().toString();
            mr.setOutputFile(dirPath+"/Record.mp4");
            try {
                mr.prepare();
                mr.start();
                System.out.println("Recording On");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void stopPlay(){
        ((TextView) findViewById(R.id.Current_State)).setText(("Would you like to record ?"));
        ((Button) findViewById(R.id.button4)).setText(("Stop"));
        if(currentlyPlaying.get()) {
            mr.reset();
            mr.release();
            mr.stop();
            mr = null;
        }
    }
}