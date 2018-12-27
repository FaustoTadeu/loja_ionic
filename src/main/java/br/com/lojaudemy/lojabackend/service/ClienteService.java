package br.com.lojaudemy.lojabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.lojaudemy.lojabackend.service.exception.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.lojaudemy.lojabackend.dto.ClienteDTO;
import br.com.lojaudemy.lojabackend.dto.ClienteNewDTO;
import br.com.lojaudemy.lojabackend.enums.TipoCliente;
import br.com.lojaudemy.lojabackend.model.Cidade;
import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.model.Endereco;
import br.com.lojaudemy.lojabackend.repository.CidadeRepository;
import br.com.lojaudemy.lojabackend.repository.ClienteRepository;
import br.com.lojaudemy.lojabackend.repository.EnderecoRepository;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;

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
            cli = clienteRepository.save(cli);
            enderecoRepository.saveAll(cli.getEndereco());
            return cli;
        }
    }

    public void apagarCliente(Integer idCli) {
        Cliente cli =  buscarClientePorId(idCli);
        try{
            clienteRepository.delete(cli);
        } catch (Exception e) {
            throw new DataIntegrityViolationException("Não é possivel excluir clientes que possuem pedidos cadastrados");
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
    
    public Cliente fromDTO (ClienteNewDTO cliNewDto, Integer idCliente) {
    	Cliente cli = new Cliente (idCliente == null ? null : idCliente, cliNewDto.getNomeCliente(), cliNewDto.getEmailCliente(), cliNewDto.getCpfCnpjCliente(), TipoCliente.toEnum(cliNewDto.getTipoCliente()));
    	Cidade cid = cidadeRepository.findById(cliNewDto.getCidadeId()).get();    
    	Endereco end = new Endereco(null, cliNewDto.getLogradouroEndereco(), cliNewDto.getNumeroEndereco(), cliNewDto.getComplementoEndereco(), cliNewDto.getBairroEndereco(), cliNewDto.getCepEndereco(), cli, cid);
    	cli.getEndereco().add(end);
    	cli.getTelefones().add(cliNewDto.getTelefoneUm());
    	if(cliNewDto.getTelefoneDois() != null) {
    		cli.getTelefones().add(cliNewDto.getTelefoneDois());
    	}
    	if(cliNewDto.getTelefoneTres() != null) {
    		cli.getTelefones().add(cliNewDto.getTelefoneTres());
    	}
    	
    	return cli;
    }
    
    private void updateData(Cliente newCli, Cliente cli) {
    	newCli.setNomeCliente(cli.getNomeCliente());
    	newCli.setEmailCliente(cli.getEmailCliente());
    }
}
