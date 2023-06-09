package io.github.luaprogrammer.api.service;

import io.github.luaprogrammer.api.dto.UsuarioDto;
import io.github.luaprogrammer.api.exception.BusinessException;
import io.github.luaprogrammer.api.model.UsuarioModel;
import io.github.luaprogrammer.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ModelMapper mapper;

    public List<UsuarioDto> findAll() {
        if (usuarioRepository.findAll().isEmpty()) throw new BusinessException("Nenhum usuário encontrado");
        return usuarioRepository.findAll().stream()
                .map(usuarioModel -> mapper.map(usuarioModel, UsuarioDto.class))
                .toList();
    }

    public UsuarioDto findById(Long id) {
        if (!usuarioRepository.existsById(id)) throw new BusinessException("Usuário não encontrado");
        return mapper.map(usuarioRepository.findById(id), UsuarioDto.class);
    }

    public UsuarioDto save(UsuarioDto usuarioDto) {
        final var usuarioSalvo = usuarioRepository.save(mapper.map(usuarioDto, UsuarioModel.class));
        return mapper.map(usuarioSalvo, UsuarioDto.class);
    }

    public UsuarioDto update(UsuarioDto usuarioDto, Long id) {
        findById(id);
        usuarioDto.setId(id);
        final var usuarioSalvo = usuarioRepository.save(mapper.map(usuarioDto, UsuarioModel.class));
        return mapper.map(usuarioSalvo, UsuarioDto.class);
    }

    public void delete(Long id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }

}
