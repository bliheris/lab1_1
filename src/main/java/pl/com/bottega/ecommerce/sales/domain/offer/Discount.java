package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private BigDecimal value;
    private String currency;
    private String discountCause;

    public Discount(BigDecimal value, String currency, String discountCause) {
        this.value = value;
        this.currency = currency;
        this.discountCause = discountCause;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount)) return false;

        Discount discount1 = (Discount) o;

        if (currency != null ? !currency.equals(discount1.currency) : discount1.currency != null) return false;
        if (value != null ? !value.equals(discount1.value) : discount1.value != null) return false;
        if (discountCause != null ? !discountCause.equals(discount1.discountCause) : discount1.discountCause != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (discountCause != null ? discountCause.hashCode() : 0);
        return result;
    }
}
