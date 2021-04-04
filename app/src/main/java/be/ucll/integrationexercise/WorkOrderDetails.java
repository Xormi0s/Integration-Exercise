package be.ucll.integrationexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WorkOrderDetails extends AppCompatActivity {

    private UserViewModel userViewModel;
    private String firstname;
    private String lastname;
    private String username;

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

        EditText problem = findViewById(R.id.editTextTextPersonName3);

        Button save = findViewById(R.id.button2);

        userViewModel.getDetails(id).observe(this, new Observer<WorkOrder>() {
            @Override
            public void onChanged(WorkOrder workOrder) {
                if (workOrder.getProcessed() == true) {
                    problem.setText(workOrder.getDetailedProblemDescription());
                }

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String problemText = problem.getText().toString();
                        workOrder.setDetailedProblemDescription(problemText);
                        workOrder.setProcessed(true);
                        userViewModel.updateWorkOrder(workOrder);
                        Intent intent = new Intent(WorkOrderDetails.this, MainActivity.class);
                        intent.putExtra("user", username);
                        intent.putExtra("firstname", firstname);
                        intent.putExtra("lastname", lastname);
                        finish();
                        startActivity(intent);
                    }
                });
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