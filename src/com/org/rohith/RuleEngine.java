package com.org.rohith;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine
{
	
	List<Rules<SKU, SKU>> rules;
	OfferPrice offerPrice = new OfferPrice();

    public RuleEngine() 
    {
        rules = new ArrayList<>();
    }

    public double rule(Promotion promotion) 
    {
    	for(Rules<SKU, SKU> rule: rules)
    	{
    		offerPrice = rule.applyPromo(promotion, offerPrice);
    	}
    	
    	return offerPrice.getOfferPriceA() + offerPrice.getOfferPriceB() + 
    			offerPrice.getOfferPriceC() + offerPrice.getOfferPriceD();
    }


    public RuleEngine registerRule(Rules<SKU, SKU> rule) 
    {
        rules.add(rule);
        return this;
    }

}
