package service;

import modelo.Usuario;
import repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List getAllUsuarios() {
        return userRepository.findAll();
    }

    public Usuario getUsuarioPorId(Long id) {
        return (Usuario) userRepository.findById(id).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) {
        return (Usuario) userRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario detallesUsuario) {
        Usuario usuario = (Usuario) userRepository.findById(id).orElse(null);
        if (usuario != null) {
        	usuario.setNombre(detallesUsuario.getNombre());
        	usuario.setEmail(detallesUsuario.getEmail());
            return (Usuario) userRepository.save(usuario);
        }
        return null;
    }

    public void deleteUsuario(Long id) {
        userRepository.deleteById(id);
    }
}