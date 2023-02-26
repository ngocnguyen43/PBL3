package repositories;

import models.Business;
import utils.exceptions.dbExceptipns.CreateFailedException;
import utils.exceptions.dbExceptipns.DuplicateEntryException;
import utils.exceptions.dbExceptipns.NotFoundException;

import java.util.List;

public interface IBusinessRepository {
	void createBusines(Business business) throws DuplicateEntryException, CreateFailedException;

	List<Business> findAll() throws NotFoundException;
}
