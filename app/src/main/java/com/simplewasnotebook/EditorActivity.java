package com.simplewasnotebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class EditorActivity extends AppCompatActivity {
    EditText inputText;
    Note currentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor_layout);

        inputText = (EditText) findViewById(R.id.editTextTextMultiLine);

    }

    @Override
    protected  void onPause(){
        super.onPause();
        currentNote = new Note(inputText.getText(), new Date());
        Toast.makeText(this, currentNote.getNoteContent(), Toast.LENGTH_SHORT).show();
    }

    public static Intent newIntent(Context packageContext){
        return new Intent(packageContext, EditorActivity.class);
    }
}
