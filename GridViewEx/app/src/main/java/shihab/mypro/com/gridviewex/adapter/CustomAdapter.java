package shihab.mypro.com.gridviewex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import shihab.mypro.com.gridviewex.R;
import shihab.mypro.com.gridviewex.model.menuItem;

/**
 * Created by shihab on 11/3/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<menuItem> arrayList;

    public CustomAdapter(Context c, ArrayList<menuItem> arrayList) {
        this.c = c;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View custom_view = inflater.inflate(R.layout.grid_item_layout, null);

        ImageView iVCric = custom_view.findViewById(R.id.imageViewCric);
        TextView tVCric = custom_view.findViewById(R.id.textViewName);

        iVCric.setImageResource(arrayList.get(position).getImageID());
        tVCric.setText(arrayList.get(position).getName());

        return custom_view;
    }
}