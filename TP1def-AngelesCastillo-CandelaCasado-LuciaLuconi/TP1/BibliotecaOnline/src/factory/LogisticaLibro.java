package factory;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
//@AllArgsConstructor


public class LogisticaLibro {
    public static Libro Cargar(String tipo, String autor, String titulo, int paginas){
        switch (tipo){
            case "FISICO": return LibroFisico.builder()
                    .titulo(titulo)
                    .autor(autor)
                    .paginas(paginas).build();

            case "DIGITAL": return LibroDigital.builder().titulo(titulo)
                    .autor(autor)
                    .paginas(paginas).build();
            default: throw new IllegalArgumentException("tipo de libro desconocido");

        }
    }
}
