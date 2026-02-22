package ar.edu.unlp.info.oo2._Ejercicio12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {
    private FileSystem fileSystem;
    private Directorio root;
    private Archivo archivoA;
    private Archivo archivoB;
    private Archivo archivoC;
    private Directorio dirB;
    private Directorio dirD;

    @BeforeEach
    public void setUp() {
        root = new Directorio("Root", LocalDate.of(2023, 1, 1));
        archivoA = new Archivo("doc1", LocalDate.of(2023, 2, 1), 100);
        dirB = new Directorio("FolderB", LocalDate.of(2023, 3, 1));
        archivoB = new Archivo("doc2", LocalDate.of(2023, 4, 1), 200);
        dirD = new Directorio("FolderD", LocalDate.of(2023, 5, 1));
        archivoC = new Archivo("doc1", LocalDate.of(2023, 6, 1), 50);

        // Estructura:
        // Root
        // ├── doc1 (100 bytes, 2023-02-01)
        // ├── FolderB
        // │   └── doc2 (200 bytes, 2023-04-01)
        // └── FolderD
        //     └── doc1 (50 bytes, 2023-06-01)

        root.agregarElemento(archivoA);
        root.agregarElemento(dirB);
        root.agregarElemento(dirD);
        dirB.agregarElemento(archivoB);
        dirD.agregarElemento(archivoC);

        fileSystem = new FileSystem(root);
    }

    @Test
    public void testTamanoTotalOcupado() {
        // Tamaño esperado: 32 (Root) + 100 (doc1) + 32 (FolderB) + 200 (doc2) + 32 (FolderD) + 50 (doc1) = 446
        assertEquals(446, fileSystem.tamanoTotalOcupado());
    }

    @Test
    public void testTamanoTotalOcupadoDirectorioVacio() {
        // Sistema con un solo directorio vacío
        FileSystem emptyFileSystem = new FileSystem(new Directorio("Empty", LocalDate.now())); 
        assertEquals(32, emptyFileSystem.tamanoTotalOcupado());
    }

    @Test
    public void testArchivoMasGrande() {
        // El archivo más grande es doc2 (200 bytes)
        Archivo masGrande = fileSystem.archivoMasGrande();
        assertNotNull(masGrande);
        assertEquals("doc2", masGrande.getNombre());
        assertEquals(200, masGrande.getTamanio());
    }

    @Test
    public void testArchivoMasGrandeSinArchivos() {
        // Sistema con un solo directorio vacío
        FileSystem emptyFileSystem = new FileSystem(new Directorio("Empty", LocalDate.now())); 
        assertNull(emptyFileSystem.archivoMasGrande());
    }

    @Test
    public void testArchivoMasNuevo() {
        // El archivo más nuevo es doc1 en FolderD (2023-06-01)
        Archivo masNuevo = fileSystem.archivoMasNuevo();
        assertNotNull(masNuevo);
        assertEquals("doc1", masNuevo.getNombre());
        assertEquals(LocalDate.of(2023, 6, 1), masNuevo.getFechaCreacion());
    }

    @Test
    public void testArchivoMasNuevoSinArchivos() {
        // Sistema con un solo directorio vacío
        FileSystem emptyFileSystem = new FileSystem(new Directorio("Empty", LocalDate.now())); 
        assertNull(emptyFileSystem.archivoMasNuevo());
    }

    @Test
    public void testBuscarArchivoPrimerNivel() {
        // Buscar doc1 en el primer nivel
        Elemento encontrado = fileSystem.buscar("doc1");
        assertNotNull(encontrado);
        assertEquals("doc1", encontrado.getNombre());
        assertEquals(100, encontrado.getTamanio());
    }

    @Test
    public void testBuscarDirectorio() {
        // Buscar FolderB
        Elemento encontrado = fileSystem.buscar("FolderB");
        assertNotNull(encontrado);
        assertEquals("FolderB", encontrado.getNombre());
        assertTrue(encontrado instanceof Directorio);
    }

    @Test
    public void testBuscarNoExistente() {
        // Buscar un nombre que no existe
        Elemento encontrado = fileSystem.buscar("noexiste");
        assertNull(encontrado);
    }

    @Test
    public void testBuscarTodos() {
        // Buscar todos los elementos con nombre "doc1" (dos archivos)
        List<Elemento> encontrados = fileSystem.buscarTodos("doc1");
        assertEquals(2, encontrados.size());
        assertTrue(encontrados.stream().anyMatch(e -> e.getNombre().equals("doc1") && e.getTamanio() == 100));
        assertTrue(encontrados.stream().anyMatch(e -> e.getNombre().equals("doc1") && e.getTamanio() == 50));
    }

    @Test
    public void testBuscarTodosNoExistente() {
        // Buscar un nombre que no existe
        List<Elemento> encontrados = fileSystem.buscarTodos("noexiste");
        assertTrue(encontrados.isEmpty());
    }

    @Test
    public void testBuscarTodosUnSoloElemento() {
        // Buscar FolderB (un solo directorio)
        List<Elemento> encontrados = fileSystem.buscarTodos("FolderB");
        assertEquals(1, encontrados.size());
        assertEquals("FolderB", encontrados.get(0).getNombre());
    }

    @Test
    public void testListadoDeContenido() {
        // Verificar el listado completo
        String esperado = "/Root\n" +
                         "/Root/doc1\n" +
                         "/Root/FolderB\n" +
                         "/Root/FolderB/doc2\n" +
                         "/Root/FolderD\n" +
                         "/Root/FolderD/doc1\n";
        assertEquals(esperado, fileSystem.listadoDeContenido());
    }

    @Test
    public void testListadoDeContenidoSoloRoot() {
        // Sistema con un solo directorio
        FileSystem singleDir = new FileSystem(new Directorio("Root", LocalDate.now())); 
        assertEquals("/Root\n", singleDir.listadoDeContenido());
    }
}