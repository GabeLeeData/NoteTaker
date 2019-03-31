package gabriellee.project.notetaker.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String mTitle;
    private String mContents;
    private String mTimestamp;

    public Note(String title, String contents, String timestamp) {
        mTitle = title;
        mContents = contents;
        mTimestamp = timestamp;
    }

    public Note() {

    }

    protected Note(Parcel in) {
        mTitle = in.readString();
        mContents = in.readString();
        mTimestamp = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContents() {
        return mContents;
    }

    public void setContents(String contents) {
        mContents = contents;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Note{" +
                "mTitle='" + mTitle + '\'' +
                ", mContents='" + mContents + '\'' +
                ", mTimestamp='" + mTimestamp + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mContents);
        dest.writeString(mTimestamp);
    }
}
