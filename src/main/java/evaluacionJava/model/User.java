package evaluacionJava.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@ApiModel(description = "Detalles sobre el usuario") // Describe la entidad
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "El ID único del usuario, generado automáticamente")
    private UUID id;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String name;

    @ApiModelProperty(notes = "Correo electrónico del usuario, debe ser único")
    private String email;

    @ApiModelProperty(notes = "Contraseña del usuario, almacenada en forma segura")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    @ApiModelProperty(notes = "Lista de teléfonos asociados al usuario")
    private List<Phone> phones;

    @CreationTimestamp
    @ApiModelProperty(notes = "Fecha y hora de creación del usuario")
    private LocalDateTime created;

    @UpdateTimestamp
    @ApiModelProperty(notes = "Fecha y hora de la última modificación del usuario")
    private LocalDateTime modified;

    @ApiModelProperty(notes = "Fecha y hora del último ingreso del usuario")
    private LocalDateTime lastLogin;

    @ApiModelProperty(notes = "Token de sesión para autenticación")
    private String token;

    @ApiModelProperty(notes = "Estado de actividad del usuario")
    private Boolean isActive;

    // Getters y setters


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
