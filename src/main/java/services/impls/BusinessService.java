package services.impls;

import dtos.BusinessDTO;
import models.Business;
import repositories.IBusinessRepository;
import services.IBusinessService;
import utils.exceptions.dbExceptipns.CreateFailedException;
import utils.exceptions.dbExceptipns.DuplicateEntryException;
import utils.helper.Helper;
import utils.helper.IDGeneration;
import utils.messages.Message;
import utils.messages.Meta;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

public class BusinessService implements IBusinessService {
	@Inject
	private IBusinessRepository businessRepository;

	@Override
	public Message createBusiness(BusinessDTO businessDTO) {
		// TODO Auto-generated method stub
		try {
			Business business = Helper.objectMapper(businessDTO, Business.class);
			String id = IDGeneration.generate();
			business.setId(id);
			businessRepository.createBusines(business);

			Meta meta = new Meta.Builder(HttpServletResponse.SC_CREATED).withMessage("Created Successfully").build();
			return new Message.Builder(meta).build();
		} catch (DuplicateEntryException | CreateFailedException e) {
			Meta meta = new Meta.Builder(e.getStatusCode()).withErrCode(e.getErrorCode()).withError(e.getMessage())
					.build();
			return new Message.Builder(meta).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			Meta meta = new Meta.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).withError(e.getMessage()).build();
			Message message = new Message.Builder(meta).build();
			return message;

		}
	}

}
