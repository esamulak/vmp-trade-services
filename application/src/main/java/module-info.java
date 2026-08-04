module vmp.trade.services.application {

    requires vmp.trade.services.domain;

    exports pl.es8it.vmp.trade.application.service;
    exports pl.es8it.vmp.trade.application.service.data;

    provides pl.es8it.vmp.trade.application.service.ItemListingService
        with pl.es8it.vmp.trade.application.service.impl.ItemListingServiceImpl;
}