module vmp.trade.services.infrastructure {

    requires vmp.trade.services.domain;
    requires vmp.trade.services.application;

    // Spring
    requires spring.web;
    requires spring.context;

    // Jakarta
    requires jakarta.validation;
    requires jakarta.annotation;

    // JSON
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    // OpenAPI
    requires io.swagger.v3.oas.annotations;

    //Lombok
    requires static lombok;

    uses pl.es8it.vmp.trade.application.service.ItemListingService;

    exports pl.es8it.vmp.trade.infrastructure.web.rest;

    opens pl.es8it.vmp.trade.infrastructure.web.rest to spring.core;
    opens pl.es8it.vmp.trade.infrastructure.configuration to spring.core, spring.beans, spring.context;
    opens pl.es8it.vmp.trade.model to com.fasterxml.jackson.databind;
}