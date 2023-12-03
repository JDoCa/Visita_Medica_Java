package domenech.jordi.dam.mp09.uf01.pr2.seguridad.controller;

import domenech.jordi.dam.mp09.uf01.pr2.seguridad.model.domain.VisitaMedica;
import domenech.jordi.dam.mp09.uf01.pr2.seguridad.model.security.AESSecurity;
import domenech.jordi.dam.mp09.uf01.pr2.seguridad.model.security.MD5Security;
import domenech.jordi.dam.mp09.uf01.pr2.seguridad.model.security.SHA256Security;
import domenech.jordi.dam.mp09.uf01.pr2.seguridad.view.console.VisitaMedicaView;

public class VisitaMedicaController {

    private VisitaMedicaView visitaMedicaView = new VisitaMedicaView();

    public void aplicarSeguridadMD5() {
        try {
            visitaMedicaView.mostrarMensaje("MD5 ------------", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();

            MD5Security md5Security = new MD5Security();

            String nomPacienteEnc = md5Security.encripta(visitaMedica.getNomPaciente());
            String diagnosticoEnc = md5Security.encripta(visitaMedica.getDiagnostico());

            VisitaMedica visitaMedicaEnc = new VisitaMedica();
            visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
            visitaMedicaEnc.setNomPaciente(nomPacienteEnc);
            visitaMedicaEnc.setNomMetge(visitaMedica.getNomMetge());
            visitaMedicaEnc.setFecha(visitaMedica.getFecha());
            visitaMedicaEnc.setDiagnostico(diagnosticoEnc);

            visitaMedicaView.mostrarVisitaMedica(visitaMedicaEnc);
        } catch (Exception ex) {
            visitaMedicaView.mostrarMensaje(ex.getMessage(), true);
        }
    }

    public void aplicarSeguridadSHA256() {
        try {
            visitaMedicaView.mostrarMensaje("SHA256 ------------", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();

            SHA256Security sha256Security = new SHA256Security();

            String nomPacienteEnc = sha256Security.encripta(visitaMedica.getNomPaciente());
            String diagnosticoEnc = sha256Security.encripta(visitaMedica.getDiagnostico());

            VisitaMedica visitaMedicaEnc = new VisitaMedica();
            visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
            visitaMedicaEnc.setNomPaciente(nomPacienteEnc);
            visitaMedicaEnc.setNomMetge(visitaMedica.getNomMetge());
            visitaMedicaEnc.setFecha(visitaMedica.getFecha());
            visitaMedicaEnc.setDiagnostico(diagnosticoEnc);

            visitaMedicaView.mostrarVisitaMedica(visitaMedicaEnc);
        } catch (Exception ex) {
            visitaMedicaView.mostrarMensaje(ex.getMessage(), true);
        }
    }

    public void aplicarSeguridadAES() {
        try {
            visitaMedicaView.mostrarMensaje("AES ------------ Encripta", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();

            AESSecurity aesSecurity = new AESSecurity();

            String nomPacienteEnc = aesSecurity.encripta(visitaMedica.getNomPaciente());
            String diagnosticoEnc = aesSecurity.encripta(visitaMedica.getDiagnostico());

            VisitaMedica visitaMedicaEnc = new VisitaMedica();
            visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
            visitaMedicaEnc.setNomPaciente(nomPacienteEnc);
            visitaMedicaEnc.setNomMetge(visitaMedica.getNomMetge());
            visitaMedicaEnc.setFecha(visitaMedica.getFecha());
            visitaMedicaEnc.setDiagnostico(diagnosticoEnc);

            visitaMedicaView.mostrarVisitaMedica(visitaMedicaEnc);

            visitaMedicaView.mostrarMensaje("AES ------------ Desencripta", false);
            String nomPacienteDesenc = aesSecurity.desencripta(visitaMedicaEnc.getNomPaciente());
            String diagnosticoDesenc = aesSecurity.desencripta(visitaMedicaEnc.getDiagnostico());

            VisitaMedica visitaMedicaDesenc = new VisitaMedica();
            visitaMedicaDesenc.setIdVisita(visitaMedica.getIdVisita());
            visitaMedicaDesenc.setNomPaciente(nomPacienteDesenc);
            visitaMedicaDesenc.setNomMetge(visitaMedica.getNomMetge());
            visitaMedicaDesenc.setFecha(visitaMedica.getFecha());
            visitaMedicaDesenc.setDiagnostico(diagnosticoDesenc);

            visitaMedicaView.mostrarVisitaMedica(visitaMedicaDesenc);

        } catch (Exception ex) {
            visitaMedicaView.mostrarMensaje(ex.getMessage(), true);
        }
    }
}
