module vmp.trade.services.infrastructure {
    requires vmp.trade.services.domain;

    requires spring.web;
    requires jakarta.validation;
    requires jakarta.annotation;
    requires jakarta.servlet;
    requires spring.context;
    requires com.fasterxml.jackson.annotation;
    requires io.swagger.v3.oas.annotations;
}