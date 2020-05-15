package com.org.rohith;

import java.util.List;

public class RuleCAndD implements Rules<SKU, SKU> {

	@Override
	public boolean matches(SKU input) 
	{
		if (matchForCFound(input) && matchForDFound(input)) 
		{
			return true;
		}
		return false;
	}

	boolean matchForCFound(SKU input) {
		return input.getName().equals("C");

	}

	boolean matchForDFound(SKU input) {
		return input.getName().equals("D");

	}

	public OfferPrice applyPromo(Promotion promotion, OfferPrice offerPrice) {
		double offerPriceForC = 0.0;
		double offerPriceForD = 0.0;
		boolean matchFoundForC = false;
		boolean matchFoundForD = false;
		SKU skuForC = null;
		SKU skuForD = null;

		int countForC = 0;
		int countForD = 0;

		List<SKU> skuList = promotion.getList();
		for(SKU input: skuList) 
		{
			matchFoundForC = matchForCFound(input);
			matchFoundForD = matchForDFound(input);

			if(matchFoundForC)
			{
				skuForC = input;
			}

			if(matchFoundForD)
			{
				skuForD = input;
			}

		}
		if(skuForC != null) 
		{
		countForC = skuForC.getCount();
		}
		
		if(skuForD != null) 
		{
		countForD = skuForD.getCount();
		}
		
		if(skuForC != null && skuForD != null)
		{
			while(countForC>=1 && countForD>=1) 
			{
				offerPriceForC += 30.0;
				countForC -= 1;
				countForD -= 1;
			}
		}
			if(countForC != 0)
			{
				offerPriceForC += countForC *skuForC.getPrice();
			}
			offerPrice.setOfferPriceC(offerPriceForC);

			if(countForD != 0)
			{
				offerPriceForD += countForD *skuForD.getPrice();

			}
			offerPrice.setOfferPriceD(offerPriceForD);

		return offerPrice;

	}

}
