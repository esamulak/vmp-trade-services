module vmp.trade.services.infrastructure {
    requires vmp.trade.services.domain;
    requires vmp.trade.services.application;

    requires spring.web;
    requires spring.context;
    requires jakarta.validation;
    requires jakarta.annotation;
    requires jakarta.servlet;
    requires com.fasterxml.jackson.annotation;
    requires io.swagger.v3.oas.annotations;
}