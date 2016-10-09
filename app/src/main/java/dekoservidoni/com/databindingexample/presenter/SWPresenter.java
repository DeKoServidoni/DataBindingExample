package dekoservidoni.com.databindingexample.presenter;

import android.view.View;
import android.widget.Toast;

import dekoservidoni.com.databindingexample.model.SWCharacter;

public class SWPresenter {
    public void onCharacterClick(View view, SWCharacter character) {
        Toast.makeText(view.getContext(), "" + character.getName() + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
