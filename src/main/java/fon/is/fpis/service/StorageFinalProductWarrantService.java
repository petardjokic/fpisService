package fon.is.fpis.service;

import java.util.List;

import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.service.dto.InternalCheckPlanSearchRequest;
import fon.is.fpis.service.dto.InternalCheckPlanSearchResponse;

public interface StorageFinalProductWarrantService {

	public StorageFinalProductWarrant getById(Long id);

	public List<StorageFinalProductWarrant> getAll();

	public InternalCheckPlanSearchResponse searchStorageFinalProductWarrants(InternalCheckPlanSearchRequest request);

	public StorageFinalProductWarrant save(StorageFinalProductWarrant plan);

	public boolean deleteStorageFinalProductWarrantById(Long id);
}
