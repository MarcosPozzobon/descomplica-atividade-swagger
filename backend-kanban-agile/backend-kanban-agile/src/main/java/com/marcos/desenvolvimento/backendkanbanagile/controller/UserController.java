package com.marcos.desenvolvimento.backendkanbanagile.controller;

import com.marcos.desenvolvimento.backendkanbanagile.request.UserRequest;
import com.marcos.desenvolvimento.backendkanbanagile.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {

    @GetMapping
    public ResponseEntity<UserResponse> buscarPorUsuario(@RequestParam("current-user") final String user);

    @PostMapping("/salvar-usuario")
    public ResponseEntity<Void> salvarUsuario(@RequestBody final UserRequest userRequest);

    @GetMapping("/listar-todos")
    public ResponseEntity<List<UserResponse>> listarTodos();

    @PatchMapping("/alterar-usuario")
    public ResponseEntity<UserResponse> alterarUsuario(@RequestParam("user") String user, @RequestBody final UserRequest userRequest);

    @DeleteMapping("/deletar-usuario")
    public ResponseEntity<Void> deletarPorUsuario(@RequestParam("user") String user);

}
