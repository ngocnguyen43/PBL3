package services;

import dtos.BusinessDTO;
import utils.messages.Message;

public interface IBusinessService {
	Message createBusiness(BusinessDTO businessDTO);
}
