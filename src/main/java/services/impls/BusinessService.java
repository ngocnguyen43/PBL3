package services.impls;

import dtos.BusinessDTO;
import models.Business;
import repositories.IBusinessRepository;
import services.IBusinessService;
import utils.datastructures.searching.InterpolationSearch;
import utils.exceptions.dbExceptipns.CreateFailedException;
import utils.exceptions.dbExceptipns.DuplicateEntryException;
import utils.exceptions.dbExceptipns.NotFoundException;
import utils.helper.Helper;
import utils.helper.IDGeneration;
import utils.messages.Data;
import utils.messages.Message;
import utils.messages.Meta;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        } catch (Exception e) {
            // TODO: handle exception
            Meta meta = new Meta.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).withError(e.getMessage()).build();
            return new Message.Builder(meta).build();

        }
    }

    @Override
    public Message getAllBusiness() {
        try {
            InterpolationSearch<Business> algorithm = new InterpolationSearch<>();
            List<Business> businesses = businessRepository.findAll();
            Business res = algorithm.Search(businesses, "id", "Ohz6sTAYNNrl5k9UBy6iTz8");
            Meta meta = new Meta.Builder(HttpServletResponse.SC_OK).withMessage("Success").build();
            Data data = new Data.Builder(null).withResults(res).build();
            return new Message.Builder(meta).withData(data).build();

        } catch (NotFoundException e) {
            Meta meta = new Meta.Builder(e.getStatusCode()).withErrCode(e.getErrorCode()).withMessage(e.getMessage()).build();
            return new Message.Builder(meta).build();
        }
    }

}
