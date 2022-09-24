package android.app.hospitals9.ui.Create;

import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.app.hospitals9.bd.SQLite;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.hospitals9.R;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Random;

public class Crear extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    private Button btnLimpia,btnGuarda;
    private EditText etid,etNombre,etFecha,etEdad,etEstatura,etPeso;
    private Spinner spnArea,spnDr,spnGenero;
    private ImageView ivFoto;
    private ImageButton btnCalendario;
    public static String img="",a,d,sex;

    public SQLite sqlite;


    private CrearViewModel mViewModel;

    public static Crear newInstance() {
        return new Crear();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.crear_fragment, container, false);
        sqlite = new SQLite(getContext());
        Componentes(root);

        return root;

    }
    private void Componentes(View root){
        EditTextComponentes(root);
        ButtonComponentes(root);
        SpinnerComponentes(root);

    }

    private  void EditTextComponentes( View root){
         etid = root.findViewById(R.id.etcIDP);
         etNombre= root.findViewById(R.id.etEID2);
         etFecha=root.findViewById(R.id.etcFecha);
         etEdad=root.findViewById(R.id.etcEdad);

        etEstatura= root.findViewById(R.id.Estatura);
        etPeso=root.findViewById(R.id.Peso);
    }
    private  void ButtonComponentes( View root){

        btnLimpia=root.findViewById(R.id.btnLimpiar);
        btnGuarda= root.findViewById(R.id.btnGuardar);
        ivFoto=root.findViewById(R.id.ivEPacienteFoto);


    }
    private  void SpinnerComponentes( View root){
        ArrayAdapter<CharSequence> areaAdapter,drAdapter,generoAdapter;
        areaAdapter = ArrayAdapter.createFromResource(getContext(),R.array.opciones, android.R.layout.simple_spinner_item);
        drAdapter = ArrayAdapter.createFromResource(getContext(), R.array.o0x, android.R.layout.simple_spinner_item);
        generoAdapter = ArrayAdapter.createFromResource(getContext(),R.array.sx, android.R.layout.simple_spinner_item);
        spnArea = root.findViewById(R.id.snpnncAreaP);
        spnDr=root.findViewById(R.id.SpinnerIEMedico);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CrearViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        
    }
}