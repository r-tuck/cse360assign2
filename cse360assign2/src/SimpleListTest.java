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
	// Complex case using add, append, and remove method to make sure that 
	// a complex series of the methods results in the correct size, element
	// count, and list elements.
	public void testComplexCase() {
		SimpleList tester = new SimpleList();
		tester.add(101);
		tester.remove(1);
		tester.remove(4);
		for (int num = 100; num >= 1; num--) {
			tester.add(num);
		}
		for (int num = 1; num <= 99; num++) {
			tester.remove(num);
		}
		tester.append(102);
		tester.add(99);
		
		
		assertEquals("99 100 101 102", tester.toString(), 
				"Resulting list should be 99, 100, 101, 102");
		assertEquals(4, tester.count(), 
				"List must have a count of 3 after Test");
		assertEquals(4, tester.size(), 
				"List must have a count of 4 after Test");
	}

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
	// Test to show that the add method works as intended for the edge case
	// where list is at capacity, and makes sure that the capacity is increased
	// by the correct amount.
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
	// Test to show that the add method works as intended when the number elements
	// added is very large, the capacity of the list and the number of elements in
	// the list should be updated correctly.
	public void testAddLargeList() {
		SimpleList tester = new SimpleList();
		for (int num = 1; num <= 100; num++) {
			tester.add(num);
		}
		
		assertEquals(100, tester.count(), 
				"List must show that the number of elements in the "
				+ "list equal to 100");
		assertEquals(109, tester.size(), 
				"List must show that the capacity was increased the appropriate "
				+ "amount of times and now is set to 109");
	}
	
	@Test
	// Test to show that the append method is functional
	public void testAppendSimple() {
		SimpleList tester = new SimpleList();
		tester.append(1);
		tester.append(2);
		tester.append(3);
		tester.append(4);
		
		assertEquals("1 2 3 4", tester.toString(), 
				"List must add 1, 2, 3, 4 in the correct order");
		assertEquals(4, tester.count(), 
				"List must have a count of 4 after Test");
	}
	
	@Test
	// Test to show that the append method works for edge case where the
	// list is empty
	public void testAppendEmptyList() {
		SimpleList tester = new SimpleList();
		tester.append(1);
		
		assertEquals("1", tester.toString(), 
				"List must add only 1 to and Empty List");
		assertEquals(1, tester.count(), 
				"List must have a count of 1 after Test");
	}
	
	@Test
	// Test to show that the append method works as intended when the list is
	// empty by removing the last element of the list when a new element 
	// is added
	public void testAppendFullList() {
		SimpleList tester = new SimpleList();
		tester.append(1);
		tester.append(2);
		tester.append(3);
		tester.append(4);
		tester.append(5);
		tester.append(6);
		tester.append(7);
		tester.append(8);
		tester.append(9);
		tester.append(10);
		tester.append(11);
		
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
	// Test to show that the add method works as intended when the number elements
	// added is very large, the capacity of the list and the number of elements in
	// the list should be updated correctly.
	public void testAppendLargeList() {
		SimpleList tester = new SimpleList();
		for (int num = 1; num <= 100; num++) {
			tester.append(num);
		}
		
		assertEquals(100, tester.count(), 
				"List must show that the number of elements in the "
				+ "list equal to 100");
		assertEquals(109, tester.size(), 
				"List must show that the capacity was increased the appropriate "
				+ "amount of times and now is set to 109");
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
		assertEquals(7, tester.size(), 
				"List will decrease by 25% as the list had"
				+ "more than 25% empty spaces");
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
		assertEquals(10, tester.size(), 
				"List size should not decrease as there was no "
				+ "elements removed from the list");
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
		assertEquals(7, tester.size(), 
				"List will decrease by 25% as the list had"
				+ "more than 25% empty spaces");
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
		assertEquals(7, tester.size(), 
				"List will decrease by 25% as the list had"
				+ "more than 25% empty spaces");
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
		assertEquals(7, tester.size(), 
				"List will decrease by 25% as the list had"
				+ "more than 25% empty spaces");
		assertEquals(-1, tester.search(1), 
				"List must not contain 1 after the test");
	}
	
	@Test
	// Test to show that the remove method works as intended for the
	// edge case that the integer to remove is at the front of the list
	public void testRemoveLargeList() {
		SimpleList tester = new SimpleList();
		for (int num = 1; num <= 100; num++) {
			tester.append(num);
		}
		for (int num = 1; num <= 100; num++) {
			tester.remove(num);
		}
		
		assertEquals(0, tester.count(), 
				"List must have a count of 0 after Test");
		assertEquals(1, tester.size(), 
				"List will decrease by 25% every time there is"
				+ "more than 25% empty spaces");
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
	
	@Test
	// Test to show that the size method is functional
	public void testSizeSimpleAdd() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);	
		
		assertEquals(10, tester.size(), 
				"After adding three elements to the list the capacity"
				+ "of the list should remain the same");
	}
	
	@Test
	// Test to show that the size method works as intended when an 
	// element is removed from the list.
	public void testSizeSimpleSubtract() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);
		tester.remove(2);
		
		assertEquals(7, tester.size(), 
				"After adding three elements and subtracting one the "
				+ "size is decreased to 7 as the list is more than"
				+ "25% empty spaces");
	}
	
	@Test
	// Test to show that the size method works as intended when an element
	// is added to a full list.
	public void testSizeFullList() {
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
		
		assertEquals(15, tester.size(), 
				"The capacity of the list will increase"
				+ "by 50% as the list hit full capacity");
	}
	
	@Test
	// Test to show that the first method works as intended with add method
	public void testFirstSimpleAdd() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);	
		
		assertEquals(1, tester.first(), 
				"After adding all elements to the list the first "
				+ "element in the list should be 1");
	}
	
	@Test
	// Test to show that the first method works as intended with subtract method
	public void testFirstSimpleSubtract() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);
		tester.remove(1);
		
		assertEquals(2, tester.first(), 
				"After adding three elements then removing the first element"
				+ "the element at the front of the list should be 2");
	}
	
	@Test
	// Test to show that the first method works as intended when an element
	// is added to a full list.
	public void testFirstFullList() {
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
		
		assertEquals(1, tester.first(), 
				"After adding all elements to the list the element at the front "
				+ "of the list should be 1");
	}
	
	@Test
	// Test to show that the first method works as intended for the edge
	// case that the list is empty.
	public void testFirstEmptyList() {
		SimpleList tester = new SimpleList();
		tester.add(1);
		tester.remove(1);
		
		assertEquals(-1, tester.first(), 
				"After removing the only element in the list the first method should "
				+ "return -1 as the list is empty");
	}
	
	@Test
	// Test to show that the last method works as intended with add method
	public void testLastSimpleAdd() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);	
		
		assertEquals(3, tester.last(), 
				"After adding all elements to the list the last "
				+ "element in the list should be 3");
	}
	
	@Test
	// Test to show that the last method works as intended with subtract method
	public void testLastSimpleSubtract() {
		SimpleList tester = new SimpleList();
		tester.add(3);
		tester.add(2);
		tester.add(1);
		tester.remove(3);
		
		assertEquals(2, tester.last(), 
				"After adding three elements then removing the last element"
				+ "the element at the end of the list should be 2");
	}
	
	@Test
	// Test to show that the last method works as intended when an element
	// is added to a full list.
	public void testLastFullList() {
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
		
		assertEquals(11, tester.last(), 
				"After adding all elements to the list the element at the end "
				+ "of the list should be 11");
	}
	
	@Test
	// Test to show that the last method works as intended for the edge
	// case that the list is empty.
	public void testLastEmptyList() {
		SimpleList tester = new SimpleList();
		tester.add(1);
		tester.remove(1);
		
		assertEquals(-1, tester.last(), 
				"After removing the only element in the list the last method should "
				+ "return -1 as the list is empty");
	}
	
}
