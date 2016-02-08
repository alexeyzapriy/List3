package com.example.azapriy.list3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by azapriy on 2/7/16.
 */
public class CardsRecyclerAdapter extends RecyclerView.Adapter<CardsRecyclerAdapter.ViewHolder>{
    private Context context;
    private Random rand;
    private String[] mDataset;
    private int [] images = { R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4,
                                R.drawable.i5, R.drawable.i6, R.drawable.i7};

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout mCard;
        public ViewHolder(LinearLayout v) {
            super(v);
            mCard = v;
        }
    }

    public CardsRecyclerAdapter(Context context, String[] dataSet) {
        this.context = context;
        mDataset = dataSet;
        rand = new Random();
    }

    @Override
    public CardsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CardsRecyclerAdapter.ViewHolder holder, int position) {
        TextView textView = (TextView) holder.mCard.findViewById(R.id.info_text);
        Drawable img = context.getResources().getDrawable(images[rand.nextInt(7)]);
        ((ImageView)holder.mCard.findViewById(R.id.imageView)).setImageDrawable(img);
        textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
