package ejemplo.eje2;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Imagen {
    private String denominacion;
    private Long id;

    @Override
    public String toString (){
        return "Imagen { " + denominacion + "id" + id +"}";
    }
}
