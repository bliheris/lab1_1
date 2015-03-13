/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class OfferItem {

    private ProductSnapshot productSnapshot;
    private Discount discount;
	private int quantity;

	public OfferItem(ProductSnapshot productSnapshot, int quantity) {
		this(productSnapshot, quantity, null);
	}

	public OfferItem(ProductSnapshot productSnapshot, int quantity,
			Discount discount) {
		this.productSnapshot = productSnapshot;

		this.quantity = quantity;
		this.discount = discount;
	}

    public String getProductId(){
        return productSnapshot.getId();
    }

	public BigDecimal getTotalCost() {
        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null){
            discountValue = discountValue.subtract(discount.getValue());
        }

        BigDecimal totalCost = productSnapshot.getPrice()
                .multiply(new BigDecimal(quantity)).subtract(discountValue);
        return totalCost;
	}

	/**
	 * 
	 * @param other
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
        if(! productSnapshot.equals(other.productSnapshot)){
            return false;
        }

		if (quantity != other.quantity){
            return false;
        }

		BigDecimal max, min;
		if (getTotalCost().compareTo(other.getTotalCost()) > 0) {
			max = getTotalCost();
			min = other.getTotalCost();
		} else {
			max = other.getTotalCost();
			min = getTotalCost();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}
}
