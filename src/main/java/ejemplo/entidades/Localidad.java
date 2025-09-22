package ejemplo.entidades;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Builder
@Getter
@Setter

public class Localidad {
    private String nombre;
    private Provincia provincia;
    @Builder.Default
    private Set<Domicilio> domicilio = new HashSet<>();


    @Override
    public String toString (){
        return "Localidad { " +nombre + " } de {" + (provincia != null ? provincia.getNombre() : null ) +"}";
    }
}
