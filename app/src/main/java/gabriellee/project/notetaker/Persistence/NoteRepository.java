package gabriellee.project.notetaker.Persistence;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

import gabriellee.project.notetaker.Models.Note;
import gabriellee.project.notetaker.async.deleteAsyncTask;
import gabriellee.project.notetaker.async.insertAsyncTask;
import gabriellee.project.notetaker.async.updateAsyncTask;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note) {
        new insertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public void updateNote(Note note){
        new updateAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public LiveData<List<Note>> retrieveNotesTask(){

        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNode(Note note){
        new deleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

}
