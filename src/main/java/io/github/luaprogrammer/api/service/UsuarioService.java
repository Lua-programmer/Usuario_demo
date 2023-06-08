package io.github.luaprogrammer.api.service;

import io.github.luaprogrammer.api.dto.UsuarioDto;
import io.github.luaprogrammer.api.model.UsuarioModel;
import io.github.luaprogrammer.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ModelMapper mapper;

    public List<UsuarioDto> findAll() {
        if (usuarioRepository.findAll().isEmpty()) throw new RuntimeException("Nenhum usuário encontrado");
        return usuarioRepository.findAll().stream()
                .map(usuarioModel -> mapper.map(usuarioModel, UsuarioDto.class))
                .toList();
    }

    public UsuarioDto findById(UUID id) {
        if (!usuarioRepository.existsById(id)) throw new RuntimeException("Usuário não encontrado");
        return mapper.map(usuarioRepository.findById(id), UsuarioDto.class);
    }

    public UsuarioDto save(UsuarioDto usuarioDto) {
        final var usuarioSalvo = usuarioRepository.save(mapper.map(usuarioDto, UsuarioModel.class));
        return mapper.map(usuarioSalvo, UsuarioDto.class);
    }

    public UsuarioDto update(UsuarioDto usuarioDto, UUID id) {
        usuarioDto.setId(id);
        final var usuarioSalvo = usuarioRepository.save(mapper.map(usuarioDto, UsuarioModel.class));
        return mapper.map(usuarioSalvo, UsuarioDto.class);
    }

    public void delete(UUID id) {
        usuarioRepository.deleteById(id);
    }

}
