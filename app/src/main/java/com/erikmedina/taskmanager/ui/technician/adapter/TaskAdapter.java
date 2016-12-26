package com.erikmedina.taskmanager.ui.technician.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.domain.interactor.task.CompleteTaskInteractor;
import com.erikmedina.taskmanager.domain.interactor.task.CompleteTaskInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.user.GetUserByIdInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.GetUserByIdInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.user.UpdateUserWorkLoadInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.UpdateUserWorkLoadInteractorImpl;
import com.erikmedina.taskmanager.model.Task;
import com.erikmedina.taskmanager.model.User;
import com.erikmedina.taskmanager.util.Utils;

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
    private final OnItemClickListener listener;
    int userId;

    public TaskAdapter(Context context, int userId, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        this.userId = userId;
        tasks = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view, context, userId);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(tasks.get(position), listener);
        if (tasks.get(position).isCompleted()) {
            holder.rlTaskItem.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
        }
        String taskType = "";
        switch (tasks.get(position).getType()) {
            case Utils.SkillType.SUPPORT_ID:
                taskType = Utils.SkillType.SUPPORT;
                break;
            case Utils.SkillType.REPAIRMENT_ID:
                taskType = Utils.SkillType.REPAIRMENT;
                break;
            case Utils.SkillType.INSTALLATION_ID:
                taskType = Utils.SkillType.INSTALLATION;
                break;
            case Utils.SkillType.COMMUNICATION_ID:
                taskType = Utils.SkillType.COMMUNICATION;
                break;
        }
        holder.tvTaskType.setText(taskType);
        Resources res = context.getResources();
        String text = String.format(res.getString(R.string.task_duration_hours),
                String.valueOf(tasks.get(position).getDuration()));
        holder.tvTaskDuration.setText(text);
        holder.tvTaskDescription.setText(String.valueOf(tasks.get(position).getDescription()));
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Task task);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CompleteTaskInteractor completeTaskInteractor;
        GetUserByIdInteractor getUserByIdInteractor;
        private UpdateUserWorkLoadInteractor updateUserWorkLoadInteractor;

        @BindView(R.id.rl_task_item)
        RelativeLayout rlTaskItem;
        @BindView(R.id.tv_task_type)
        TextView tvTaskType;
        @BindView(R.id.tv_task_duration)
        TextView tvTaskDuration;
        @BindView(R.id.tv_task_description)
        TextView tvTaskDescription;

        private int userId;
        Context context;

        public ViewHolder(View itemView, Context context, int userId) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.context = context;
            this.userId = userId;
            completeTaskInteractor = new CompleteTaskInteractorImpl();
            getUserByIdInteractor = new GetUserByIdInteractorImpl();
            updateUserWorkLoadInteractor = new UpdateUserWorkLoadInteractorImpl();
        }

        public void bind(final Task task, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!task.isCompleted()) {
                        listener.onItemClick(task);
                        completeTaskInteractor.execute(task, new CompleteTaskInteractor.OnCompleteTaskListener() {
                            @Override
                            public void onCompleteTaskSuccess() {
                                getUserByIdInteractor.execute(userId, new GetUserByIdInteractor.OnGetUserByIdListener() {
                                    @Override
                                    public void onGetUserByIdSuccess(User user) {
                                        updateUserWorkLoadInteractor.execute(user, task.getDuration(), false, new UpdateUserWorkLoadInteractor.OnUpdateUserWorkLoadListener() {
                                            @Override
                                            public void onUpdateUserWorkLoadSuccess() {
                                                Toast.makeText(context, "Task is completed", Toast.LENGTH_LONG).show();
                                            }

                                            @Override
                                            public void onUpdateUserWorkLoadError(String error) {

                                            }
                                        });
                                    }

                                    @Override
                                    public void onGetUserByIdError(String error) {

                                    }
                                });
                                itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
                                itemView.setOnClickListener(null);
                            }

                            @Override
                            public void onCompleteTaskError() {

                            }
                        });

                    } else {
                        itemView.setOnClickListener(null);
                    }
                }
            });
        }

    }
}
