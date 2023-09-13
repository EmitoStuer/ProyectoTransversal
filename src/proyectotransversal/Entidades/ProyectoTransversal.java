
package proyectotransversal.Entidades;

import java.time.LocalDate;
import proyectotransversal.AccesoDatos.AlumnoData;
import proyectotransversal.AccesoDatos.MateriaData;

public class ProyectoTransversal {
    
    public static void main(String[] args) {
        
        //Alumno alumno = new Alumno(33123123,"Gomez","Marta",LocalDate.of(2010,05,10),true);
        //AlumnoData ad = new AlumnoData();
        //ad.guardarAlumno(alumno);
        //Alumno ae= ad.buscarAlumnoPorDni(33123123);
        /*if (ae!=null){
            System.out.println("Encontrado con dni");
            System.out.println(ae);
        }else{
            System.out.println("No existe alumno con ese ID");
        }
        */
        /*if (ad.listarAlumnos().isEmpty()){
            System.out.println("No hay Alumnos en la lista");
        }else{
            System.out.println(ad.listarAlumnos());
        }*/
        
       // ad.eliminarAlumno(2);
       
        /*if (ad.listarAlumnos().isEmpty()){
            System.out.println("No hay Alumnos en la lista");
        }else{
            System.out.println(ad.listarAlumnos());
        }*/
        
       /*  //Modificar Alumno
        Alumno a= ad.buscarAlumno(1);
        System.out.println(a);
        a.setNombre("Eugenia");
        System.out.println(a);
        ad.modificarAlumno(a);
      */  
        //Eliminar Alumno-borrado lógico
        
        //ad.eliminarAlumno(1);
        MateriaData md = new MateriaData();
        //Materia m= new Materia("Matematica",4,true);
        //md.guardarMateria(m);
        
        Materia m=md.buscarMateria(1);
        System.out.println(m);
        m.setNombre("FILOSOFIA");
        System.out.println(m);
        md.modificarMateria(m);
        
        
    }
       
}
