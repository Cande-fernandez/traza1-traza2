package ejemplo.eje2;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UnidadMedida {
    private String denominacion;
    private Long id;

    @Override
    public String toString (){
        return "Unidad de Medida { " + denominacion + " id " + id +"}";
    }
}
