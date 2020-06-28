package it.claudiopezzino.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class VMFragment1 extends Fragment implements View.OnClickListener {
    private MyViewModel vmodel;
    private TextView tv_message;
    private EditText et_msg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vm_1, container, false);
        tv_message = view.findViewById(R.id.tv_message);
        et_msg = view.findViewById(R.id.et_message);
        Button btn_SendToF1 = view.findViewById(R.id.btn_F1SendToF2);
        Button btn_SendToActivity = view.findViewById(R.id.btn_F1SendToActivity);

        btn_SendToActivity.setOnClickListener(this);
        btn_SendToF1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vmodel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        vmodel.getFragment1_msg().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_message.setText(s);
            }
        });
    }


    @Override
    public void onClick(View view) {

        int viewId = view.getId();

        if (viewId == R.id.btn_F1SendToActivity) {
            vmodel.setActivity_msg(et_msg.getText().toString());
        }

        if (viewId == R.id.btn_F1SendToF2) {
            vmodel.setFragment2_msg((et_msg.getText().toString()));

        }
    }
}


