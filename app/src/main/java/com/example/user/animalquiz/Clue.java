package com.example.user.animalquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Clue extends AppCompatActivity{

    RadioGroup radioGrup;
    ImageView gambar;
    Button mainLagi, keluar;
    RadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton, radioButton;
    private TextView  clueTextView, clueChanceTextView, keteranganTextView;
    private List<GetSoal> listSoal;
    private Context mContext;
    private PopupWindow mPopupWindow;
    private LinearLayout mLinearLayout;
    boolean cekPertanyaan = false;
    int urutanPertanyaan = 0;
    String clue1, clue2, clue3, jawaban, keterangan;
    int flag = 0, image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue);

        mContext = getApplicationContext();
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        clueTextView = (TextView) findViewById(R.id.clue);
        clueChanceTextView = (TextView) findViewById(R.id.clueChance);

        option1RadioButton = (RadioButton) findViewById(R.id.option1);
        option2RadioButton = (RadioButton) findViewById(R.id.option2);
        option3RadioButton = (RadioButton) findViewById(R.id.option3);
        option4RadioButton = (RadioButton) findViewById(R.id.option4);
        radioGrup = (RadioGroup) findViewById(R.id.radioGrup);


        Database db = new Database(this);

        listSoal = new ArrayList<GetSoal>();
        listSoal = db.getSoal();

        setUpSoal();
    }

    private void setUpSoal() {
        this.mulai(0, cekPertanyaan);
    }

    private void mulai(int urutan_soal, boolean review) {
        try {
            GetSoal soal = new GetSoal();
            soal = listSoal.get(urutan_soal);
            clue1 = soal.getClue1();
            clue2 = soal.getClue2();
            clue3 = soal.getClue3();
            String option1 = soal.getPilihan1();
            String option2 = soal.getPilihan2();
            String option3 = soal.getPilihan3();
            String option4 = soal.getPilihan4();
            keterangan = soal.getKeterangan();
            image = soal.getImg();
            jawaban = soal.getJawaban();

            clueTextView.setText(clue1.toCharArray(), 0, clue1.length());
            clueChanceTextView.setText("Clue 1/3");
            flag = 1;

            option1RadioButton.setText(option1.toCharArray(), 0, option1.length());
            option2RadioButton.setText(option2.toCharArray(), 0, option2.length());
            option3RadioButton.setText(option3.toCharArray(), 0, option3.length());
            option4RadioButton.setText(option4.toCharArray(), 0, option4.length());

        } catch (Exception e) {
            Log.e(this.getClass().toString(), e.getMessage(), e.getCause());
        }
    }

    //KETIKA TOMBOL NEXT DI TEKAN
    public void next(View view){
        if(flag == 1){
            clueTextView.setText(clue2.toCharArray(), 0, clue2.length());
            clueChanceTextView.setText("Clue 2/3");
            flag = 2;
        }
        else if(flag == 2){
            clueTextView.setText(clue3.toCharArray(), 0, clue3.length());
            clueChanceTextView.setText("Clue 3/3");
            flag = 3;
        }
    }

    //KETIKA TOMBOL BACK DI TEKAN
    public void back(View view){
        if(flag == 2){
            clueTextView.setText(clue1.toCharArray(), 0, clue1.length());
            clueChanceTextView.setText("Clue 1/3");
            flag = 1;
        }
        else if(flag == 3){
            clueTextView.setText(clue2.toCharArray(), 0, clue2.length());
            clueChanceTextView.setText("Clue 2/3");
            flag = 2;
        }
    }

    public void submit(View view) {
        int selectedId = radioGrup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String jawabanRadioButton = radioButton.getText().toString();

        if (jawabanRadioButton.equals(jawaban)) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            // Inflate the custom layout/view
            View customView = inflater.inflate(R.layout.activity_pop_up,null);
            keteranganTextView = (TextView) customView.findViewById(R.id.keterangan_textView);
            gambar = (ImageView) customView.findViewById(R.id.imageView);
            mainLagi = (Button) customView.findViewById(R.id.button);
            keluar = (Button) customView.findViewById(R.id.keluar);

            //MENGATUR GAMBAR DAN KETERANGAN
            keteranganTextView.setText(keterangan.toCharArray(), 0, keterangan.length());
            gambar.setImageResource(image);

            // Initialize a new instance of popup window
            mPopupWindow = new PopupWindow(
                    customView,
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
            );

            // Call requires API level 21
            if(Build.VERSION.SDK_INT>=21){
                mPopupWindow.setElevation(5.0f);
            }

            mainLagi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Dismiss the popup window
                    urutanPertanyaan++;
                    if (urutanPertanyaan < listSoal.size()) {
                        mulai(urutanPertanyaan, cekPertanyaan);
                    }
                    else if(urutanPertanyaan >= listSoal.size()){
                        Toast.makeText(Clue.this, "Yeeyy.. Selamat Kamu Sudah Berhasil Menjawa Semua Soal", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Clue.this, MainActivity.class);
                        startActivity(intent);
                    }
                    mPopupWindow.dismiss();
                }
            });

            keluar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Dismiss the popup window
                    Intent intent = new Intent(Clue.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            // Finally, show the popup window at the center location of root relative layout
            mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);
        }
        else {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            // Inflate the custom layout/view
            View customView = inflater.inflate(R.layout.activity_pop_up_false,null);
            ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);

            // Initialize a new instance of popup window
            mPopupWindow = new PopupWindow(
                    customView,
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );

            // Call requires API level 21
            if(Build.VERSION.SDK_INT>=21){
                mPopupWindow.setElevation(5.0f);
            }

            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Dismiss the popup window
                    mPopupWindow.dismiss();
                }
            });

            // Finally, show the popup window at the center location of root relative layout
            mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);
        }
    }
}