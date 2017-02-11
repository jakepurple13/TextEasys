package app.easy.text.texteasy.ContactList;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viethoa.RecyclerViewFastScroller;

import java.util.ArrayList;

import app.easy.text.texteasy.Messages.MainActivity;
import app.easy.text.texteasy.R;

/**
 * Created by Jacob on 9/15/16.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> implements RecyclerViewFastScroller.BubbleTextGetter  {
    private ArrayList<Contacts.ContactInfo> mDataset;

    Contacts in;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    /**
     * 
     */
    /**
     * 
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        /**
         * 
         * @param v 
         */
        public TextView mTextView;


        /**
         * 
         * @param v 
         */
        public ViewHolder(View v) {
            super(v);
    /**
     * 
     * @param myDataset 
     * @param in 
     */
            mTextView = (TextView) v.findViewById(R.id.textView);


        }
    }

    /**
     * 
     * @param parent 
     * @param viewType 
     */
    // Provide a suitable constructor (depends on the kind of dataset)
    /**
     * 
     * @param myDataset 
     * @param in 
     */
    public ContactAdapter(ArrayList<Contacts.ContactInfo> myDataset, Contacts in) {
        mDataset = myDataset;
        this.in = in;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mytextview, parent, false);
        // set the view's size, margins, paddings and layout parameters
            /**
             * 
             * @param v 
             */

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    /**
     * 
     * @param holder 
     * @param position 
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

    /**
     * 
     */
        GradientDrawable bgShape = (GradientDrawable) holder.mTextView.getBackground();
        bgShape.setColor(Color.rgb(187, 187, 187)); //gray

        holder.mTextView.setText(mDataset.get(position).toString());
        holder.mTextView.setTextColor(Color.BLACK);
        //holder.mTextView.setGravity(Gravity.CENTER);
        //holder.mTextView.setTextColor(R.color.textColors);

    /**
     * 
     * @param pos 
     */
        View.OnClickListener von = new View.OnClickListener() {
            /**
             * 
             * @param v 
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(in, MainActivity.class);
                intent.putExtra("Number", mDataset.get(position).number);
                Bundle bndlanimation =
                        ActivityOptions.makeCustomAnimation(in.getApplicationContext(), R.anim.back_to_contacts,R.anim.from_contacts).toBundle();
                in.startActivity(intent, bndlanimation);
            }
        };

        holder.mTextView.setOnClickListener(von);


    }

    // Return the size of your dataset (invoked by the layout manager)
    /**
     * 
     */
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * 
     * @param pos 
     */
    @Override
    public String getTextToShowInBubble(int pos) {
        if (pos < 0 || pos >= mDataset.size())
            return null;

        String name = mDataset.get(pos).name;
        if (name == null || name.length() < 1)
            return null;

        return mDataset.get(pos).name.substring(0, 1);
    }

}


