package ejemplo.eje2;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ArticuloInsumo extends Articulo{
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMinimo;
    private Integer stockMaximo;
    private Boolean esParaElaborar;

    @Override
    public String toString (){
        return "Insumos { " + denominacion + " id " + id +"}";
    }
}
