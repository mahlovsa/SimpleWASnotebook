package com.simplewasnotebook;

import java.util.Date;

public class Note {
    String header;
    String[] noteContent;
    Date date;
    int noteCount = 0;

    public Note (String header, Date date){
        this.header = header;
        this.date = date;
        noteCount++;

    }

    public int getCount(){
        return noteCount;
    }
}
