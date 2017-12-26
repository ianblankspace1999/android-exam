package com.exam.ph.examination.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exam.ph.examination.R;
import com.exam.ph.examination.Utils.ModelUtil;
import com.exam.ph.examination.models.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by IanBlanco on 12/26/2017.
 */

public class DisplayListUserAdapter extends RecyclerView.Adapter<DisplayListUserAdapter.UserHolder> {


    public interface Callback {
        void changeIntent(Context context, String response);
    }

    private Context mContext;
    private ArrayList<User> mUserList;
    private Callback mCallback;

    public DisplayListUserAdapter(Context mContext, ArrayList<User> mUserList, Callback callback) {
        this.mContext = mContext;
        this.mUserList = mUserList;
        this.mCallback = callback;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_userlist, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User user = mUserList.get(position);
        holder.tvName.setText(user.getFirstName() + " " + user.getLastName());

        holder.cardUser.setOnClickListener(v -> mCallback.changeIntent(mContext, ModelUtil.toJsonString(user)));

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    public class UserHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.cardUser)
        CardView cardUser;

        public UserHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
