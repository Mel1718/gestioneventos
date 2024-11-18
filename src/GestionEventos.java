package gestioneventos;

import javax.swing.JOptionPane;

public class GestionEventos {

    public static class Evento {

        String nombre;
        String fecha;
        String tipo;

        // Constructor para inicializar los datos del evento
        public Evento(String nombre, String fecha, String tipo) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.tipo = tipo;
        }

        // Mostrar el evento
        public String mostrarEvento() {
            return "Nombre: " + nombre + ", Fecha: " + fecha + ", Tipo: " + tipo;
        }

        // Setters para actualizar los valores del evento
        public void setNombre(String nombre) {
            this.nombre = nombre; // Actualiza el nombre del evento.
        }

        public void setFecha(String fecha) {
            this.fecha = fecha; // Actualiza fecha del evento.
        }

        public void setTipo(String tipo) {
            this.tipo = tipo; // Actualiza el tipo del evento.
        }
    }

    // Array para almacenar los eventos (max 100)
    private Evento[] listaEventos = new Evento[100];
    private int contadorEventos = 0;

    // Métodos de gestión de eventos
    public void crearEvento(String nombre, String fecha, String tipo) {
        if (contadorEventos < listaEventos.length) {
            Evento nuevoEvento = new Evento(nombre, fecha, tipo);
            listaEventos[contadorEventos] = nuevoEvento;
            contadorEventos++;
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más eventos. Capacidad máxima alcanzada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String listarEventos() {
        String eventosListado = "Lista de eventos registrados:\n";
        for (int i = 0; i < contadorEventos; i++) {
            eventosListado += listaEventos[i].mostrarEvento() + "\n";
        }
        if (contadorEventos == 0) {
            eventosListado = "No hay eventos registrados.";
        }
        return eventosListado;
    }

    public boolean actualizarEvento(String nombre, String nuevoNombre, String nuevaFecha, String nuevoTipo) {
        for (int i = 0; i < contadorEventos; i++) {
            if (listaEventos[i].nombre.equals(nombre)) {
                listaEventos[i].setNombre(nuevoNombre);
                listaEventos[i].setFecha(nuevaFecha);
                listaEventos[i].setTipo(nuevoTipo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEvento(String nombre) {
        for (int i = 0; i < contadorEventos; i++) {
            if (listaEventos[i].nombre.equals(nombre)) {
                for (int j = i; j < contadorEventos - 1; j++) {
                    listaEventos[j] = listaEventos[j + 1]; // Desplaza los eventos
                }
                listaEventos[contadorEventos - 1] = null;
                contadorEventos--;
                return true;
            }
        }
        return false;
    }

    public String buscarEvento(String nombre, String tipo) {
        String eventosEncontrados = "Eventos encontrados:\n";
        boolean encontrado = false;
        for (int i = 0; i < contadorEventos; i++) {
            boolean coincideNombre = nombre.length() == 0 || listaEventos[i].nombre.equals(nombre);
            boolean coincideTipo = tipo.length() == 0 || listaEventos[i].tipo.equals(tipo);
            if (coincideNombre && coincideTipo) {
                eventosEncontrados += listaEventos[i].mostrarEvento() + "\n";
                encontrado = true;
            }
        }
 
        if (encontrado) {
            return eventosEncontrados;
        } else {
            return "No se encontraron eventos.";
        }
    }
}

