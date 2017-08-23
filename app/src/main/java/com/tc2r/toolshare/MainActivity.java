package com.tc2r.toolshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	private RecyclerView recyclerView;
	private ArushiAdapter adapter;
	private LinearLayoutManager layoutManager;

	private ArrayList<ListingModel> listings = null;
	private ListingModel tempModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initialize Variables
		listings = new ArrayList<>();
		recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


		// TRY OUT EACH ONE OF THESE TO SEE WHAT THE LAYOUT MANAGER DOES.
		layoutManager = new LinearLayoutManager(this);
		//	layoutManager = new GridLayoutManager(this, 2);
		//	layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
		//	layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, true);


		// Create Fake models to use temporarily.
		tempModel = new ListingModel(1, "Ttsukasa", "Can Opener For Sale", "I have a can opener if anyone needs it must be returned before nightfall", "Lombard, IL", "662-123-4567");
		listings.add(tempModel);
		tempModel = new ListingModel(2, "Rai", "Bike Mount for car", "Specifically fits tanks, to borrow it you have to wrestle it from my cold dead hands. Come at me!", "Collegeville, IL", "773-123-4567");
		listings.add(tempModel);
		tempModel = new ListingModel(3, "Ttsukasa", "Can Opener For Sale", "I have a can opener if anyone needs it must be returned before nightfall", "Lombard, IL", "662-123-4567");
		listings.add(tempModel);
		tempModel = new ListingModel(4, "Rai", "Bike Mount for car", "Specifically fits tanks, to borrow it you have to wrestle it from my cold dead hands. Come at me!", "Collegeville, IL", "773-123-4567");
		listings.add(tempModel);
		tempModel = new ListingModel(5, "Ttsukasa", "Can Opener For Sale", "I have a can opener if anyone needs it must be returned before nightfall", "Lombard, IL", "662-123-4567");
		listings.add(tempModel);
		tempModel = new ListingModel(6, "Rai", "Bike Mount for car", "Specifically fits tanks, to borrow it you have to wrestle it from my cold dead hands. Come at me!", "Collegeville, IL", "773-123-4567");
		listings.add(tempModel);
		tempModel = new ListingModel(7, "Ttsukasa", "Can Opener For Sale", "I have a can opener if anyone needs it must be returned before nightfall", "Lombard, IL", "662-123-4567");
		listings.add(tempModel);
		tempModel = new ListingModel(8, "Rai", "Bike Mount for car", "Specifically fits tanks, to borrow it you have to wrestle it from my cold dead hands. Come at me!", "Collegeville, IL", "773-123-4567");
		listings.add(tempModel);

		// Set up the recyclerview.
		adapter = new ArushiAdapter(listings, this);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
	}

}
