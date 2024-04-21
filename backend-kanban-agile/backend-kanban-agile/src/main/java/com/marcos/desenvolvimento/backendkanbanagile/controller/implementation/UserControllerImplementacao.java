package com.marcos.desenvolvimento.backendkanbanagile.controller.implementation;

import com.marcos.desenvolvimento.backendkanbanagile.controller.UserController;
import com.marcos.desenvolvimento.backendkanbanagile.entity.User;
import com.marcos.desenvolvimento.backendkanbanagile.mapper.UserMapper;
import com.marcos.desenvolvimento.backendkanbanagile.request.UserRequest;
import com.marcos.desenvolvimento.backendkanbanagile.response.UserResponse;
import com.marcos.desenvolvimento.backendkanbanagile.service.UserService;
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
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserControllerImplementacao implements UserController {

    private final UserService userService;

    private final UserMapper mapper;

    @Operation(summary = "Buscar registro por usuario")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))
    })
    @Override
    public ResponseEntity<UserResponse> buscarPorUsuario(String user) {
        User finalUser = userService.buscarPorUsuario(user);
        return ResponseEntity.status(200)
                .body(mapper.toUserResponse(finalUser));
    }

    @Operation(summary = "Salvar um novo usuário")
    @ApiResponse(responseCode = "201", description = "Usuário salvo com sucesso")
    @Override
    public ResponseEntity<Void> salvarUsuario(UserRequest userRequest) {
        User userToBeSaved = userService.salvarUsuario(userRequest);
        return ResponseEntity.status(201).build();

    }

    @Operation(summary = "Listar todos os usuários")
    @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserResponse.class)))
    })
    @Override
    public ResponseEntity<List<UserResponse>> listarTodos() {
       List<User> userList = userService.encontrarTodos();
       List<UserResponse> userResponseList = mapper.toUserResponseList(userList);
       return ResponseEntity.status(200).body(userResponseList);

    }

    @Operation(summary = "Alterar um usuário existente")
    @ApiResponse(responseCode = "200", description = "Usuário alterado com sucesso", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))
    })
    @Override
    public ResponseEntity<UserResponse> alterarUsuario(String user, UserRequest userRequest) {
        User updatedUser = userService.atualizarUsuario(user, userRequest);
        UserResponse userResponse = mapper.toUserResponse(updatedUser);
        return ResponseEntity.ok(userResponse);
    }


    @Operation(summary = "Deletar um usuário")
    @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso")
    @Override
    public ResponseEntity<Void> deletarPorUsuario(String user) {
        userService.deletarPorUsuario(user);
        return ResponseEntity.noContent().build();
    }
}
