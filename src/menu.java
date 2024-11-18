package gestioneventos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class menu {

    public static void main(String[] args) {
        GestionEventos gestion = new GestionEventos();
        ImageIcon icono = new ImageIcon(menu.class.getResource("/images/evento.png"));
        boolean salir = false;

        while (!salir) {
            String opcion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú de Gestión de Eventos",
                    JOptionPane.PLAIN_MESSAGE,
                    icono,
                    new Object[]{"Crear evento", "Listar eventos", "Actualizar evento", "Eliminar evento", "Buscar evento", "Salir"},
                    "Crear evento"
            );

            if (opcion == null) {
                salir = true;
                break;
            }

            switch (opcion) {
                case "Crear evento":
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del evento:");
                    String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha del evento (dd/mm/aaaa):");
                    String tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo de evento:");
                    gestion.crearEvento(nombre, fecha, tipo);
                    JOptionPane.showMessageDialog(null, "Evento creado exitosamente.");
                    break;
                case "Listar eventos":
                    String listado = gestion.listarEventos();
                    JOptionPane.showMessageDialog(null, listado);
                    break;
                case "Actualizar evento":
                    String nombreActualizar = JOptionPane.showInputDialog(null, "Ingrese el nombre del evento a actualizar:");
                    String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre:");
                    String nuevaFecha = JOptionPane.showInputDialog(null, "Ingrese la nueva fecha:");
                    String nuevoTipo = JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo:");
                    boolean actualizado = gestion.actualizarEvento(nombreActualizar, nuevoNombre, nuevaFecha, nuevoTipo);

                    String mensaje;
                    if (actualizado) {
                        mensaje = "Evento actualizado correctamente.";
                    } else {
                        mensaje = "Evento no encontrado.";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case "Eliminar evento":
                    String nombreEliminar = JOptionPane.showInputDialog(null, "Ingrese el nombre del evento a eliminar:");
                    boolean eliminado = gestion.eliminarEvento(nombreEliminar);

                    String mensajeEliminado;
                    if (eliminado) {
                        mensajeEliminado = "Evento eliminado correctamente.";
                    } else {
                        mensajeEliminado = "Evento no encontrado.";
                    }
                    JOptionPane.showMessageDialog(null, mensajeEliminado);
                    break;
                case "Buscar evento":
                    String nombreBuscar = JOptionPane.showInputDialog(null, "Ingrese el nombre del evento a buscar o deje en blanco para buscar por tipo:");
                    String tipoBuscar = JOptionPane.showInputDialog(null, "Ingrese el tipo del evento a buscar:");
                    String eventosEncontrados = gestion.buscarEvento(nombreBuscar, tipoBuscar);
                    JOptionPane.showMessageDialog(null, eventosEncontrados);
                    break;
                case "Salir":
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Gracias por se parte de M.F.", "Salir", JOptionPane.INFORMATION_MESSAGE, icono);
                    break;
                default:
                    break;
            }
        }
    }
}
