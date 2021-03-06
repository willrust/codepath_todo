package com.netflix.prototypes.willr.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    EditText etEditText;
    Integer position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        position = getIntent().getIntExtra("position", 0);
        String item = getIntent().getStringExtra("item");
        etEditText = (EditText) findViewById(R.id.etEditText);
        etEditText.setText(item);
        etEditText.setSelection(item.length());
        etEditText.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    public void onEditItem(View view) {
        Intent data = new Intent();
        data.putExtra("position", position);
        data.putExtra("item", etEditText.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}
