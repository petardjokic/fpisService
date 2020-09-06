package fon.is.fpis.service;

import java.util.List;
import java.util.Optional;

import fon.is.fpis.domain.StorageFinalProductWarrant;

public interface StorageFinalProductWarrantService {

	public Optional<StorageFinalProductWarrant> getById(Long id);

	public List<StorageFinalProductWarrant> getAll();

	public StorageFinalProductWarrant save(StorageFinalProductWarrant plan);

	public void deleteById(Long id);
	
	public boolean exists(Long id);
}
