package repositories;

import models.Business;
import utils.exceptions.dbExceptipns.CreateFailedException;
import utils.exceptions.dbExceptipns.DuplicateEntryException;

public interface IBusinessRepository {
	void createBusines(Business business) throws DuplicateEntryException, CreateFailedException;
}
