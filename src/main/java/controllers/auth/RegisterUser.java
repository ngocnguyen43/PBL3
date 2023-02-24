package controllers.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.ResponseConfig;
import dtos.UserDTO;
import services.IAuthService;
import utils.helper.Helper;
import utils.messages.Message;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/v1/auth/register"})
public class RegisterUser extends HttpServlet {

    @Inject
    private IAuthService authService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ResponseConfig.ConfigHeader(resp);
        ObjectMapper obj = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        UserDTO userDTO = Helper.of(req.getReader()).toModel(UserDTO.class);
        Message message = authService.Register(userDTO);
        String json = obj.writeValueAsString(message);
        resp.setStatus(message.getMeta().getStatusCode());
        out.print(json);
        out.flush();
    }
}
