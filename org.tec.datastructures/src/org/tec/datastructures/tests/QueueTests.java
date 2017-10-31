package org.tec.datastructures.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tec.datastructures.structures.Queue;

public class QueueTests {

	@Test
	public void testEnqueue() {
		Queue<Integer> tester = new Queue<>();
		
		assertEquals(tester.size(), 0);
		
		assertNull(tester.peak());
		tester.enqueue(0);
		assertNotNull(tester.peak());
		
		tester.enqueue(1);
		tester.enqueue(2);
		
		assertEquals(tester.size(), 3);
		
	}
	
	@Test
	public void testDequeue() {
		Queue<Integer> tester = new Queue<>();
		
		tester.enqueue(0);
		tester.enqueue(1);
		tester.enqueue(2);
		
		assertEquals((Object)tester.dequeue().getValue(), 0);
		assertEquals((Object)tester.dequeue().getValue(), 1);
		assertEquals((Object)tester.dequeue().getValue(), 2);
		
		assertNull(tester.dequeue());
		
		assertEquals(tester.size(), 0);
		
	}
	
	@Test
	public void TestPeak() {
		Queue<Integer> tester = new Queue<>();
		
		tester.enqueue(0);
		tester.enqueue(1);
		tester.enqueue(2);
		
		assertEquals(tester.size(), 3);
		assertEquals((Object)tester.peak().getValue(), 0);
		assertEquals(tester.size(), 3);
		
		tester.dequeue();
		
		assertEquals(tester.size(), 2);
		assertEquals((Object)tester.peak().getValue(), 1);
		assertEquals(tester.size(), 2);		
		
		tester.clear();
		
		assertNull(tester.peak());
		
		
	}

}
