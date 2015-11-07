package com.example.carlos.aula2;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AbstractActivity {

    static final int REQ_ACTIVITY2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //seta um texto
        TextView hello = (TextView) findViewById(R.id.hello);
        hello.setText("Novo Hello World");

        //pega nome do aplicativo do arquivo de strings
        String app_name = getResources().getString(R.string.app_name);

        //pega o botao e seta no nome para ele
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setText("Login");
        //pega evento do botao
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton();
            }
        });

        //tratar excessoes
        try {

        } catch (Exception e){
            Log.e(TAG, "Ocorreu um Erro: ", e);
        }

        //lista de dados
        final String[] arr = {"sol", "mercurio", "venus", "terra", "marte", "jupiter", "saturno", "urano", "neturno"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showMessage("Clicou em " + arr[position], Toast.LENGTH_LONG);

                //criar activity
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("planeta", arr[position]);
                startActivityForResult(i, REQ_ACTIVITY2);
                //REQ_ACTIVITY2 identificar quem esta chamando a outra activity
            }
        });
    }

    private void clickButton() {

        //seta texto
        TextView hello = (TextView) findViewById(R.id.hello);

        //pega da classe principal, dai define com final o hello
        hello.setText("Alterei o Texto..ahahahaha!");

        //alert toast
        showMessage("Alert toast teste", Toast.LENGTH_SHORT);

        //log
        Log.i(TAG, "Alterou texto");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //recupera o valor resultado devolvido pela outra activity
        if(resultCode == RESULT_OK && requestCode == REQ_ACTIVITY2) { //se for ok e for da activity que fez a requisicao
            showMessage(data.getStringExtra("result"), Toast.LENGTH_LONG);
            Log.i(TAG, "Result da activity: " + data.getStringExtra("result"));
        }
    }
}
