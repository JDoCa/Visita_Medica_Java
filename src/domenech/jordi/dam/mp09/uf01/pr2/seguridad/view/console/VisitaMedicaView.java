package domenech.jordi.dam.mp09.uf01.pr2.seguridad.view.console;

import java.time.LocalDate;
import java.util.Scanner;
import domenech.jordi.dam.mp09.uf01.pr2.seguridad.model.domain.VisitaMedica;

public class VisitaMedicaView {

    public VisitaMedica getVisitaMedica() {
        VisitaMedica visitaMedica = new VisitaMedica();
        Scanner scanner = new Scanner(System.in);

        mostrarMensaje("Introduce el ID de la visita: ", false);
        visitaMedica.setIdVisita(scanner.nextInt());

        mostrarMensaje("Introduce el nombre del paciente: ", false);
        visitaMedica.setNomPaciente(scanner.next());

        mostrarMensaje("Introduce el nombre del médico: ", false);
        visitaMedica.setNomMetge(scanner.next());

        mostrarMensaje("Introduce la fecha (YYYY-MM-DD): ", false);
        visitaMedica.setFecha(LocalDate.parse(scanner.next()));

        mostrarMensaje("Introduce el diagnóstico: ", false);
        visitaMedica.setDiagnostico(scanner.next());

        return visitaMedica;
    }

    public void mostrarVisitaMedica(VisitaMedica visitaMedica) {
        System.out.println(visitaMedica.toString());
    }

    public void mostrarMensaje(String mensaje, boolean esError) {
        if (esError) {
            System.err.println(mensaje);
        } else {
            System.out.println(mensaje);
        }
    }
}
