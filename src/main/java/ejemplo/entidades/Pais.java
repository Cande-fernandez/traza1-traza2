package ejemplo.entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pais {
    private String nombre;
    @Builder.Default
    private Set<Provincia> provincia= new HashSet<>();

    @Override
    public String toString() {
        return "Pais { " + nombre + " }";
    }
}
