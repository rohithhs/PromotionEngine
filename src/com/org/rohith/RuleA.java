package com.org.rohith;

import java.util.List;

public class RuleA implements Rules<SKU,SKU> {
	
	@Override
	public boolean matches(SKU input) {
		return input.getName().equals("A");
	}

	@Override
	public OfferPrice applyPromo(Promotion promotion, OfferPrice offerPrice) 
	{
		double offerPriceForA = 0.0;

		List<SKU> skuList = promotion.getList();
		for(SKU input: skuList) 
		{
			boolean matchFound = matches(input);
			if(matchFound) 
			{
				int count =input.getCount();

				while(count>=3) 
				{
					offerPriceForA += 130.0;
					count -= 3;

				}

				if(count != 0)
				{
					offerPriceForA += count *input.getPrice();
				}
				offerPrice.setOfferPriceA(offerPriceForA);
			}
		}
		return offerPrice;
	}



}
