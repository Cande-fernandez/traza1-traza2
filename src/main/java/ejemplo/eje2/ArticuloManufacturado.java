package ejemplo.eje2;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@SuperBuilder
public class ArticuloManufacturado extends Articulo{
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;

    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> ArticuloDetalle = new HashSet<>();

    @Override
    public String toString (){
        return "Articulo manufacturado { " + descripcion  + ArticuloDetalle + "}";
    }

}
