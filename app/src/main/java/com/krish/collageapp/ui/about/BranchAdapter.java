package com.krish.collageapp.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.krish.collageapp.R;

import java.util.List;

public class BranchAdapter extends PagerAdapter {
    private Context context;
    private List<BranchModel> list;

    public BranchAdapter() {
    }

    public BranchAdapter(Context context, List<BranchModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.branch_item,container,false);

        ImageView br_Icon;
        TextView br_Title,br_Description;

        br_Icon = view.findViewById(R.id.br_Icon);
        br_Title = view.findViewById(R.id.br_Title);
        br_Description = view.findViewById(R.id.br_Description);

        br_Icon.setImageResource(list.get(position).getImg());
        br_Title.setText(list.get(position).getTitle());

        container.addView(view,0);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView((View) object);
    }
}
