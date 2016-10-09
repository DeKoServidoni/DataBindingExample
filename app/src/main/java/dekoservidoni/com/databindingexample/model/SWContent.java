package dekoservidoni.com.databindingexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SWContent {

    @SerializedName("results")
    private List<SWCharacter> results = new ArrayList<>();

    public List<SWCharacter> getResults() {
        return results;
    }
}
