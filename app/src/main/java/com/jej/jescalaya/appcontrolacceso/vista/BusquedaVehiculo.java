package com.jej.jescalaya.appcontrolacceso.vista;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.DialogFragment;
import android.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.jej.jescalaya.appcontrolacceso.R;
import com.jej.jescalaya.appcontrolacceso.controlador.C_CentroCosto;

public class BusquedaVehiculo extends DialogFragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private EditText txtBuscarVehiculo;

    //Para mostrar dialogo a pantalla completa
    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.busqueda_vehiculo, container, false);
        listView = view.findViewById(R.id.listaVehiculos);
        txtBuscarVehiculo = view.findViewById(R.id.txtBusquedaVehiculo);


        llenarListView();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ((RegistroIngresoSalida)getActivity()).txtVehiculoMovimiento.setText(String.valueOf(adapter.getItem(position)));

                getDialog().dismiss();

            }
        });



        txtBuscarVehiculo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                llenarListView();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }

    private void llenarListView() {
        C_CentroCosto c_centroCosto = new C_CentroCosto();
        adapter = c_centroCosto.llenarListaCentroCosto(BusquedaVehiculo.this.getActivity().getApplication(), listView, txtBuscarVehiculo.getText().toString());

    }

}
