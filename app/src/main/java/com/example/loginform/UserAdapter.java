package com.example.loginform;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;

    // Constructor for the adapter
    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // Get the User object at this position
        User user = userList.get(position);

        // Bind the User object to the views in the ViewHolder
        holder.tvName.setText(user.getFirstName() + " " + user.getLastName());
        holder.tvAge.setText("Age: " + user.getAge());
        holder.tvGender.setText("Gender: " + user.getGender());
        holder.tvState.setText("State: " + user.getState());
        holder.tvCountry.setText("Country: " + user.getCountry());
        holder.tvMobile.setText("Mobile: " + user.getMobile());
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return userList.size();
    }

    // Provide a reference to the type of views that you are using (custom ViewHolder)
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAge, tvGender, tvState, tvCountry, tvMobile;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the TextViews with the corresponding views in item_user.xml
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvState = itemView.findViewById(R.id.tvState);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvMobile = itemView.findViewById(R.id.tvMobile);
        }
    }
}
