package id.ac.mi.poliban.diana.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnStore, btnGet ;
    private EditText etname;
    private DatabaseHelper databaseHelper;
    private TextView tvname;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        tvname = (TextView) findViewById(R.id.tvnames);
        btnStore = (Button) findViewById(R.id.btnStore);
        btnGet = (Button) findViewById(R.id.btnget);
        etname = (EditText) findViewById(R.id.etname);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(etname.getText().toString());
                etname.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentList();
                tvname.setText("");
                for (int i = 0; i <arrayList.size(); i++){
                    tvname.setText(tvname.getText().toString()+", "+arrayList.get(i));
                }
            }
        });


    }
}

