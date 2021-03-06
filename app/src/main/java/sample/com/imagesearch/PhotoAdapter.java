package sample.com.imagesearch;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private PhotoViewHolder photoViewHolder;
    private MainViewModel mainViewModel;
    private List<PhotoItemViewModel> photoItemViewModelList;

    public PhotoAdapter(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
        photoItemViewModelList = new ArrayList<>();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //ItemPhotoBinding itemCartBinding =
        return new PhotoViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        this.photoViewHolder = holder;
        PhotoItemViewModel photoItemViewModel = getItemForPosition(position);
        holder.bind(photoItemViewModel, mainViewModel);
    }

    @Override
    public int getItemCount() {
        return (null != photoItemViewModelList ? photoItemViewModelList.size() : 0);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public void setItems(List<PhotoItemViewModel> itemViewModelList) {
        this.photoItemViewModelList.clear();
        this.photoItemViewModelList.addAll(itemViewModelList);
        notifyDataSetChanged();
    }

    private PhotoItemViewModel getItemForPosition(int position) {
        return photoItemViewModelList.get(position);
    }
}
