package gabriellee.project.notetaker.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;


@Entity(tableName = "notes")
public class Note implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "content")
    private String mContents;

    @ColumnInfo(name = "timestamp")
    private String mTimestamp;

    public Note(String title, String contents, String timestamp) {
        mTitle = title;
        mContents = contents;
        mTimestamp = timestamp;
    }

    @Ignore
    public Note() {

    }

    protected Note(Parcel in) {
        id = in.readInt();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(mTitle);
        dest.writeString(mContents);
        dest.writeString(mTimestamp);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", mTitle='" + mTitle + '\'' +
                ", mContents='" + mContents + '\'' +
                ", mTimestamp='" + mTimestamp + '\'' +
                '}';
    }
}
