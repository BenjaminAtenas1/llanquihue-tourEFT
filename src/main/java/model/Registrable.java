package model;
/**
 *
 * Interfaz para condicionar uso de metodo mostrarInformacion. La implementan @link{Cliente}, @link{GuiaTuristico},
 * @link{ExcursionCultural} y @link{PaseoLacustre}
 *
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */
public interface Registrable {
    String mostrarInformacion();
}
