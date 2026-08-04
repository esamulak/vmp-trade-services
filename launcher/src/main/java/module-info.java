module vmp.trade.services.launcher {

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;

    requires org.apache.commons.logging;
    requires org.yaml.snakeyaml;
    requires spring.boot.tomcat;
    requires org.apache.tomcat.embed.core;
    requires org.apache.tomcat.embed.el;
    requires org.apache.tomcat.embed.websocket;
    requires org.jspecify;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    requires vmp.trade.services.infrastructure;

    exports pl.es8it.vmp.trade.launcher;

    opens pl.es8it.vmp.trade.launcher
            to spring.core;
}