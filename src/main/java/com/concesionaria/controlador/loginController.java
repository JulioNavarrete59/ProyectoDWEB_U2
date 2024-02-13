package com.concesionaria.controlador;

import com.concesionaria.dao.UsuarioDao;
import com.concesionaria.modelo.usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.mindrot.jbcrypt.BCrypt;

@RequestScoped
@Named(value = "loginBean")
public class loginController {
    private String username;
    private String password;

    private String newPassword;

    private String confirmPassword;

    private final UsuarioDao usuarioDao = new UsuarioDao();

    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // Método para manejar el inicio de sesión
    public String login() {
        // Verifica el nombre de usuario y la contraseña en la base de datos
        usuario usuarioEnBaseDeDatos = usuarioDao.buscarPorUsername(this.username);

        if (usuarioEnBaseDeDatos != null && BCrypt.checkpw(this.password, usuarioEnBaseDeDatos.getPassword())) {
            // Si el inicio de sesión es exitoso, redirige al usuario a la página principal
            return "index.xhtml?faces-redirect=true";
        } else {
            // Si el inicio de sesión falla, muestra un mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre de usuario o contraseña incorrectos."));
            return null;
        }
    }

    //Método para registrar un usuario
    public String registrar() {
        try {
            // Verifica si el nombre de usuario ya existe
            usuario usuarioExistente = usuarioDao.buscarPorUsername(this.username);

            if (usuarioExistente != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El nombre de usuario ya existe."));
                return null;
            }

            // Si el nombre de usuario no existe, registra al nuevo usuario con contraseña encriptada
            usuario nuevoUsuario = new usuario();
            nuevoUsuario.setUsername(this.username);
            nuevoUsuario.setPassword(BCrypt.hashpw(this.password, BCrypt.gensalt()));
            usuarioDao.registrar(nuevoUsuario);

            // Redirige al usuario a la página principal
            return "login.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al registrar el usuario."));
            return null;
        }
    }

    public String changePassword() {
        // Verifica el nombre de usuario en la base de datos
        usuario usuarioEnBaseDeDatos = usuarioDao.buscarPorUsername(this.username);

        if (usuarioEnBaseDeDatos != null) {
            // Si el nombre de usuario existe, verifica que las nuevas contraseñas coincidan
            if (newPassword.equals(confirmPassword)) {
                // Si las contraseñas coinciden, cambia la contraseña del usuario
                usuarioEnBaseDeDatos.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
                usuarioDao.actualizar(usuarioEnBaseDeDatos);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Contraseña cambiada exitosamente."));
                return "login.xhtml?faces-redirect=true";
            } else {
                // Si las contraseñas no coinciden, muestra un mensaje de error
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las contraseñas no coinciden."));
                return null;
            }
        } else {
            // Si el nombre de usuario no existe, muestra un mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El nombre de usuario no existe."));
            return null;
        }
    }

    // Método para redirigir a la página de registro
    public String redirectToRegister() {
        return "registrarUsuario.xhtml?faces-redirect=true";
    }

    // Método para redirigir a la página de cambio de contraseña
    public String redirectToChangePassword() {
        return "forgotPassword.xhtml?faces-redirect=true";
    }

}
