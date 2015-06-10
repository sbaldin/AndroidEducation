package info.goodline.starsandplanets.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import info.goodline.starsandplanets.R;
import info.goodline.starsandplanets.data.SpaceBody;

/**
 * Created by sergeyb on 10.06.15.
 */
public class SpaceBodyListAdapter extends ArrayAdapter<SpaceBody> {
/**
 * List of news topics
 */
private ArrayList<SpaceBody> mNewslist;
private final Context mContext;
private LayoutInflater mInflater;

public SpaceBodyListAdapter(Context context) {
        super(context, R.layout.news_list_item);
        mNewslist=new ArrayList<>();
        mContext=context;
        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    mNewslist.addAll(SpaceBody.getSpaceBodyFromResource(SpaceBody.FLAG_GET_GALAXIES, mContext.getResources()));
    mNewslist.addAll(SpaceBody.getSpaceBodyFromResource(SpaceBody.FLAG_GET_STARS, mContext.getResources()));

}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

        SpaceBody spaceBody = mNewslist.get(position);
        ViewHolder holder;
        if(convertView == null) {
        convertView = mInflater.inflate(R.layout.news_list_item, null, true);
        holder  = getViewHolder(convertView);
        } else{
        holder = (ViewHolder) convertView.getTag();
        }

        holder.titleView.setText(spaceBody.getName());
        holder.dateView.setText(spaceBody.getLink());

        return convertView;
        }


/**
 * Get viewHolder by tag or create new if it doesn't exist
 * @param convertView view of news topic
 * @return instance of viewHolder
 */
private ViewHolder getViewHolder(View convertView) {
        ViewHolder holder;
        holder = new ViewHolder();
        holder.titleView = (TextView) convertView.findViewById(R.id.news_title);
        holder.dateView = (TextView) convertView.findViewById(R.id.news_date);
        convertView.setTag(holder);
        return holder;
        }


@Override
public int getCount() {
        return mNewslist.size();
        }

@Override
public SpaceBody getItem(int position) {
        return mNewslist.get(position);
        }

@Override
public long getItemId(int position) {
        return position;
        }
/**
 * Add list with news to current NewsList
 * @param parsedNewsList list to add
 */
public void addNewslist(ArrayList<SpaceBody> parsedNewsList) {
        parsedNewsList.removeAll(mNewslist);
        mNewslist.addAll(parsedNewsList);
        notifyDataSetChanged();
        }
public ArrayList<SpaceBody> getNewsList() {
        return mNewslist;
        }

/**
 * prepend list with news to current NewsList
 * used when news received from "pull to update"
 * @param newsList list to prepend
 */
public void prependNewsList(ArrayList<SpaceBody> newsList) {
        for(SpaceBody boardNews: newsList){
        mNewslist.add(0,boardNews);
        }
        notifyDataSetChanged();
        }

/**
 * implementation of ViewHolder pattern for SpaceBodyListAdapter
 */
static class ViewHolder {
    public ImageView imageView;
    public TextView titleView;
    public TextView dateView;
    public TextView descView;
}
}