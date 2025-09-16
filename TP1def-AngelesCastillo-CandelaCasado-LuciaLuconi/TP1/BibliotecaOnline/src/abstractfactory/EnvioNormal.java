package abstractfactory;

import factory.Libro;

public class EnvioNormal implements MetodoEnvio {
    @Override
    public void enviar(Libro libro, String destino) {
        System.out.println("envio normal a : "+destino+ "del libro: " +libro.getTitulo());
    }
}
