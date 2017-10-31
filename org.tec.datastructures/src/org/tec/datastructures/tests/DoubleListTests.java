package org.tec.datastructures.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tec.datastructures.structures.DoubleList;

public class DoubleListTests {

	@Test
	public void testAppendFirst() {
		DoubleList<Integer> tester = new DoubleList<>();
		
		assertNull(tester.getHead());
		tester.append(0);
		assertNotNull(tester.getHead());
		
		Object appended = tester.getHead().getValue();
		assertEquals(appended,0);
		
	}
	
	@Test
	public void testAppend() {
		DoubleList<Integer> tester = new DoubleList<>();
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		Object appended = tester.getHead().getNext().getNext().getValue();
		assertEquals(appended,2);
		
		assertEquals(tester.getHead().getNext().getPrevious(),tester.getHead());
		
	}
	
	@Test 
	public void testLength() {
		DoubleList<Integer> tester = new DoubleList<>();
		
		assertEquals(tester.length(),0);
	
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		assertEquals(tester.length(),3);
	}
	
	@Test 
	public void testSearch() {
		DoubleList<Integer> tester = new DoubleList<>();
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		Object searchedFirst = tester.search(0).getValue();
		assertEquals(searchedFirst , 0);
		
		Object searchedMiddle = tester.search(1).getValue();
		assertEquals(searchedMiddle , 1);
		
		Object searchedLast = tester.search(2).getValue();
		assertEquals(searchedLast,2);
	}
	
	@Test 
	public void testDeleteHead() {
		DoubleList<Integer> tester = new DoubleList<>();
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		tester.delete(0);
		
		assertNull(tester.search(0));
		assertNotNull(tester.getHead());
		
		Object newHead = tester.getHead().getValue();
		assertEquals(newHead,1);
		
		assertEquals(tester.length(),2);
	}
	
	@Test
	public void testDeleteLast() {
		DoubleList<Integer> tester = new DoubleList<>();
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		tester.delete(2);
		
		assertNull(tester.getHead().getNext().getNext());
		
		assertEquals(tester.length(),2);
		
	}
	
	@Test
	public void testDeleteMiddle() {
		DoubleList<Integer> tester = new DoubleList<>();
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		tester.delete(1);
		
		Object value = tester.getHead().getNext().getValue();
		
		assertEquals(value,2);
		
		assertEquals(tester.length(),2);
	
	}
	
	@Test 
	public void testEmpty() {
		DoubleList<Integer> tester = new DoubleList<>();
		
		assertTrue(tester.isEmpty());
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		assertFalse(tester.isEmpty());
		
		tester.clear();
		
		assertTrue(tester.isEmpty());
	}
}

