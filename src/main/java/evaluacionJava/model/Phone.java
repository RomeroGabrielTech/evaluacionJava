package evaluacionJava.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;

@Embeddable
@Schema(description = "Detalles del teléfono del usuario")
public class Phone {
    @Schema(description = "Número de teléfono", example = "123456789", required = true)
    private String number;

    @Schema(description = "Código de la ciudad", example = "1", required = true)
    private String citycode;

    @Schema(description = "Código del país", example = "44", required = true)
    private String contrycode;

    // Getters y Setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }
}
