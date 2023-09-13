
package proyectotransversal.Entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import proyectotransversal.AccesoDatos.AlumnoData;
import proyectotransversal.AccesoDatos.InscripcionData;
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
        
        MateriaData md = new MateriaData();     
        
        Materia ultima=null;       
        for(Materia m2 : md.listarMaterias()){
            System.out.println(m2);
            ultima = m2;
            ultima.setEstado(true);
            md.modificarMateria(ultima);
            System.out.println(m2);
        }
        
        /*ultima.setEstado(true);
        ultima.setNombre("Lengua");
        md.modificarMateria(ultima);
        
        Materia m1 = md.buscarMateria(1);
        m1.setNombre("Matematica");
        m1.setEstado(true);    
        md.modificarMateria(m1);        
        
        for(Materia m2 : md.listarMaterias()){
           System.out.println(m2);           
        }*/
     /*  
    MateriaData md= new MateriaData();
    Materia m= new Materia("Geografía",3,true);
    Materia m1=new Materia("Matemática",2,true);
    md.guardarMateria(m);
    md.guardarMateria(m1);
    AlumnoData ad=new AlumnoData();
    Alumno a= new Alumno(33090888,"Saez","Fernanda",LocalDate.of(1989, Month.MARCH, 23),true);
    Alumno a1= new Alumno(33090877,"Perez","Juan",LocalDate.of(1988, Month.MARCH, 9),true);
    ad.guardarAlumno(a);
    ad.guardarAlumno(a1);
*/
     /*
     AlumnoData ad=new AlumnoData();
     MateriaData md= new MateriaData();
    InscripcionData insd= new InscripcionData();
    Inscripcion ins=new Inscripcion(9,ad.buscarAlumno(2),md.buscarMateria(1));
    Inscripcion ins1=new Inscripcion(7,ad.buscarAlumno(1),md.buscarMateria(2));
    insd.guardarInscripcion(ins);
    insd.guardarInscripcion(ins1);
   
    InscripcionData insd= new InscripcionData();
    
    Inscripcion ins= new Inscripcion(8.5,ad.buscarAlumno(3),md.buscarMateria(1));
    insd.guardarInscripcion(ins);
    */
      //AlumnoData ad=new AlumnoData();
      //MateriaData md= new MateriaData();
      InscripcionData insd= new InscripcionData();
      //Inscripcion ins1= new Inscripcion(8.5,ad.buscarAlumno(2),md.buscarMateria(1));
      //Inscripcion ins2= new Inscripcion(7,ad.buscarAlumno(2),md.buscarMateria(1));
      //insd.guardarInscripcion(ins1);
      //insd.guardarInscripcion(ins2);
      
      List<Inscripcion> lista=insd.obtenerInscripciones();
      
      for(Inscripcion ins : lista){
          System.out.println(ins);
      }
      
    }


    
}
