package untils;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.common.pinyin.ChangeToPinYin;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import pinyin.LinkMan;

public class LinkManUntils {
    private static LinkManUntils untils = new LinkManUntils();

    private List<LinkMan> list = new ArrayList<>();

    public static LinkManUntils getInstance(){
        return untils;
    }

    public List<LinkMan> sort(){
        //排序
        final Comparator<Object> comparator = Collator.getInstance(Locale.ENGLISH);
        Collections.sort(list,(l1, l2) -> {
            String charPinyin = ChangeToPinYin.getInstance().getCharPinyin(l1.getName().charAt(0));
            String charPinyin2 = ChangeToPinYin.getInstance().getCharPinyin(l2.getName().charAt(0));
            return comparator.compare(String.valueOf(charPinyin.charAt(0)),String.valueOf(charPinyin2.charAt(0)));
        });

        //添加英文大写字母
        String flag = "";
        for (int i = 0; i < list.size(); i++) {
            String charPinyin = ChangeToPinYin.getInstance().getCharPinyin(list.get(i).getName().charAt(0));
            String change = String.valueOf(charPinyin.charAt(0));
            if (!flag.equals(change)){
                list.add(i,new LinkMan(change.toUpperCase(),LinkMan.ISLETTER));
            }
            flag = change;
        }

        return list;
    }

    //获取手机联系人并判断是否开启联系人权限
    @SuppressLint("UseCheckPermission")
    public List<LinkMan> getLinkMans(Context context){
        //判断联系人权限是否开启
        PackageManager pm = context.getPackageManager();
        boolean read = PackageManager.PERMISSION_GRANTED == pm.checkPermission("android.permission.READ_CONTACTS", "packageName");
        boolean write = PackageManager.PERMISSION_GRANTED == pm.checkPermission("android.permission.WRITE_CONTACTS", "packageName");
        if (read&&write){
            ContentResolver resolver = context.getContentResolver();
            Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            if (cursor.getCount()>0&&cursor!=null){
                while (cursor.moveToNext()){
                    boolean isRepetition = false;
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phoneNum = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    for (LinkMan linkMan : list) {
                        if (linkMan.getName().equals(name)){
                            isRepetition = true;
                            break;
                        }
                    }
                    if (!isRepetition){
                        list.add(new LinkMan(name,phoneNum,true));
                    }
                }
                return list;
            }
        }else {
            Toast.makeText(context,"请授予读写联系人权限",Toast.LENGTH_SHORT).show();
        }

        return null;
    }

    //获取26个英文字母
    List<String> letterList = new ArrayList<>();
    public List<String> getEnglishLetter(){
        if (letterList.size()!=26){
            char a = 'A';
            for (int i = 1; i <=26; i++) {
                letterList.add(String.valueOf(a++));
            }
        }
        return letterList;
    }


}
