package sample.com.imagesearch;

import android.support.v7.widget.RecyclerView;

import sample.com.imagesearch.databinding.ItemPhotoBinding;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    ItemPhotoBinding binding;

    public PhotoViewHolder(ItemPhotoBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        binding.executePendingBindings();
    }

    public void bind(PhotoItemViewModel itemViewModel, MainViewModel mainViewModel) {
        binding.setItemViewModel(itemViewModel);
        binding.setViewModel(mainViewModel);
        binding.executePendingBindings();
    }
}
