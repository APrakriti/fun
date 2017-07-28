package com.prakriti.dubaisearchmeter;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.support.v7.widget.SearchView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements android.support.v7.widget.SearchView.OnQueryTextListener, android.support.v7.widget.SearchView.OnCloseListener {
    private SearchManager searchManager;
    private SearchView searchView;
    private MyExpandableListAdapter listAdapter;
    private ExpandableListView expandableListView;
    private ArrayList<ParentRow> parentList = new ArrayList<ParentRow>();
    private ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
    private MenuItem searchItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        parentList = new ArrayList<ParentRow>();
        showTheseParentList = new ArrayList<ParentRow>();

        displayList();
        //expandAll();
    }
    private void loadData() {
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Prem Geet"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Chakka Panja"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Nai Nabhannu la"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Ma Yesto Geet Gauxu"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Loot"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Chapali Height"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"How Funny"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Woda Number:6"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Kalo Pothi"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Dhana Patti"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Pashupati Prasad"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Darpan Chaya"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"First Love"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Kabaddi Kabaddi"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Chakka Panja"));
        parentRow = new ParentRow("Nepali", childRows);
        parentList.add(parentRow);



        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Avatar"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Ghost Rider"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"The Wolverine"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"The Chronicals of Narniya"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Red Ridding Hood"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Titanic"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Van Helsing"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Turbo"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Despicable Me 2"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"The Conjuring"));
        parentRow = new ParentRow("English", childRows);
        parentList.add(parentRow);


        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Student of the year"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Kal Ho Na Ho"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"DDLJ"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Yeh Jawani Heh Diwani"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Barfi"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Jagga Jasus"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Van Helsing"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Happy New Year"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Dilwale"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Sing Is King"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Hera Phir"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher,"Don"));


        parentRow = new ParentRow("Hindi", childRows);
        parentList.add(parentRow);


    }
  /*  private void expandAll(){
        int count = listAdapter.getGroupCount();
        for(int i =0; i<count; i++){
            expandableListView.expandGroup(i);
        }
    }*/
    private void displayList(){
        loadData();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        listAdapter = new MyExpandableListAdapter(this, parentList);
        expandableListView.setAdapter(listAdapter);

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();
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

    @Override
    public boolean onClose() {
       listAdapter.filterData("");
       // expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        //expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
      //  expandAll();
        return false;
    }
}
