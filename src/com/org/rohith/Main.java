package com.org.rohith;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		SKU sku1 = new SKU();
		SKU sku2 = new SKU();
		SKU sku3 = new SKU();
		
		sku1.setName("A");
		sku1.setCount(5);
		sku1.setPrice(50);
		
		sku1.setName("B");
		sku1.setCount(5);
		sku1.setPrice(30);
		
		sku1.setName("C");
		sku1.setCount(1);
		sku1.setPrice(20);
		
		List<SKU> skuList = new ArrayList<>();
		skuList.add(sku1);
		skuList.add(sku2);
		skuList.add(sku3);
		
		Promotion promotion = new Promotion();
		promotion.setList(skuList);
		
		RuleEngine ruleEngine = new RuleEngine();
		double finalPrice = ruleEngine.rule(promotion);


	}

}
