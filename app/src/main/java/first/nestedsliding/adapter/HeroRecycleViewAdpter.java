package first.nestedsliding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import first.nestedsliding.R;
import first.nestedsliding.modle.LOLHero;

/**
 * Created by dell on 2016/9/23.
 */
public class HeroRecycleViewAdpter extends RecyclerView.Adapter<MyHeroViewHolder> {


    private Context mContext;
    private LayoutInflater mInflater;
    private List<LOLHero> mList;
    private MyHeroViewHolder mMyHeroViewHolder;

    public HeroRecycleViewAdpter(Context context, List<LOLHero> list) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    @Override
    public MyHeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.lol_item, parent, false);
        mMyHeroViewHolder = new MyHeroViewHolder(view);
        return mMyHeroViewHolder;
    }

    @Override
    public void onBindViewHolder(MyHeroViewHolder holder, int position) {
        LOLHero lolHero = mList.get(position);
        /**
         * 获取图片        holder.imageHero.setImageBitmap("bitmap");
         */
        holder.name.setText(lolHero.getName());
        holder.price.setText(lolHero.getPrice());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

class MyHeroViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageHero;
    public TextView name;
    public TextView price;
    public MyHeroViewHolder(View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view) {
        imageHero = (ImageView) view.findViewById(R.id.image_Hero);
        name = (TextView) view.findViewById(R.id.name);
        price = (TextView) view.findViewById(R.id.price);
    }
}
