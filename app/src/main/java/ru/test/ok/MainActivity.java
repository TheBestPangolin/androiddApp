package ru.test.ok;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Data data = Information.data;
    private EditText etfn;
    private EditText etsn;
    private EditText etage;
    private EditText etphn;
    private Button save;
    private Button reset;
    boolean isSaved;
    public static final String KEY_SAVED="saved";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setupView();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(KEY_SAVED,isSaved);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isSaved=savedInstanceState.getBoolean(KEY_SAVED,true);
        if(isSaved){
            save.setEnabled(true);
            reset.setEnabled(true);
        } else turnOff();
    }

    private void initView() {
        etfn = findViewById(R.id.etfn);
        etsn = findViewById(R.id.etsn);
        etage = findViewById(R.id.etage);
        etphn = findViewById(R.id.etphn);
        save = findViewById(R.id.save);
        reset=findViewById(R.id.reset);
    }

    private void setupView() {
        turnOff();
        etfn.setText(String.valueOf(data.getFn()));
        etsn.setText(String.valueOf(data.getSn()));
        etage.setText(String.valueOf(data.getAge()));
        etphn.setText(String.valueOf(data.getPhn()));
        setWatch(etfn);
        setWatch(etsn);
        setWatch(etphn);
        setWatch(etage);
        save.setOnClickListener(view -> {
            turnOff();
            Information.data.setFn(String.valueOf(etfn.getText()));
            Information.data.setSn(String.valueOf(etsn.getText()));
            Information.data.setAge(String.valueOf(etage.getText()));
            Information.data.setPhn(String.valueOf(etphn.getText()));
            setWatch(etfn);
            setWatch(etsn);
            setWatch(etphn);
            setWatch(etage);
            update();
            Toast.makeText(MainActivity.this,"Information saved", Toast.LENGTH_SHORT).show();
        });
        reset.setOnClickListener(view ->{
            turnOff();
            etfn.setText(String.valueOf(data.getFn()));
            etsn.setText(String.valueOf(data.getSn()));
            etage.setText(String.valueOf(data.getAge()));
            etphn.setText(String.valueOf(data.getPhn()));
            setWatch(etfn);
            setWatch(etsn);
            setWatch(etphn);
            setWatch(etage);
            turnOff();
            Toast.makeText(MainActivity.this,"Information has been reset", Toast.LENGTH_SHORT).show();
        });
    }
    private void setWatch(EditText et){
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                save.setEnabled(true);
                reset.setEnabled(true);
                isSaved=true;
            }
            @Override
            public void afterTextChanged(Editable editable) {
                save.setEnabled(true);
                reset.setEnabled(true);
                isSaved=true;
            }
        });
    }
    private void update(){
        data=Information.data;
    }
    private void turnOff(){
        save.setEnabled(false);
        reset.setEnabled(false);
        isSaved=false;
    }
}
