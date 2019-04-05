package com.jej.jescalaya.appcontrolacceso.vista;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
//import android.support.v4.app.DialogFragment;
import android.app.DialogFragment;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.R;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Cargo;
import com.jej.jescalaya.appcontrolacceso.controlador.C_CentroCosto;
import com.jej.jescalaya.appcontrolacceso.controlador.C_MotivoMovimiento;
import com.jej.jescalaya.appcontrolacceso.controlador.C_MovimientoAcceso;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Personal;
import com.jej.jescalaya.appcontrolacceso.controlador.C_TipoAcceso;
import com.jej.jescalaya.appcontrolacceso.controlador.C_TipoSexo;
import com.jej.jescalaya.appcontrolacceso.entidad.E_MotivoMovimiento;
import com.jej.jescalaya.appcontrolacceso.entidad.E_TipoAcceso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistroIngresoSalida extends AppCompatActivity {

    private EditText txtFechaHoraMovimiento;
    private ImageButton imbFechaHoraMovimiento;
    private Spinner spMotivoMovimiento;
    private Spinner spTipoAccesoMovimiento;
    private EditText txtDniMovimiento;
    private EditText txtNombreApellidoMovimiento;
    public EditText txtVehiculoMovimiento;
    private Button btnBuscaVehiculo;
    public EditText txtPlacaMovimiento;
    public EditText txtMarcaMovimiento;
    private EditText txtModeloMovimiento;
    private Button btnRegistraMovimiento;
    private Button btnVolverMenuMovimiento;

    private int hora;
    private int minuto;
    private String horaSelector = "";

    private int idMotivo;
    private int idTipoAcceso;
    public int idCentroCosto = 5;

    private String placa;
    private String marca;
    private String modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ingreso_salida);

        txtFechaHoraMovimiento = findViewById(R.id.txtFechaHoraMovimiento);
        imbFechaHoraMovimiento = findViewById(R.id.imbFechaHoraMovimiento);
        spMotivoMovimiento = findViewById(R.id.spMotivoMovimiento);
        spTipoAccesoMovimiento = findViewById(R.id.spTipoAccesoMovimiento);
        txtDniMovimiento = findViewById(R.id.txtDniMovimiento);
        txtNombreApellidoMovimiento = findViewById(R.id.txtNombreApellidoMovimiento);
        txtVehiculoMovimiento = findViewById(R.id.txtVehiculoMovimiento);
        btnBuscaVehiculo = findViewById(R.id.btnBuscaVehiculo);
        txtPlacaMovimiento = findViewById(R.id.txtPlacaMovimiento);
        txtMarcaMovimiento = findViewById(R.id.txtMarcaMovimiento);
        txtModeloMovimiento = findViewById(R.id.txtModeloMovimiento);
        btnRegistraMovimiento = findViewById(R.id.btnRegistraMovimiento);
        btnVolverMenuMovimiento = findViewById(R.id.btnVolverMenuMovimiento);

        llenarMotivoMovimiento();
        llenarTipoAcceso();
        txtFechaHoraMovimiento.setText(fechaHoraActual("dd/MM/yy HH:mm:ss"));

        placa = txtPlacaMovimiento.getText().toString();
        marca = txtMarcaMovimiento.getText().toString();
        modelo = txtModeloMovimiento.getText().toString();

        txtFechaHoraMovimiento.setEnabled(false);
        txtNombreApellidoMovimiento.setEnabled(false);

        txtDniMovimiento.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try{
                    C_Personal c_personal =  new C_Personal();
                    txtNombreApellidoMovimiento.setText(c_personal.buscaPersona(RegistroIngresoSalida.this, txtDniMovimiento.getText().toString()));
                }catch (Exception e){
                    Toast.makeText(RegistroIngresoSalida.this, "¡Persona no encontrada!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    C_Personal c_personal =  new C_Personal();
                    txtNombreApellidoMovimiento.setText(c_personal.buscaPersona(RegistroIngresoSalida.this, txtDniMovimiento.getText().toString()));
                }catch (Exception e){
                    Toast.makeText(RegistroIngresoSalida.this, "¡Persona no encontrada!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtVehiculoMovimiento.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    buscaDatosCentroCosto();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtDniMovimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    C_Personal c_personal =  new C_Personal();
                    txtNombreApellidoMovimiento.setText(c_personal.buscaPersona(RegistroIngresoSalida.this, txtDniMovimiento.getText().toString()));
                }catch (Exception e){
                    Toast.makeText(RegistroIngresoSalida.this, "¡Persona no encontrada!", Toast.LENGTH_SHORT).show();
                }
            }
        });



        spMotivoMovimiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                E_MotivoMovimiento motivoMovimiento = (E_MotivoMovimiento) adapterView.getSelectedItem();
                idMotivo = motivoMovimiento.getMotMov_Id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spTipoAccesoMovimiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                E_TipoAcceso e_tipoAcceso = (E_TipoAcceso) adapterView.getSelectedItem();
                idTipoAcceso = e_tipoAcceso.getTipAcc_Id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnBuscaVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBusquedaVehiculo();
            }
        });

        imbFechaHoraMovimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                hora = calendar.get(Calendar.HOUR_OF_DAY);
                minuto = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialogHora = new TimePickerDialog(RegistroIngresoSalida.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        horaSelector = hourOfDay + ":" + minute + ":00";
                        txtFechaHoraMovimiento.setText(fechaHoraActual("dd/MM/yyyy") + " " + horaSelector);
                    }
                }, hora, minuto, false);
                timePickerDialogHora.show();
            }
        });

        //Registra Movimiento

        btnRegistraMovimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buscaDatosCentroCosto();

                if(txtDniMovimiento.getText().toString().equals("")) {
                    Toast.makeText(RegistroIngresoSalida.this, "Falta DNI", Toast.LENGTH_SHORT).show();
                }else if(txtNombreApellidoMovimiento.getText().toString().equals("")){
                    Toast.makeText(RegistroIngresoSalida.this, "Por favor registre Personal", Toast.LENGTH_SHORT).show();

                }else if(!txtDniMovimiento.getText().toString().equals("") && !txtNombreApellidoMovimiento.getText().toString().equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(RegistroIngresoSalida.this);
                    builder.setTitle("Registro Movimiento Acceso");
                    builder.setMessage("¿Desea guardar registro?");
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            C_MovimientoAcceso c_movimientoAcceso = new C_MovimientoAcceso();
                            c_movimientoAcceso.insertaMovimientoAcceso(RegistroIngresoSalida.this, txtFechaHoraMovimiento.getText().toString(),fechaHoraActual("dd/MM/yyyy HH:mm:ss"),fechaHoraActual("dd/MM/yyyy HH:mm:ss"),txtDniMovimiento.getText().toString(),1, Integer.parseInt(VariableGeneral.conf_Sucursal),idMotivo, idTipoAcceso, idCentroCosto,placa,marca,modelo);
                            limpiarElementos();
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
        });

        btnVolverMenuMovimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             volverMenu();
            }
        });

        txtVehiculoMovimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscaDatosCentroCosto();
            }
        });


    }

    void limpiarElementos(){
        txtFechaHoraMovimiento.setText(fechaHoraActual("dd/MM/yyyy HH:mm:ss"));
        txtDniMovimiento.setText("");
        txtNombreApellidoMovimiento.setText("");
        txtVehiculoMovimiento.setText("");
        txtPlacaMovimiento.setText("");
        txtMarcaMovimiento.setText("");
        txtModeloMovimiento.setText("");
    }

    void volverMenu(){
        Intent intent = new Intent(RegistroIngresoSalida.this, MenuPrincipal.class);
        startActivity(intent);
        RegistroIngresoSalida.this.finish();
    }

    @Override
    public void onBackPressed() {
        volverMenu();
    }


    void llenarMotivoMovimiento(){
        C_MotivoMovimiento c_motivoMovimiento = new C_MotivoMovimiento();
        c_motivoMovimiento.llenarSpinner(RegistroIngresoSalida.this, spMotivoMovimiento);
    }

    void llenarTipoAcceso(){
        C_TipoAcceso c_tipoAcceso = new C_TipoAcceso();
        c_tipoAcceso.llenarSpinner(RegistroIngresoSalida.this, spTipoAccesoMovimiento);
    }

    private String fechaHoraActual(String formatoFechaHora) {
        Calendar Cal = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat(formatoFechaHora);
        return (df.format(Cal.getInstance().getTime()).toString());
    }

    private void callBusquedaVehiculo() {
        idCentroCosto = 0;
        txtVehiculoMovimiento.setText("");

        BusquedaVehiculo dialog = new BusquedaVehiculo();
        dialog.show(getFragmentManager(),"VEHICULO");
    }

    public void buscaDatosCentroCosto(){
        C_CentroCosto c_centroCosto = new C_CentroCosto();

        try{
            if(!txtVehiculoMovimiento.getText().toString().equals("")) {
                String[] data = c_centroCosto.buscaDatosCentroCosto(RegistroIngresoSalida.this, txtVehiculoMovimiento.getText().toString());
                idCentroCosto = Integer.parseInt(data[0]);
                txtPlacaMovimiento.setText(data[1]);
                txtMarcaMovimiento.setText(data[2]);
                txtModeloMovimiento.setText(data[3]);
            }else{
                idCentroCosto = 5;
                placa = "-";
                marca = "-";
                modelo = "-";
            }
        }catch (Exception e){

        }
    }
}
