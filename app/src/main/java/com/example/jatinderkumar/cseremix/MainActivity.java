package com.example.jatinderkumar.cseremix;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jatinderkumar.cseremix.data.Person;
import com.example.jatinderkumar.cseremix.data.PersonContract.PersonEntry;
import com.example.jatinderkumar.cseremix.data.PersonData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listItem;
    Button btnSave,btnShow;
    ArrayList<Person> people;
    ArrayList<String> names;
    EditText edtNae,edtPhones;
    ArrayList<Integer> phones;
    PersonData data ;
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPhones = findViewById(R.id.edtAddress);
        edtNae = findViewById(R.id.edtName);
        btnShow = findViewById(R.id.btnShow);
        listItem = findViewById(R.id.listItem);
        btnSave = findViewById(R.id.btnSave);
        names = new ArrayList<>();
      //  people = new ArrayList<>();
        data = new PersonData(MainActivity.this);
        phones = new ArrayList<>();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //data = new PersonData(MainActivity.this);
                String name = edtNae.getText().toString();
                int phone = Integer.parseInt(edtPhones.getText().toString());
                names.add(name);
                phones.add(phone);
                SQLiteDatabase database = data.getWritableDatabase();
                ContentValues values = new ContentValues();

                for (int i = 0; i < phones.size(); i++) {
                    values.put(PersonEntry.PERSON_NAME, names.get(i));
                    values.put(PersonEntry.PERSON_PHONE, phones.get(i));
                    database.insert(PersonEntry.TABLE_NAME, null, values);
                    database.close();
                    Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showDatabase();

            }
        });

    }
    private void showDatabase()
    {
        SQLiteDatabase database = data.getReadableDatabase();
        String query = "SELECT * FROM "+PersonEntry.TABLE_NAME;
        Cursor cursor = database.rawQuery(query,null);
        ArrayList<Person> peple = new ArrayList<>();
        while (cursor.moveToNext()){
            Person person = new Person();
            String name = cursor.getString(1);
            int phone = cursor.getInt(2);
            person.setName(name);
            person.setPhone(Integer.parseInt(String.valueOf(phone)));
            peple.add(person);
        }
        ListAdapter adapter = new ListAdapter(MainActivity.this,peple);
        listItem.setAdapter(adapter);
    }
}
