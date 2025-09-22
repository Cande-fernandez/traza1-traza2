package ejemplo.entidades;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Domicilio {
    private String calle;
    private Integer numero;
    private Integer cp;
    private Localidad localidad;

    @Override
    public String toString (){
        return "Domicilio { calle: " +calle + " -numero: "+ numero + " -cp: " +cp + " de " + (localidad != null ? localidad.getNombre() : null) + " }";
    }
}
