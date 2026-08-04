module vmp.trade.services.infrastructure {
    requires vmp.trade.services.domain;
    requires vmp.trade.services.application;

    requires spring.web;
    requires spring.context;
    requires jakarta.validation;
    requires jakarta.annotation;
    requires com.fasterxml.jackson.annotation;
    requires io.swagger.v3.oas.annotations;
    requires com.fasterxml.jackson.databind;

    uses pl.es8it.vmp.trade.application.service.ItemListingService;

    exports pl.es8it.vmp.trade.infrastructure.web.rest;

    opens pl.es8it.vmp.trade.infrastructure.web.rest
            to spring.core, spring.beans;
    opens pl.es8it.vmp.trade.model to com.fasterxml.jackson.databind;
}