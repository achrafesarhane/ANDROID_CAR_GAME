package edu.iu.se.trafficruler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pratish on 11/4/2015.
 */
class SongList {
    //String name;
    String path;
    boolean selected = false;

    public SongList(String path) {
        this.path = path;

    }

    public SongList(String path,boolean selected) {
        this.selected = selected;
        this.path = path;
    }

//    public SongList(String path) {
//        this.path = path;
//    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {

        return path;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

public class SongListAdaptor extends ArrayAdapter<SongList>{

    private List<SongList> songLists;
    private Context context;

    public SongListAdaptor(List<SongList> songLists, Context context) {
        super(context, R.layout.activity_row_jukebox,songLists);
        Log.e("Context : " , String.valueOf(context));
        this.songLists = songLists;
        this.context = context;
    }

    private static class SongListHolder {
        public CheckBox checkBox1;
        public TextView textView1;
        //public TextView distView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("Position : ", String.valueOf(position));
        Log.e("convertView : ", String.valueOf(convertView));
        Log.e("parent : ", String.valueOf(parent));

        View v = convertView;

        SongListHolder holder = new SongListHolder();

        if(convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.activity_row_jukebox, null);
            Log.e("Value of View v : ", String.valueOf(v));
            holder.checkBox1 = (CheckBox) v.findViewById(R.id.checkBox1);
            holder.textView1 = (TextView) v.findViewById(R.id.textView1);
//            Log.e("Value of chkb : ", String.valueOf(holder.checkBox1));
//            Log.e("Value of textView : ", String.valueOf(holder.textView1));
            //holder.distView = (TextView) v.findViewById(R.id.dist);


            holder.checkBox1.setOnCheckedChangeListener((PauseJukeboxSel) context);

        } else {
            holder.checkBox1 = (CheckBox) v.findViewById(R.id.checkBox1);
            holder.textView1 = (TextView) v.findViewById(R.id.textView1);
//            holder = (SongListHolder) v.getTag();
//            Log.e("Value of holder : ", String.valueOf(holder));
            //Log.e("Value of textView : ", String.valueOf(holder.textView1));
        }

    SongList s = songLists.get(position);
        Log.e("Value of Path ", s.getPath());
        try {
    holder.textView1.setText(s.getPath());
}catch (Exception e){
    Log.e("Exception : ", String.valueOf(e));
}
       // holder.distView.setText("" + s.getDistance());
        holder.checkBox1.setChecked(s.selected);
        holder.checkBox1.setTag(s);

        return v;
    }

}
