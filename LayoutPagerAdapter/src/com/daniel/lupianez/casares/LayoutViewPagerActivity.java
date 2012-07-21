package com.daniel.lupianez.casares;

import java.util.ArrayList;

import com.daniel.lupianez.casares.LayoutPagerAdapter.OnViewLoadedListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LayoutViewPagerActivity extends Activity implements OnViewLoadedListener {
	
	
	/**
	 * The main view pager
	 */
	private ViewPager mainViewPager;
	
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Get the view pager
        mainViewPager = (ViewPager)findViewById(R.id.mainViewPager);
        
        //Create an adapter for this view
        ArrayList<Integer> layoutIds = new ArrayList<Integer>();
        layoutIds.add(R.layout.view_number_1);
        layoutIds.add(R.layout.view_number_2);
        layoutIds.add(R.layout.view_number_1);
        layoutIds.add(R.layout.view_number_2);
        layoutIds.add(R.layout.view_number_2);
        LayoutPagerAdapter layoutPagerAdapter = new LayoutPagerAdapter(layoutIds);
        layoutPagerAdapter.setOnViewLoadedListener(this);
        
        //Set the adapter for the view pager
        mainViewPager.setAdapter(layoutPagerAdapter);
        
    }

    
    
	@Override
	public void onViewLoadedListener(LayoutPagerAdapter pagerAdapter,View loadedView, int position) {
		
		//Get some views, RENEMBER TO GET THE VIEWS FROM THE LOADEDVIEW
		TextView textView = (TextView)loadedView.findViewById(R.id.viewNumber2TextView);
		Button button = (Button)loadedView.findViewById(R.id.viewNumber2Button);
		
		//Configure the views
		if (position == 1){
			textView.setText("A nice example!");
		}
		else if (position == 3){
			textView.setText("Removing drawable here!");
			textView.setCompoundDrawables(null, null, null, null);
		}
		else if (position == 4){
			button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					final Toast toast = Toast.makeText(v.getContext(), "See, it works!", Toast.LENGTH_LONG);
					toast.show();
					
				}
			});
			textView.setText("Here the button should work!");
		}
		
	}
}