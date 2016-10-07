package com.vtechsofts.materialdesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rajashekhar.v on 10/07/2016.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    final private List<String> mUsers;

    public UserAdapter(List<String> users) {
        this.mUsers = users;
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvUser.setText(mUsers.get(position));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_row, parent, false);
        return new ViewHolder(v);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final private TextView tvUser;

        public ViewHolder(View view) {
            super(view);

            tvUser = (TextView) view.findViewById(R.id.tv_user);
        }
    }
}