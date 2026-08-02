module vmp.trade.services.application {
    requires spring.web;
    requires spring.boot.autoconfigure;
    requires spring.boot;

    exports pl.es8it.vmp.trade.application;
    exports pl.es8it.vmp.trade.application.service;

    provides pl.es8it.vmp.trade.application.service.ItemListingService
        with pl.es8it.vmp.trade.application.service.impl.ItemListingServiceImpl;

    opens pl.es8it.vmp.trade.application to spring.core, spring.beans, spring.context;
}