package evaluacionJava.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Schema(description = "Detalles de un usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "ID del usuario", example = "1", required = true)
    private UUID id;

    @Schema(description = "Nombre del usuario", example = "John Doe", required = true)
    private String name;

    @Schema(description = "Email del usuario", example = "john.doe@example.com", required = true)
    private String email;

    @Schema(description = "Contraseña del usuario", example = "password123", required = true)
    private String password;

    @ElementCollection
    @Schema(description = "Lista de teléfonos del usuario")
    private List<Phone> phones;

    @Schema(description = "Fecha de creación del usuario")
    private LocalDateTime created;

    @Schema(description = "Fecha de modificación del usuario")
    private LocalDateTime modified;

    @Schema(description = "Último inicio de sesión del usuario")
    private LocalDateTime lastLogin;

    @Schema(description = "Token del usuario")
    private String token;

    @Schema(description = "Indica si el usuario está activo")
    private Boolean isActive;

    // Getters y Setters
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
