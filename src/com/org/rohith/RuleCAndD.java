package com.org.rohith;

import java.util.List;

public class RuleCAndD implements Rules<SKU,SKU> {

	@Override
	public SKU process(SKU input) {
		return null;
	}

	@Override
	public boolean matches(SKU input) {
		//Check for C and D
		//if C & D both are found return true 
		return false;
	}
	
	boolean matchForCFound(SKU input)
	{
		return false;
		
	}
	

	public OfferPrice applyPromo(Promotion promotion, OfferPrice offerPrice) 
	{
		double offerPriceForC = 0.0;
		List<SKU> skuList = promotion.getList();
		for(SKU input: skuList) 
		{
			boolean matchFound = matches(input);
			if(matchFound) 
			{
				int count =input.getCount();

				while(count>=3) 
				{
					offerPriceForC += 130.0;
					count -= 3;

				}

				if(count != 0)
				{
					offerPriceForC += count *input.getPrice();
				}
				offerPrice.setOfferPriceA(offerPriceForC);
			}
		}
		
		return offerPrice;
		
		
	}

}
