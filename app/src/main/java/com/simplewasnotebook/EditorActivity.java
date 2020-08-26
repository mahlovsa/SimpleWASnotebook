package com.simplewasnotebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    private class StoreNote extends AsyncTask <String, Void, Void>{
        //TODO: rewrite asynctask on concurrency or something
        @Override
        protected Void doInBackground(String... noteText) {
            String filename = "note";

            try(FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE)){
                fos.write(noteText.toString().getBytes());
            } catch (IOException e) {
                // shall catch this shit
            }
            return null;


        }
    }


    @Override
    protected  void onPause(){
        super.onPause();
        currentNote = new Note(inputText.getText(), new Date());
        StoreNote storeNote = new StoreNote();
        storeNote.execute(currentNote.getNoteContent());
        Toast.makeText(this, currentNote.getNoteContent(), Toast.LENGTH_SHORT).show();

    }

    public static Intent newIntent(Context packageContext){
        return new Intent(packageContext, EditorActivity.class);
    }
}
