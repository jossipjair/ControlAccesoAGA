package com.jej.jescalaya.appcontrolacceso.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.R;

public class Login extends AppCompatActivity {

    private EditText usuario;
    private EditText password;
    private Button btnAcceder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.input_password);
        btnAcceder = findViewById(R.id.btnIngresar);

        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(usuario.getText().toString().equals("admin") && password.getText().toString().equals("1234")) {
                    VariableGeneral.estado_Configuracion = true;
                    Intent intent = new Intent(view.getContext(), MenuPrincipal.class);
                    startActivity(intent);
                    Login.this.finish();
                }else if(usuario.getText().toString().equals("SEGURIDAD") && password.getText().toString().equals("123")){
                    VariableGeneral.estado_Configuracion = false;
                    Intent intent = new Intent(view.getContext(), MenuPrincipal.class);
                    startActivity(intent);
                    Login.this.finish();
                }else{
                    Toast.makeText(Login.this, "Error de inicio de Sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
