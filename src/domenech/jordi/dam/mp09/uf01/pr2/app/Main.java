package domenech.jordi.dam.mp09.uf01.pr2.app;

import domenech.jordi.dam.mp09.uf01.pr2.seguridad.controller.VisitaMedicaController;

public class Main {

    public static void main(String[] args) {
        VisitaMedicaController visitaMedicaController = new VisitaMedicaController();
        visitaMedicaController.aplicarSeguridadMD5();
        visitaMedicaController.aplicarSeguridadAES();
        visitaMedicaController.aplicarSeguridadSHA256();
        
    }
}
