package com.kal.usermangement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewholderClass> {

    public static List<Users> list;
    public Context context;

    AdapterClass(List<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewholderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewholderClass(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewholderClass holder, int position) {
        final Users user = list.get(position);
        holder.firstname.setText(user.getFname());
        holder.lastname.setText(user.getLname());
        holder.itemView.getId();
//        holder.cardview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(itemView.getContext(),DetailActivity.class);
//                itemView.getContext().startActivity(intent);
//
//            }
//        });

     }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewholderClass extends RecyclerView.ViewHolder implements View.OnLongClickListener {

         CardView cardview;
        TextView firstname, lastname;

        public ViewholderClass(@NonNull final View itemView) {
            super(itemView);
            cardview=(CardView)itemView.findViewById(R.id.cardview);
            firstname = (TextView) itemView.findViewById(R.id.item_firstName);
            lastname = (TextView) itemView.findViewById(R.id.item_lastName);
           cardview.setOnLongClickListener(this);

           cardview.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent=new Intent(itemView.getContext(),DetailActivity.class);

                   intent.putExtra("po",getAdapterPosition());
                   intent.putExtra("fn",new Users().getFname());
                   intent.putExtra("ln",new Users().getLname());
                  // intent.putExtra("fn",new Users().);
                   itemView.getContext().startActivity(intent);

               }
           });
        }

//        @Override
//        public void onClick(View view) {
//            //deleteEachCard(getAdapterPosition());
//
//        }
        //delete each method
        public void deleteEachCard(int postion)
        {
            list.remove(postion);
            notifyItemRemoved(postion);

        }

        @Override
        public boolean onLongClick(View view) {
            deleteEachCard(getAdapterPosition());

            return true;
        }
    }


}
