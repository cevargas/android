package com.example.carlos.aula2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //recupera parametro passado pela outra activity
        final String planeta = getIntent().getStringExtra("planeta");

        //seta o valor
        TextView getText = (TextView) findViewById(R.id.textPlaneta);
        getText.setText(planeta);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("result", planeta);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
