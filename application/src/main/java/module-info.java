module vmp.trade.services.application {
    requires spring.web;

    requires spring.boot.autoconfigure;
    requires spring.boot;

    exports pl.es8it.vmp.trade.application;

    opens pl.es8it.vmp.trade.application to spring.core, spring.beans, spring.context;
}