package builder;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor



public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private LocalDate nacimiento;

}
