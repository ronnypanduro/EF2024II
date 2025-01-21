package com.examen.app_seguridad.services;

import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.examen.app_seguridad.Model.UsuarioModel;
import com.examen.app_seguridad.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioModel{
    @Autowired
    IUsuarioRepository repository;
    //private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

     // Llave secreta (debe ser almacenada de forma segura, por ejemplo, en un servicio de gestión de claves)
     private static final String SECRET_KEY = "1234567890123456"; 

    @Override
    public List<UsuarioModel> findAll() {
        return (List<UsuarioModel>)repository.findAll();
    }

    @Override
    public UsuarioModel findById(Integer id) {
        return (UsuarioModel)repository.findById(id).get();
    }

    @Override
    public UsuarioModel add(UsuarioModel model) {
        return repository.save(model);
    }

    @Override
    public UsuarioModel update(UsuarioModel model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public String LoguearUsuario(String username, String password) {
        try {
            Optional<UsuarioModel> optionalUser = ((Collection<UsuarioModel>) repository.findAll())
                .stream()
                .filter(user -> user.getNombre().equals(username) && user.getClave().equals(password))
                .findFirst();
    
            if (optionalUser.isPresent()) {
                return "Login exitoso";
            } else {
                return "Usuario o contraseña incorrectos";
            }
        } catch (Exception e) {
            return "Error durante el proceso de login: " + e.getMessage();
        }
    }

    @Override
    public Boolean validarUsuario(String username) {
        try {
            return ((Collection<UsuarioModel>) repository.findAll())
                .stream()
                .anyMatch(user -> user.getNombre().equals(username));
        } catch (Exception e) {
            // Manejo de errores
            return false;
        }
    }

    

    
    @Override
    public String encryptPassword2(String password) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    @Override
    public String decryptPassword2(String encryptPassword) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encryptPassword);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted);
    }

    @Override
    public UsuarioModel findByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }
    
    public List<UsuarioModel>  getAcces() {
       
        return (List<UsuarioModel>) repository.findAll();
    }
   
    public Boolean validatedCredentials(String UserName, String Password) {
        List<UsuarioModel> result = (List<UsuarioModel>) repository.findAll();
        List<UsuarioModel> resultFilter = result.stream()
                .filter(t -> t.getNombre().equals(UserName) && t.getClave().equals(Password))
                .collect(Collectors.toList());
        if (null == resultFilter || resultFilter.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public String encryptPassword(String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encryptPassword'");
    }

    @Override
    public Boolean validatePassword(String password, String encodedPassword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validatePassword'");
    }
}
