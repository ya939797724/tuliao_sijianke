package basemap;

import android.content.Context;
import android.util.AttributeSet;

import com.amap.api.maps.MapView;

public class BaseMap extends MapView {

    private IBundle iBundle;

    public BaseMap(Context context) {
        super(context);
}

    public BaseMap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseMap(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

}
