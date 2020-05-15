package com.org.rohith;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		SKU sku1 = new SKU();
		SKU sku2 = new SKU();
		SKU sku3 = new SKU();
		SKU sku4 = new SKU();
		
		sku1.setName("A");
		sku1.setCount(3);
		sku1.setPrice(50);
		
		sku2.setName("B");
		sku2.setCount(5);
		sku2.setPrice(30);
		
		sku3.setName("C");
		sku3.setCount(1);
		sku3.setPrice(20);
		
		sku4.setName("D");
		sku4.setCount(1);
		sku4.setPrice(15);
		
		List<SKU> skuList = new ArrayList<>();
		skuList.add(sku1);
		skuList.add(sku2);
		skuList.add(sku3);
		skuList.add(sku4);
		
		Promotion promotion = new Promotion();
		promotion.setList(skuList);
		
		RuleEngine ruleEngine = new RuleEngine();
		 ruleEngine
         .registerRule(new RuleA())
         .registerRule(new RuleB())
         .registerRule(new RuleCAndD());	
		 
		 double totalPrice = ruleEngine.rule(promotion);
		 
		 System.out.println("Total Price ::"+ totalPrice);


	}

}
