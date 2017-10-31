package org.tec.datastructures.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tec.datastructures.structures.SimpleList;

public class SimpleListTests {

	@Test
	public void testAppendFirst() {
		SimpleList<Integer> tester = new SimpleList<>();
		
		assertNull(tester.getHead());
		tester.append(0);
		assertNotNull(tester.getHead());
		
		Object appended = tester.getHead().getValue();
		assertEquals(appended,0);
		
	}
	
	@Test
	public void testAppend() {
		SimpleList<Integer> tester = new SimpleList<>();
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		Object appended = tester.getHead().getNext().getNext().getValue();
		assertEquals(appended,2);
	}
	
	@Test 
	public void testLength() {
		SimpleList<Integer> tester = new SimpleList<>();
		
		assertEquals(tester.length(),0);
	
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		assertEquals(tester.length(),3);
	}
	
	@Test 
	public void testSearch() {
		SimpleList<Integer> tester = new SimpleList<>();
		
		assertNull(tester.search(0));
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		Object searchedFirst = tester.search(0).getValue();
		assertEquals(searchedFirst,0);
		
		Object searchedMiddle = tester.search(1).getValue();
		assertEquals(searchedMiddle,1);
		
		Object searchedLast = tester.search(2).getValue();
		assertEquals(searchedLast,2);
	}
	
	
	@Test 
	public void testDeleteHead() {
		SimpleList<Integer> tester = new SimpleList<>();
		
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
		SimpleList<Integer> tester = new SimpleList<>();
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		tester.delete(2);
		
		assertNull(tester.getHead().getNext().getNext());
		
		assertEquals(tester.length(),2);
	}
	
	@Test
	public void testDeleteMiddle() {
		SimpleList<Integer> tester = new SimpleList<>();
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		tester.delete(1);
		
		assertEquals((Object)tester.getHead().getNext().getValue(),2);
		
		assertEquals(tester.length(),2);
	}
	
	@Test 
	public void testEmpty() {
		SimpleList<Integer> tester = new SimpleList<>();
		
		assertTrue(tester.isEmpty());
		
		tester.append(0);
		tester.append(1);
		tester.append(2);
		
		assertFalse(tester.isEmpty());
		
		tester.clear();
		
		assertTrue(tester.isEmpty());
		
	}
}

