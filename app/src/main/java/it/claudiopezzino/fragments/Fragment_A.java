package it.claudiopezzino.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Objects;

public class Fragment_A extends Fragment implements View.OnClickListener, TextView.OnEditorActionListener{

    private Button btn_send_message;
    private EditText etMessage;
    private TextView tv_incoming_messages;
    private FragmentAListener listener;

    /*-------------------------------------------------------------------------------------------------------------------------- */

    /* communication interface from A to B */
    public interface FragmentAListener{
        void sendMessageToB(CharSequence text);
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    /* it's necessary because before Fragment_A starts up it has to know message of Fragment_B */
    static Fragment_A newInstance(CharSequence message){
        Fragment_A fragment = new Fragment_A();
        Bundle args = new Bundle();
        args.putCharSequence("message", message);
        fragment.setArguments(args);
        return fragment;
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    /* Bundle is necessary for exchange of messages from A to B */
    private void setBundleInstance(){

        Bundle bundle = this.getArguments();
       if(bundle != null){
            updateOnTextView(Objects.requireNonNull(bundle).getString("message"));
        }
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_frag_comm_1, container, false);

        btn_send_message = v.findViewById(R.id.btn_send_message);
        etMessage = v.findViewById(R.id.etMessage);
        tv_incoming_messages = v.findViewById(R.id.tv_incoming_messages);

        btn_send_message.setOnClickListener(this);
        etMessage.setOnEditorActionListener(this);

        setBundleInstance();

        return v;
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    /* during this event communication interface is activated and Activity container implements its method */
    @Override
    public void onClick(View v) {

        if(v.getId() == btn_send_message.getId()){
            CharSequence message = etMessage.getText().toString();
            if(listener != null){
                listener.sendMessageToB(message);
            }
        }
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    /* during this event communication interface is activated and Activity container implements its method */
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_DONE){
            CharSequence message = etMessage.getText().toString();
            listener.sendMessageToB(message);
        }
        return false;
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    /* Text View of A is updated with message of B */
    public void updateOnTextView(CharSequence message){

        if(tv_incoming_messages != null) {
            tv_incoming_messages.setText(message);
        }
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    /* during this moment Fragment_A knows his Activity container and this one implements its interface */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener) {
            listener = (FragmentAListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FragmentAListener");
        }
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
