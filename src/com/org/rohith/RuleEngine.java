package com.org.rohith;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
	
	List<Rules<SKU, SKU>> rules;

    public RuleEngine() {
        rules = new ArrayList<>();
    }

    public double rule(Promotion promotion) {
    	OfferPrice offerPrice = new OfferPrice();
    	promotion.getList();
		/*
		 * return rules.stream() .filter(rule -> rule.matches(sku)) .map(rule ->
		 * rule.process(sku)) // .map(rule -> rule.applyPromo(sku, offerPrice))
		 * .findFirst() .orElseThrow(() -> new
		 * RuntimeException("No Matching rule found"));
		 */
    	
    	return 0.0;
    }


    public RuleEngine registerRule(Rules<SKU, SKU> rule) {
        rules.add(rule);
        return this;
    }

}
