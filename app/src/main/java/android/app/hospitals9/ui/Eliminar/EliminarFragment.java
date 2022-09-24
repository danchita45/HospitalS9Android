package android.app.hospitals9.ui.Eliminar;

import android.app.hospitals9.databinding.FragmentEliminarBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.hospitals9.databinding.FragmentEliminarBinding;

public class EliminarFragment extends Fragment {

    private FragmentEliminarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EliminarViewModel eliminarViewModel =
                new ViewModelProvider(this).get(EliminarViewModel.class);

        binding = FragmentEliminarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}