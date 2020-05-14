package fon.is.fpis.service;

import java.util.List;

import fon.is.fpis.domain.InternalCheckPlan;
import fon.is.fpis.service.dto.InternalCheckPlanSearchRequest;
import fon.is.fpis.service.dto.InternalCheckPlanSearchResponse;

public interface InternalCheckPlanService {
		
	public InternalCheckPlan getInternalCheckPlanById(Long id);
	
	public List<InternalCheckPlan> getAllInternalCheckPlans();
	
	public InternalCheckPlanSearchResponse searchInternalCheckPlans(InternalCheckPlanSearchRequest request);
	
	public InternalCheckPlan saveInternalCheckPlan(InternalCheckPlan plan);
	
	public boolean deleteInternalCheckPlanById(Long id);
}
