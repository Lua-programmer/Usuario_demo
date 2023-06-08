package io.github.luaprogrammer.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    @Id
    private Long id;

    private String username;

    private String dataNascimento;

    private String email;
}
