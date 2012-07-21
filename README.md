
LayoutPagerAdapter
====================

An VERY SIMPLE extension of the PagerAdapter for android that allows to work with an array of layout ids. Views are loaded as they are requested (Lazy Loading)

Installation
====================

This component makes use of the android support library v4. Specifically it uses these two classes:

android.support.v4.view.PagerAdapter

android.support.v4.view.ViewPager <-- You will use this with the LayoutPagerAdapter

For more information on hoy to install it, check the official documentation:
http://developer.android.com/tools/extras/support-library.html

How to use it
====================

Just create a LayoutPagerAdapter and assign it to the ViewPager of your choice

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
    
You can implement OnViewLoadedListener to reuse layouts and configure them as you want:

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