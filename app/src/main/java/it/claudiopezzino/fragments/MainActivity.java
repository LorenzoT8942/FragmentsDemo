package it.claudiopezzino.fragments;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Holder();
    }



    class Holder implements View.OnClickListener{
        Button btn_ViewModel_communication;
        Button btn_single_fragment;
        Button btn_multiple_fragments;
        Button btn_swipe;

        Holder(){

            btn_single_fragment = findViewById(R.id.btn_activity_communication);
            btn_multiple_fragments = findViewById(R.id.btn_multiple_fragments);
            btn_ViewModel_communication = findViewById(R.id.btn_vm);
            btn_swipe = findViewById(R.id.btn_swipe);

            btn_single_fragment.setOnClickListener(this);
            btn_multiple_fragments.setOnClickListener(this);
            btn_ViewModel_communication.setOnClickListener(this);
            btn_swipe.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.btn_multiple_fragments){
                Intent intent = new Intent(MainActivity.this, FragmentsActivity.class);
                startActivity(intent);
            }

            if (v.getId() == R.id.btn_activity_communication){
                Intent intent = new Intent(MainActivity.this, FragmentToActivity.class);
                startActivity(intent);
            }

            if(v.getId() == R.id.btn_vm){
                Intent intent = new Intent(MainActivity.this, VM_Activity.class);
                startActivity(intent);
            }

            if(v.getId() == R.id.btn_swipe){
                Intent intent = new Intent(MainActivity.this, Swipe_Activity.class);
                startActivity(intent);
            }
        }
    }
}
