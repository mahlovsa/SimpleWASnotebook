package com.simplewasnotebook;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Note> notes = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView recyclerView = findViewById(R.id.note_recyclerview);

        final NoteAdapter noteAdapter = new NoteAdapter(notes);
        recyclerView.setAdapter(noteAdapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        Button newNoteButton = (Button)findViewById(R.id.new_note_button);
        newNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date cdate = new Date();
                String test = "test";
                Note newNote = new Note(test, cdate);
                noteAdapter.addNote(newNote);
            }
        });

        Button clearNotesButton = (Button)findViewById(R.id.clear_notes_button);
        clearNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteAdapter.clearNotes();
            }
        });
    }



}