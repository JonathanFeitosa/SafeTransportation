
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color implements Parcelable
{

    @SerializedName("hex")
    @Expose
    private String hex;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("nameTranslationKey")
    @Expose
    private String nameTranslationKey;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<Color> CREATOR = new Creator<Color>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Color createFromParcel(Parcel in) {
            return new Color(in);
        }

        public Color[] newArray(int size) {
            return (new Color[size]);
        }

    }
    ;

    protected Color(Parcel in) {
        this.hex = ((String) in.readValue((String.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.nameTranslationKey = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Color() {
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getNameTranslationKey() {
        return nameTranslationKey;
    }

    public void setNameTranslationKey(String nameTranslationKey) {
        this.nameTranslationKey = nameTranslationKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hex);
        dest.writeValue(slug);
        dest.writeValue(nameTranslationKey);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
