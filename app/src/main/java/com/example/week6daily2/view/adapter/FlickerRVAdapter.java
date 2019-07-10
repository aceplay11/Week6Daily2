package com.example.week6daily2.view.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.week6daily2.R;
import com.example.week6daily2.model.flickr.Item;
import com.example.week6daily2.view.activity.FullImageActivity;
import com.example.week6daily2.view.activity.MainActivity;


import java.util.List;



public class FlickerRVAdapter extends RecyclerView.Adapter<FlickerRVAdapter.ViewHolder> {
    List<Item> listOfQuery;

    public FlickerRVAdapter(List<Item> items) {
        this.listOfQuery = items;
    }



    @NonNull
    @Override
    public FlickerRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flicker_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Item itemResult = listOfQuery.get(position);
        final String title = itemResult.getTitle();
        final String description = itemResult.getAuthor();
        final String imageLink = itemResult.getMedia().getM();

        holder.tvTitle.setText(title);
        holder.tvDescription.setText(description);
        Glide.with(holder.imgFlickrPic).load(imageLink).into(holder.imgFlickrPic);
        holder.imgFlickrPic.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                final Intent imageIntent = new Intent(view.getContext(), FullImageActivity.class);
                imageIntent.putExtra("image",imageLink);

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Small or Fullscreen Image");
                builder.setPositiveButton("FullScreen", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       view.getContext().startActivity(imageIntent);
                    }


                });
                builder.setNegativeButton("Thumbnail", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder imgSmall = new AlertDialog.Builder(view.getContext());

                        LayoutInflater layoutInflater = LayoutInflater.from(view.getContext());
                        View diaView = layoutInflater.inflate(R.layout.flickr_image_thumb, null);
                        ImageView imgThumb = diaView.findViewById(R.id.imgInflateThumb);
                        imgSmall.setView(diaView);
                        Glide.with(imgThumb).load(imageLink).into(imgThumb);
                        imgSmall.create();
                        imgSmall.show();

                    }
                }).setIcon(android.R.drawable.ic_menu_gallery).show();
                return false;

            }

        });
    }

    private void getActivity(Intent intent) {
       new Activity().startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return listOfQuery.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFlickrPic;
        TextView tvDescription;
        TextView tvTitle;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imgFlickrPic = itemView.findViewById(R.id.imgThumb);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
//            imgFlickrPic.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(final View view) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                    builder.setTitle("Small or Fullscreen Image");
//                    builder.setPositiveButton("FullScreen", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Log.d("TAG", "Works");
//                             Intent imageIntent = new Intent(view.getContext(), FullImageActivity.class);
//                             imageIntent.putExtra("image", )
//
//
//
//
//                        }
//
//
//                    });
//                    builder.setNegativeButton("Thumbnail", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    }).setIcon(android.R.drawable.ic_menu_gallery).show();
//                    return false;
//
//                }
//
//            });
        }

        private void startActivity(Intent intent) {

        }
    }

//    AlertDialog.Builder builder = new AlertDialog.Builder();
//                builder.setTitle("Small of Fullscreen Image");
//                builder.setPositiveButton("FullScreen", new DialogInterface.OnClickListener() {
//        @Override
//        public void onClick(DialogInterface dialog, int which) {
////                        Context context;
////                        Intent intent = new Intent(this , FullScreenActivity.class);
////                                startActivity(intent);
//            Log.d("TAG", "Works");
//
//        }
//    });
}




