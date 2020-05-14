package fon.is.fpis.service;

import java.util.List;

import fon.is.fpis.domain.InternalCheckPlan;
import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.service.dto.InternalCheckPlanSearchRequest;
import fon.is.fpis.service.dto.InternalCheckPlanSearchResponse;

public interface StorageFinalProductWarrantService {

	public StorageFinalProductWarrant getStorageFinalProductWarrantnById(Long id);

	public List<StorageFinalProductWarrant> getAllStorageFinalProductWarrants();

	public InternalCheckPlanSearchResponse searchStorageFinalProductWarrants(InternalCheckPlanSearchRequest request);

	public InternalCheckPlan saveStorageFinalProductWarrant(InternalCheckPlan plan);

	public boolean deleteStorageFinalProductWarrantById(Long id);
}
