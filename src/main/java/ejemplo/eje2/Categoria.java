package ejemplo.eje2;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private String denominacion;
    private Long id;

    @Builder.Default
    private Set<Articulo> articulo = new HashSet<>();

    @Override
    public String toString (){
        return "Categoria { " + denominacion + " id " + id +"}";
    }
}
