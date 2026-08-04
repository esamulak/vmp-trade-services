module vmp.trade.services.launcher {

    // Spring Boot
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.boot.tomcat;

    // Runtime dependencies
    requires org.apache.commons.logging;
    requires org.yaml.snakeyaml;
    requires org.jspecify;
    requires org.apache.tomcat.embed.core;

    // Application modules
    requires vmp.trade.services.infrastructure;

    exports pl.es8it.vmp.trade.launcher;

    opens pl.es8it.vmp.trade.launcher
            to spring.core;
}