package ejemplo.entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;
    @Builder.Default
    private Set<Sucursal> sucursal =new HashSet<>();

    @Override
    public String toString (){
        return "Empresa { " + nombre+ " - razonSocial: " + razonSocial + " - cuit: " +cuit+ " -logo: " + logo;
    }

}
