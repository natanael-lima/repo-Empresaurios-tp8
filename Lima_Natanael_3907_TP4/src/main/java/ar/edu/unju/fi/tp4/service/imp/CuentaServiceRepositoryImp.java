package ar.edu.unju.fi.tp4.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Cuenta;
import ar.edu.unju.fi.tp4.repository.ICuentaRepository;
import ar.edu.unju.fi.tp4.service.ICuentaService;

@Service("tableCuentaRepository")
public class CuentaServiceRepositoryImp implements ICuentaService{
    @Autowired
    private ICuentaRepository cuentaRepository;
	@Override
	public List<Cuenta> obtenerCuentas() {
		// TODO Auto-generated method stub
		return (List<Cuenta>) cuentaRepository.findAll();
	}

	@Override
	public Optional<Cuenta> buscarCuenta(long id) {
		// TODO Auto-generated method stub
		return cuentaRepository.findById(id);
	}

}
