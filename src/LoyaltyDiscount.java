import java.math.BigDecimal;

public class LoyaltyDiscount extends DiscountDecorator {

    public static final BigDecimal NINETY_NINE = new BigDecimal(95);
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public LoyaltyDiscount(Discount discount) {
        super(discount);
    }

    @Override
    public BigDecimal apply(BigDecimal originalPrice) {
        return super.apply(originalPrice).multiply(NINETY_NINE).divide(ONE_HUNDRED);
    }

}