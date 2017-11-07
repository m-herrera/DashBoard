package org.tec.datastructures.tests;

import org.junit.Test;
import org.tec.datastructures.hierarchical.BinaryTree;

import static org.junit.Assert.*;

public class BinaryTreeTests {
	
	@Test
	public void TestAppend() {
		BinaryTree<Integer> tester  = new BinaryTree<>();
		
		assertNull(tester.getRoot());
		tester.append(3);
		assertNotNull(tester.getRoot());
		
		tester.append(1);
		assertEquals((Object)tester.getRoot().getLeft().getValue(),1);
		assertFalse(tester.getRoot().getLeft().hasChildren());
		
		tester.append(2);
		assertEquals((Object)tester.getRoot().getLeft().getRight().getValue(),2);
		assertFalse(tester.getRoot().getLeft().getRight().hasChildren());
		
		tester.append(4);
		assertEquals((Object)tester.getRoot().getRight().getValue(),4);
		assertFalse(tester.getRoot().getRight().hasChildren());
		
		tester.append(5);
		assertEquals((Object)tester.getRoot().getRight().getRight().getValue(), 5);
	}
	
	@Test
	public void TestSearch() {
		BinaryTree<Integer> tester  = new BinaryTree<>();
		
		assertNull(tester.search(0));
		
		tester.append(3);
		tester.append(1);
		tester.append(2);
		tester.append(4);
		tester.append(5);
		
		assertNull(tester.search(100));
		
		assertEquals((Object)tester.search(1).getValue(), 1);
		assertEquals((Object)tester.search(2).getValue(), 2);
		assertEquals((Object)tester.search(3).getValue(), 3);
		assertEquals((Object)tester.search(4).getValue(), 4);
		assertEquals((Object)tester.search(5).getValue(), 5);
	}
	
	@Test
	public void TestDelete() {
		BinaryTree<Integer> tester  = new BinaryTree<>();
		
		tester.delete(0);
		
		tester.append(3);
		tester.append(1);
		tester.append(2);
		tester.append(4);
		tester.append(5);
		
		tester.delete(3);
		tester.delete(99);
		
		assertEquals((Object)tester.getRoot().getValue(), 4);
		
		assertEquals((Object)tester.getRoot().getRight().getValue(), 5);
		tester.delete(5);
		assertNull(tester.getRoot().getRight());
		
		tester.delete(4);
		assertEquals((Object)tester.getRoot().getValue(), 1);
		
		assertTrue(tester.getRoot().hasChildren());
		tester.delete(2);
		assertFalse(tester.getRoot().hasChildren());
	}
}
