package first.nestedsliding.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import first.nestedsliding.R;
import first.nestedsliding.adapter.FragmentAdapter;
import first.nestedsliding.adapter.RecycleViewAdapter;
import first.nestedsliding.fragment.HeroFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private FloatingActionButton right;
    private RecycleViewAdapter adapter;
    private TabLayout tabLayout;
    private List<String> mTitles;
    private ViewPager mViewPager;
    private FragmentAdapter mFragmentAdapter; //fragment切换适配器
    private List<Fragment> mFragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(toolbar);


        /**
         * 设置viewPager
         */
        mTitles.add("傻根1号");
        mTitles.add("傻根2号");
        mTitles.add("傻根3号");
        mTitles.add("傻根4号");
        mTitles.add("傻根5号");
        mTitles.add("傻根6号");

        /**
         * 设置tabs
         */
        int width = tabLayout.getWidth();
        int height = tabLayout.getHeight();
//        for(int i = 0;i < 3;i++) {
//            TextView textView = new TextView(MainActivity.this);
//            textView.setText(mTitles.get(i));
//            textView.setGravity(Gravity.CENTER);
//            tabLayout.addView(textView,width/3,height);
//        }

        tabLayout.addTab(tabLayout.newTab().setTag(mTitles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setTag(mTitles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setTag(mTitles.get(2)));
        tabLayout.addTab(tabLayout.newTab().setTag(mTitles.get(3)));
        tabLayout.addTab(tabLayout.newTab().setTag(mTitles.get(4)));
        tabLayout.addTab(tabLayout.newTab().setTag(mTitles.get(5)));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),mFragmentList,mTitles);
//        PagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {
//                return mFragmentList.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return mFragmentList.size();
//            }
//        };
        mViewPager.setAdapter(mFragmentAdapter);
//        mViewPager.setAdapter(adapter);

        /**
         * 添加Fragment
         */
        mFragmentList.add(new HeroFragment());
        mFragmentList.add(new HeroFragment());
        mFragmentList.add(new HeroFragment());
        mFragmentList.add(new HeroFragment());
        mFragmentList.add(new HeroFragment());
        mFragmentList.add(new HeroFragment());


        /**
         * 适配mPagerAdapter
         */
        tabLayout.setupWithViewPager(mViewPager);


//        String[] strings = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",};
        right = (FloatingActionButton) findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "FAB", Snackbar.LENGTH_LONG).setAction("cancle", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("TAG", "hah");
                    }
                }).show();
            }
        });
//        adapter = new RecycleViewAdapter(getApplicationContext(), strings);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//        mRecycleView = (RecyclerView) findViewById(R.id.recycleView);
//        mRecycleView.setLayoutManager(layoutManager);
//        mRecycleView.setAdapter(adapter);
//        ItemDivider mItemDivider = new ItemDivider(getApplicationContext(),R.drawable.item_divider);
//        mRecycleView.addItemDecoration(mItemDivider);


    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mFragmentList = new ArrayList<>();
        mTitles = new ArrayList<>();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
