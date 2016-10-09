package dekoservidoni.com.databindingexample.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dekoservidoni.com.databindingexample.R;
import dekoservidoni.com.databindingexample.databinding.ItemListBinding;
import dekoservidoni.com.databindingexample.model.SWCharacter;
import dekoservidoni.com.databindingexample.model.SWContent;
import dekoservidoni.com.databindingexample.presenter.SWPresenter;

public class SWCharactersAdapter extends RecyclerView.Adapter<SWCharactersAdapter.ViewHolder> {

    private List<SWCharacter> mContent = new ArrayList<>();

    /**
     * Holder class
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemListBinding itemListBinding;
        ViewHolder(ItemListBinding itemListBinding) {
            super(itemListBinding.cardView);
            this.itemListBinding = itemListBinding;
        }
    }

    /**
     * Constructor
     *
     * @param context of the application
     */
    public SWCharactersAdapter(Context context) {
        String json = readFromAssets(context);
        SWContent content = new Gson().fromJson(json, SWContent.class);
        mContent.addAll(content.getResults());
    }

    // Adapter methods

    @Override
    public int getItemCount() {
        return mContent.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemListBinding itemListBinding = holder.itemListBinding;
        itemListBinding.setCharacter(mContent.get(position));
        itemListBinding.setPresenter(new SWPresenter());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemListBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_list, parent, false);
        return new ViewHolder(binding);
    }

    // Private methods

    /**
     * Read the JSON content from assets file
     *
     * @param context of the application
     *
     * @return JSON string
     */
    private String readFromAssets(Context context) {
        StringBuilder builder = new StringBuilder();

        InputStream inputStream = null;
        BufferedReader bufferedInputStream = null;

        try {
            inputStream = context.getAssets().open("sw_characters.json");
            bufferedInputStream = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while((line = bufferedInputStream.readLine()) != null) {
                builder.append(line);
            }

        } catch (IOException e) {
            Log.e("SW_TAG", "", e);

        } finally {

            try {
                if(inputStream != null) {
                    inputStream.close();
                }

                if(bufferedInputStream != null) {
                    bufferedInputStream.close();
                }


            } catch (IOException e) {
                Log.e("SW_TAG", "", e);
            }
        }

        return builder.toString();
    }
}
