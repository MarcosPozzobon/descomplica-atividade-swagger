package com.marcos.desenvolvimento.backendkanbanagile.controller;

import com.marcos.desenvolvimento.backendkanbanagile.request.TaskRequest;
import com.marcos.desenvolvimento.backendkanbanagile.response.TaskResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskController {

    @GetMapping
    public ResponseEntity<List<TaskResponse>> filtraPorTitulo(@RequestParam("titulo") final String titulo);

    @GetMapping("/encontrar-por-id")
    public ResponseEntity<TaskResponse> filtraPorId(@RequestParam("identificador") final Long identificador);

    @GetMapping("/encontrar-por-descricao")
    public ResponseEntity<List<TaskResponse>> filtraPorDescricao(@RequestBody final TaskRequest taskRequest);

    @GetMapping("/encontrar-por-estado")
    public ResponseEntity<List<TaskResponse>> filtraPorEstado(@RequestParam("estado") final String estado);

    @PatchMapping("/backlog")
    public ResponseEntity<Void> mudaParaBacklog(@RequestParam("identificador") final Long id);

    @PatchMapping("/doing")
    public ResponseEntity<TaskResponse> mudaParaDoing(@RequestParam("identificador") final Long id);

    @PatchMapping("/review")
    public ResponseEntity<TaskResponse> mudaParaReview(@RequestParam("identificador") final Long id);

    @PatchMapping("/done")
    public ResponseEntity<TaskResponse> mudaParaDone(@RequestParam("identificador") final Long id);

    @DeleteMapping("/excluir-tarefa")
    public ResponseEntity<Void> deletaTarefa(@RequestParam("identificador") final Long id);

    @PostMapping("/criar-tarefa")
    public ResponseEntity<Void> criaTarefa(@RequestBody final TaskRequest taskRequest);

}
