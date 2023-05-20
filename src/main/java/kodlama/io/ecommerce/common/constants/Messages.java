package kodlama.io.ecommerce.common.constants;

public class Messages {
    // nesnelerin farklı durumlarında gösterilecek mesajlar olacak burada örn:
    public static class Category {
        public static final String NotExists = "CATEGORY_NOT_EXISTS";
        public static final String Exists = "CATEGORY_ALREADY_EXISTS";
    }

    public static class CorporateCustomer {
        public static final String NotExists = "CORPORATE_CUSTOMER_NOT_EXISTS";
        public static final String Exists = "CORPORATE_CUSTOMER_ALREADY_EXISTS";
        public static final String PointNotValid = "Point must match the pattern";
        public static final String TaxNumberNotValid = "Tax number must match the pattern";
        public static final String CompanyNameNotValid = "Company name must match the pattern";



    }

    public static class Customer {
        public static final String NotExists = "CUSTOMER_NOT_EXISTS";
        public static final String Exists = "CUSTOMER_ALREADY_EXISTS";

    }

    public static class IndividualCustomer {
        public static final String NotExists = "INDIVIDUAL_CUSTOMER_NOT_EXISTS";
        public static final String Exists = "INDIVIDUAL_CUSTOMER_ALREADY_EXISTS";
        public static final String IdentityNumberNotValid = "identity number must match the pattern";
        public static final String FirstNameNotValid = "first name must match the pattern";
        public static final String LastNameNotValid = "first name must match the pattern";

    }

    public static class Invoice {
        public static final String NotFound = "INVOICE_NOT_FOUND";
    }

    public static class Order {
        public static final String NotFound = "ORDER_NOT_FOUND";
    }

    public static class Payment {
        public static final String NotFound = "PAYMENT_NOT_FOUND";
        public static final String CardNumberAlreadyExists = "CARD_NUMBER_ALREADY_EXISTS";
        public static final String NotEnoughMoney = "NOT_ENOUGH_MONEY";
        public static final String NotAValidPayment = "NOT_A_VALID_PAYMENT";
        public static final String Failed = "PAYMENT_FAILED";
    }

    public static class Product {
        public static final String NotExists = "PRODUCT_NOT_EXISTS";
        public static final String Exists = "PRODUCT_ALREADY_EXISTS";
        public static final String NotInStock = "PRODUCT_NOT_IN_STOCK";

    }

    public static class User {
        public static final String NotExists = "USER_NOT_EXISTS";
        public static final String Exists = "USER_ALREADY_EXISTS";
        public static final String EmailNotValid = "email number must match the pattern";

    }

}
