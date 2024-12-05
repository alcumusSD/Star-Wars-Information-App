package com.example.multimediaproject;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class StarWarsCharacters implements Parcelable {

    private String name;
    private String desc;
    private String BirthYear;
    private String Profession;

    private String LightSaberColor;


    private int  image;

    public StarWarsCharacters(String name, String desc, String BirthYear, String Profession, String LightSaberColor, int  image) {
        this.name = name;
        this.desc = desc;
        this.BirthYear = BirthYear;
        this.Profession = Profession;
        this.LightSaberColor = LightSaberColor;
        this.image = image;
    }

    protected StarWarsCharacters(Parcel in) {
        name = in.readString();
        desc = in.readString();
        BirthYear = in.readString();
        Profession = in.readString();
        LightSaberColor = in.readString();
        image = in.readInt();
    }

    public static final Creator<StarWarsCharacters> CREATOR = new Creator<StarWarsCharacters>() {
        @Override
        public StarWarsCharacters createFromParcel(Parcel in) {
            return new StarWarsCharacters(in);
        }

        @Override
        public StarWarsCharacters[] newArray(int size) {
            return new StarWarsCharacters[size];
        }
    };

    public String getName() {
        return name;
    }



    public String getDesc() {
        return desc;
    }

    public String getBirthYear() {
        return BirthYear;
    }

    public String getProfession() {
        return Profession;
    }

    public String getLightSaberColor() {
        return LightSaberColor;
    }

    public int getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(BirthYear);
        dest.writeString(Profession);
        dest.writeString(LightSaberColor);
        dest.writeInt(image);
    }
}

