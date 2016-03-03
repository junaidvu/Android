package in.debate.debate.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.debate.debate.R;
import in.debate.debate.loader.ImageLoader;
import in.debate.debate.views.ScaleImageView;

public class StaggeredAdapter extends ArrayAdapter<String> {

    private ImageLoader mLoader;
    private  List headLines=new ArrayList();

    public StaggeredAdapter(Context context, int textViewResourceId,
                            String[] objects,List headLines) {
        super(context, textViewResourceId, objects);
        mLoader = new ImageLoader(context);
        this.headLines=headLines;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(getContext());
            convertView = layoutInflator.inflate(R.layout.row_staggered,
                    null);
            holder = new ViewHolder();
            holder.imageView = (ScaleImageView) convertView .findViewById(R.id.imageView1);
            holder.headLines=(TextView) convertView.findViewById(R.id.headLines);

            convertView.setTag(holder);
        }

        holder = (ViewHolder) convertView.getTag();
        holder.headLines.setText((CharSequence) headLines.get(position));
        mLoader.DisplayImage(getItem(position), holder.imageView);

        return convertView;
    }

    static class ViewHolder {
        ScaleImageView imageView;
        TextView headLines;
    }
}
