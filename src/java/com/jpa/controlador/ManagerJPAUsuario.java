package com.jpa.controlador;

import com.entidad.Usuario;
import com.jpa.controlador.entidad.UsuarioJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerJPAUsuario {
    private EntityManagerFactory emf;
    private UsuarioJpaController usuarioJpaController;
    
    public  ManagerJPAUsuario(){
        emf = Persistence.createEntityManagerFactory("JPAPU");
        usuarioJpaController = new UsuarioJpaController(emf);
    }
    
    public void gurdar(Usuario usuario){
        usuarioJpaController.create(usuario);
    }
    
    public List<Usuario> todosLosUsuarios(){
        return usuarioJpaController.findUsuarioEntities();
    }
}
