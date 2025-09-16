package abstractfactory;

import factory.Libro;

public class EnvioExpress implements MetodoEnvio {
    @Override
    public void enviar(Libro libro, String destino) {
        System.out.println("envio express a : "+destino+ "del libro: " +libro.getTitulo());
    }
}
