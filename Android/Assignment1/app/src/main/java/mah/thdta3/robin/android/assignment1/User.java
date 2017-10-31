package mah.thdta3.robin.android.assignment1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by robin on 18/09/2017.
 */

public class User implements Parcelable{

    private String firstname, surname, password, username;
    private int id;

    public User(String firstname, String surname, String username, String password){
        this.id = 0;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public User(int id,String firstname, String surname, String username, String password){
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(firstname);
        dest.writeString(surname);
        dest.writeString(username);
        dest.writeString(password);

    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source.readInt(), source.readString(), source.readString(), source.readString(), source.readString());
        }

        @Override
        public User[] newArray(int size) {
            return new User[0];
        }
    };
}
