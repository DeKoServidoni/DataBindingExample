package dekoservidoni.com.databindingexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import dekoservidoni.com.databindingexample.R;
import dekoservidoni.com.databindingexample.view.adapter.SWCharactersAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerList = (RecyclerView) findViewById(R.id.recycler_list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerList.setLayoutManager(layoutManager);

        SWCharactersAdapter adapter = new SWCharactersAdapter(this);
        recyclerList.setAdapter(adapter);
    }
}
