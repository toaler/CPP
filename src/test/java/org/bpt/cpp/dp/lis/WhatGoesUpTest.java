package org.bpt.cpp.dp.lis;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class WhatGoesUpTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"-7\n" +
				"10\n" +
				"9\n" +
				"2\n" +
				"3\n" +
				"8\n" +
				"8\n" +
				"1\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		WhatGoesUp.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"4\n" +
				"-\n" +
				"-7\n" +
				"2\n" +
				"3\n" +
				"8\n";
		
		assertEquals(out, baos.toString()); 
	}
	
	
	public void testInput2() throws IOException {
		String in = 
				"1825198813\n" +
				"703574781\n" +
				"1357013548\n" +
				"882614101\n" +
				"91123810\n" +
				"693635462\n" +
				"509962994\n" +
				"13091984\n" +
				"476503935\n" +
				"692987701\n" +
				"845877457\n" +
				"484660669\n" +
				"2118992354\n" +
				"1583536068\n" +
				"1830890927\n" +
				"125909470\n" +
				"389054618\n" +
				"61633602\n" +
				"1167630334\n" +
				"1245222478\n" +
				"1653407157\n" +
				"1539092241\n" +
				"1260848996\n" +
				"1092105640\n" +
				"1343321214\n" +
				"1337792438\n" +
				"743752911\n" +
				"895144236\n" +
				"644021011\n" +
				"306984050\n" +
				"206209071\n" +
				"1968038758\n" +
				"694647582\n" +
				"627044827\n" +
				"1228453736\n" +
				"923849393\n" +
				"994690063\n" +
				"1935458528\n" +
				"351391203\n" +
				"1747161030\n" +
				"1759120300\n" +
				"1040627854\n" +
				"1076069512\n" +
				"1110842238\n" +
				"2104791827\n" +
				"326007565\n" +
				"159295061\n" +
				"522217290\n" +
				"1564248899\n" +
				"459709341\n" +
				"368308305\n" +
				"510183713\n" +
				"1141726537\n" +
				"2069288597\n" +
				"94198657\n" +
				"557718943\n" +
				"1355469954\n" +
				"1075065596\n" +
				"1830809408\n" +
				"660014489\n" +
				"1515539776\n" +
				"750393546\n" +
				"518211796\n" +
				"692879112\n" +
				"1918631132\n" +
				"533634230\n" +
				"1974805736\n" +
				"1999632389\n" +
				"616397282\n" +
				"1170189545\n" +
				"315109278\n" +
				"834252002\n" +
				"1161967889\n" +
				"103216749\n" +
				"1534876392\n" +
				"998665307\n" +
				"1795057301\n" +
				"1251226459\n" +
				"900157290\n" +
				"1509113371\n" +
				"1092226810\n" +
				"1988172767\n" +
				"2128641328\n" +
				"1107418067\n" +
				"48984604\n" +
				"1391219046\n" +
				"1763691983\n" +
				"435334167\n" +
				"1137289136\n" +
				"78170531\n" +
				"1100176263\n" +
				"795618180\n" +
				"2087635596\n" +
				"893474920\n" +
				"1313562613\n" +
				"1238129761\n" +
				"314970551\n" +
				"566882611\n" +
				"2043820790\n" +
				"1354652240\n";

		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		WhatGoesUp.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"17\n" +
				"-\n" +
				"13091984\n" +
				"125909470\n" +
				"389054618\n" +
				"644021011\n" +
				"694647582\n" +
				"923849393\n" +
				"994690063\n" +
				"1040627854\n" +
				"1076069512\n" +
				"1110842238\n" +
				"1141726537\n" +
				"1355469954\n" +
				"1515539776\n" +
				"1534876392\n" +
				"1795057301\n" +
				"1988172767\n" +
				"2043820790\n";
		
		assertEquals(out, baos.toString()); 
	}
}
