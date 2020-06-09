package sample.background;

import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;

public class CustomSkinControl extends SkinBase<CustomControl> implements Skin<CustomControl>  {

    protected CustomSkinControl(CustomControl control) {
        super(control);
    }
}
