module fr.youtube.yoh4n.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    opens fr.youtube.yoh4n.jfx.vues to javafx.fxml;
    exports fr.youtube.yoh4n.jfx;
}