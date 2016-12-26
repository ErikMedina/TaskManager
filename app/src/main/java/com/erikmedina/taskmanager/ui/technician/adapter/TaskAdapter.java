package com.erikmedina.taskmanager.ui.technician.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by erik on 26/12/16.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> tasks;
    private Context context;

    public TaskAdapter(Context context) {
        this.context = context;
        tasks = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTaskType.setText(String.valueOf(tasks.get(position).getType()));
        holder.tvTaskDuration.setText(String.valueOf(tasks.get(position).getDuration()));
        holder.tvTaskDescription.setText(String.valueOf(tasks.get(position).getDescription()));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_task_type)
        TextView tvTaskType;
        @BindView(R.id.tv_task_duration)
        TextView tvTaskDuration;
        @BindView(R.id.tv_task_description)
        TextView tvTaskDescription;

        Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.context = context;
        }
    }
}
