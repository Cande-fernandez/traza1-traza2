package ejemplo.eje2;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@SuperBuilder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public abstract class  Articulo {
    protected String denominacion;
    protected Double precioVenta;
    protected Long id;

    @Builder.Default
    protected Set<Imagen> imagen = new HashSet<>();


    protected UnidadMedida unidadMedida;

    private Categoria categoria;



}
