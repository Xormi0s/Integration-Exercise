package be.ucll.integrationexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        String firstname = intent.getStringExtra("firstname");
        String lastname = intent.getStringExtra("lastname");
        String username = intent.getStringExtra("user");

        TextView welcome = findViewById(R.id.textView12);

        welcome.setText("Welcome " + firstname + " " + lastname + " !");

        TableLayout table = findViewById(R.id.tableLayout);
        int layout_height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(0, layout_height, 1.0f);

        userViewModel.getWorkOrderUser(username).observe(this, new Observer<List<WorkOrder>>() {
            @Override
            public void onChanged(List<WorkOrder> workOrders) {
                int lenght = workOrders.size();
                for (WorkOrder order: workOrders) {
                    TableRow row = new TableRow(MainActivity.this);
                    row.setBackgroundColor(Color.WHITE);
                    TextView name = new TextView(MainActivity.this);
                    TextView device = new TextView(MainActivity.this);
                    TextView city = new TextView(MainActivity.this);
                    TextView code = new TextView(MainActivity.this);
                    TextView processed = new TextView(MainActivity.this);
                    int orderID = order.getOrderID();

                    name.setGravity(Gravity.CENTER);
                    device.setGravity(Gravity.CENTER);
                    city.setGravity(Gravity.CENTER);
                    code.setGravity(Gravity.CENTER);
                    processed.setGravity(Gravity.CENTER);


                    name.setLayoutParams(layoutParams);
                    device.setLayoutParams(layoutParams);
                    city.setLayoutParams(layoutParams);
                    code.setLayoutParams(layoutParams);
                    processed.setLayoutParams(layoutParams);

                    name.setText(order.getCustomerName());
                    device.setText(order.getDevice());
                    city.setText(order.getCity());
                    code.setText(order.getProblemCode());

                    if(order.getProcessed() == true){
                        processed.setText("YES");
                    } else {
                        processed.setText("NO");
                    }
                    processed.setBackgroundColor(Color.parseColor("#13a838"));
                    processed.setTextColor(Color.WHITE);

                    row.addView(name);
                    row.addView(device);
                    row.addView(city);
                    row.addView(code);
                    row.addView(processed);

                    processed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, WorkOrderDetails.class);
                            intent.putExtra("id", orderID);
                            intent.putExtra("user", username);
                            intent.putExtra("firstname", firstname);
                            intent.putExtra("lastname", lastname);
                            finish();
                            startActivity(intent);
                        }
                    });

                    row.setPadding(0,10,5,10);
                    table.addView(row, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
                }
            }
        });
    }
}