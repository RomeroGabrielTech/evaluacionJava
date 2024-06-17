package evaluacionJava.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

@Entity
@ApiModel(description = "Detalles sobre el teléfono del usuario") // Describe la entidad
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "El ID único del teléfono, generado automáticamente")
    private Long id;

    @ApiModelProperty(notes = "Número de teléfono")
    private String number;

    @ApiModelProperty(notes = "Código de ciudad del número de teléfono")
    private String cityCode;

    @ApiModelProperty(notes = "Código de país del número de teléfono")
    private String countryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ApiModelProperty(notes = "Usuario al que pertenece este teléfono")
    private User user;

    // Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
