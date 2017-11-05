package org.tec.datastructures.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tec.datastructures.hierarchical.BTree;

public class BTreeTests {

	@Test
	public void testAppend() {
		BTree<Integer> tester = new BTree<>(3);
		tester.append(3);
		tester.append(1);
		tester.append(2);
		tester.append(0);
		tester.append(4);
		tester.append(5);
		
		assertEquals((Object)tester.getRoot().getKeys().get(0), 2);
		assertEquals((Object)tester.getRoot().getKeys().get(1), 4);
		
		assertEquals((Object)tester.getRoot().getBranches().get(0).getKeys().get(0), 0);
		assertEquals((Object)tester.getRoot().getBranches().get(0).getKeys().get(1), 1);
		
		assertEquals((Object)tester.getRoot().getBranches().get(1).getKeys().get(0), 3);
		
		assertEquals((Object)tester.getRoot().getBranches().get(2).getKeys().get(0), 5);
	}
	
	@Test
	public void testSearch() {
		BTree<Integer> tester = new BTree<>(3);
		
		assertNull(tester.search(0));
		tester.append(3);
		tester.append(1);
		tester.append(2);
		tester.append(0);
		tester.append(4);
		tester.append(5);
		
		assertNull(tester.search(99));
		
		assertEquals((Object)tester.search(0), 0);
		assertEquals((Object)tester.search(1), 1);
		assertEquals((Object)tester.search(2), 2);
		assertEquals((Object)tester.search(3), 3);
		assertEquals((Object)tester.search(4), 4);
		assertEquals((Object)tester.search(5), 5);
	}
	
}
