package prototype;

import builder.Usuario;
import factory.Libro;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Prestamo implements Cloneable{
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;


    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone(); //  shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar préstamo", e);
        }
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro='" + libro + '\'' +
                ", usuario='" + usuario + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }

}

