package privado.lisseth.pizzaricaapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class Principal extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);



            ClaseManejadora adapter = new ClaseManejadora(getSupportFragmentManager());
            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(adapter);

            mViewPager.setOnPageChangeListener(this);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            ActionBar.Tab tab = actionBar.newTab().setText("Productos").setTabListener(this);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText("Sucursales").setTabListener(this);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText("Quines Somos").setTabListener(this);
            actionBar.addTab(tab);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Iniciar) {
            return true;
        }

        if (id == R.id.Cerrar) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public class ClaseManejadora extends FragmentPagerAdapter {

        public ClaseManejadora(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new Fragment_Producto();
                case 1:
                    return new Fragment_Sucursales();
                case 2:
                    return new Fragment_Quienes();
                default:
                    return null;
            }
        }
        public int getCount() {
            return 3;
        }
    }

    // Implementación de OnPageChangeListener
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    // Implementación de TabListener
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
