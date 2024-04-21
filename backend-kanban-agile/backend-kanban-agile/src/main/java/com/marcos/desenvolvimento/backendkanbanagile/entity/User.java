package com.marcos.desenvolvimento.backendkanbanagile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String senha;


    //metodo criado para poder acessar o atributo de usuario de um objeto do tipo User
    //e poder retornar somente o nome do usuario ao inves da entidade toda... nao alterar isto.
    public String getNomeUsuario(){
        return this.usuario;
    }
}
