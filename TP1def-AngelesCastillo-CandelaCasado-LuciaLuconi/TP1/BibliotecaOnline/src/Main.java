import abstractfactory.AbstractFactory;
import abstractfactory.AdminFactory;
import abstractfactory.InterfazUI;
import abstractfactory.MetodoEnvio;
import builder.Usuario;
import factory.Libro;
import factory.LogisticaLibro;
import prototype.Prestamo;
import singleton.Database;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.println(db1 == db2);
        Libro l1 = LogisticaLibro.Cargar("FISICO", "Gabriel Garcia Marquez", "Cronicas de una muerte anunciada", 150);
        Libro l2 = LogisticaLibro.Cargar("DIGITAL", "Agatha Kristi", "Muerte en el nilo", 200);
        Libro l3 = LogisticaLibro.Cargar("FISICO", "pepa", "After", 500);
        Libro l4 = LogisticaLibro.Cargar("DIGITAL", "Gabriel Garcia Marquez", "NOSE", 400);

        db1.agregarLibro(l1);
        db1.agregarLibro(l2);
        db1.agregarLibro(l3);
        db1.agregarLibro(l4);
        System.out.println("total de libros en la base de datos: " + db1.getLibros().size());
        db1.getLibros().forEach(libro -> System.out.println("titulo: " + libro.getTitulo() + ", autor: " + libro.getAutor() + ", tipo: " + libro.getTipo()));
        //usamos la fabrica de admin
        AbstractFactory factory = new AdminFactory();
        // Crear la interfaz de usuario para administrador
        InterfazUI adminUI = factory.crearUI();
        MetodoEnvio envio = factory.crearEnvio();
        adminUI.render();
        envio.enviar(l4, "madrid");
//creacion de usuarios
        Usuario u1= new Usuario().builder().nombre("Angeles")
                .apellido("Castillo")
                .correo("castilloangi887@gmail.com")
                .telefono("2613004357")
                .nacimiento(LocalDate.of(2003, 9, 12)) .build();
        Usuario u2 = new Usuario().builder().nombre("Constanza ")
                .apellido("Castillo")
                .telefono("2613004357")
                .correo("castilloconstanza15@gmail.com")
                .nacimiento(LocalDate.of(2006, 9, 15)).build();
        System.out.println("---------Usuarios en el sistema---------");
        System.out.println(u2);
        System.out.println(u1);
        // Crear fechas
        Calendar cal = Calendar.getInstance();
        LocalDate inicio = LocalDate.now();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        LocalDate fin = inicio.plusDays(7);

        //  Crear un préstamo prototipo
        // Libro libro = new Libro().build().;
        //Usuario usuario = new Usuario("Ana");
        Prestamo prestamoOriginal = new Prestamo(l1, u2, inicio, fin);
        System.out.println("Original: " + prestamoOriginal);

        //  Clonar y modificar atributos
        Prestamo prestamoClone1 = prestamoOriginal.clone();
        prestamoClone1.getUsuario().setNombre("Carlos"); // cambia el nombre del usuario compartido

        Prestamo prestamoClone2 = prestamoOriginal.clone();
        prestamoClone2.getLibro().setTitulo("Cien años de soledad"); // cambia el título del libro compartido

        System.out.println("Clone1:   " + prestamoClone1);
        System.out.println("Clone2:   " + prestamoClone2);
        System.out.println("Original después de modificar clones: " + prestamoOriginal);
    }
    }









