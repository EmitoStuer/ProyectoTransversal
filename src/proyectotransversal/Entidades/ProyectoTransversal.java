
package proyectotransversal.Entidades;

import java.time.LocalDate;
import proyectotransversal.AccesoDatos.AlumnoData;

public class ProyectoTransversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno alumno = new Alumno(33123123,"Gomez","Marta",LocalDate.of(2010,05,10),true);
        AlumnoData ad = new AlumnoData();
        ad.guardarAlumno(alumno);

    }
    
}
