package gabriellee.project.notetaker.async;

import android.os.AsyncTask;
import android.util.Log;

import gabriellee.project.notetaker.Models.Note;
import gabriellee.project.notetaker.Persistence.NoteDao;

public class deleteAsyncTask extends AsyncTask<Note, Void, Void> {
    private static final String TAG = "insertAsyncTask";
    private NoteDao mNoteDao;

    public deleteAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        Log.d(TAG, "doInBackground: thread" + Thread.currentThread().getName());
        mNoteDao.delete(notes);
        return null;
    }

}
