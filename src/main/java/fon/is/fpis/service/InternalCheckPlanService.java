package fon.is.fpis.service;

import java.util.List;
import java.util.Optional;

import fon.is.fpis.domain.InternalCheckPlan;

public interface InternalCheckPlanService {
		
	public Optional<InternalCheckPlan> getInternalCheckPlanById(Long id);
	
	public List<InternalCheckPlan> getAllInternalCheckPlans();
	
	public InternalCheckPlan saveInternalCheckPlan(InternalCheckPlan plan);
	
	public void deleteInternalCheckPlanById(Long id);
}
