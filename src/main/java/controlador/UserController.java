package controlador;

import modelo.Usuario;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
    private UserService userService;

    @GetMapping
    public List getAllUsuarios() {
        return userService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = userService.getUsuarioPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUser = userService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsuario(@PathVariable Long id,  Usuario userDetails) {
        Usuario updatedUser = userService.updateUsuario(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable Long id) {
        userService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
