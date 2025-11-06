package matepore.springboot.gestion.clientes.service;

import matepore.springboot.gestion.clientes.model.ClienteDTO;

import java.util.List;

// Servicio para gestionar operaciones relacionadas con clientes.
public interface ClienteService {
    ClienteDTO create(ClienteDTO clienteDTO);
    ClienteDTO findById(Long id);
    ClienteDTO update(Long id, ClienteDTO clienteDTO);
    void delete(Long id);
    List<ClienteDTO> list();
}
