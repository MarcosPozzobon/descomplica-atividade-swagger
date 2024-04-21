package com.marcos.desenvolvimento.backendkanbanagile.mapper;

import com.marcos.desenvolvimento.backendkanbanagile.entity.Task;
import com.marcos.desenvolvimento.backendkanbanagile.response.TaskResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public List<TaskResponse> toTaskResponseList(List<Task> tasks) {
        return tasks.stream()
                .map(this::toTaskResponse)
                .collect(Collectors.toList());
    }

    public TaskResponse toTaskResponse(Task task){
        if(task != null && task.getResponsavel() != null){
            TaskResponse finalTaskResponse = new TaskResponse(
                    task.getId(),
                    task.getTitulo(),
                    task.getDescricao(),
                    task.getEstado(),
                    task.getPrevisaoEntrega(),
                    task.getDataCriacao(),
                    task.getDataUltimaAtualizacao(),
                    task.getResponsavel().getNomeUsuario()
            );
            return finalTaskResponse;
        } else if (task != null) {
            TaskResponse finalTaskResponse = new TaskResponse(
                    task.getId(),
                    task.getTitulo(),
                    task.getDescricao(),
                    task.getEstado(),
                    task.getPrevisaoEntrega(),
                    task.getDataCriacao(),
                    task.getDataUltimaAtualizacao(),
                    null
            );
            return finalTaskResponse;
        }
        return null;
    }
}
