module vmp.trade.services.api {
    requires vmp.trade.services.application;
    requires spring.web;

    requires spring.boot.autoconfigure;
    requires spring.boot;

    exports pl.es8it.vmp.trade;
    exports pl.es8it.vmp.trade.api.controller;

    opens pl.es8it.vmp.trade to spring.core, spring.beans, spring.context;
}