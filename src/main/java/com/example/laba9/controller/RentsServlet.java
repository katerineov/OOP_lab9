package com.example.laba9.controller;

import com.example.laba9.model.Rent;
import com.example.laba9.repository.RentsRepository;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.util.List;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "RentsServlet", urlPatterns = {"/rents"})
public class RentsServlet extends HttpServlet {
    private RentsRepository rentsRepository;

    @Override
    public void init() {
        rentsRepository = new RentsRepository(getServletContext().getRealPath("/"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Rent> rents = rentsRepository.loadRents();
        request.setAttribute("rents", rents);
        request.setAttribute("loadjson", "true");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Rent rent = new Rent();
        rent.setName(request.getParameter("Name"));
        rent.setPhoneNumber(request.getParameter("PhoneNumber"));
        rent.setRentDate(request.getParameter("RentDate"));
        rent.setProductName(request.getParameter("ProductName"));
        rent.setPrice(Double.parseDouble(request.getParameter("Price")));
        rent.setDuration(request.getParameter("Duration"));

        List<Rent> rents = rentsRepository.loadRents();
        rents.add(rent);
        rentsRepository.saveRents(rents);

        response.sendRedirect(request.getContextPath() + "/rents");
    }
}