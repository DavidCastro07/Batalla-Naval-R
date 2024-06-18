package src.Clases;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;
import java.applet.AudioClip;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;

import Clases.Archivo;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentMatchers;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArchivoTest {
    private Clases.Archivo archivo;
    private JFileChooser mockFileChooser;

    @BeforeEach
    public void setUp() {
        mockFileChooser = mock(JFileChooser.class);
        archivo = new Clases.Archivo();
    }

    @Test
    public void testCrearTxt(@TempDir File tempDir) throws IOException {
        // Arrange
        String testFilePath = new File(tempDir, "test.txt").getAbsolutePath();
        String texto = "Hola, mundo!";

        // Act
        archivo.crearTxt(testFilePath, texto);

        // Assert
        assertEquals(texto, archivo.leer(testFilePath));
    }

    @Test
    public void testConcatenar(@TempDir File tempDir) throws IOException {
        // Arrange
        String testFilePath = new File(tempDir, "test.txt").getAbsolutePath();
        archivo.crearTxt(testFilePath, "Hola, ");
        String textoConcatenado = "mundo!";

        // Act
        archivo.concatenar(testFilePath, textoConcatenado);

        // Assert
        assertEquals("Hola, mundo!", archivo.leer(testFilePath));
    }

    @Test
    public void testLeerGrafico() {
        try {
            // Arrange
            Clases.Archivo archivo = spy(new Clases.Archivo()); // Usamos spy para poder simular métodos

            // Directorio base donde se creará el archivo temporal
            File baseDir = new File("C:\\Users\\Usuario\\Batalla-Naval-R");

            // Crear un archivo temporal en la ubicación especificada
            File mockSelectedFile = File.createTempFile("mockFile", ".txt", baseDir);

            // Escribir contenido en el archivo temporal
            FileWriter fileWriter = new FileWriter(mockSelectedFile);
            fileWriter.write("Hola, mundo!");
            fileWriter.close();

            // Simula comportamiento de JFileChooser
            when(mockFileChooser.showOpenDialog(any())).thenReturn(JFileChooser.APPROVE_OPTION);
            when(mockFileChooser.getSelectedFile()).thenReturn(mockSelectedFile);

            // Establece el JFileChooser simulado
            archivo.setFileChooser(mockFileChooser);

            // Act
            String lectura = archivo.leerGrafico();

            // Assert
            assertEquals("Hola, mundo!", lectura);

            // Verificar interacciones con JFileChooser
            verify(mockFileChooser, times(1)).showOpenDialog(any());
            verify(mockFileChooser, times(1)).getSelectedFile();
        } catch (IOException e) {
            fail("Excepción IOException no esperada: " + e.getMessage());
        }
    }


    @Test
    public void testAudio() {
    }

}

//testCrearTxt: Prueba la creación de un archivo de texto (crearTxt()) y luego verifica que el texto escrito sea el mismo que el texto leído (leer()).
//
//testConcatenar: Prueba el método concatenar(), que agrega texto adicional a un archivo existente y luego verifica que el resultado sea correcto.
//
//testLeerGrafico: Prueba el método leerGráfico(), que lee un archivo .txt e identifica si lo que está dentro de éste es lo esperado.