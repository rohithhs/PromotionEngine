package com.org.rohith;

public interface Rules<I,O> {
	
	boolean matches(I input); 
	O process(I input);
	OfferPrice applyPromo(Promotion promotion, OfferPrice offerPrice);

}
