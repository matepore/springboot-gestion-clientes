package matepore.springboot.gestion.clientes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import matepore.springboot.gestion.clientes.entity.Cliente;
import matepore.springboot.gestion.clientes.exception.ClienteNoEncontradoException;
import matepore.springboot.gestion.clientes.model.ClienteDTO;
import matepore.springboot.gestion.clientes.model.EdadCompletaDTO;
import matepore.springboot.gestion.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    // Métodos de mapeo entre Cliente y ClienteDTO
    private ClienteDTO mapDTO(Cliente cliente){
        // Cálculo detallado de la edad
        LocalDate hoy = LocalDate.now();
        Period edadDetallada = Period.between(cliente.getFechaNacimiento(), hoy);

        return ClienteDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .edad(cliente.getEdad())
                .fechaNacimiento(cliente.getFechaNacimiento())
                .edadCompleta(new EdadCompletaDTO(edadDetallada.getYears(), edadDetallada.getMonths(), edadDetallada.getDays()))
                .build();
    }

    private Cliente mapEntity(ClienteDTO clienteDTO){
        return Cliente.builder()
                .id(clienteDTO.getId())
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .edad(clienteDTO.getEdad())
                .fechaNacimiento(clienteDTO.getFechaNacimiento())
                .build();
    }

    // Implementación de los métodos del servicio
    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        log.info("Agregando un nuevo cliente a la base de datos.");
        Cliente cliente = clienteRepository.save(mapEntity(clienteDTO));
        return mapDTO(cliente);
    }

    @Override
    public ClienteDTO findById(Long id) {
        log.info("Intentando encontrar un cliente por el id: {}", id);
        return clienteRepository.findById(id)
                .map(this::mapDTO)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
    }

    @Override
    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        log.info("Actualizando el cliente con el id: {}", id);

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNoEncontradoException(id));
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setEdad(clienteDTO.getEdad());
        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());

        return mapDTO(clienteRepository.save(cliente));
    }

    @Override
    public void delete(Long id) {
        log.info("Eliminando el cliente con el id: {}", id);
        if(!clienteRepository.existsById(id)) {
            throw new ClienteNoEncontradoException(id);
        }
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteDTO> list() {
        log.info("Listando todos los clientes.");
        return clienteRepository.findAll().stream().map(this::mapDTO).toList();
    }
}
