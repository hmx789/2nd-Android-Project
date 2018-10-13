package com.example.hassan.cs478proj2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    final private String tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                /Toast.makeText(v.getContext(), "" + position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(),ImageActivity.class);
                Log.i(tag, "This is the id: " + id);
                i.putExtra("res_id",(int)id);
                startActivity(i);
            }
        });
        registerForContextMenu(gridview);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, v.getId(), 0, "View Full Picture");
        menu.add(0, v.getId(), 0, "Vehicle Webpage");
        menu.add(0,v.getId(),0,"Dealerships");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String menuName = item.getTitleCondensed().toString();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int itemID = (int)info.id;      // Getting ID of image
//        String carName = getResources().getResourceEntryName(itemID);   // Getting image file name
//        Log.i(tag,"This is the picture name: " + carName);
        Intent i;
        switch(menuName) {
            case "Vehicle Webpage":
                i = new Intent(Intent.ACTION_VIEW);
                String url = ID2Link.getMap().get(itemID);
                i.setData(Uri.parse(url));
                startActivity(i);
                return true;
            case "View Full Picture":
                i = new Intent(this,ImageActivity.class);
                i.putExtra("res_id",itemID);
                startActivity(i);
                return true;
            case "Dealerships":
                i = new Intent(this,ListActivity.class);
                i.putExtra("res_id",itemID);
                startActivity(i);
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }
}


class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer mThumbIds[] =  {
            R.drawable.toyota,R.drawable.bmwm5,
            R.drawable.jaguarftype,R.drawable.maseratighibli,
            R.drawable.infinitiq50,R.drawable.honda,
    };
    private  String mThumbNames[] = {
            "Toyota Camry","Bmw M5",
            "Jaguar F-Type","Maserati Ghibli",
            "Infiniti Q50", "Honda Accord",
    };
    private LayoutInflater inflater;
    public ImageAdapter(Context c) {
        mContext = c;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds[position];
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = inflater.inflate(R.layout.gridview_layout,null);
            TextView carModel = (TextView) view.findViewById(R.id.gridview_text);
            ImageView carPic = (ImageView) view.findViewById(R.id.gridview_image);
            carPic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            carPic.setPadding(2,2,2,2);
            carModel.setText(mThumbNames[position]);
            carPic.setImageResource(mThumbIds[position]);
        }
        else {
            view = (View) convertView;
        }
        return view;
    }
}
