package com.tc2r.toolshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	private RecyclerView recyclerView;
	private ArushiAdapter adapter;
	private LinearLayoutManager layoutManager;

	private ArrayList<ListingModel> listings = null;
	private ListingModel tempModel;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initialize Variables
		listings = new ArrayList<>();
		recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);


		// TRY OUT EACH ONE OF THESE TO SEE WHAT THE LAYOUT MANAGER DOES.
		layoutManager = new LinearLayoutManager(this);
		//	layoutManager = new GridLayoutManager(this, 2);
		//	layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
		//	layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, true);

		// Get Real Data From SQL Database.

		// Create a call for the data (request)
		Call<List<ListingModel>> call = RetrofitInterface
						.Factory
						.getInstance()
						.getEverything();


		// Queue our request and listen for a response, on successful response, update recyclerview/adater
		// on fail alert user.
		call.enqueue(new Callback<List<ListingModel>>() {
			@Override
			public void onResponse(Call<List<ListingModel>> call, Response<List<ListingModel>> response) {
				// Dismiss Progress Bar
				progressBar.setVisibility(View.GONE);

				// If response isn't an error
				if (response.isSuccessful()) {
					listings = (ArrayList<ListingModel>) response.body();
					adapter = new ArushiAdapter(listings, getApplicationContext());
					adapter.notifyDataSetChanged();
					Log.d("JSON DATA: ", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
					recyclerView.setAdapter(adapter);
				}
			}

			@Override
			public void onFailure(Call<List<ListingModel>> call, Throwable t) {
				// Dismiss Progress Bar
				progressBar.setVisibility(View.GONE);
				Log.e(TAG, "Unable To Connect To Server " + t.getMessage());
			}
		});

		// Set up the recyclerview.
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(layoutManager);
	}

}
