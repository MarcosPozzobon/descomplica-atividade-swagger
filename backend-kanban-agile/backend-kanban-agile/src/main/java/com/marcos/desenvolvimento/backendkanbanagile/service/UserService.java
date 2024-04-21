package com.marcos.desenvolvimento.backendkanbanagile.service;

import com.marcos.desenvolvimento.backendkanbanagile.entity.User;
import com.marcos.desenvolvimento.backendkanbanagile.exception.ExistingUserException;
import com.marcos.desenvolvimento.backendkanbanagile.exception.NonexistentUserException;
import com.marcos.desenvolvimento.backendkanbanagile.exception.InvalidUserFormatException;
import com.marcos.desenvolvimento.backendkanbanagile.mapper.UserMapper;
import com.marcos.desenvolvimento.backendkanbanagile.repository.UserRepository;
import com.marcos.desenvolvimento.backendkanbanagile.request.UserRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public User buscarPorUsuario(String user){

        User existingUser = repository.findByUsuario(user);

        if(existingUser == null ){
            throw new NonexistentUserException("O usuário não existe.");
        }

        if(user == null || user.isEmpty() || user.isBlank()){
            throw new InvalidUserFormatException();
        }

       return repository.findByUsuario(user);
    }

    public User salvarUsuario(UserRequest userRequest){
        User existingUser = repository.findByUsuario(userRequest.usuario());

        if (existingUser != null) {
            throw new ExistingUserException("Usuário já existente na base de dados.");
        }

        return repository.save(userMapper.toUserEntity(userRequest));
    }


    public List<User> encontrarTodos(){
        return repository.findAll();
    }


    public User atualizarUsuario(String user, final UserRequest userRequest) {
        User existingUser = repository.findByUsuario(user);
        if (existingUser == null) {
            throw new NonexistentUserException();
        }
        existingUser.setUsuario(userRequest.usuario());
        existingUser.setSenha(userRequest.senha());
        return repository.save(existingUser);
    }

    public void deletarPorUsuario(String user){

        if(user == null || user.isEmpty() || user.isBlank()){
            throw new InvalidUserFormatException();
        }
        repository.deleteByUsuario(user);
    }
}
