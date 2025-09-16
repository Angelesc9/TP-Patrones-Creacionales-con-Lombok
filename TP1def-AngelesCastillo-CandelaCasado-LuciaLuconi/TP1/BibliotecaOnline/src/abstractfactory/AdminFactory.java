package abstractfactory;

import factory.Libro;

public class AdminFactory implements AbstractFactory {
    @Override
    public  InterfazUI crearUI() {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio crearEnvio() {
        return new EnvioExpress() {
            @Override
            public void enviar(Libro libro, String destino) {

            }
        };
    }
}
