package be.ucll.integrationexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        String firstname = intent.getStringExtra("firstname");
        String lastname = intent.getStringExtra("lastname");

        TextView welcome = findViewById(R.id.textView12);

        welcome.setText("Welcome " + firstname + " " + lastname + " !");

        TableLayout table = findViewById(R.id.tableLayout);
        TableRow row1 = new TableRow(this);
        TextView test4 = new TextView(this);
        test4.setText("dit is een test");
        row1.addView(test4);
        table.addView(row1);




        // https://stackoverflow.com/questions/24078275/how-to-add-a-row-dynamically-in-a-tablelayout-in-android
    }
}