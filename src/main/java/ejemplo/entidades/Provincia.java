package ejemplo.entidades;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Builder
@Getter
@Setter

public class Provincia {
    private String nombre;

    @Builder.Default
    private Set<Localidad> localidad = new HashSet<>();
    private Pais pais;

    @Override
    public String toString (){
        return "Provincia { " +nombre+ " } de { " + (pais != null ? pais.getNombre():null) + " }";
    }
}
