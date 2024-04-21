package com.marcos.desenvolvimento.backendkanbanagile.service;

import com.marcos.desenvolvimento.backendkanbanagile.entity.Task;
import com.marcos.desenvolvimento.backendkanbanagile.entity.User;
import com.marcos.desenvolvimento.backendkanbanagile.exception.NonexistentTaskException;
import com.marcos.desenvolvimento.backendkanbanagile.mapper.TaskMapper;
import com.marcos.desenvolvimento.backendkanbanagile.repository.TaskRepository;
import com.marcos.desenvolvimento.backendkanbanagile.request.TaskRequest;
import com.marcos.desenvolvimento.backendkanbanagile.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public Task encontrarTaskPorId(Long identificador){
        Task existingTask = repository.findTaskById(identificador);
        if(existingTask == null){
            throw new NonexistentTaskException();
        }
        return existingTask;
    }

    public List<Task> encontrarTaskPorTitulo(String titulo){return repository.findByTitulo(titulo);}

    public List<Task> encontrarPorDescricao(String descricao){
        return repository.findByDescricao(descricao);
    }

    public List<Task> encontrarPorEstadoDaTarefa(String estadoAtual){return repository.findByEstado(estadoAtual);}

    public void atualizarTarefaParaBacklog(Long taskId){
        Task existingTask = repository.findTaskById(taskId);
        if(existingTask == null){
            throw new NonexistentTaskException();
        }
        repository.atualizarParaBacklog(existingTask.getId());
    }

    public void atualizarTarefaParaDoing(Long taskId){
        Task existingTask = repository.findTaskById(taskId);
        if(existingTask == null){
            throw new NonexistentTaskException();
        }
        repository.atualizarParaDoing(existingTask.getId());
    }

    public void atualizarTarefaParaReview(Long taskId){
        Task existingTask = repository.findTaskById(taskId);
        if(existingTask == null){
            throw new NonexistentTaskException();
        }
        repository.atualizarParaReview(existingTask.getId());
    }

    public void atualizarTarefaParaDone(Long taskId){
        Task existingTask = repository.findTaskById(taskId);
        if(existingTask == null){
            throw new NonexistentTaskException();
        }
        repository.atualizarParaDone(existingTask.getId());
    }

    public void deletarTarefa(Long id){
        Task taskExistente = repository.findTaskById(id);
        if(taskExistente == null){
            throw new NonexistentTaskException();
        }
        repository.deletarTarefaPorId(taskExistente.getId());
    }

    public Task criarTarefa(TaskRequest request){

        Task newTask = new Task();
        newTask.setTitulo(request.titulo());
        newTask.setDescricao(request.descricao());
        newTask.setEstado(request.estado());
        newTask.setPrevisaoEntrega(request.previsaoEntrega());

        Date currentDate = new Date();
        newTask.setDataCriacao(currentDate);
        newTask.setDataUltimaAtualizacao(currentDate);

        return repository.save(newTask);

    }

}
