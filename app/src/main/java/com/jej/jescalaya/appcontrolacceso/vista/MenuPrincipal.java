package com.jej.jescalaya.appcontrolacceso.vista;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.R;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Configuracion;
import com.jej.jescalaya.appcontrolacceso.entidad.E_Configuracion;
import com.jej.jescalaya.appcontrolacceso.modelo.Sincroniza_MovimientoAcceso;
import com.jej.jescalaya.appcontrolacceso.modelo.Sincroniza_Personal;

public class MenuPrincipal extends AppCompatActivity {

    private ImageButton imbPersonal;
    private ImageButton imbRegistroMovimiento;
    private ImageButton imbConfiguracion;
    private ImageButton imbSincronizaMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        imbPersonal = findViewById(R.id.imbPersonal);
        imbRegistroMovimiento = findViewById(R.id.imbRegistroMovimiento);
        imbConfiguracion = findViewById(R.id.imbConfiguracion);
        imbSincronizaMenu = findViewById(R.id.imbSincronizaMenu);

        if(!VariableGeneral.estado_Configuracion){
            imbConfiguracion.setEnabled(false);
        }


        traeConfiguracion();

        imbPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), IngresaPersonal.class);
                startActivity(intent);
                MenuPrincipal.this.finish();
            }
        });

        imbRegistroMovimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RegistroIngresoSalida.class);
                startActivity(intent);
                MenuPrincipal.this.finish();
            }
        });

        imbConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Configuracion.class);
                startActivity(intent);
                MenuPrincipal.this.finish();
            }
        });

        imbSincronizaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sincroniza Personal
                Sincroniza_Personal sincroniza_personal = new Sincroniza_Personal();
                sincroniza_personal.recorreListaSincronizaPersonal(MenuPrincipal.this);

                //Sincroniza Movimiento
                Sincroniza_MovimientoAcceso sincroniza_movimientoAcceso = new Sincroniza_MovimientoAcceso();
                sincroniza_movimientoAcceso.recorreListaSincronizaPersonal(MenuPrincipal.this);

                Toast.makeText(MenuPrincipal.this, "¡Tablas Sincronizadas!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void traeConfiguracion() {
        C_Configuracion configuracion = new C_Configuracion();
        E_Configuracion config = new E_Configuracion();
        config = configuracion.configuracionSelect(MenuPrincipal.this);
        try {
            VariableGeneral.conf_Empresa = config.getConf_Empresa();
            VariableGeneral.conf_Sucursal = config.getConf_Sucursal();
            VariableGeneral.conf_IpServidor = config.getConf_IpServidor();

        } catch (NullPointerException e) {
            Toast.makeText(this, "Inicie parámetros de configuración", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuPrincipal.this, Configuracion.class);
            startActivity(intent);

        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuPrincipal.this);
        builder.setTitle("Control Acceso Personal");
        builder.setMessage("¿Desea salir del App?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MenuPrincipal.this.finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


}
