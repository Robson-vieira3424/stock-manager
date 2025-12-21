package com.StockManager.Controller;

import com.StockManager.Model.DTO.UsuarioLoginDTO;
import com.StockManager.Model.Permissao;
import com.StockManager.Model.Usuario;
import com.StockManager.Repositories.UsuarioRepository;
import com.StockManager.Services.TokenService;
import com.StockManager.Services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioLoginDTO dto){
        UsernamePasswordAuthenticationToken autenticationToken =
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());

        Authentication auth = authenticationManager.authenticate(autenticationToken);
        Usuario usuario =(Usuario) auth.getPrincipal();

        String token = tokenService.gerarToken(usuario);
        return  ResponseEntity.ok().body(token);
     }

     @PostMapping("/registrar")
     public ResponseEntity<String> registrar(@RequestBody UsuarioLoginDTO dto){

        String senha = new BCryptPasswordEncoder().encode(dto.getSenha());
        Usuario user = new Usuario(dto.getNome(),dto.getEmail(), senha, Permissao.valueOf(dto.getPermissao())  );
         usuarioRepository.save(user);
         return ResponseEntity.ok().body("Novo Usuario Cadastrado!");
    }


}
