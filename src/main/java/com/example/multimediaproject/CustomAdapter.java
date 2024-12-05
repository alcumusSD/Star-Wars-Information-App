package com.example.multimediaproject;
import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<StarWarsCharacters>
{
    List list;
    Context context;
    int xmlResource;

    public CustomAdapter(Context context, int resource, ArrayList<StarWarsCharacters> objects)
    {
        super(context, resource, objects);
        xmlResource = resource;
        list = objects;
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //return super.getView(position, convertView, parent); // return a view that displays the data at a specified position.
        // We are getting specific so we mute/delete this.
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View adapterLayout = layoutInflater.inflate(xmlResource, null);
        // root has to do with hierarchy of Views, keep null for our purposes ^

        Switch rotate =  adapterLayout.findViewById(R.id.switch1);

        TextView name = adapterLayout.findViewById(R.id.textView);
        TextView info = adapterLayout.findViewById(R.id.textView2);
        TextView by= adapterLayout.findViewById(R.id.textView4);
        TextView prof = adapterLayout.findViewById(R.id.textView5);
        TextView lsc = adapterLayout.findViewById(R.id.textView6);
        ImageView image = adapterLayout.findViewById(R.id.imageView);
        Button remove = adapterLayout.findViewById(R.id.button);
        remove.setText("remove");
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        rotate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)

                    image.setRotation((image.getRotation() + 180));

                else image.setRotation((image.getRotation() + 180));

            }
        });

        name.setText(getItem(position).getName());
        info.setText(getItem(position).getDesc());
        image.setImageResource(getItem(position).getImage());

        return adapterLayout;
    }
}

