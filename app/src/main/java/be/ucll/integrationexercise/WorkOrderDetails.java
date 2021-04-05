package be.ucll.integrationexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WorkOrderDetails extends AppCompatActivity {

    private UserViewModel userViewModel;
    private String firstname;
    private String lastname;
    private String username;
    private Boolean input1 = false;
    private Boolean input2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_details);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        Intent intent = getIntent();

        firstname = intent.getStringExtra("firstname");
        lastname = intent.getStringExtra("lastname");
        username = intent.getStringExtra("user");

        int id = intent.getIntExtra("id", 0);

        TextView textView = findViewById(R.id.textView9);
        textView.setText("Ordernumber: " + id);

        Button save = findViewById(R.id.button2);
        EditText problemText = findViewById(R.id.editTextTextPersonName3);
        EditText repairText = findViewById(R.id.editTextTextPersonName4);

        save.setText("Back");
        TextView info = findViewById(R.id.textView15);

        problemText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input1 = true;
                if(input1 && input2){
                    save.setText("Save");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        repairText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input2 = true;
                if(input1 && input2){
                    save.setText("Save");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        userViewModel.getDetails(id).observe(this, new Observer<WorkOrder>() {
            @Override
            public void onChanged(WorkOrder workOrder) {
                info.setText(workOrder.getCustomerName() + ", " + workOrder.getCity() + ", " + workOrder.getDevice());
                if (workOrder.getProcessed() == true) {
                    problemText.setText(workOrder.getDetailedProblemDescription());
                    repairText.setText(workOrder.getRepairInformation());
                    save.setText("Back");
                    problemText.setEnabled(false);
                    repairText.setEnabled(false);
                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(WorkOrderDetails.this, MainActivity.class);
                            intent.putExtra("user", username);
                            intent.putExtra("firstname", firstname);
                            intent.putExtra("lastname", lastname);
                            finish();
                            startActivity(intent);
                        }
                    });
                } else {
                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(save.getText() == "Back"){
                                Intent intent = new Intent(WorkOrderDetails.this, MainActivity.class);
                                intent.putExtra("user", username);
                                intent.putExtra("firstname", firstname);
                                intent.putExtra("lastname", lastname);
                                finish();
                                startActivity(intent);
                            } else {
                                String problem = problemText.getText().toString();
                                workOrder.setDetailedProblemDescription(problem);
                                String repair = repairText.getText().toString();
                                workOrder.setRepairInformation(repair);
                                workOrder.setProcessed(true);
                                userViewModel.updateWorkOrder(workOrder);
                                Intent intent = new Intent(WorkOrderDetails.this, MainActivity.class);
                                intent.putExtra("user", username);
                                intent.putExtra("firstname", firstname);
                                intent.putExtra("lastname", lastname);
                                finish();
                                startActivity(intent);
                            }
                        }
                    });
                }
            }});
        }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user", username);
        intent.putExtra("firstname", firstname);
        intent.putExtra("lastname", lastname);
        finish();
        startActivity(intent);
    }
}