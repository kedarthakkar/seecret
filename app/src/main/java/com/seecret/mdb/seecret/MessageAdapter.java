package com.seecret.mdb.seecret;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kedarthakkar on 11/20/16.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.CustomViewHolder> {

    private Context context;
    private ArrayList<Message> messageList;

    public MessageAdapter(Context context, ArrayList<Message> messages){
        this.context = context;
        messageList = messages;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new CustomViewHolder(view);
    }

    public void onBindViewHolder(CustomViewHolder holder, int position){

        Message currMessage = messageList.get(position);

        holder.name.setText(currMessage.getName());
        holder.lastMessage.setText(currMessage.getLastMessage());
        holder.time.setText(currMessage.getTime());

        holder.setTag(currMessage.getTag());
    }

    public void setMessages(ArrayList<Message> messages) {messageList = messages;}

    public int getItemCount(){
        return messageList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView lastMessage;
        TextView time;
        String tag;

        public void setTag(String tag) {this.tag = tag;}

        public String getTag() {return tag;}

        public CustomViewHolder (View view){

            super(view);
            this.name = (TextView) (view.findViewById(R.id.name));
            this.lastMessage = (TextView) (view.findViewById(R.id.last_message));
            this.time = (TextView) (view.findViewById(R.id.time));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TextActivity.class);
                    intent.putExtra("table name", getTag());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }

}
