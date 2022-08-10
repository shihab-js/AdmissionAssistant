package shihab.mypro.com.gridviewex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import shihab.mypro.com.gridviewex.R;

/**
 * Created by shihab on 11/9/2017.
 */

public class CustomAdapterForGeneralList extends BaseAdapter {

    Context context;
    int[] versityImage;
    String[] versityName;
    LayoutInflater layoutInflater;

    public CustomAdapterForGeneralList(Context context,String[] productsName ,int[] productsImage) {
        this.context = context;
        this.versityName = productsName;
        this.versityImage = productsImage;
    }

    @Override
    public int getCount() {
        return versityName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_layout,parent,false);
        }

        ImageView pImage = convertView.findViewById(R.id.imageViewProduct);
        TextView pName = convertView.findViewById(R.id.textViewName);


        pImage.setImageResource(versityImage[position]);
        pName.setText(versityName[position]);

        return convertView;
    }

}
