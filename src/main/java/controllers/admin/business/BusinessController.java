package controllers.admin.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.BusinessDTO;
import services.IBusinessService;
import utils.helper.Helper;
import utils.messages.Message;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/v1/private/business"})
public class BusinessController extends HttpServlet {
    @Inject
    private IBusinessService businessService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File directory = new File(".");
        System.out.println(directory.getCanonicalPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper obj = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        BusinessDTO businessDto = Helper.of(req.getReader()).toModel(BusinessDTO.class);
//        System.out.println(businessDto.getBusinessName());
        Message message = businessService.createBusiness(businessDto);
        String json = obj.writeValueAsString(message);
        System.out.println(message.getMeta().getMessage());
        resp.setStatus(message.getMeta().getStatusCode());
        out.print(json);
        out.flush();
    }

}
