package com.vedha.mysoapapi.controller;


import com.example.employee.service.GetEmployeeRequest;
import com.example.employee.service.GetEmployeeResponse;
import com.example.employee.service.ObjectFactory;
import com.vedha.mysoapapi.repository.EmployeeRepository;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;

@Endpoint
public class EmployeeEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/employee/service";

    private EmployeeRepository empRepository;

    @Autowired
    public EmployeeEndpoint(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public JAXBElement<GetEmployeeResponse> getEmployee(@RequestPayload JAXBElement<GetEmployeeRequest> request) {

        GetEmployeeResponse response = new GetEmployeeResponse();
        GetEmployeeRequest myreq = request.getValue();
        System.out.println(myreq.getId());
        //response.setEmployee(empRepository.findEmployee(request.getValue().getId()));
        response.setEmployee(empRepository.findEmployee(request.getValue().getId()));


        QName responseQName = new QName(NAMESPACE_URI, "getEmployeeResponse");
        return new JAXBElement<>(responseQName, GetEmployeeResponse.class, response);

    }
}
