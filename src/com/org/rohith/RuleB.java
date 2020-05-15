package com.org.rohith;

import java.util.List;

public class RuleB implements Rules<SKU,SKU> {

	
	@Override
	public SKU process(SKU input) {
		return null;
	}

	@Override
	public boolean matches(SKU input) {
		return input.getName().equals("B");
	}

	public OfferPrice applyPromo(Promotion promotion, OfferPrice offerPrice) {
		double offerPriceForB = 0.0;
		List<SKU> skuList = promotion.getList();
		for(SKU input: skuList) 
		{
			boolean matchFound = matches(input);
			if(matchFound) 
			{
				int count =input.getCount();

				while(count>=2) 
				{
					offerPriceForB += 45.0;
					count -= 2;

				}

				if(count != 0)
				{
					offerPriceForB += count *input.getPrice();
				}
				offerPrice.setOfferPriceA(offerPriceForB);
			}
		}
		return offerPrice;
	}
}
