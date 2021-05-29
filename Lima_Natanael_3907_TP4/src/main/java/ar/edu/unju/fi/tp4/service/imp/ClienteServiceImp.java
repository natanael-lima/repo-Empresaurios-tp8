package ar.edu.unju.fi.tp4.service.imp;


import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;
import ar.edu.unju.fi.tp4.util.TablaCliente;
@Service("tableService")
public class ClienteServiceImp implements IClienteService{

	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	
	private List<Cliente> clienteList;
	
	@Override
	public void generarList() {
		clienteList = TablaCliente.registros;	
	}
	
	@Override
	public void agregarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		LOGGER.info("SERVICE: IClienteService -> ClienteServiceImp");
		LOGGER.info("METHOD: agregarCliente()");
		if(clienteList == null)
			generarList();

		clienteList.add(cliente);

	}

	@Override
	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return clienteList;
	}

	@Override
	public void eliminarCliente(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Cliente> buscarCliente(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
