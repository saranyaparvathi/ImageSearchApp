package sample.com.imagesearch;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import sample.com.imagesearch.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel mainViewModel;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        getLifecycle().addObserver(mainViewModel);
        binding.setViewModel(mainViewModel);
    }
}
