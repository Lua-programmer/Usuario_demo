package io.github.luaprogrammer.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private UUID id;

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dataNascimento;

    @NotBlank(message = "O campo email é obrigatório")
    private String email;

}