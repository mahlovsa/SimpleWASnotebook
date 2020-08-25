package com.simplewasnotebook;

import android.text.Editable;

import java.util.Date;

public class Note {
    String header;
    Editable noteContent;
    Date date;
    int noteCount = 0;

    public Note (Editable content, Date date){
        this.header = "FFF";
        this.date = date;
        this.noteContent = content;
        noteCount++;
    }

    public int getCount(){
        return noteCount;
    }

    public void setNoteContent(Editable content){
        this.noteContent = content;
    }

    public String getNoteContent(){
        return noteContent.toString();
    }


}
