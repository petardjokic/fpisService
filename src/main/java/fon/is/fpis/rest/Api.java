package fon.is.fpis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fon.is.fpis.domain.InternalCheckPlan;
import fon.is.fpis.domain.Product;
import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.domain.StorageWarantItem;
import fon.is.fpis.domain.Worker;
import fon.is.fpis.service.InternalCheckPlanService;
import fon.is.fpis.service.ProductService;
import fon.is.fpis.service.StorageFinalProductWarrantService;
import fon.is.fpis.service.WorkerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "api")
@CrossOrigin
@Slf4j
public class Api {
	
	@Autowired
	private InternalCheckPlanService planService;
	
	@Autowired
	private WorkerService workerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StorageFinalProductWarrantService warrantService;
	
	
	@GetMapping(path = "warrants/{id}")
	public StorageFinalProductWarrant getWarrant(@PathVariable Long id) {
		log.info("Request get plan with ID: {}", id);
		return warrantService.getById(id);
	}
	
	@GetMapping(path = "warrants/{id}/items/{orderNumber}")
	public StorageWarantItem getWarrantItem(@PathVariable Long id,@PathVariable Integer orderNumber) {
		log.info("Request get plan with ID: {}", id);
		return warrantService.getById(id).getItems().stream().filter(x -> x.getOrderNumber().equals(orderNumber)).findFirst().get();
	}
	
	@GetMapping(path = "internal-check-plans/{id}")
	public InternalCheckPlan getInternalCheckPlanById(@PathVariable Long id) {
		log.info("Request get plan with ID: {}", id);
		return planService.getInternalCheckPlanById(id);
	}
	
	@GetMapping(path = "internal-check-plans")
	public List<InternalCheckPlan> getAllInternalCheckPlans() {
		log.info("Request get all plans");
		return planService.getAllInternalCheckPlans();
	}
	
	@PostMapping(path = "internal-check-plans")
	public InternalCheckPlan saveAllInternalCheckPlans(@RequestBody InternalCheckPlan plan) {
		log.info("Request save plan: {}", plan);
		return planService.saveInternalCheckPlan(plan);
	}
	
	@DeleteMapping(path = "internal-check-plans")
	public void deleteInternalCheckPlanById(@PathVariable Long id) {
		log.info("Request delete plan with ID: {}", id);
		planService.deleteInternalCheckPlanById(id);
	}

	@GetMapping(path = "workers")
	public List<Worker> getAllWorkers() {
		log.info("Request get all workers");
		return workerService.getAll();
	}
	
	@GetMapping(path = "products")
	public List<Product> getAllProducts() {
		log.info("Request get all products");
		return productService.getAll();
	}
}
