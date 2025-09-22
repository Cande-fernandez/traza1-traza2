package ejemplo.entidades;

import ejemplo.eje2.ArticuloManufacturado;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean es_Casa_Matriz;
    private Domicilio domicilio;
    private Empresa empresa;

    @Builder.Default
    private Set<ArticuloManufacturado> articulosManufacturados = new HashSet<>();

    @Override
    public String toString (){
        return "Sucursal { " + nombre+ " - Horario Apertura: " + horarioApertura + " - Horario Cierre: " + horarioCierre + " - Es casa Matriz: "+ es_Casa_Matriz +
                "- domicilio " + domicilio +"}";
    }


}
