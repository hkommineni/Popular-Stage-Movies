package com.example.harishkommineni.popular_movies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Harish Kommineni
 * <p/>
 * Custom adapter for populating GridView.
 */
class ArrayAdapter extends BaseAdapter {
    private final Context context;
    private final Movie[] movies;

    /**
     * Constructor
     *
     * @param context Application context
     * @param movies  Movie array
     */
    public ArrayAdapter(Context context, Movie[] movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        if (movies == null || movies.length == 0) {
            return -1;
        }

        return movies.length;
    }

    @Override
    public Movie getItem(int position) {
        if (movies == null || movies.length == 0) {
            return null;
        }

        return movies[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        // Will be null if it's not recycled. Will initialize ImageView if new.
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(context)
                .load(movies[position].getPosterPath())
                .resize(context.getResources().getInteger(R.integer.tmdb_poster_w185_width),
                        context.getResources().getInteger(R.integer.tmdb_poster_w185_height))
                .error(R.drawable.not_found)
                .placeholder(R.drawable.searching)
                .into(imageView);

        return imageView;
    }
}
