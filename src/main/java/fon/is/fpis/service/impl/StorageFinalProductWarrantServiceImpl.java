package fon.is.fpis.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fon.is.fpis.dao.ProductRepository;
import fon.is.fpis.dao.StorageFinalProductWarrantRepository;
import fon.is.fpis.domain.InternalCheckPlan;
import fon.is.fpis.domain.Product;
import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.domain.StorageWarantItem;
import fon.is.fpis.service.StorageFinalProductWarrantService;
import fon.is.fpis.service.dto.InternalCheckPlanSearchRequest;
import fon.is.fpis.service.dto.InternalCheckPlanSearchResponse;

@Service
public class StorageFinalProductWarrantServiceImpl implements StorageFinalProductWarrantService {

	private StorageFinalProductWarrantRepository warrantRepo;

	public StorageFinalProductWarrantServiceImpl(StorageFinalProductWarrantRepository warrantRepo, ProductRepository productRepo) {
		this.warrantRepo = warrantRepo;
		
		StorageFinalProductWarrant warrant = StorageFinalProductWarrant.builder().id(1L).date(LocalDate.now()).build();
		Product p1 = Product.builder().name("Smoki").build();
		Product p2 = Product.builder().name("Nutela").build();
		productRepo.save(p1);
		productRepo.save(p2);
		StorageWarantItem item1 = StorageWarantItem.builder().orderNumber(1).amount(2).note("Note 1").product(p1)
				.build();
		StorageWarantItem item2 = StorageWarantItem.builder().orderNumber(2).amount(6).note("Note 2").product(p2)
				.build();
		List<StorageWarantItem> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		warrant.setItems(items);
		warrantRepo.save(warrant);
	}

	@Override
	public StorageFinalProductWarrant getById(Long id) {
		return warrantRepo.findById(id).get();
	}

	@Override
	public List<StorageFinalProductWarrant> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalCheckPlanSearchResponse searchStorageFinalProductWarrants(InternalCheckPlanSearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageFinalProductWarrant save(StorageFinalProductWarrant warrant) {
		return warrantRepo.saveAndFlush(warrant);
	}

	@Override
	public boolean deleteStorageFinalProductWarrantById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
