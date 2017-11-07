package org.tec.datastructures.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tec.datastructures.hierarchical.AVLTree;

public class AVLTreeTests {

	@Test
	public void testAppend() {
		AVLTree<Integer> tester = new AVLTree<>();
		
		assertNull(tester.getRoot());
		tester.append(1);
		assertNotNull(tester.getRoot());
		
		
		tester.append(2);
		assertEquals((Object)tester.getRoot().getValue(), 1);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 2);
		
		tester.append(3);
		assertEquals((Object)tester.getRoot().getValue(), 2);
		assertEquals((Object)tester.getRoot().getLeft().getValue(), 1);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 3);
		
		tester.append(-1);
		tester.append(0);
		assertEquals((Object)tester.getRoot().getValue(), 2);
		assertEquals((Object)tester.getRoot().getLeft().getValue(), 0);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 3);
		assertEquals((Object)tester.getRoot().getLeft().getLeft().getValue(), -1);
		assertEquals((Object)tester.getRoot().getLeft().getRight().getValue(), 1);
		
		tester.append(-2);
		assertEquals((Object)tester.getRoot().getValue(), 0);
		assertEquals((Object)tester.getRoot().getLeft().getValue(), -1);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 2);
		assertEquals((Object)tester.getRoot().getLeft().getLeft().getValue(), -2);
		assertEquals((Object)tester.getRoot().getRight().getRight().getValue(), 3);
		assertEquals((Object)tester.getRoot().getRight().getLeft().getValue(), 1);
		
		tester.append(4);
		tester.append(5);
		assertEquals((Object)tester.getRoot().getValue(), 0);
		assertEquals((Object)tester.getRoot().getLeft().getValue(), -1);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 2);
		assertEquals((Object)tester.getRoot().getLeft().getLeft().getValue(), -2);
		assertEquals((Object)tester.getRoot().getRight().getRight().getValue(), 4);
		assertEquals((Object)tester.getRoot().getRight().getLeft().getValue(), 1);
		assertEquals((Object)tester.getRoot().getRight().getRight().getRight().getValue(), 5);
		assertEquals((Object)tester.getRoot().getRight().getRight().getLeft().getValue(), 3);
		
	}
	
	@Test
	public void testSearch() {
		AVLTree<Integer> tester = new AVLTree<>();
		
		assertNull(tester.search(1));
		tester.append(1);
		assertNull(tester.search(2));
		
		tester.append(2);
		tester.append(3);
		tester.append(-1);
		tester.append(-2);
		tester.append(4);
		tester.append(5);
		
		assertEquals((Object)tester.search(-2).getValue(), -2);
		assertEquals((Object)tester.search(-1).getValue(), -1);
		assertEquals((Object)tester.search(1).getValue(), 1);
		assertEquals((Object)tester.search(2).getValue(), 2);
		assertEquals((Object)tester.search(3).getValue(), 3);
		assertEquals((Object)tester.search(4).getValue(), 4);
		assertEquals((Object)tester.search(5).getValue(), 5);
	}
	
	@Test
	public void testDelete() {
		AVLTree<Integer> tester = new AVLTree<>();
		
		tester.append(1);
		tester.append(2);
		tester.append(3);
		tester.append(-1);
		tester.append(0);
		tester.append(-2);
		tester.append(4);
		tester.append(5);
		
		tester.delete(4);
		tester.delete(5);
		assertEquals((Object)tester.getRoot().getValue(), 0);
		assertEquals((Object)tester.getRoot().getLeft().getValue(), -1);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 2);
		assertEquals((Object)tester.getRoot().getLeft().getLeft().getValue(), -2);
		assertEquals((Object)tester.getRoot().getRight().getRight().getValue(), 3);
		assertEquals((Object)tester.getRoot().getRight().getLeft().getValue(), 1);
		
		tester.delete(-2);
		assertEquals((Object)tester.getRoot().getValue(), 0);
		assertEquals((Object)tester.getRoot().getLeft().getValue(), -1);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 2);
		assertNull(tester.getRoot().getLeft().getLeft());
		assertEquals((Object)tester.getRoot().getRight().getRight().getValue(), 3);
		assertEquals((Object)tester.getRoot().getRight().getLeft().getValue(), 1);
		
		tester.delete(-1);
		assertEquals((Object)tester.getRoot().getValue(), 2);
		assertEquals((Object)tester.getRoot().getLeft().getValue(), 0);
		assertEquals((Object)tester.getRoot().getLeft().getRight().getValue(), 1);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 3);
		
		tester.delete(2);
		assertEquals((Object)tester.getRoot().getValue(), 1);
		assertEquals((Object)tester.getRoot().getRight().getValue(), 3);
		assertEquals((Object)tester.getRoot().getLeft().getValue(), 0);
		
		tester.delete(1);
		tester.delete(0);
		tester.delete(3);
		
		assertNull(tester.getRoot());
	}
}
