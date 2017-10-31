package org.tec.datastructures.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tec.datastructures.nodes.SimpleNode;
import org.tec.datastructures.structures.Stack;

public class StackTests {

	@Test
	public void testPush() {
		Stack<Integer> tester = new Stack<>();
		
		assertNull(tester.peak());
		tester.push(0);
		assertNotNull(tester.peak());
		
		assertEquals((Object)tester.peak().getValue(),0);
		
		tester.push(1);
		assertEquals((Object)tester.peak().getValue(),1);
		
		tester.push(2);
		assertEquals((Object)tester.peak().getValue(),2);
		
		assertEquals(tester.size(), 3);
	}
	
	@Test
	public void testPop() {
		Stack<Integer> tester = new Stack<>();
		
		tester.push(0);
		tester.push(1);
		tester.push(2);
		
		SimpleNode<Integer> popped = tester.pop();
		assertEquals((Object)popped.getValue(),2);
		
		popped = tester.pop();
		assertEquals((Object)popped.getValue(),1);

		assertEquals(tester.size(), 1);
		
		popped = tester.pop();
		assertEquals((Object)popped.getValue(),0);
		
		assertNull(tester.pop());
		
	}
	
	@Test
	public void testPeak() {
		Stack<Integer> tester = new Stack<>();
		
		assertNull(tester.peak());
		
		tester.push(0);
	
		assertEquals((Object)tester.peak().getValue(),0);
		
		tester.push(1);
		assertEquals((Object)tester.peak().getValue(),1);
		
		tester.push(2);
		assertEquals((Object)tester.peak().getValue(),2);
		
		tester.clear();
		assertNull(tester.peak());
		
		assertEquals(tester.size(), 0);
	}
	
}
