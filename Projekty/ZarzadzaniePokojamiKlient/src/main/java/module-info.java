module com.projektp3.zarzadzaniepokojamiklient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.projektp3.zarzadzaniepokojamiklient to javafx.fxml;
    exports com.projektp3.zarzadzaniepokojamiklient;
}