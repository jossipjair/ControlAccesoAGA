package com.jej.jescalaya.appcontrolacceso.vista;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.R;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Configuracion;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Empresa;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Sucursal;
import com.jej.jescalaya.appcontrolacceso.entidad.E_Empresa;
import com.jej.jescalaya.appcontrolacceso.entidad.E_Sucursal;

public class Configuracion extends AppCompatActivity {

    private Spinner spEmpresa;
    private Spinner spSucursal;
    private EditText txtIpServidor;
    private ImageButton imbSincronizaTablas;
    private Button btnGrabar;
    private Button btnSalir;

    private int empresa_Id = 1;
    private int sucursal_Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        spEmpresa = findViewById(R.id.spEmpresa);
        spSucursal = findViewById(R.id.spSucursal);
        txtIpServidor = findViewById(R.id.txtServidor);
        imbSincronizaTablas = findViewById(R.id.imbSincronizacion);
        btnGrabar = findViewById(R.id.btnGrabar);
        btnSalir = findViewById(R.id.btnSalirSistema);


        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveConfiguracion();
            }
        });

        imbSincronizaTablas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VariableGeneral.conf_IpServidor = txtIpServidor.getText().toString();
                Intent intent = new Intent(view.getContext(), Sincronizacion.class);
                startActivity(intent);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volverMenu();
            }
        });

        llenarEmpresa();
        llenarSucursal();

        spEmpresa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                E_Empresa empresa = (E_Empresa) parent.getSelectedItem();
                empresa_Id = empresa.getEmp_Id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spSucursal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                E_Sucursal sucursal = (E_Sucursal) parent.getSelectedItem();
                sucursal_Id = sucursal.getSuc_Id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onBackPressed() {
      volverMenu();
    }

    void volverMenu(){
        Intent intent = new Intent(Configuracion.this, MenuPrincipal.class);
        startActivity(intent);
        Configuracion.this.finish();
    }
    void llenarEmpresa(){
        C_Empresa empresa = new C_Empresa();
        empresa.llenarSpinner(Configuracion.this, spEmpresa);
    }

    void llenarSucursal(){
        C_Sucursal sucursal = new C_Sucursal();
        sucursal.llenarSpinner(Configuracion.this, spSucursal);
    }

    public void saveConfiguracion() {
        C_Configuracion configuracion = new C_Configuracion();

        if(empresa_Id > 0 && sucursal_Id > 0 ){
            configuracion.guardarConfiguracion(Configuracion.this, String.valueOf(empresa_Id), String.valueOf(sucursal_Id), String.valueOf(txtIpServidor.getText()));
        }else {
            Toast.makeText(this, "No se puede guardar configuración\nRevise sincronización", Toast.LENGTH_SHORT).show();
        }
    }


}
