package src.Clases;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.StringTokenizer;
import javax.swing.JButton;

import java.util.ArrayList;


public class NivelesTest {

    @Mock
    private src.Clases.Archivo mockArchivo;

    private Niveles niveles;
    private Niveles niveles2;
    private Niveles niveles3;

    @Mock
    private ArrayList<JButton> mockNivelMedio;

    @Mock
    private ArrayList<JButton> mockNivelDificil;


    @Before
    public void setUp() {

        MockitoAnnotations.openMocks(this);

        // Inicializar el mock del archivo
        mockArchivo = mock(src.Clases.Archivo.class);

        // Inicializar los arreglos de botones necesarios para Niveles
        JButton[] memoricBase = new JButton[225];
        JButton[] tablero = new JButton[225];

        niveles3 = new Niveles(memoricBase, tablero);
        niveles3.Tiros = new JButton[225];

        // Crear una instancia de Niveles y asignar el mock de Archivo
        niveles = new Niveles(new JButton[0], new JButton[0]); // Pasamos arreglos vacíos ya que no son necesarios para este test
        niveles.archivo = mockArchivo; // Asignar el mock de Archivo a la instancia de Niveles

        // Crear una instancia de Niveles con los arreglos de botones
        niveles2 = new Niveles(memoricBase, tablero);

        // Establecer Tiros para la prueba
        niveles2.Tiros = new JButton[225];
        for (int i = 0; i < 225; i++) {
            niveles2.Tiros[i] = new JButton("Boton " + i);
        }

        // Configurar mocks
        niveles3.NivelMedio = mockNivelMedio.toArray(new JButton[0]);
        niveles3.NivelDificil = mockNivelDificil.toArray(new JButton[0]);



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

    @Test
    public void testPartir_A() {
        // Llamar al método Partir_A con n=100
        JButton[] resultado = niveles2.Partir_A(100);

        // Verificar el tamaño del arreglo resultado
        assertEquals(100, resultado.length);

        // Verificar los elementos del arreglo resultado
        for (int i = 0; i < 100; i++) {
            assertSame(niveles2.Tiros[i], resultado[i]);
        }
    }


    @Test
    public void testPartir_B() {
        // Llamar al método Partir_B con n=100 y x=125
        JButton[] resultado = niveles2.Partir_B(100, 125);

        // Verificar el tamaño del arreglo resultado
        assertEquals(125, resultado.length);

        // Verificar los elementos del arreglo resultado
        for (int i = 0; i < 125; i++) {
            assertSame(niveles2.Tiros[i + 100], resultado[i]);
        }
    }

    

    @Test
    public void testNivelPredeterminado_Facil() {
        niveles3.Nivel = "Facil";

        JButton[] resultado = niveles3.NivelPredeterminado();

        assertNull(resultado);
    }

}

