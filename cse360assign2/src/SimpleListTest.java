/*
 * Ryan Tucker
 * Assignment 2
 * Class ID: 226
 * 
 * This class provides a series of tests for the SimpleList class that will
 * test whether each method in the class is working as intended, including
 * the edge cases for each method.
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	@Test
	// Test to show that the add method is functional
	public void testAddSimple() {
		SimpleList tester = new SimpleList();
		tester.add(4);
		tester.add(3);
		tester.add(2);
		tester.add(1);
		
		assertEquals("1 2 3 4", tester.toString(), 
				"List must add 1, 2, 3, 4 in the correct order");
		assertEquals(4, tester.count(), 
				"List must have a count of 4 after Test");
	}
	
	@Test
	// Test to show that the add method works for edge case where the
	// list is empty
	public void testAddEmptyList() {
		SimpleList tester = new SimpleList();
		tester.add(1);
		
		assertEquals("1", tester.toString(), 
				"List must add only 1 to and Empty List");
		assertEquals(1, tester.count(), 
				"List must have a count of 1 after Test");
	}
	
	@Test
	// Test to show that the add method works as intended when the list is
	// empty by removing the last element of the list when a new element 
	// is added
	public void testAddFullList() {
		SimpleList tester = new SimpleList();
		tester.add(11);
		tester.add(10);
		tester.add(9);
		tester.add(8);
		tester.add(7);
		tester.add(6);
		tester.add(5);
		tester.add(4);
		tester.add(3);
		tester.add(2);
		tester.add(1);		
		
		assertEquals("1 2 3 4 5 6 7 8 9 10 11", tester.toString(), 
				"List must include all elements of the list including"
				+ "the first element added 11");
		assertEquals(11, tester.count(), 
				"List must show that the size was increased by 50%"
				+ "as the list was previously full");
		assertEquals(15, tester.size(), 
				"List must show that capacity of the list is"
				+ "15 as the list was previously full");
	}
	
	@Test
	// Test to show that the remove method is functional
	public void testRemoveSimple() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);
		tester.remove(2);	
		
		assertEquals("1 3", tester.toString(), 
				"List must add 1 3 to show 2 was "
				+ "removed from the list");
		assertEquals(2, tester.count(), 
				"List must have a count of 2 after Test");
		assertEquals(-1, tester.search(2), 
				"List must not contain 1 after the test");
	}
	
	@Test
	// Test to show that the remove method works as intended for the 
	// edge case that the list is empty
	public void testRemoveEmptyList() {
		SimpleList tester = new SimpleList();
		tester.remove(1);	
		
		assertEquals("", tester.toString(), 
				"List Must show that it is still empty");
		assertEquals(0, tester.count(), 
				"List must show that it still has a size "
				+ "of 0 after the test");
		assertEquals(-1, tester.search(2), 
				"List must not contain 1 after the test");
	}
	
	@Test
	// Test to show that the remove method works as intended for the
	// edge case that the integer to remove is at the end of the list
	public void testRemoveEndOfList() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);
		tester.remove(3);	
		
		assertEquals("1 2", tester.toString(), 
				"List must add 2 3 to show 2 was "
				+ "removed from the list");
		assertEquals(2, tester.count(), 
				"List must have a count of 2 after Test");
		assertEquals(-1, tester.search(3), 
				"List must not contain 1 after the test");
	}
	
	@Test
	// Test to show that the remove method works as intended for the 
	// edge case that there is only one element in the list
	public void testRemoveOneElement() {
		SimpleList tester = new SimpleList();
		tester.add(1);
		tester.remove(1);	
		
		assertEquals("", tester.toString(), 
				"List Must show that it is still empty");
		assertEquals(0, tester.count(), 
				"List must show that it still has a size "
				+ "of 0 after the test");
		assertEquals(-1, tester.search(2), 
				"List must not contain 1 after the test");
	}
	
	@Test
	// Test to show that the remove method works as intended for the
	// edge case that the integer to remove is at the front of the list
	public void testRemoveFrontOfList() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);
		tester.remove(1);	
		
		assertEquals("2 3", tester.toString(), 
				"List must add 2 3 to show 2 was "
				+ "removed from the list");
		assertEquals(2, tester.count(), 
				"List must have a count of 2 after Test");
		assertEquals(-1, tester.search(1), 
				"List must not contain 1 after the test");
	}
	
	@Test
	// Test to show that the count method is functional
	public void testCountSimpleAdd() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);	
		
		assertEquals(3, tester.count(), 
				"After adding three elements the count method"
				+ "must return 3");
	}
	
	@Test
	// Test to show that the count method works as intended when an 
	// element is removed from the list.
	public void testCountSimpleSubtract() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);
		tester.remove(2);
		
		assertEquals(2, tester.count(), 
				"After adding three elements and removing one"
				+ "the count method must return 3");
	}
	
	@Test
	// Test to show that the count method works as intended when an element
	// is added to a full list.
	public void testCountFullList() {
		SimpleList tester = new SimpleList();
		tester.add(11);
		tester.add(10);
		tester.add(9);
		tester.add(8);
		tester.add(7);
		tester.add(6);
		tester.add(5);
		tester.add(4);
		tester.add(3);
		tester.add(2);
		tester.add(1);		
		
		assertEquals(11, tester.count(), 
				"List must show that the list contains 11"
				+ "elements after the following operations");
	}
	
	@Test
	// Test to show that the count method works as intended for the edge
	// case that the list is empty.
	public void testCountEmptyList() {
		SimpleList tester = new SimpleList();
		tester.add(1);
		tester.remove(1);
		
		assertEquals(0, tester.count(), 
				"After adding one element and then removing "
				+ "the same element to list must show a count"
				+ "of 0, showing the list is empty");
	}
	
	@Test
	// Test to show that the search method is functional
	public void testSearchSimple() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);	
		
		assertEquals(1, tester.search(2), 
				"List must contain 2 after adding the elements"
				+ "1, 2, and 3");
	}
	
	@Test
	// Test to show that the search method works as intended for the edge
	// case that the list is full.
	public void testSearchFullList() {
		SimpleList tester = new SimpleList();
		tester.add(10);
		tester.add(9);
		tester.add(8);
		tester.add(7);
		tester.add(6);
		tester.add(5);	
		tester.add(4);
		tester.add(3);
		tester.add(2);
		tester.add(1);
		
		assertEquals(7, tester.search(8), 
				"List must contain the int 8 after the test");
	}
	
	@Test
	// Test to show that the search method works as intended for the edge
	// case that the list is empty.
	public void testSearchEmptyList() {
		SimpleList tester = new SimpleList();
		assertEquals(-1, tester.search(1), 
				"An Empty List cannot contain any element "
				+ "so the value returned must equal -1");
	}
	
	@Test
	// Test to show that the toString method is functional
	public void testToStringSimple() {
		SimpleList tester = new SimpleList();
		tester.add(4);
		tester.add(3);
		tester.add(2);
		tester.add(1);
		
		assertEquals("1 2 3 4", tester.toString(), 
				"List must add 1, 2, 3, 4 in the correct order");
	}
	
	@Test
	// Test to show that the toString method works as intended for the 
	// edge case that the list is full
	public void testToStringFullList() {
		SimpleList tester = new SimpleList();
		tester.add(11);
		tester.add(10);
		tester.add(9);
		tester.add(8);
		tester.add(7);
		tester.add(6);
		tester.add(5);
		tester.add(4);
		tester.add(3);
		tester.add(2);
		tester.add(1);		
		
		assertEquals("1 2 3 4 5 6 7 8 9 10 11", tester.toString(), 
				"List must show numbers 1-11");
	}
	
	@Test
	// Test to show that the toString method works as intended for the 
	// edge case that the list is empty
	public void testToStringEmptyList() {
		SimpleList tester = new SimpleList();
		assertEquals("", tester.toString(), 
				"List must show that the resulting string is "
				+ "empty as the list is empty");
	}
	
}
