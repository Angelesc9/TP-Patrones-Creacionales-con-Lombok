package abstractfactory;

public class AdminUI implements InterfazUI {
    @Override public void render(){
        System.out.println("AdminUI: catalogos, usuarios y reportes");
    }
}
