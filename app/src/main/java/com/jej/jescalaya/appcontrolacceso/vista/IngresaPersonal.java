package com.jej.jescalaya.appcontrolacceso.vista;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.R;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Cargo;
import com.jej.jescalaya.appcontrolacceso.controlador.C_Personal;
import com.jej.jescalaya.appcontrolacceso.controlador.C_TipoDocumentoIdentidad;
import com.jej.jescalaya.appcontrolacceso.controlador.C_TipoSexo;
import com.jej.jescalaya.appcontrolacceso.entidad.E_Cargo;
import com.jej.jescalaya.appcontrolacceso.entidad.E_TipoDocumentoIdentidad;
import com.jej.jescalaya.appcontrolacceso.entidad.E_TipoSexo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IngresaPersonal extends AppCompatActivity {

    private Spinner spTipoDocumento;
    private Spinner spCargo;
    private Spinner spSexo;
    private EditText txtDni;
    private EditText txtApellidoPaterno;
    private EditText txtApellidoMaterno;
    private EditText txtNombres;
    private EditText txtDireccion;
    private EditText txtFechaNacimiento;
    private ImageButton imbFechaNacimiento;
    private Button btnRegistrar;
    private Button btnVolverMenu;
    private String fechaSeleccionada;

    //Fecha
    private int anio;
    private int mes;
    private int dia;

    private int tipoDocumento;
    private int tipoSexo;
    private int tipoCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresa_personal);

        spTipoDocumento = findViewById(R.id.spTipoDocumento);
        spCargo = findViewById(R.id.spCargo);
        spSexo = findViewById(R.id.spSexo);
        txtDni = findViewById(R.id.txtDni);
        txtApellidoPaterno = findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = findViewById(R.id.txtApellidoMaterno);
        txtNombres = findViewById(R.id.txtNombres);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        imbFechaNacimiento = findViewById(R.id.imbFechaNacimiento);
        btnRegistrar = findViewById(R.id.btnRegistraMovimiento);
        btnVolverMenu = findViewById(R.id.btnVolverMenuMovimiento);

        llenarCargo();
        llenarSexo();
        llenarTipoDocumento();

        spTipoDocumento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                E_TipoDocumentoIdentidad tipoDocumentoIdentidad = (E_TipoDocumentoIdentidad) adapterView.getSelectedItem();
                tipoDocumento = tipoDocumentoIdentidad.getTipDocIde_Id();
                //Toast.makeText(IngresaPersonal.this, String.valueOf(tipoDocumento), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spCargo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                E_Cargo cargo = (E_Cargo) adapterView.getSelectedItem();
                tipoCargo = cargo.getCar_Id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                E_TipoSexo e_tipoSexo = (E_TipoSexo) adapterView.getSelectedItem();
                tipoSexo = e_tipoSexo.getTipSex_Id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        txtFechaNacimiento.setEnabled(false);

        imbFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                dia = calendar.get(Calendar.DAY_OF_MONTH);
                mes = calendar.get(Calendar.MONTH);
                anio = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(IngresaPersonal.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechaSeleccionada = (month + 1) + "/" + dayOfMonth + "/" + year;
                        Date fecha = new Date(fechaSeleccionada);
                        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                        txtFechaNacimiento.setText(sd.format(fecha));
                    }
                }, anio, mes, dia);
                datePickerDialog.show();
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(IngresaPersonal.this);
                builder.setTitle("Registro Personal");
                builder.setMessage("¿Desea guardar registro?");
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (txtDni.getText().toString().equals("")) {
                            Toast.makeText(IngresaPersonal.this, "Falta DNI", Toast.LENGTH_SHORT).show();
                        } else if (txtApellidoPaterno.getText().toString().equals("")) {
                            Toast.makeText(IngresaPersonal.this, "Falta Apellido Paterno", Toast.LENGTH_SHORT).show();
                        } else if (txtApellidoMaterno.getText().toString().equals("")) {
                            Toast.makeText(IngresaPersonal.this, "Falta Apellido Materno", Toast.LENGTH_SHORT).show();
                        } else if (txtNombres.getText().toString().equals("")) {
                            Toast.makeText(IngresaPersonal.this, "Falta Nombres", Toast.LENGTH_SHORT).show();
                        } else if (txtDireccion.getText().toString().equals("")) {
                            Toast.makeText(IngresaPersonal.this, "Falta Direccion", Toast.LENGTH_SHORT).show();
                        } else if (txtFechaNacimiento.getText().toString().equals("")) {
                            Toast.makeText(IngresaPersonal.this, "Falta Fecha Nacimiento", Toast.LENGTH_SHORT).show();
                        } else {
                            C_Personal c_personal = new C_Personal();
                            c_personal.insertaPersonalLocal(IngresaPersonal.this, txtDni.getText().toString(), 1, tipoCargo, tipoDocumento, tipoSexo, txtApellidoPaterno.getText().toString(), txtApellidoMaterno.getText().toString(), txtNombres.getText().toString(), txtDni.getText().toString(), txtDireccion.getText().toString(), "-", txtFechaNacimiento.getText().toString(), "");
                            limpiaElementos();
                        }


                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btnVolverMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volverMenu();
            }
        });


    }

    @Override
    public void onBackPressed() {
        volverMenu();
    }

    void volverMenu() {
        Intent intent = new Intent(IngresaPersonal.this, MenuPrincipal.class);
        startActivity(intent);
        IngresaPersonal.this.finish();
    }

    void llenarTipoDocumento() {
        C_TipoDocumentoIdentidad c_tipoDocumentoIdentidad = new C_TipoDocumentoIdentidad();
        c_tipoDocumentoIdentidad.llenarSpinner(IngresaPersonal.this, spTipoDocumento);
    }

    void llenarCargo() {
        C_Cargo c_cargo = new C_Cargo();
        c_cargo.llenarSpinner(IngresaPersonal.this, spCargo);
    }

    void llenarSexo() {
        C_TipoSexo c_tipoSexo = new C_TipoSexo();
        c_tipoSexo.llenarSpinner(IngresaPersonal.this, spSexo);
    }

    void limpiaElementos() {
        txtDni.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtNombres.setText("");
        txtFechaNacimiento.setText("");
        txtDireccion.setText("");
    }

}
