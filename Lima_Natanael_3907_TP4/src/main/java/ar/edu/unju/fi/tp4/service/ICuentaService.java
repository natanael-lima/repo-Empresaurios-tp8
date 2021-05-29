package ar.edu.unju.fi.tp4.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp4.model.Cuenta;

public interface ICuentaService {
	public List<Cuenta> obtenerCuentas();
	public Optional<Cuenta> buscarCuenta(long id);
}
