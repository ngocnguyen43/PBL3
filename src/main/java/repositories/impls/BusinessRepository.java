package repositories.impls;

import daos.IBusinessDAO;
import models.Business;
import repositories.IBusinessRepository;
import utils.exceptions.dbExceptipns.CreateFailedException;
import utils.exceptions.dbExceptipns.DuplicateEntryException;
import utils.exceptions.dbExceptipns.NotFoundException;

import javax.inject.Inject;
import java.util.List;

public class BusinessRepository implements IBusinessRepository {
	@Inject
	private IBusinessDAO businessDAO;
	@Override
	public void createBusines(Business domainBusiness) throws DuplicateEntryException, CreateFailedException {
		// TODO Auto-generated method stub
		Business business = businessDAO.findOne(domainBusiness.getBusinessName());
		if (business != null) throw new DuplicateEntryException("Business Name has already existed");
		String id = businessDAO.save(domainBusiness);
		if (id == null) throw new CreateFailedException("Create Business Failed");
		return ;
		
	}

	@Override
	public List<Business> findAll() throws NotFoundException {
		List<Business> businesses = businessDAO.findAll();
		if (businesses == null) throw new NotFoundException("Not Found Business");
		return businesses;
	}

}
