package basemap;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.amap.api.maps.utils.overlay.SmoothMoveMarker;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.example.gdmap.R;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapActivity extends AppCompatActivity implements LocationSource, AMapLocationListener, GeocodeSearch.OnGeocodeSearchListener {
    protected BaseMap mMapView;
    protected AMap aMap;
    protected MyLocationStyle myLocationStyle;
    protected GeocodeSearch geocoderSearch;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                    "android.permission.WRITE_EXTERNAL_STORAGE",
                    "android.permission.ACCESS_NETWORK_STATE",
                    "android.permission.ACCESS_WIFI_STATE",
                    "android.permission.READ_PHONE_STATE",
                    "android.permission.ACCESS_COARSE_LOCATION",
                    "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS",
                    "android.permission.WRITE_EXTERNAL_STORAGE",
                    "android.permission.CHANGE_WIFI_STATE",
                    "android.permission.ACCESS_FINE_LOCATION"
            }, 100);
        }

        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
    }

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                //可在其中解析amapLocation获取相应内容。
                    //城市
                    String city = aMapLocation.getCity();
                    //城区
                    String district = aMapLocation.getDistrict();
                    //街道
                    String street = aMapLocation.getStreet();
                    Log.d("zf","城市->"+city+"    城区->"+district+"    街道->"+street);
                }else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError","location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }
        }
    };

    protected void addMap(ViewGroup group,Bundle bundle){
        mMapView = new BaseMap(this);
        group.addView(mMapView);
        mMapView.onCreate(bundle);

        if (aMap == null) {
            aMap = mMapView.getMap();
        }

        //初始化定位蓝点
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            initBlueDot();
        }else {
            initLowBlueDot();
        }
    }

    private void initLowBlueDot() {
        // 设置定位监听
        aMap.setLocationSource(this);
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationEnabled(true);
        // 设置定位的类型为定位模式，有定位、跟随或地图根据面向方向旋转几种
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
    }

    private void initBlueDot() {
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(10000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        myLocationStyle.showMyLocation(true);//设置是否显示定位小蓝点，用于满足只想使用定位，不想使用定位小蓝点的场景，设置false以后图面上不再有定位蓝点的概念，但是会持续回调位置信息。
//        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_MAP_ROTATE);//连续定位、且将视角移动到地图中心点，地图依照设备方向旋转，定位点会跟随设备移动。（1秒1次定位）
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.getUiSettings().setMyLocationButtonEnabled(false);//设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        setMapStyle("ae275769d2f45def07be29df9cb50358");
    }

    protected abstract int bandLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMapView!=null){
            //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
            mMapView.onDestroy();
        }
        if(null != mlocationClient){
            mlocationClient.onDestroy();
        }
        mLocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mMapView!=null){
            //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
            mMapView.onResume();
        }
        //初始化定位
//        initPlace();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMapView!=null){
            //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
            mMapView.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
//        mLocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mMapView!=null){
            //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
            mMapView.onSaveInstanceState(outState);
        }
    }

    OnLocationChangedListener mListener;
    AMapLocationClient mlocationClient;
    AMapLocationClientOption mLocationOption;

    /**
     * 激活定位
     */
    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        Log.d("zf","激活定位");
        if (mlocationClient == null) {
            Log.d("zf","激活定位");
            //初始化定位
            mlocationClient = new AMapLocationClient(getApplicationContext());
            //初始化定位参数
            mLocationOption = new AMapLocationClientOption();
            //设置定位回调监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();//启动定位
        }
    }

    //声明AMapLocationClientOption对象
//    public AMapLocationClientOption mLocationOption = null;
//
//    private void initPlace() {
//        if (mLocationOption==null){
//            //初始化定位
//            mLocationClient = new AMapLocationClient(getApplicationContext());
//            //设置定位回调监听
//            mLocationClient.setLocationListener(mLocationListener);
//            //初始化AMapLocationClientOption对象
//            mLocationOption = new AMapLocationClientOption();
//            //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
//            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//            //给定位客户端对象设置定位参数
//            mLocationClient.setLocationOption(mLocationOption);
//            //启动定位
//            mLocationClient.startLocation();
//        }
//
//    }

    /**
     * 停止定位
     */
    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    /**
     * 定位成功后回调函数
     */
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null&&aMapLocation != null) {
            if (aMapLocation != null
                    &&aMapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点
                Log.d("zf","定位成功");
            } else {
                String errText = "定位失败," + aMapLocation.getErrorCode()+ ": " + aMapLocation.getErrorInfo();
                Log.e("zf",errText);
            }
        }
    }

    protected void setMapStyle(String mId){
        //该方法在AMap类中提供
        aMap.setCustomMapStyle(
                new com.amap.api.maps.model.CustomMapStyleOptions()
                        .setEnable(true)
                        .setStyleId(mId)//官网控制台-自定义样式 获取

        );

    }

    //滑动
    private void startMove(){
        // 获取轨迹坐标点
        List<LatLng> points = latLngs;
        LatLngBounds bounds = new LatLngBounds(points.get(0), points.get(points.size() - 2));
        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));

        SmoothMoveMarker smoothMarker = new SmoothMoveMarker(aMap);
        // 设置滑动的图标
        smoothMarker.setDescriptor(BitmapDescriptorFactory.fromResource(R.drawable.car));

        LatLng drivePoint = points.get(0);
        Pair<Integer, LatLng> pair = SpatialRelationUtil.calShortestDistancePoint(points, drivePoint);
        points.set(pair.first, drivePoint);
        List<LatLng> subList = points.subList(pair.first, points.size());

        // 设置滑动的轨迹左边点
        smoothMarker.setPoints(subList);
        // 设置滑动的总时间
        smoothMarker.setTotalDuration(40);
        // 开始滑动
        smoothMarker.startSmoothMove();
    }

    List<LatLng> latLngs = new ArrayList<>();

    //处理坐标 的转换
    //获取输入点坐标
    private void readLatLngs(double i,double i1){
        LatLng latLng = new LatLng(i, i1);
        latLngs.add(latLng);
        startMove();
    }

    //提供外部调用查询
    public void searchPlace(String name){
        // name表示地址，第二个参数表示查询城市，中文或者中文全拼，citycode、adcode
        GeocodeQuery query = new GeocodeQuery(name, "中国");

        geocoderSearch.getFromLocationNameAsyn(query);
    }

    //查询地址回调
    @Override
    public void onGeocodeSearched(GeocodeResult result, int rCode) {
        //解析result获取坐标信息
        GeocodeQuery geocodeQuery = result.getGeocodeQuery();
        List<GeocodeAddress> geocodeAddressList = result.getGeocodeAddressList();

    }
    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {

    }
}
//获取到容器的宽度-图片的宽度就是他X轴的位置