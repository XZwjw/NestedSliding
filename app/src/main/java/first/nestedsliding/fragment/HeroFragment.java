package first.nestedsliding.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import first.nestedsliding.R;
import first.nestedsliding.adapter.HeroRecycleViewAdpter;
import first.nestedsliding.modle.LOLHero;
import first.nestedsliding.shap.ItemDivider;

/**
 * Created by dell on 2016/9/23.
 */
public class HeroFragment extends Fragment {



    private RecyclerView mRecycleViewLOL;

    private HeroRecycleViewAdpter mHeroRecycleViewAdapter;
    private List<LOLHero> list;     //数据列表

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lol_fragment, container, false);
        init(view);
        list = getList();

        mHeroRecycleViewAdapter = new HeroRecycleViewAdpter(getContext(),list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        mRecycleViewLOL.setAdapter(mHeroRecycleViewAdapter);
        mRecycleViewLOL.setLayoutManager(gridLayoutManager);
        ItemDivider itemDivider = new ItemDivider(getContext(),R.drawable.item_divider);
        mRecycleViewLOL.addItemDecoration(itemDivider);
        return view;
    }

    private void init(View view) {
        mRecycleViewLOL = (RecyclerView) view.findViewById(R.id.recycleView_lol);
    }

    /**
     *
     * @return
     */
    public List<LOLHero> getList() {
        List<LOLHero> lists = new ArrayList<>();
        for(int i = 0;i<40;i++) {
            LOLHero lolHero = new LOLHero();
            lolHero.setName("德玛西亚"+i+"号");
            lolHero.setPrice(i * 450 + "金币");
            lolHero.setBitmapUri(i+"");
            lists.add(lolHero);
        }
        return lists;
    }


    /**
     * 获取信息数据
     * @return
     */

}
