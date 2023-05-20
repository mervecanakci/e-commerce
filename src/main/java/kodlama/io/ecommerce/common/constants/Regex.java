package kodlama.io.ecommerce.common.constants;

public class Regex {
    public final static String EmailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; //User
    /*
    büyük küçük harf, rakam, nokta,alt çizgi, artı, eksi ve yüzde işaretlerini içerebilir
    @ işaretinden sonra bir veya daha fazla harf, rakam veya tire içerebilir
    . işaretinden sonra en az iki harf içermesi gerekir
     */
    public final static String IdentityNumberRegex = "^[1-9]{1}[0-9]{9}[0,2,4,6,8]{1}$"; // IndividualCustomer
    public final static String PointRegex = "^[1-5](\\.\\d+)?$"; //CorporateCustomer
    /*    Sayı 1 ile 5 arasında olmalıdır.
        Sayı virgül ile birlikte ondalık hane içerebilir */
    public final static String TaxNumberRegex = "^[0-9]{10}";
    public final static String CompanyNameRegex = "^[abcçdefgğhıijklmnoöprsştuüvwqyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVWQYZ 0-9]{2,50}";
    public final static String NameRegex = "^[abcçdefgğhıijklmnoöprsştuüvwqyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVWQYZ ]{2,50}";
}
