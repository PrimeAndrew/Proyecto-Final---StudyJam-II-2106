package com.linux.prime.bolivarprime;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by prime on 26-12-16.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Songs> items;

    public CustomAdapter(Activity activity, ArrayList data) {
        this.context = activity;
        this.items = data;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /*Typeface tf_thing = Typeface.createFromAsset(
                context.getAssets(), "fonts/roboto_thin.ttf");
        Typeface tf_bold = Typeface.createFromAsset(
                context.getAssets(), "fonts/roboto_light.ttf");

        viewHolder.itemNombre.setTypeface(tf_bold);
        viewHolder.itemTipo.setTypeface(tf_thing);*/

        Songs currentItem = (Songs) getItem(position);
        viewHolder.itemTitulo.setText(currentItem.getTitulo());
        viewHolder.itemLetra.setText(currentItem.getLetra());

        return convertView;
    }

    private class ViewHolder {
        TextView itemTitulo;
        TextView itemLetra;


        public ViewHolder(View view) {
            itemTitulo = (TextView)view.findViewById(R.id.tvTitulo);
            itemLetra = (TextView) view.findViewById(R.id.tvSubtitulo);

        }
    }

}
