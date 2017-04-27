package com.example.daniel.rss_reader.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.rss_reader.MainActivity;
import com.example.daniel.rss_reader.R;
import com.example.daniel.rss_reader.models.RSS;
import com.squareup.picasso.Picasso;


import java.util.List;


/**
 * Created by daniel on 23.4.2017..
 */
public class RSSAdapter extends BaseAdapter {
    private List<RSS> mRSS;

    public RSSAdapter(List<RSS> RSS) {
        Log.e("TEST", "construct");
        mRSS = RSS;
    }

    @Override
    public int getCount() {
        return this.mRSS.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mRSS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("TEST", "onVIEW");
        RSSViewHolder rssViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_rss, parent, false);
            rssViewHolder = new RSSViewHolder(convertView);
            convertView.setTag(rssViewHolder);
        } else {
            rssViewHolder = (RSSViewHolder) convertView.getTag();
        }
        RSS rss = this.mRSS.get(position);
        Log.e("RSS", String.valueOf(rss.getmTitle()));
        Log.e("RSS", String.valueOf(rss.getmLink()));
        Log.e("KAteg", String.valueOf(rss.getmCategory()));
        Log.e("RSS", String.valueOf(rss.getmDescription()));
        Log.e("RSS", String.valueOf(rss.getmGuid()));
        rssViewHolder.tvRSSTitle.setText(rss.getmTitle());
        rssViewHolder.tvRSSCategory.setText(rss.getmCategory());

        rssViewHolder.tvRSSDescription.setText(rss.getmDescription());


        Picasso.with(parent.getContext())
                .load(rss.getUrl())
                .fit()
                .centerCrop()
                .into(rssViewHolder.ivRSSPoster);
        return convertView;
    }


    static class RSSViewHolder {
        TextView tvRSSTitle, tvRSSCategory, tvRSSDescription;
        ImageView ivRSSPoster;

        public RSSViewHolder(View RSSView) {
            this.tvRSSTitle = (TextView) RSSView.findViewById(R.id.tvRSSTitle);
            this.tvRSSCategory = (TextView) RSSView.findViewById(R.id.tvRSSCategory);
            this.tvRSSDescription = (TextView) RSSView.findViewById(R.id.tvRSSDescrpition);
            this.ivRSSPoster = (ImageView) RSSView.findViewById(R.id.ivRSSPoster);
        }
    }
}
