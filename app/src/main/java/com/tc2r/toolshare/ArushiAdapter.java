package com.tc2r.toolshare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nudennie.white on 8/23/17.
 */

public class ArushiAdapter extends RecyclerView.Adapter<ArushiAdapter.ArushiViewHolder> {


	private ArrayList<ListingModel> itemList;
	private Context context;

	public ArushiAdapter(ArrayList<ListingModel> listOfItems, Context context) {
		this.itemList = listOfItems;
		this.context = context;
	}

	@Override
	public ArushiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		// Create a view, which we will place inside the recyclerview object for every model
		// in our arraylist.
		// this View will be kept in a ViewHolder object, which will be stacked based on the
		// LayoutManager settings.

		Context context = parent.getContext();
		LayoutInflater inflater = LayoutInflater.from(context);
		int layoutId = R.layout.listitem_layout;
		View view = inflater.inflate(layoutId, parent, false);
		ArushiViewHolder viewHolder = new ArushiViewHolder(view);
		return viewHolder;


	}

	@Override
	public void onBindViewHolder(ArushiViewHolder holder, final int position) {
		// Position = the current position in our recyclerview.

		ListingModel model = itemList.get(position);

		// Fill the views with infromation from the model.
		holder.tvId.setText(String.valueOf(model.getId()));
		holder.tvTitle.setText(model.getTitle());
		holder.tvDescription.setText(model.getDescription());
		holder.tvContact.setText(model.getContact());
		holder.tvLocation.setText(model.getLocation());
		holder.tvSharerID.setText(model.getSharerId());

	}

	@Override
	public int getItemCount() {
		return itemList.size();
	}

	public class ArushiViewHolder extends RecyclerView.ViewHolder {

		// Declare layout object item variables.
		TextView tvId, tvTitle, tvSharerID, tvDescription, tvLocation, tvContact;

		public ArushiViewHolder(View itemView) {
			super(itemView);

			// Initialize Objects of the layout item to variables.
			tvId = itemView.findViewById(R.id.tv_id);
			tvTitle = itemView.findViewById(R.id.tv_title);
			tvDescription = itemView.findViewById(R.id.tv_description);
			tvContact = itemView.findViewById(R.id.tv_contact);
			tvLocation = itemView.findViewById(R.id.tv_location);
			tvSharerID = itemView.findViewById(R.id.tv_sharer_id);
		}
	}
}
