package matepore.springboot.gestion.clientes;

import matepore.springboot.gestion.clientes.entity.Cliente;
import matepore.springboot.gestion.clientes.exception.ClienteNoEncontradoException;
import matepore.springboot.gestion.clientes.model.ClienteDTO;
import matepore.springboot.gestion.clientes.repository.ClienteRepository;
import matepore.springboot.gestion.clientes.service.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    private Cliente cliente;
    private ClienteDTO clienteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cliente = Cliente.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Pérez")
                .edad(32)
                .fechaNacimiento(LocalDate.of(1993, 5, 10))
                .build();

        clienteDTO = ClienteDTO.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Pérez")
                .edad(32)
                .fechaNacimiento(LocalDate.of(1993, 5, 10))
                .build();
    }

    @Test
    @DisplayName("Debe crear un nuevo cliente correctamente")
    void test_create_cliente() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        ClienteDTO result = clienteService.create(clienteDTO);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        assertEquals(32, result.getEdad());
        assertNotNull(result.getEdadCompleta());
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Debe retornar un cliente existente por ID")
    void test_find_by_id_existente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        ClienteDTO result = clienteService.findById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Juan", result.getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Debe lanzar excepción si no encuentra un cliente por ID")
    void test_find_by_id_no_existente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ClienteNoEncontradoException.class, () -> clienteService.findById(1L));
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Debe actualizar un cliente existente correctamente")
    void test_update_cliente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        clienteDTO.setNombre("Carlos");

        ClienteDTO result = clienteService.update(1L, clienteDTO);

        assertEquals("Carlos", result.getNombre());
        verify(clienteRepository, times(1)).findById(1L);
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Debe lanzar excepción al intentar actualizar cliente inexistente")
    void test_update_cliente_no_existente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ClienteNoEncontradoException.class, () -> clienteService.update(1L, clienteDTO));
    }

    @Test
    @DisplayName("Debe eliminar un cliente existente correctamente")
    void test_delete_cliente() {
        when(clienteRepository.existsById(1L)).thenReturn(true);

        clienteService.delete(1L);

        verify(clienteRepository, times(1)).existsById(1L);
        verify(clienteRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Debe lanzar excepción al eliminar cliente inexistente")
    void test_delete_cliente_no_existente() {
        when(clienteRepository.existsById(1L)).thenReturn(false);

        assertThrows(ClienteNoEncontradoException.class, () -> clienteService.delete(1L));
        verify(clienteRepository, times(1)).existsById(1L);
        verify(clienteRepository, never()).deleteById(anyLong());
    }

    @Test
    @DisplayName("Debe listar todos los clientes correctamente")
    void test_list_clientes() {
        when(clienteRepository.findAll()).thenReturn(List.of(cliente));

        List<ClienteDTO> result = clienteService.list();

        assertEquals(1, result.size());
        assertEquals("Juan", result.get(0).getNombre());
        assertNotNull(result.get(0).getEdadCompleta());
        verify(clienteRepository, times(1)).findAll();
    }
}