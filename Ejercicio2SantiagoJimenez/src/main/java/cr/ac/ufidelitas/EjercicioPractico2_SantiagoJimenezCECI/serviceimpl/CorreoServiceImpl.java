package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.serviceimpl;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service.CorreoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String correoEmisor;

    public CorreoServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void enviarBienvenida(String destinatario, String nombre) {

        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setFrom(correoEmisor);
        mensaje.setTo(destinatario);
        mensaje.setSubject("Bienvenido a MediCare");

        mensaje.setText(
                "Hola " + nombre + ",\n\n"
                + "Bienvenido a MediCare.\n\n"
                + "Su cuenta ha sido registrada correctamente en nuestro "
                + "Sistema de Gestión de Citas Médicas.\n\n"
                + "Ya puede acceder a los servicios disponibles según "
                + "el rol asignado a su cuenta.\n\n"
                + "Saludos,\n"
                + "Equipo MediCare"
        );

        mailSender.send(mensaje);
    }
}