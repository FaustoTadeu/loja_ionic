package br.com.lojaudemy.lojabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.lojaudemy.lojabackend.dto.ClienteDTO;
import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.repository.ClienteRepository;
import br.com.lojaudemy.lojabackend.service.exception.ConstraintViolationException;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarClientePorId(Integer idCat) {
        Optional<Cliente> obj = clienteRepository.findById(idCat);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + idCat + ", Tipo: " + Cliente.class.getName()
        ));
    }

    public List<Cliente> buscarTodosClientes() {
        List<Cliente> obj = null;
        try {
            obj =  clienteRepository.findAll();
        }catch (Exception e) {
           throw  new ObjectNotFoundException("Objetos do tipo " + Cliente.class.getName() + " não encontrados");
        }
        return obj;
    }

    public Cliente inserirEditarCliente(Cliente cli) {
        if (cli.getIdCliente() != null) {
            Cliente newCli = buscarClientePorId(cli.getIdCliente());
            updateData(newCli, cli);
            return clienteRepository.save(newCli);
        } else {
            return clienteRepository.save(cli);
        }
    }

    public void apagarCliente(Integer idCli) {
        Cliente cli =  buscarClientePorId(idCli);
        try{
            clienteRepository.delete(cli);
        } catch (Exception e) {
            throw new ConstraintViolationException("Não é possivel excluir clientes que possuem endereços cadastrados");
        }
    }

    @SuppressWarnings("deprecation")
	public Page<Cliente> buscarTodosClientesPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente fromDTO (ClienteDTO cliDto, Integer idCliente) {
    	return new Cliente (idCliente == null ? null : idCliente, cliDto.getNomeCliente(), cliDto.getEmailCliente(), null, null);
    }
    
    private void updateData(Cliente newCli, Cliente cli) {
    	newCli.setNomeCliente(cli.getNomeCliente());
    	newCli.setEmailCliente(cli.getEmailCliente());
    }
}
