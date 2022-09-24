package android.app.hospitals9.ui.Eliminar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EliminarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EliminarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Eliminar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}