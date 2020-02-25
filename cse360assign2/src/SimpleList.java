/*
 * Ryan Tucker
 * Assignment 2
 * Class ID: 226
 * 
 * This class creates a simple list of up to 10 integers, as well
 * as providing methods to manipulate, traverse, and display the
 * stated list.
 */

public class SimpleList {
	
	// Array representing the list of integers
	private int[] list;
	// Number of elements currently in the list
	private int count;
	// Size of the current list
	private int size;

	/**
	 * Constructor for the class, initializes the array to an array of 
	 * integers of length 10, and the integer representing the number 
	 * integers in the list to 0 as the list is initially empty.
	 */
	public SimpleList()	{
		this.list = new int[10];
		this.count = 0;
		this.size = 10;
	}
	
	/**
	 * Adds a new element to the front of the list and increments 
	 * the total number of elements by 1. If the total number of elements 
	 * is already at the maximum the last element of the list is removed.
	 * 
	 * @param num the integer to be added to the front of the list
	 */
	public void add(int num) {
		if (count == 0) {
			list[0] = num;
		}
		else {
			if(count < size) {
				int curr = num;
				int next = num;
				for (int ndx = 0; ndx <= count; ndx++) {
					next = list[ndx];
					list[ndx] = curr;
					curr = next;
				}
			}
			else {
				int newSize = size + (size/2);
				int[] newList = new int[newSize];
				newList[0] = num;
				for (int ndx = 0; ndx < count; ndx++) {
					newList[ndx+1] = list[ndx];
				}
				list = newList;
				size = newSize;
			}
		}
		count++;
	}
	
	public void append(int num) {
		if (count == 0) {
			list[0] = num;
		}
		else {
			if(count < size) {
				list[count] = num;
			}
			else {
				int newSize = size + (size/2);
				int[] newList = new int[newSize];
				for (int ndx = 0; ndx < count; ndx++) {
					newList[ndx] = list[ndx];
				}
				newList[count] = num;
				list = newList;
				size = newSize;
			}
		}
		count++;
	}
	
	/**
	 * Removes a specified element of the list if it is present, and 
	 * decrements the total elements of the list. If the list has more
	 * than 25% empty spots after removing the element then the capacity
	 * of the list is decreased by 25%.
	 * 
	 * @param num the integer to be removed from the list if in the list
	 */
	public void remove(int num)	{
		int ndxToRemove = search(num);
		if (ndxToRemove != -1) {
			if (ndxToRemove == count) {
				count--;
			}
			else {
				int prev = list[count - 1];
				int curr = list[count - 1];
				for (int ndx = count - 1; ndx > ndxToRemove; ndx--) {
					curr = list[ndx];
					list[ndx] = prev;
					prev = curr;
				}
				if(count != 0 ) {
					list[ndxToRemove] = curr;
				}
			}
			count--;
			if (count < (.75 * size)) {
				int newSize = (int)(0.75 * size);
				int[] newList = new int[newSize];
				for (int ndx = 0; ndx < count; ndx++) {
					newList[ndx] = list[ndx];
				}
				list = newList;
				size = newSize;
			}
		}
	}
	
	/**
	 * Returns an integer representing the total number of elements 
	 * in the list
	 * 
	 * @return	an integer representing the total number of 
	 * 			elements in the list
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Returns an integer representing the capacity of the list
	 * 
	 * @return	an integer representing the capacity of the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns an integer representing the first integer in the list
	 * 
	 * @return	an integer representing the first element in the list
	 */
	public int first() {
		return list[0];
	}
	/*
	 * Returns a string representation of the list of integers  that
	 * is all current numbers in the list separated by a single space. 
	 * If the list is empty an empty string is returned.
	 * 
	 * @return	a string representation of the list.
	 */
	public String toString() {
		String result = "";
		if (count > 0) {
			result += list[0];
			if (count > 1) {
				for (int ndx = 1; ndx < count; ndx++) {
					result += " " + list[ndx];
				}
			}
		}
		return result;
	}
	
	/*
	 *  Searches the list for a given integer (num) and returns a integer
	 * (result) representing the index of the given integer. If the 
	 * provided integer is not present in the list then -1 is 
	 * returned instead.
	 * 
	 * @param num integer representing the integer to be searched 
	 * 			  for in the list
	 * @return	  integer representing either index of the given integer
	 * 			  or -1 if the given integer is not in the list.
	 */
	public int search(int num) {
		int result = -1;
		for (int ndx = 0; ndx < count; ndx++) {
			if (list[ndx] == num) {
				result = ndx;
			}
		}
		return result;
	}
}
