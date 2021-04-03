package be.ucll.integrationexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class loginuserActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginuser);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        TextView textView = findViewById(R.id.textView3);

        Button login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText inputUsername = findViewById(R.id.editTextTextPersonName);
                String username = inputUsername.getText().toString();

                EditText inputPass = findViewById(R.id.editTextTextPersonName2);
                String pass = inputPass.getText().toString();

                /*if(){
                    textView.setText("login is ok ");
                } else {
                    textView.setText("login is niet ok");
                }*/
                User test = userViewModel.login(username, pass).getValue();

                List<User> test2 = userViewModel.getAllUsers().getValue();

                if(test != null){
                    textView.setText(test.getLastname());
                } else {
                   textView.setText("test " + username + " / " + pass);
                }
            }
        });

    }
}