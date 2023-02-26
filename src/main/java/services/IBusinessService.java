package services;

import dtos.BusinessDTO;
import models.Business;
import utils.messages.Message;

import java.util.List;

public interface IBusinessService {
	Message createBusiness(BusinessDTO businessDTO);
	Message getAllBusiness();
}
