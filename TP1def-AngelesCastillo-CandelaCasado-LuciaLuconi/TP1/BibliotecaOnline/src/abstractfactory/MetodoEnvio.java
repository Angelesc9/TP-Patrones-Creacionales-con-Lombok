package abstractfactory;

import factory.Libro;

public interface MetodoEnvio {
    //enviar libro a su destinoA
    void enviar(Libro libro, String destino);
}
