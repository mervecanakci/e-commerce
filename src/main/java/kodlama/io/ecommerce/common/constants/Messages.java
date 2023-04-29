package kodlama.io.ecommerce.common.constants;

public class Messages {
    // nesnelerin farklı durumlarında gösterilecek mesajlar olacak burada örn:
    /*
      public static class Car {
        public static final String NotExists = "CAR_NOT_EXISTS";
        public static final String Exists = "CAR_ALREADY_EXISTS";
        public static final String NotAvailable = "CAR_NOT_AVAILABLE";
        public static final String PlateExists = "PLATE_ALREADY_EXISTS";
        public static final String PlateNotValid = "plate number must match the pattern";
    }

    public static class Model {
        public static final String NotExists = "MODEL_NOT_EXISTS";
        public static final String Exists = "MODEL_ALREADY_EXISTS";
    }

     */
    public static class Payment {
        public static final String NotFound = "PAYMENT_NOT_FOUND";
        public static final String CardNumberAlreadyExists = "CARD_NUMBER_ALREADY_EXISTS";
        public static final String NotEnoughMoney = "NOT_ENOUGH_MONEY";
        public static final String NotAValidPayment = "NOT_A_VALID_PAYMENT";
        public static final String Failed = "PAYMENT_FAILED";
    }

    public static class Invoice {
        public static final String NotFound = "INVOICE_NOT_FOUND";
    }
}
