package src.Clases;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.StringTokenizer;
import javax.swing.JButton;

public class NivelesTest {

    @Mock
    private src.Clases.Archivo mockArchivo;

    private Niveles niveles;

    @Before
    public void setUp() {
        // Inicializar el mock del archivo
        mockArchivo = mock(src.Clases.Archivo.class);

        // Crear una instancia de Niveles y asignar el mock de Archivo
        niveles = new Niveles(new JButton[0], new JButton[0]); // Pasamos arreglos vacíos ya que no son necesarios para este test
        niveles.archivo = mockArchivo; // Asignar el mock de Archivo a la instancia de Niveles
    }

    @Test
    public void testGetNivel() {
        // Configurar el mock para que devuelva un valor esperado al llamar a archivo.leer()
        String contenidoArchivo = "Medio%%%%OtroDato%%%%...";
        when(mockArchivo.leer(anyString())).thenReturn(contenidoArchivo);

        // Llamar al método GetNivel() y verificar el resultado
        String nivel = niveles.GetNivel();

        // Verificar que se llame a archivo.leer() con el path esperado
        verify(mockArchivo).leer("archivos/Controles.txt");

        // Verificar que el nivel devuelto es el primero en el contenido del archivo
        assertEquals("Medio", nivel);
    }
}

