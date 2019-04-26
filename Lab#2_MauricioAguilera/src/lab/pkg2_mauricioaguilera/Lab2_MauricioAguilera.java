
package lab.pkg2_mauricioaguilera;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab2_MauricioAguilera {

    static Scanner input = new Scanner(System.in);
    static Random r = new Random();
    
    public static void main(String[] args) {
        ArrayList empleado = new ArrayList();
        boolean val=false;
        int opcion=0;
        int cont=1;//contador de cantidad de gerentes
        while (opcion!=8){
            System.out.print("1. Registro de empleados\n2. Depedir empleados\n3. Log In\n4. Ascender cajero\n5. Listar empleados\n6. Modificar Empleado\n7. RANDOM\n8. Salir \nIngrese una opcion: ");
            opcion= input.nextInt();
            switch (opcion){
                case 1:
                    //***************************************registro de un nuevo empleado
                    if (val==true){
                        System.out.print("Ingrese el nombre del nuevo empleado: ");
                        String nombre=input.next();
                        System.out.print("Ingrese el apellido: ");
                        String appe=input.next();
                        System.out.print("Ingrese el color favorito: ");
                        String color=input.next();
                        System.out.print("Ingrese la edad: ");
                        int edad=input.nextInt();
                        System.out.print("Ingrese el genero (1.Masculino y 2. Femenino): ");
                        int temp=input.nextInt();
                        while (temp<1 || temp>2){
                            System.out.print("El valor es invalido, intentelo de nuevo (1.Masculino y 2. Femenino): ");
                            temp=input.nextInt();
                        }
                        String genero="";
                        if(temp==1){
                            genero="Masculino";
                        }
                        else{
                            genero=",Femenino";
                        }
                        System.out.print("Ingrese la altura: ");
                        double alt=input.nextDouble();
                        System.out.print("Ingrese el peso: ");
                        double peso=input.nextDouble();
                        System.out.print("Ingrese el titulo: ");
                        String titulo=input.next();
                        System.out.print("Ingrese el cargo (1. Aseador, 2. Seguridad, 3. Cajero, 4. Gerente):");
                        temp=input.nextInt();
                        while (temp<1 || temp>4){
                            System.out.print("El valor es invalido, intentelo de nuevo (1. Aseador, 2. Seguridad, 3. Cajero, 4. Gerente): ");
                            temp=input.nextInt();
                        }
                        while (cont>3 && temp==4){
                            System.out.print("Se ha alcanzado la cantidad maxima de gerentes, intentelo de nuevo (1. Aseador, 2. Seguridad, 3. Cajero, 4. Gerente): ");
                            temp=input.nextInt();
                        }
                        String cargo="";
                        int sueldo=0;
                        if (temp==1){
                            cargo="Aseador";
                            sueldo=30000;
                        }
                        if (temp==2){
                            cargo="Seguridad";
                            sueldo=38000;
                        }
                        if (temp==3){
                            cargo="Cajero";
                            sueldo=40000;
                        }
                        if (temp==4){
                            cargo="Gerente";
                            sueldo=50000;
                            cont++;
                            System.out.println(cont);
                        }
                        empleado.add(new Empleados(nombre, appe, color, edad, genero, alt, peso, titulo, cargo, sueldo));
                        System.out.println("");
                        System.out.println("Registro exitoso");
                        System.out.println("");
                        //*******************************fin del registro de un nuevo empleado
                    }
                    else{//validacion de que haya hecho log in
                        System.out.println("Acceso denegado, debe registrase para poder realizar cualquier tipo de modificacion al programa");
                        System.out.println("");
                    }
                    break;
                case 2:
                    if (val==true){
                        for (Object t : empleado){
                            System.out.println(empleado.indexOf(t)+". "+t);
                        }
                        System.out.println("");
                        System.out.print("Ingrse la posicion del empleado a despedir: ");
                        int pos= input.nextInt();
                        if ("Gerente".equals(( (Empleados) empleado.get(pos) ).getCargo())){
                            cont--;
                        }
                        empleado.remove(pos);
                        System.out.println("Empleado eliminado exitosamente");
                        System.out.println("");
                    }
                    else{//validacion de que haya hecho log in
                        System.out.println("Acceso denegado, debe registrase para poder realizar cualquier tipo de modificacion al programa");
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el usuario: ");
                    String user=input.next();
                    System.out.println("Ingrese la contraseña: ");
                    String pass=input.next();
                    while (!"leobanegas".equals(user) || !"99".equals(pass)){
                        System.out.print("Ingrese el usuario: ");
                        user=input.next();
                        System.out.println("Ingrese la contraseña: ");
                        pass=input.next();
                    }
                    val=true;
                    System.out.println("Ha accedido exitosamente, bienvenido "+user);
                    System.out.println("");
                    break;
                case 4:
                    if (val==true){
                        if (cont<=3){
                            for (Object t : empleado) {
                                if ("Cajero".equals(( (Empleados) empleado.get((int) t) ).getCargo())){
                                    System.out.println(empleado.indexOf(t)+". "+t);
                                }
                            }
                            System.out.println("");
                            System.out.print("Ingrese la posicion del cajero que quiera ascender a gerente: ");
                            int pos=input.nextInt();
                            ( (Empleados) empleado.get(pos) ).setCargo("Gerente");
                        }
                        else{
                            System.out.println("Lamentamos notificarle que la cantidad de gerentes ha llegado a su maximo, debera modificar o despedir alguno de los gerentes disponibles");
                        }
                        System.out.println("");
                    }
                    else{//validacion de que haya hecho log in
                        System.out.println("Acceso denegado, debe registrase para poder realizar cualquier tipo de modificacion al programa");
                        System.out.println("");
                    }
                    break;
                case 5:
                    for (Object t : empleado){
                        System.out.println(empleado.indexOf(t)+". "+t);
                    }
                    System.out.println("");
                    break;
                case 6:
                    if (val==true){
                        for (Object t : empleado){
                            System.out.println(empleado.indexOf(t)+". "+t);
                        }
                        System.out.println("");
                        System.out.print("Ingrese la posicion del empleado al que quiera modificar: ");
                        int pos=input.nextInt();
                        System.out.println("");
                        System.out.print("1. Nombre \n2. Appellido \n3. Color favorito \n4. Edad \n5. Genero \n6. Altura \n.7. Peso \n8. Titulo \n9. Cargo \nIngrese el valor a modificar: ");
                        int valor = input.nextInt();
                        System.out.println("");
                        String nuevo;
                        switch (valor){
                            case 1://nuevo nombre
                                System.out.print("Ingrese el nuevo nombre: ");
                                nuevo=input.next();
                                ( (Empleados) empleado.get(pos) ).setNombre(nuevo);
                                break;
                            case 2://nuevo apellido
                                System.out.print("Ingrese el nuevo apellido: ");
                                nuevo=input.next();
                                ( (Empleados) empleado.get(pos) ).setAppe(nuevo);
                                break;
                            case 3://nuevo color
                                System.out.print("Ingrese el nuevo color favorito: ");
                                nuevo=input.next();
                                ( (Empleados) empleado.get(pos) ).setNombre(nuevo);
                                break;
                            case 4://nueva edad
                                System.out.print("Ingrese la nueva edad: ");
                                int nuevo2=input.nextInt();
                                ( (Empleados) empleado.get(pos) ).setEdad(nuevo2);
                                break;
                            case 5://nuevo genero
                                System.out.print("Ingrese el nuevo genero (1. Masculino y 2. Femenino): ");
                                nuevo2=input.nextInt();
                                while (nuevo2<1 || nuevo2>2){
                                System.out.print("El valor es invalido, intentelo de nuevo (1.Masculino y 2. Femenino): ");
                                nuevo2=input.nextInt();
                                }   
                                if (nuevo2==1){
                                    ( (Empleados) empleado.get(pos) ).setGenero("Masculino");
                                }
                                else{
                                    ( (Empleados) empleado.get(pos) ).setGenero("Femenino");
                                }
                                break;
                            case 6://nueva altura
                                System.out.print("Ingrese la nuevo altura: ");
                                double nuevo3=input.nextDouble();
                                ( (Empleados) empleado.get(pos) ).setAlt(nuevo3);
                                break;
                            case 7://nuevo peso
                                System.out.print("Ingrese el nuevo peso: ");
                                nuevo3=input.nextDouble();
                                ( (Empleados) empleado.get(pos) ).setPeso(nuevo3);
                                break;
                            case 8://nuevo titulo
                                System.out.print("Ingrese el nuevo titulo: ");
                                nuevo=input.next();
                                ( (Empleados) empleado.get(pos) ).setTitulo(nuevo);
                                break;
                            case 9://nuevo cargo
                                System.out.print("Ingrese el nuevo cargo (1. Aseador, 2. Seguridad, 3. Cajero, 4. Gerente): ");
                                nuevo2=input.nextInt();
                                while (nuevo2<1 || nuevo2>4){
                                System.out.print("El valor es invalido, intentelo de nuevo (1. Aseador, 2. Seguridad, 3. Cajero, 4. Gerente): ");
                                nuevo2=input.nextInt();
                                }
                                while (cont>3 && nuevo2==4){//validacion de cantidad de gerentes
                                    System.out.print("Se ha alcanzado la cantidad maxima de gerentes, intentelo de nuevo (1. Aseador, 2. Seguridad, 3. Cajero, 4. Gerente): ");
                                    nuevo2=input.nextInt();
                                }
                                if (nuevo2==1){
                                    if ("Gerente".equals(( (Empleados) empleado.get(pos) ).getCargo())){
                                        cont--;
                                    }
                                    ( (Empleados) empleado.get(pos) ).setCargo("Aseador");
                                    ( (Empleados) empleado.get(pos) ).setSueldo(30000);
                                }
                                if (nuevo2==2){
                                    if ("Gerente".equals(( (Empleados) empleado.get(pos) ).getCargo())){
                                        cont--;
                                    }
                                    ( (Empleados) empleado.get(pos) ).setCargo("Seguridad");
                                    ( (Empleados) empleado.get(pos) ).setSueldo(38000);
                                }
                                if (nuevo2==3){
                                    if ("Gerente".equals(( (Empleados) empleado.get(pos) ).getCargo())){
                                        cont--;
                                    }
                                    ( (Empleados) empleado.get(pos) ).setCargo("Cajero");
                                    ( (Empleados) empleado.get(pos) ).setSueldo(40000);
                                }
                                if (nuevo2==4){
                                    ( (Empleados) empleado.get(pos) ).setCargo("Gerente");
                                    ( (Empleados) empleado.get(pos) ).setSueldo(50000);
                                    cont++;
                                }
                                break;
                        }
                        System.out.println("La modificacion ha sido exitosa");
                        System.out.println("");
                    }
                    else{//validacion de que haya hecho log in
                        System.out.println("Acceso denegado, debe registrase para poder realizar cualquier tipo de modificacion al programa");
                        System.out.println("");
                    }
                    break;
                case 7:
                    if (val==true){
                        System.out.print("Ingrese la cantidad de empleados cuyos puestos seran cambiados: ");
                        int num=input.nextInt();
                        int c=0;
                        while (c<num){
                            int random= 1+r.nextInt(4);
                            int ranpos= 1+r.nextInt(empleado.size()-1);
                            if (random==1){
                                if ("Gerente".equals(( (Empleados) empleado.get(ranpos) ).getCargo())){
                                    cont--;
                                }
                                ( (Empleados) empleado.get(ranpos) ).setCargo("Aseador");
                                ( (Empleados) empleado.get(ranpos) ).setSueldo(30000);
                                c++;
                            }
                            if (random==2){
                                if ("Gerente".equals(( (Empleados) empleado.get(ranpos) ).getCargo())){
                                    cont--;
                                }
                                ( (Empleados) empleado.get(ranpos) ).setCargo("Seguridad");
                                ( (Empleados) empleado.get(ranpos) ).setSueldo(38000);
                                c++;
                            }
                            if (random==3){
                                if ("Gerente".equals(( (Empleados) empleado.get(ranpos) ).getCargo())){
                                    cont--;
                                }
                                ( (Empleados) empleado.get(ranpos) ).setCargo("Cajero");
                                ( (Empleados) empleado.get(ranpos) ).setSueldo(40000);
                                c++;
                            }
                            if(random==4 && cont<=3){
                                ( (Empleados) empleado.get(ranpos) ).setCargo("Gerente");
                                ( (Empleados) empleado.get(ranpos) ).setSueldo(50000);
                                cont++;
                                c++;
                            }
                        }
                        System.out.println("Cargos exitosamente revueltos");
                        System.out.println("");
                    }
                    else{//validacion de que haya hecho log in
                        System.out.println("Acceso denegado, debe registrase para poder realizar cualquier tipo de modificacion al programa");
                        System.out.println("");
                    }
                    break;
            }
        }
    }
    
}
