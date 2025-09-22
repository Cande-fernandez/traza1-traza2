package ejemplo.eje2;

import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@SuperBuilder
public class ArticuloManufacturadoDetalle {
    private Integer cantidad;
    private Long id;
    private ArticuloInsumo articuloInsumo;

    @Override
    public String toString (){
        return "Cantidad { " + cantidad + " id " + articuloInsumo +"}";
    }
}
