package com.example.carlos.aula2;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by CarlosEduardode on 07/11/2015.
 */
public class AbstractActivity extends AppCompatActivity {

    //definicao da identificacao da classe nos logs
    final String TAG = this.getClass().getSimpleName();

    //mensagem de alert
    void showMessage(String msg, int duraction) {
        Toast.makeText(this, msg, duraction).show();
    }
}
