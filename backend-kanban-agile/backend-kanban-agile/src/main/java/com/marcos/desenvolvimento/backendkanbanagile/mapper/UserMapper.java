package com.marcos.desenvolvimento.backendkanbanagile.mapper;

import com.marcos.desenvolvimento.backendkanbanagile.entity.User;
import com.marcos.desenvolvimento.backendkanbanagile.exception.NullPasswordException;
import com.marcos.desenvolvimento.backendkanbanagile.exception.InvalidUserFormatException;
import com.marcos.desenvolvimento.backendkanbanagile.request.UserRequest;
import com.marcos.desenvolvimento.backendkanbanagile.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User toUserEntity(UserRequest userRequest){

        User user = new User();

        if(userRequest != null) {

            if(userRequest.usuario() == null && userRequest.senha().isBlank()){
                throw new InvalidUserFormatException();
            }
            if(userRequest.senha() == null){
                throw new NullPasswordException();
            }

            user.setUsuario(userRequest.usuario());
            user.setSenha(userRequest.senha());
        }
        return user;
    }

    public UserResponse toUserResponse(User user){
        return new UserResponse(user.getUsuario());
    }

    public List<UserResponse> toUserResponseList(List<User> users) {
        return users.stream()
                .map(this::toUserResponse)
                .collect(Collectors.toList());
    }
}
