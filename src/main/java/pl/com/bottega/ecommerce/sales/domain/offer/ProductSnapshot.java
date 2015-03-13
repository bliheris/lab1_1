package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class ProductSnapshot {

    private String id;
    private BigDecimal price;
    private String currency;
    private String name;
    private String type;
    private Date snapshotDate;

    public ProductSnapshot(String id, BigDecimal price, String currency,
                           String name, String type, Date snapshotDate) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.name = name;
        this.type = type;
        this.snapshotDate = snapshotDate;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSnapshot)) return false;

        ProductSnapshot that = (ProductSnapshot) o;

        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (snapshotDate != null ? !snapshotDate.equals(that.snapshotDate) : that.snapshotDate != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (snapshotDate != null ? snapshotDate.hashCode() : 0);
        return result;
    }
}
