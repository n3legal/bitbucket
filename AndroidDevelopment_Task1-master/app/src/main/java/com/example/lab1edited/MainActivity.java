package com.example.lab1edited;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<RowElement> elements = new ArrayList<>();
    NumberConverter converter = new NumberConverter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        CustomAdapter adapter = new CustomAdapter(this, elements);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {
        for (int i = 0; i < 1000000; i++) {
            elements.add(new RowElement (converter.getNumberInWords(i + 1)));
        }
    }

    public void exit(View view){
        finish();
    }
}
