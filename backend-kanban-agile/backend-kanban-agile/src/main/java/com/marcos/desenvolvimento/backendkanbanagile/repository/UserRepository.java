package com.marcos.desenvolvimento.backendkanbanagile.repository;

import com.marcos.desenvolvimento.backendkanbanagile.entity.User;
import com.marcos.desenvolvimento.backendkanbanagile.request.UserRequest;
import com.marcos.desenvolvimento.backendkanbanagile.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public void deleteByUsuario(String usuario);

    public User findByUsuario(String usuario);

}
