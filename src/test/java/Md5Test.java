import com.oraclewdp.ddbookmarket.util.Md5Util;

public class Md5Test {
    public static void main(String[] args)throws  Exception{
        String  str ="admin";
        System.out.println(Md5Util.getEncryptedPwd(str));
    }
}
