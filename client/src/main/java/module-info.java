module client {
    requires javafx.controls;
    requires java.net.http;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.tronina.cs to com.fasterxml.databind;
    exports com.tronina.cs;
}