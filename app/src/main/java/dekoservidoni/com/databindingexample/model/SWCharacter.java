package dekoservidoni.com.databindingexample.model;

import com.google.gson.annotations.SerializedName;

public class SWCharacter {

    @SerializedName("name")
    public String name;
    @SerializedName("birth_year")
    public String birthYear;

    public String getName() {
        return name;
    }

    public String getBirthYear() {
        return birthYear;
    }
}
