package com.simplewasnotebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    static final class NoteViewHolder extends RecyclerView.ViewHolder{

        private final TextView noteTextView;

        public NoteViewHolder (@NonNull View itemView){
            super(itemView);
            noteTextView = itemView.findViewById(R.id.note_item);
        }

        private void bind (@NonNull Note note){
            noteTextView.setText(note.date.toString());
        }
    }

    private final List<Note> mNotes;

    public NoteAdapter (List<Note> notes){
        this.mNotes = notes;
    }

    @Override
    @NonNull
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_cell_layout, viewGroup, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder viewHolder, int i){
        viewHolder.bind(mNotes.get(i));
    }

    @Override
    public int getItemCount(){
        return mNotes.size();
    }

    public void clearNotes(){
        mNotes.clear();
        notifyDataSetChanged();
    }

    public void addNote(Note note){
        mNotes.add(note);
        notifyDataSetChanged();
    }


}
