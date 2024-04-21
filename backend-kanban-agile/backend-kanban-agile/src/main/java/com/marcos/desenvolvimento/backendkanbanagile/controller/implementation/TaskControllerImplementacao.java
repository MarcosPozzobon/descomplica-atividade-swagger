package com.marcos.desenvolvimento.backendkanbanagile.controller.implementation;

import com.marcos.desenvolvimento.backendkanbanagile.controller.TaskController;
import com.marcos.desenvolvimento.backendkanbanagile.mapper.TaskMapper;
import com.marcos.desenvolvimento.backendkanbanagile.request.TaskRequest;
import com.marcos.desenvolvimento.backendkanbanagile.response.TaskResponse;
import com.marcos.desenvolvimento.backendkanbanagile.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskControllerImplementacao implements TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @Operation(summary = "Filtrar tarefas por título")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TaskResponse.class)))
    })
    @Override
    public ResponseEntity<List<TaskResponse>> filtraPorTitulo(String titulo) {
        return ResponseEntity
                .status(200)
                .body(taskMapper.toTaskResponseList(taskService.encontrarTaskPorTitulo(titulo)));
    }


    @Operation(summary = "Buscar tarefa por ID")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))
    })
    @Override
    public ResponseEntity<TaskResponse> filtraPorId(Long identificador) {
        return ResponseEntity
                .status(200)
                .body(taskMapper.toTaskResponse(taskService.encontrarTaskPorId(identificador)));
    }

    @Operation(summary = "Filtrar tarefas por descrição")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TaskResponse.class)))
    })
    @Override
    public ResponseEntity<List<TaskResponse>> filtraPorDescricao(TaskRequest taskRequest) {
        return ResponseEntity
                .status(200)
                .body(taskMapper.toTaskResponseList(taskService.encontrarPorDescricao(taskRequest.descricao())));
    }

    @Operation(summary = "Filtrar tarefas por estado")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TaskResponse.class)))
    })
    @Override
    public ResponseEntity<List<TaskResponse>> filtraPorEstado(String estado) {
        return ResponseEntity
                .status(200)
                .body(taskMapper.toTaskResponseList(taskService.encontrarPorEstadoDaTarefa(estado)));
    }

    @Operation(summary = "Mover tarefa para o estado de 'Backlog'")
    @ApiResponse(responseCode = "204", description = "Tarefa movida para 'Backlog'")
    @Override
    public ResponseEntity<Void> mudaParaBacklog(Long id) {
        taskService.atualizarTarefaParaBacklog(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Mover tarefa para o estado de 'Doing'")
    @ApiResponse(responseCode = "200", description = "Tarefa movida para 'Doing'", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))
    })
    @Override
    public ResponseEntity<TaskResponse> mudaParaDoing(Long id) {
        taskService.atualizarTarefaParaDoing(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Mover tarefa para o estado de 'Review'")
    @ApiResponse(responseCode = "200", description = "Tarefa movida para 'Review'", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))
    })
    @Override
    public ResponseEntity<TaskResponse> mudaParaReview(Long id) {
        taskService.atualizarTarefaParaReview(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Mover tarefa para o estado de 'Done'")
    @ApiResponse(responseCode = "200", description = "Tarefa movida para 'Done'", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))
    })
    @Override
    public ResponseEntity<TaskResponse> mudaParaDone(Long id) {
        taskService.atualizarTarefaParaDone(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Excluir uma tarefa")
    @ApiResponse(responseCode = "204", description = "Tarefa excluída com sucesso")
    @Override
    public ResponseEntity<Void> deletaTarefa(Long id) {
        taskService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Criar uma nova tarefa")
    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso")
    @Override
    public ResponseEntity<Void> criaTarefa(final TaskRequest taskRequest) {
        taskService.criarTarefa(taskRequest);
        return ResponseEntity
                .status(201)
                .build();
    }
}
