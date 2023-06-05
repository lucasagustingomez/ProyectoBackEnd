package com.example.v2.Security;


import com.example.v2.Entity.Usuario;
import com.example.v2.Entity.UsuarioRol;
import com.example.v2.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CargadoraDeDatos implements ApplicationRunner {


    private UsuarioRepository usuarioRepository;

    @Autowired
    public CargadoraDeDatos(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



    @Override
    public void run(ApplicationArguments args) {


        BCryptPasswordEncoder cifrador=new BCryptPasswordEncoder();

        String passACifrar="12345678";
        String passCifrada=cifrador.encode(passACifrar);


        Usuario usuarioAInsertar = new Usuario( "lukitas","gomez","lukitasgomez@gmail.com",passCifrada, UsuarioRol.ROLE_USER);

        usuarioRepository.save(usuarioAInsertar);


        String passwordCifrado2= cifrador.encode("98765432");

        usuarioAInsertar = new Usuario("lucas","gomez","lucasgomez@gmail.com",passwordCifrado2, UsuarioRol.ROLE_ADMIN);


        usuarioRepository.save(usuarioAInsertar);


    }
}