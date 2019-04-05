package com.jej.jescalaya.appcontrolacceso.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.jej.jescalaya.appcontrolacceso.R;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Cargo;
import com.jej.jescalaya.appcontrolacceso.controlador.C_CentroCosto;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Empresa;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Estado;
import com.jej.jescalaya.appcontrolacceso.controlador.C_MotivoMovimiento;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Personal;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Sucursal;
import com.jej.jescalaya.appcontrolacceso.controlador.C_TipoAcceso;
import com.jej.jescalaya.appcontrolacceso.controlador.C_TipoDocumentoIdentidad;
import com.jej.jescalaya.appcontrolacceso.controlador.C_TipoSexo;

public class Sincronizacion extends AppCompatActivity {

    private CheckBox chkCargo;
    private CheckBox chkCentroCosto;
    private CheckBox chkEmpresa;
    private CheckBox chkEstado;
    private CheckBox chkMotivoMovimiento;
    private CheckBox chkMovimientoAcceso;
    private CheckBox chkPersonalTrabajadores;
    private CheckBox chkSucursal;
    private CheckBox chkTipoAcceso;
    private CheckBox chkTipoDocumentoIdentidad;
    private CheckBox chkSexo;
    private CheckBox chkSeleccionaTodo;
    private Button btnSincroniza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizacion);

        chkCargo = findViewById(R.id.chkCargo);
        chkCentroCosto = findViewById(R.id.chkCentroCosto);
        chkEmpresa = findViewById(R.id.chkEmpresa);
        chkEstado = findViewById(R.id.chkEstado);
        chkMotivoMovimiento = findViewById(R.id.chkMotivoMovimiento);
        chkMovimientoAcceso = findViewById(R.id.chkMovimientoAcceso);
        chkPersonalTrabajadores = findViewById(R.id.chkPersonal);
        chkSucursal = findViewById(R.id.chkSucursal);
        chkTipoAcceso = findViewById(R.id.chkTipoAcceso);
        chkTipoDocumentoIdentidad = findViewById(R.id.chkTipoDocumentoIdentidad);
        chkSexo = findViewById(R.id.chkTipoSexo);
        chkSeleccionaTodo = findViewById(R.id.chkTodas);
        btnSincroniza = findViewById(R.id.btnSincroniza);

        btnSincroniza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validSeleccion();
            }
        });

        chkSeleccionaTodo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chkCargo.setChecked(true);
                chkCentroCosto.setChecked(true);
                chkEmpresa.setChecked(true);
                chkEstado.setChecked(true);
                chkMotivoMovimiento.setChecked(true);
                chkMovimientoAcceso.setChecked(true);
                chkPersonalTrabajadores.setChecked(true);
                chkSucursal.setChecked(true);
                chkTipoAcceso.setChecked(true);
                chkTipoDocumentoIdentidad.setChecked(true);
                chkSexo.setChecked(true);
            }
        });

    }

    void validSeleccion(){
        if(chkCentroCosto.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_CentroCosto c_centroCosto = new C_CentroCosto();
                c_centroCosto.insertaCentroCostoRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkCargo.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_Cargo c_cargo = new C_Cargo();
                c_cargo.insertaCargoRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkEmpresa.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_Empresa c_empresa = new C_Empresa();
                c_empresa.insertaEmpresaRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkEstado.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_Estado c_estado = new C_Estado();
                c_estado.insertaEstadoRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkMotivoMovimiento.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_MotivoMovimiento c_motivoMovimiento = new C_MotivoMovimiento();
                c_motivoMovimiento.insertaMotivoMovimientoRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkPersonalTrabajadores.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_Personal c_personal = new C_Personal();
                c_personal.insertaPersonalRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkSucursal.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_Sucursal c_sucursal = new C_Sucursal();
                c_sucursal.insertaSucursalRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkTipoAcceso.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_TipoAcceso c_tipoAcceso = new C_TipoAcceso();
                c_tipoAcceso.insertaTipoAccesoRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkTipoDocumentoIdentidad.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_TipoDocumentoIdentidad c_tipoDocumentoIdentidad = new C_TipoDocumentoIdentidad();
                c_tipoDocumentoIdentidad.insertaTipoDocumentoIdentidadRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(chkSexo.isChecked()){
            try{
                Thread.sleep(3 * 1000);
                C_TipoSexo c_tipoSexo = new C_TipoSexo();
                c_tipoSexo.insertaTipoSexoRest(Sincronizacion.this);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onBackPressed() {
        volverMenu();
    }

    void volverMenu(){
        Intent intent = new Intent(Sincronizacion.this, Configuracion.class);
        startActivity(intent);
        Sincronizacion.this.finish();
    }

}
