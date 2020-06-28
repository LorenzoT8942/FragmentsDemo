package it.claudiopezzino.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class VM_Activity extends AppCompatActivity implements View.OnClickListener {

    private MyViewModel vmodel;
    private TextView tv_msg;
    private EditText et_msg;
    private Button btn_sendToF1;
    private Button btn_sendToF2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vm_comm);

        tv_msg = findViewById(R.id.tv_message);
        et_msg = findViewById(R.id.et_message);
        btn_sendToF1 = findViewById(R.id.btn_SendToF1);
        btn_sendToF2 = findViewById(R.id.btn_SendToF2);
        btn_sendToF1.setOnClickListener(this);
        btn_sendToF2.setOnClickListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_1, new VM_fragment1()).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_2, new VM_fragment2()).commit();
        }

        vmodel = new ViewModelProvider(this).get(MyViewModel.class);
        vmodel.getActivity_msg().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_msg.setText(s);
            }
        });

    }

    @Override
    public void onClick(View view) {
        Log.d("et debug", et_msg.getText().toString());
        int ViewID = view.getId();

        if (ViewID == R.id.btn_SendToF1){
            Log.d("et debug", et_msg.getText().toString());
            vmodel.setFragment1_msg(et_msg.getText().toString());
        }

        if (ViewID == R.id.btn_SendToF2){
            Log.d("et debug", et_msg.getText().toString());
            vmodel.setFragment2_msg(et_msg.getText().toString());
        }
    }
}
